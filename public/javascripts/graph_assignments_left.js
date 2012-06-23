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

var coders = new Array();
var codersLength = 0;
var gDiv = new Array();

function toggleGroup(groupId) {
    var group = document.getElementById(groupId);
    var html = group.innerHTML;
    group.innerHTML = gDiv[groupId];
    gDiv[groupId] = html;
    refreshDiv();
}

function Coder(coderId) {
    this.id = coderId;
    this.clusterings = new Array();
}

function sortByLimit50(a, b) {
    return b.clusterings[50] - a.clusterings[50];
}
function sortByLimit60(a, b) {
    return b.clusterings[60] - a.clusterings[60];
}
function sortByLimit70(a, b) {
    return b.clusterings[70] - a.clusterings[70];
}
function sortByLimit80(a, b) {
    return b.clusterings[80] - a.clusterings[80];
}
function sortByLimit90(a, b) {
    return b.clusterings[90] - a.clusterings[90];
}

function showRanking(limit) {
    var doc = parent.frames[1].document;
    doc.open();
    doc.write("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheets/pds.css\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"../stylesheets/graph_assignment_right.css\" /></head><body onload='cloneArray(parent.frames[0].locked, locked); refreshDiv();'><script type=\"text/javascript\" src=\"../javascripts/wz_tooltip.js\"></script><script type=\"text/javascript\" src=\"../javascripts/graph_assignments.js\"></script>");
    doc.write("<h1 style='margin-top: 6px;'>Ranking</h1><br/>");
    doc.write("Cut off criterion: ");
    doc.write("<select onchange='parent.frames[0].showRanking(this.options[this.selectedIndex].value);'>");
    var i = 0;
    for (i = 90; i >= 50; i -= 10) {
        if (limit == i) {
            doc.write("<option value=" + i + " selected='selected'>&ge; " + i + "%</option>");
        }
        else {
            doc.write("<option value=" + i + ">&ge; " + i + "%</option>");
        }
    }
    doc.write("</select>");
    doc.write("<p/>");

    var sortedList = new Array();
    for (i in coders) {
        sortedList.push(coders[i]);
    }
    
    switch (limit) {
        case 90:
            sortedList = sortedList.sort(sortByLimit90);
            break;
        case 80:
            sortedList = sortedList.sort(sortByLimit80);
            break;
        case 80:
            sortedList = sortedList.sort(sortByLimit70);
            break;
        case 80:
            sortedList = sortedList.sort(sortByLimit60);
            break;
        default:
            sortedList = sortedList.sort(sortByLimit50);
            break;
    }
    doc.write("<table class='assignments' border='1' width=100% cellpadding='5'>");
    doc.write("<col width='50'/><col width='100'/><col width='50'/>")
    doc.write("<th class='assignments'>Rank</th><th class='assignments'>Student</th><th class='assignments'>Found</th>")
    var length;

    if (sortedList.length < 10) {
        length = sortedList.length;
    }
    else {
        length = 10;
    }

    var id, time;
    for (i = 0; i < length; i++) {
        doc.write("<tr>");
        id = sortedList[i].id;
        time = sortedList[i].clusterings[limit];
        doc.write("<td class='assignments' align='center'>" + (i + 1) + "</td>");
        doc.write("<td class='assignments'>");
        doc.write("<div class=\"c" + id + "\" ");
        doc.write("onclick=\"lockDiv('c"+id+"');parent.frames[0].lockDiv('c"+id+"'); onmouseout(); onmouseover();\" ");
        doc.write("onmouseover=\"Tip(parent.frames[0].showInfo('" + id + "'));highlightDiv('c" + id + "');parent.frames[0].highlightDiv('c" + id + "');\" ");
        doc.write("onmouseout=\"UnTip();normalDiv('c" + id + "');parent.frames[0].normalDiv('c" + id + "');\">" + id + "</div>");
        doc.write("</td>");
        doc.write("<td class='assignments' align='center'>" + time + "</td>");
        doc.write("</tr>");
    }
    doc.write("</table>");
    doc.write("</body></html>")
    doc.close();
}

function showInfo(coderId) {
    var coder = coders[coderId];
    var result = "Student: <b>" + escape(coderId) + "</b><p />";
    if (coder != null) {
        result += "Found in cut off criterion:<br/>";
        result += "&ge; 90% - " + coder.clusterings[90] + " times<br />";
        result += "&ge; 80% - " + coder.clusterings[80] + " times<br />";
        result += "&ge; 70% - " + coder.clusterings[70] + " times<br />";
        result += "&ge; 60% - " + coder.clusterings[60] + " times<br />";
        result += "&ge; 50% - " + coder.clusterings[50] + " times<br />";
    } else {
        result += "Found in cut off criterion:<br/>";
        result += "&ge; 90% - 0 times<br />";
        result += "&ge; 80% - 0 times<br />";
        result += "&ge; 70% - 0 times<br />";
        result += "&ge; 60% - 0 times<br />";
        result += "&ge; 50% - 0 times<br />";
    }

    if (locked['c'+ coderId] == true) {
        result += "<p/>Click to unmark this student";
    }
    else {
        result += "<p/>Click to mark this student";
    }

    return result;
}