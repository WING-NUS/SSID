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

function getNumStr(row, max) {
    var reply = row.toString();
    while (reply.length < max.length) {
        reply = " " + reply;
    }
    return reply;
}

var left = 0, right = 1;
var leftMappingSpans = new Array();
var rightMappingSpans = new Array();
var idReg = 0;

function searchMappingStartAtIndex(mappings, index) {
    for (i in mappings) {
        if (mappings[i].startIndex == index) {
            return mappings[i];
        }
    }
    return null;
}

var highlightColor = '#FF0000';
//var skeletonColor = '#66CC66';
var skeletonColor = 'black';
var mappedColor = '#990066';

function showCode(index, rows, codes, mappings, mappingSpans) {
    var i, j;
    var count = 0;
    var inBound = false;
    var output = "<table class='coding'>"
    var strRows = rows.toString();
    var curMapping;

    for (i = 0; i < rows; i++) {

        var s = codes[i];
        var numStr = getNumStr(i + 1, strRows);
        var tmp = "<tr id='Code_" + index + "_Row_" + (i + 1) + "'><td align=right><div><pre class=num>" + numStr + "&nbsp;&nbsp;</pre></div></td><td class='code'><pre>";

        if (inBound) {
            mappingSpans[curMapping.id].push(idReg);
            tmp += "<span class='mappings' id='span_" + idReg++ + "'>";
        }

        for (j = 0; j < s.length; j++) {

            var myString = escapeHTML(s.charAt(j));
            
            if (inBound == false) {
                curMapping = searchMappingStartAtIndex(mappings, count);
                if (curMapping != null) {
                    inBound = true;
                    mappingSpans[curMapping.id] = new Array();
                    mappingSpans[curMapping.id].push(idReg);
                    tmp += "<span class='mappings' id='span_" + idReg++ + "'>";
                }
                tmp += myString;
            }
            else {
                tmp += myString;
                if (count == curMapping.endIndex) {
                    inBound = false;
                    tmp += "</span>"
                }
            }
            count++;
        }

        if (inBound) {
            tmp += "</font>";
        }
        tmp += "</pre></td></tr>"
        output += tmp;
        count++;
    }

    output += "</table>"

    var doc;
    if (index == 0)
        doc = document.getElementById('leftFrame');
    else
        doc = document.getElementById('rightFrame');

    if (doc == null) {
        alert("Null?");
    }
    doc.innerHTML = output;

    clearHighlightText(mappings, mappingSpans);
}

function clearHighlightText(mappings, mappingSpans) {
    var span, spanIds, i, j, mapping;

    for (i in mappings) {
        mapping = mappings[i];
        if (mapping.isPlag == true) {

            spanIds = mappingSpans[mapping.id];
            for (j in spanIds) {
                span = document.getElementById("span_" + spanIds[j]);
                span.style.color = mappedColor;
            }
        }
        else {
            spanIds = mappingSpans[mapping.id];
            for (j in spanIds) {
                span = document.getElementById("span_" + spanIds[j]);
                span.style.color = skeletonColor;
            }
        }
    }
}

function highlightText(index, mappingId, mappings, mappingSpans) {

    clearHighlightText(mappings, mappingSpans);
    var span, spanIds, i, j;
    var mapping;
    var doc, obj, pos;
    for (i in mappings) {
        mapping = mappings[i];
        if (mapping.id == mappingId) {
            spanIds = mappingSpans[mappingId];
            for (j in spanIds) {
                span = document.getElementById("span_" + spanIds[j]);
                span.style.color = highlightColor;
            }

            if (index == 0) {
                doc = document.getElementById('leftFrame');
                obj = document.getElementById("Code_0_Row_" + mapping.startLine);
            }
            else {
                doc = document.getElementById('rightFrame');
                obj = document.getElementById("Code_1_Row_" + mapping.startLine);
            }
            if (obj != null) {
                pos = findPos(obj);
                doc.scrollLeft = 0;
                doc.scrollTop = pos[1];
            }

            break;
        }
    }

    
}

function showLeftCode() {
    showCode(left, leftRows, leftCodes, leftMappings, leftMappingSpans);
}

function showRightCode() {
    showCode(right, rightRows, rightCodes, rightMappings, rightMappingSpans);
}

function highlightTexts(mappingId) {
    highlightText(0, mappingId, leftMappings, leftMappingSpans);
    highlightText(1, mappingId,rightMappings, rightMappingSpans);
}

function findPos(obj) {
    var curLeft = 0;
    var curTop = 0;

    curLeft = obj.offsetLeft;
    curTop = obj.offsetTop;

    return [curLeft, curTop];
}

function escapeHTML(myChar) {
    var myString;
    switch (myChar) {
        case '&':
            myString = "&amp;";
            break;
        case '"':
            myString = "&quot;";
            break;
        case '<':
            myString = "&lt;";
            break;
        case '>':
            myString = "&gt;";
            break;
        default:
            myString = myChar + "";
    }
    return myString;
}