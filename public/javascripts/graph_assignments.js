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

var locked = new Array();

//const lockedBackgroundColor = "#63BCFF";
const lockedBackgroundColor = "#C2DCFC";
const highlightBackgroundColor = "rgb(250,230,142)";
const defaultBackgroundColor = "white";

function lockDiv(name) {

    if (locked[name] == true) {
        locked[name] = null;
        highlightDiv(name);
        return;
    }
    
    var elements = document.getElementsByTagName("div");
    var i;

    for (i = 0; i <elements.length; i++) {
        if (elements[i].className == name) {
            elements[i].style.backgroundColor = lockedBackgroundColor;
//            if (elements[i].style.color != "red") {
//                elements[i].style.color = "white";
//            }
        }
    }
    locked[name] = true;
}

function cloneArray(source, target) {
    for (x in source) {
        target[x] = source[x];
    }
}

function refreshDiv() {
    var elements = document.getElementsByTagName("div");
    var i;

    for (i = 0; i <elements.length; i++) {
        if (locked[elements[i].className] == true) {
            elements[i].style.backgroundColor = lockedBackgroundColor;
//            if (elements[i].style.color != "red") {
//                elements[i].style.color = "white";
//            }
            locked[name] = true;
        }
        else {
            normalDiv(elements[i].className);
        }
    }
}

function highlightDiv(name) {
    if (locked[name] == true) {
        return;
    }
    var elements = document.getElementsByTagName("div");
    var i;
    for (i = 0; i <elements.length; i++) {
        if (elements[i].className == name) {
            elements[i].style.backgroundColor = highlightBackgroundColor;
//            if (elements[i].style.color != "red")
//                elements[i].style.color = "white";
        }
    }
}

function normalDiv(name) {
    if (locked[name] == true) {
        return;
    }
    var elements = document.getElementsByTagName("div");
    var i;
    for (i = 0; i <elements.length; i++) {
        if (elements[i].className == name) {
            elements[i].style.backgroundColor = defaultBackgroundColor;
//            if (elements[i].style.color != "red")
//                elements[i].style.color = "black";
        }
    }
}