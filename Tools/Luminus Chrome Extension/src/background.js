var headers;
function listener(requestDetails) {
  console.log('background.js triggered');
  let tokenFilter = requestDetails.requestHeaders.filter(e => e.name == 'Authorization');
  // let refererFilter = requestDetails.requestHeaders.filter(e => e.name == 'Referer'); // to get mod id from headers
  if (tokenFilter.length > 0 && requestDetails.method == 'GET') { // filter for only GET method calls cos requests always comes in OPTION and GET pairs, and i just need 1
    let token = tokenFilter[0].value;
    headers = {
      "Authorization": token,
      "Ocp-Apim-Subscription-Key": "6963c200ca9440de8fa1eede730d8f7e"
    };
    browser.tabs.insertCSS({ file: 'ui.fancytree.min.css' })
    .then(() => browser.tabs.insertCSS({ file: 'custom.css' }))
    .then(() => browser.tabs.executeScript({ file: 'browser-polyfill.min.js' }))
    .then(() => browser.tabs.executeScript({ file: 'jquery.min.js' }))
    .then(() => browser.tabs.executeScript({ file: 'jquery.fancytree-all-deps.min.js' }))
    .then(() => browser.tabs.executeScript({ file: 'content.js' }))
    .then(result => {
      console.log('result', result);
      var querying = browser.tabs.query({
          active: true,
          currentWindow: true
      });
      return querying;
    }).then(tabs => {
      console.log('tabs', tabs);
      browser.tabs.sendMessage(tabs[0].id, token);
    });
  }
  // return { cancel: true }; // dont continue the request, let content.js handle
}

browser.webRequest.onBeforeSendHeaders.addListener(
  listener,
  {urls: ['https://luminus.nus.edu.sg/v2/api/files/?populate=totalFileCount%2CsubFolderCount%2CTotalSize&ParentID=*']},
  ['blocking', 'requestHeaders']
);

browser.runtime.onMessage.addListener(
  (request, sender, sendResponse) => {
    if (request.query == 'folders') {
      // add placeholder to query string to skip background js request filter, otherwise will trigger infinite recursion
      return fetch('https://luminus.nus.edu.sg/v2/api/files/?placeholder=1&populate=totalFileCount%2CsubFolderCount%2CTotalSize&ParentID=' + request.folderId, {
        headers,
        mode: 'cors'
      }).then(res => res.json());
    } else if (request.query == 'files') {
      return fetch('https://luminus.nus.edu.sg/v2/api/files/' + request.folderId + '/file?populate=Creator%2ClastUpdatedUser%2Ccomment', {
        headers,
        mode: 'cors'
      }).then(res => res.json());
    } else if (request.query == 'fileDlUrl') {
      return fetch('https://luminus.nus.edu.sg/v2/api/files/file/' + request.fileId + '/downloadurl', {
        headers,
        mode: 'cors'
      })
      .then(res => res.json());
    } else if (request.query == 'folderDlUrl') {
      return fetch('https://luminus.nus.edu.sg/v2/api/files/' + request.folderId + '/downloadurl', {
        headers,
        mode: 'cors'
      })
      .then(res => res.json());
    } else if (request.query == 'notdownloaded') {
      return fetch('https://luminus.nus.edu.sg/v2/api/files/notdownloaded?ParentID=' + request.folderId, {
        headers,
        mode: 'cors',
        cache: 'no-cache'
      })
      .then(res => res.json());
    } else if (request.query == 'downloadSelectedUrl') {
      return fetch('https://luminus.nus.edu.sg/v2/api/files/' + request.moduleId + '/downloadurl', {
        method: 'post',
        headers: { ...headers, 'Content-Type': 'application/json' },
        mode: 'cors',
        body: request.body
      })
      .then(res => res.json());
    } else if (request.query == 'filesDlUrl') {
      return fetch('https://luminus.nus.edu.sg/v2/api/files/file/downloadurl', {
        method: 'post',
        headers: { ...headers, 'Content-Type': 'application/json' },
        mode: 'cors',
        body: request.body
      })
      .then(res => res.json());
    }
  }
)