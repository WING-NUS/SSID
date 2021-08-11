// document.body.style.border = "5px solid red";
console.log('content.js loaded');
// cannot declare with let cos background.js executes content.js multiple time
var contentCache = {};
/*
sample contentCache:
{
  "cebc70c2-0152-49a9-a000-e97082ca6f8a": {
    "key": "cebc70c2-0152-49a9-a000-e97082ca6f8a",
    "title": "20192020 Sem 1 IS4301 Tutorial 1.pdf",
    "dlUrl": "https://luminus.nus.edu.sg/v2/api/files/download/e7795140-7921-4eaa-b2fa-ba5b3e0fe496"
  },
  "b674ca1c-c226-44c4-b5e8-5d4b38e79dcb": {
    "key": "b674ca1c-c226-44c4-b5e8-5d4b38e79dcb",
    "title": "Tutorial instructions",
    "folder": true,
    "dlUrl": "https://luminus.nus.edu.sg/v2/api/files/download/5ad9ae00-8f1b-420c-968b-869b56a0ac6a"
  }
}
*/
var newFiles = [];
async function traverse(folderId) {
  console.log("1")
  let folders = await browser.runtime.sendMessage({ query: 'folders', folderId })
  .then(e => {
    if (e.code != '200') {
      console.log('response not ok');
      return;
    }
    return e.data;
  });
  console.log("2")
  let files = await browser.runtime.sendMessage({ query: 'files', folderId })
  .then(e => {
    if (e.code != '200') {
      console.log('response not ok');
      return;
    }
    return e.data;
  });
  console.log("3")
  let filesPromises = files.map(async e => {
    // let fileCache = contentCache[e.id];
    // let fileCache = this.folderCache.find(f => f.key == e.id);
    // console.log('fileCache', fileCache);
    // let dlUrl;
    // if (fileCache && fileCache.dlUrl) {
    //   dlUrl = fileCache.dlUrl;
    //   // console.log('using cached file dlUrl', dlUrl);
    // } else {
    //   dlUrl = await browser.runtime.sendMessage({ query: 'fileDlUrl', fileId: e.id })
    //   .then(body => body.data);
    // }
    // console.log({ ...e, dlUrl });
    let isNew = newFiles.findIndex(f => f.id == e.id) > -1;
    contentCache[e.id] = { key: e.id, title: e.name, dlUrl: true, isNew };
    return contentCache[e.id];
  });
  console.log("4")
  let foldersPromises = folders.map(async e => {
    // let currFolderCache = contentCache[e.id];
    // let currFolderCache = this.folderCache.find(f => f.key == e.id);
    // let dlUrl;
    // if (currFolderCache && currFolderCache.dlUrl) {
    //   dlUrl = currFolderCache.dlUrl;
    // } else {
    //   dlUrl = e.totalSize && await browser.runtime.sendMessage({ query: 'folderDlUrl', folderId: e.id })
    //   .then(body => body.data)
    //   .catch(console.error);
    // }
    // let currFolderCacheChildren = [];
    // if (currFolderCache && currFolderCache.children) {
    //   currFolderCacheChildren = currFolderCache.children;
    // }
    let content = await traverse(e.id);
    // console.log({ key: e.id, title: e.name, folder: true, children: content, dlUrl });
    contentCache[e.id] = { key: e.id, title: e.name, folder: true, dlUrl: e.totalSize, expanded: true };
    return { ...contentCache[e.id], children: content };
  });
  console.log("5")
  let currentContent = await Promise.all(foldersPromises.concat(filesPromises))
  .catch(console.error);
  // console.log(currentContent);
  // console.log(JSON.stringify(currentContent, null, 2));

  return currentContent;
}

function setupUI() {
  console.log("6")
  let parent = $('tool-content list-view'); //.empty();
  let defaultUI = parent.children('section');
  let filetreeUI = $('<div id="filetree" style="display:none"></div>');
  parent.append(filetreeUI);
  $('.breadcrumb')
  .after('<label for="filetree-toggler">Send to SSID</label><input id="filetree-toggler" type="checkbox"><label class="toggler-switch" for="filetree-toggler"></label>');
  $('#filetree-toggler').on('change', e => {
    if (e.target.checked) {
      defaultUI.hide();
      filetreeUI.show();
    } else {
      console.log("7")
      defaultUI.show();
      filetreeUI.hide();
    }
  });
}

