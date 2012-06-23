/*
This file is part of SSID.

SSID is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SSID is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with SSID.  If not, see <http://www.gnu.org/licenses/>.
*/

//function openMappingWindow(event) {
function openMappingWindow() {
    parent.mappingWindow = window.open("", "pdsCodeViewChildWindow", "status=0,toolbar=0,location=0,menubar=0,directories=0,resizable=1,scrollbars=1,width=100,height=1");

    if (parent.mappingWindow == null) {
        alert('Popup is being blocked.\nYou can view the mapping list by clicking the \'Show Mapping List\' link at the top left corner');
        return;
    }

    childDoc = parent.mappingWindow.document;
    childDoc.write(toolTip);
    childDoc.close();

    parent.mappingWindow.resizeTo(100, 100);
    //childWindow.moveTo(event.clientX + 20, event.clientY + body.offsetHeight);
    rows = childDoc.getElementById('maptable').getElementsByTagName('tr');
    parent.mappingWindow.resizeTo(450, childDoc.getElementById('maptable').clientHeight * 2);

    parent.mappingWindow.focus();
}

function getDocHeight(document) {
    
    return Math.max(
        //Math.max(document.body.scrollHeight, document.documentElement.scrollHeight),
        Math.max(document.body.offsetHeight, document.documentElement.offsetHeight),
        Math.max(document.body.clientHeight, document.documentElement.clientHeight)
    );
}

function childSetLeftText(start, right) {
    if (window.opener == null) {
        return;
    }
    window.opener.setLeftText(start, right);
}

function childSetRightText(start, right) {
    if (window.opener == null) {
        return;
    }
    window.opener.setRightText(start, right);
}