// function updateCache(moduleId, contentCache) {
//   let moduleCache = {};
//   moduleCache[moduleId] = contentCache;
//   browser.storage.sync.set(moduleCache).catch(console.error);
// }

function download(url, filename) {
  console.log(url, filename);
  //$('#dl').attr('href', url);
  //$('#dl').attr('download', filename);
  //$('#dl')[0].click();
  console.log("end");
}

function disableNewFilesDlButtons() {
  $('#dlNew').attr('disabled', true);
  $('#dlNew').attr('title', 'No new files to download');
  $('#dlNewUnzip').attr('disabled', true);
  $('#dlNewUnzip').attr('title', 'No new files to download');
}

// var once = true; // ensure filetree toggler 
async function receiver(message, sender, sendResponse) {
  console.log('content.js message received');
  // if ($('#filetree-toggler').length) { // filetree initiated, do nothing
  //   console.log('filetree initiated, do nothing');
  //   return;
  // }
  // if (!once) {
  //   console.log('twice');
  // }
  console.log("7")
  let observer = new MutationObserver(ms => {
    console.log('observer triggered');
    let breadcrumbMutation = ms.filter(m => m.target.classList.contains('breadcrumb'));
    if (!breadcrumbMutation.length) { // guard condition
      return;
    }
    console.log("8")
    if ($('#filetree-toggler').length) {
      console.log('filetree toggler exists, observer disconnecting');
      observer.disconnect();
      return;
    }
    console.log("9")
    let breadcrumb = breadcrumbMutation[0].target;
    console.log(breadcrumb);
    setupUI();
    once = false;
    observer.disconnect(); // ensure filetree toggler only added once
  });
  if ($('.breadcrumb').length && $('.breadcrumb').text().includes('Files') && !$('#filetree-toggler').length) {
    console.log('breadcrumb exists, setting up UI');
    setupUI();
  } else {
    console.log('observing breadcrumb');
    observer.observe(document.querySelector('body'), { childList: true, subtree: true });
  }

  // cannot implement subfolder filetree cos cannot scrape folderId from url cos angular updates the url slower than the extension script
  // let idToTraverse;
  // let folderId = window.location.href.match(/modules\/(.{36})\/files\/(.{36})/);
  let moduleId = window.location.href.match(/modules\/(.{36})/)[1];
  console.log("moduleID",moduleId);
  // console.log('folderId', folderId);
  // if (folderId) { // url has folder id (regex has match)
  //   folderId = folderId[2]; // extract the actual id
  //   idToTraverse = folderId;
  // } else {
  //   idToTraverse = moduleId;
  // }
  // console.log('idToTraverse', idToTraverse);
  // let token = message;
  // console.log(token, moduleId);
  // let filestructurePromise = traverse(moduleId);
  // await browser.storage.sync.clear();

  // loads cache
  // let moduleCache = await browser.storage.sync.get(moduleId).catch(console.error);
  // empty cache is {}, make default as []
  // else is { (moduleId): [...] }
  // if (Object.keys(moduleCache).length && moduleCache[moduleId]) {
  //   contentCache = moduleCache[moduleId];
  //   console.log('contentCache', contentCache);
  // } else {
  //   moduleCache[moduleId] = [];
  //   browser.storage.sync.set(moduleCache);
  // }

  // get list of new files
  newFiles = await browser.runtime.sendMessage({ query: 'notdownloaded', folderId: moduleId })
  .then(body => body.data)
  .catch(console.error);
  console.log('newFiles', newFiles);
  // console.log('contentCache', contentCache);
  let filestructure = await traverse(moduleId);
  console.log('filestructure', filestructure);
  // updateCache(moduleId, contentCache);

  console.log("8")
  // initialize filetree
  let filetreeUI = $('#filetree');
  filetreeUI.append('<form><label for="name">Name</label><input type="text" name="name"></form>');
  filetreeUI.append('<a id="dl">dl</a>');
  filetreeUI.append('<button id="dlNew" class="dlBtn">D</button><button id="dlNewUnzip" class="dlBtn">D</button><button id="dlAll" class="dlBtn">Download All</button>');
  if (!filestructure.length) {
    $('#dlAll').attr('disabled', true);
    $('#dlAll').attr('title', 'No files to download');
  }
  console.log("9")
  if (!newFiles.length) {
    disableNewFilesDlButtons();
  }
  console.log("10")
  filetreeUI.fancytree({
    source: filestructure,
    clickFolderMode: 2,
    renderNode: (event, data) => {
      let node = data.node;
      let dlUrl = node.data.dlUrl;
      let span = $(node.span);
      if (dlUrl && !span.children('a').length) {
        if (node.folder) {
          span.append('   ');
          let link = $('<a class="zip">zip</a>');
          console.log("link", link);
          link.on('click', async e => {
            e.preventDefault();
            let dlUrl = await browser.runtime.sendMessage({ query: 'folderDlUrl', folderId: node.key })
            .then(body => body.data)
            .catch(console.error);
            // e.target.href = dlUrl;
            // contentCache[node.key].dlUrl = dlUrl;
            // updateCache(moduleId, contentCache);
            console.log("21")
            download(dlUrl);
            span.next().find('span.new').removeClass('new'); // set children files as not new
          });
          span.append(link);
        } else {
          span.append('   ');
          // let link = $('<a style="display:none" href="' + dlUrl + '">dl</a>');
          // link.on('click', async e => {
          //   e.preventDefault();
          //   let dlUrl = await browser.runtime.sendMessage({ query: 'fileDlUrl', fileId: node.key })
          //   .then(body => body.data)
          //   .catch(console.error);
          //   e.target.href = dlUrl;
          //   // contentCache[node.key].dlUrl = dlUrl;
          //   // updateCache(moduleId, contentCache);
          //   $('#dl').attr('href', dlUrl);
          //   $('#dl')[0].click();
          //   span.removeClass('new');
          // });
          // span.append(link);
          if (node.data.isNew) {
            span.addClass('new');
          }
        }
      }
    },
    click: async (event, data) => {
      let node = data.node;
      let dlUrl = node.data.dlUrl;
      if (!node.folder && dlUrl) {
        // $(node.span).children('a')[0].click();
        let dlUrl = await browser.runtime.sendMessage({ query: 'fileDlUrl', fileId: node.key })
        .then(body => body.data)
        .catch(console.error);
        console.log("22")
        download(dlUrl);
        span.removeClass('new');
      } else if (node.folder && event.originalEvent.target.classList.contains('zip')) {
        event.preventDefault();
      }
    }
  });

  // $('#dlAll').attr('disabled', false);
  // $('#dlNew').attr('disabled', false);

  // download all handler
  $('#dlAll').on('click', async e => {
    let requestBody = JSON.stringify({
      fileIds: filestructure.filter(e => !e.folder).map(e => e.key),
      folderIds: filestructure.filter(e => e.folder).map(e => e.key),
      preserveFolder: true
    });
    let dlUrl = await browser.runtime.sendMessage({ query: 'downloadSelectedUrl', moduleId, body: requestBody })
    .then(body => body.data)
    .catch(console.error);
    console.log("23")
    download(dlUrl);
    $('.new').removeClass('new');
  });

  // download new files handler
  $('#dlNew').on('click', async e => {
    if (!newFiles.length) {
      return;
    }
    let requestBody = JSON.stringify({
      fileIds: newFiles.map(e => e.id),
      folderIds: [],
      preserveFolder: true
    });
    let dlUrl = await browser.runtime.sendMessage({ query: 'filesDlUrl', moduleId, body: requestBody })
    .then(body => body.data)
    .catch(console.error);
    console.log("25")
    download(dlUrl, moduleId + ' new files');
    $('.new').removeClass('new');
    disableNewFilesDlButtons();
  });

  // download new files unzipped handler
  $('#dlNewUnzip').on('click', async e => {
    if (!newFiles.length) {
      return;
    }
    for (e of newFiles) {
      let dlUrl = await browser.runtime.sendMessage({ query: 'fileDlUrl', fileId: e.id })
      .then(body => body.data)
      .catch(console.error);
      console.log("26")
      download(dlUrl);
    }
    $('.new').removeClass('new');
    disableNewFilesDlButtons();
    newFiles = await browser.runtime.sendMessage({ query: 'notdownloaded', folderId: moduleId })
    .then(body => body.data)
    .catch(console.error);
  });


  browser.runtime.onMessage.removeListener(receiver); // so that listener doesnt keep repeating per message received
}
browser.runtime.onMessage.addListener(receiver);
