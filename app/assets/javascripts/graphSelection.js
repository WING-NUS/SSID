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

function maximize() {
    window.moveTo(0, 0);
    window.resizeTo(screen.availWidth, screen.availHeight);
}

function clearSelecteds() {
    var selects = document.getElementsByTagName("select");

    for (i = 0; i < selects.length; i++) {
        selects[i].selectedIndex = -1;
    }
}

function hideSelect(select) {
    select.style.display = "none";
    select.selectedIndex = -1;
}

function showClusterings(assignmentId) {
    hideSelect(document.getElementById("sltClusters"));
    var select = document.getElementById("sltClusterings");
    
    while (select.length > 0) {
        select.remove(0);
    }

    var assignment = assignments[assignmentId.toString()];
    
    for (var i = 0; i < assignment.length; i++) {
        var option = document.createElement('option');
        clusteringId = assignment[i];
        option.text = clusteringsLimit[clusteringId];
        option.value = clusteringId;
        try {
            select.add(option, null);
        } catch (ex) {
            select.add(option);
        }
    }    
    select.style.display = "inline";
    document.getElementById("lblClusters2").innerHTML = "<div class='margined'>Cut off<br/>criterion</div>";
}

function showClusters(clusteringId) {
    var select = document.getElementById("sltClusters");
    while (select.length > 0) {
        select.remove(0);
    }

    var clusters = clusterings[clusteringId];

    for (var i =0; i < clusters.length; i++) {
        var option = document.createElement('option');
        clusterId = clusters[i];
        option.value = clusterId;
        option.title = coders[clusterId];

        var codersArray = coders[clusterId].split(",");
        if (codersArray.length > 3) {
            var text = "";
            for (j = 0; j < 3; j++) {
                text += codersArray[j] + ", "
            }
            text += "... (" + codersArray.length + " member";
            if (codersArray.length > 1) {
                text += "s";
            }
            text += ")";
            option.text = text;
        }
        else {
            option.text = coders[clusterId];
        }
        try {
            select.add(option, null);
        }
        catch (ex) {
            select.add(option);
        }
    }

    select.style.display = "inline";
    document.getElementById("lblClusters3").innerHTML = "<div class='margined'>Groups</div>";
}

function showSelection() {
    hideForms();
    var select = document.getElementById("sltChartType");
    var obj;
    switch (select.selectedIndex) {
        case 0:
            document.getElementById("frmAssignments").style.display = "inline";
            break;
        case 1:
            obj = document.getElementById("frmClusters");
            obj.style.display = "inline";
            obj.action = "graph_clusters";
            obj = document.getElementById("sltClusters");
            obj.multiple = true;
            break;
        case 2:
            obj = document.getElementById("frmClusters");
            obj.style.display = "inline";
            obj.action = "graph_movement";
            obj = document.getElementById("sltClusters");
            obj.multiple = false;
            break;
        case 3:
            document.getElementById("frmSim").style.display = "inline";
            break;
        case 4:
            document.getElementById("frmTop").style.display = "inline";
            break;
        case 5:
            document.getElementById("frmGroups").style.display = "inline";
            break;
                
    }
}

function transferProgrammers(source, target) {
    var selectedIndex = source.selectedIndex;
    var option, srcOption;

    var text = document.getElementById('txtfilter').value;
    
    while (selectedIndex != -1) {
        srcOption = source.options[selectedIndex];
        option = document.createElement('option');
        option.value = srcOption.value;
        option.text = srcOption.text;
        if (srcOption.text.indexOf(text) != -1) {
            try {
                target.add(option, null);
            } catch (ex) {
                target.add(option);
            }
        }
        source.remove(source.selectedIndex);
        selectedIndex = source.selectedIndex;
    }
}

function addProgrammers() {
    var source = document.getElementById("sltSimSource");
    var target = document.getElementById("sltSimTarget");
    transferProgrammers(source, target);
}

function removeProgrammers() {
    var target = document.getElementById("sltSimSource");
    var source = document.getElementById("sltSimTarget");
    transferProgrammers(source, target);
}

function submitProgrammers() {
    var target = document.getElementById("sltSimTarget");
    for (var i = 0; i < target.options.length; i++) {
        target.options[i].selected = true;
    }
}

function hideForms() {
    var forms = document.getElementsByTagName("form");
    for (var i = 0; i < forms.length; i++) {
        var j;
        var selects = forms[i].getElementsByTagName("select");
        for (j = 0; j < selects.length; j++) {
            if (selects[j].id != "" &&
                selects[j].id != "sltSimSource" &&
                selects[j].id != "sltSimTarget" &&
                selects[j].id != "sltTop" &&
                selects[j].id != "sltGroup"
                ) {
                selects[j].style.display="none";
            }
            selects[j].selectedIndex = -1;
        }
        forms[i].style.display = "none";

        var ths = forms[i].getElementsByTagName("th");
        for (j = 0; j < ths.length; j++) {
            if (ths[j].id != "") {
                ths[j].innerHTML = "";
            }
        }
    }
}

function filter(selectLst, textBox) {
    var selectBox = document.getElementById(selectLst);
    var array = new Array();
    while (selectBox.length > 0) {
        if (selectBox.options[0].selected) {
            array[selectBox.options[0].value] = true;
        }
        selectBox.options[0] = null;
    }

    var text = document.getElementById(textBox).value;
    var optn;

    for (i = 0; i < allCoders.length; i++) {
        if (allCoders[i].indexOf(text) >= 0) {
            optn = document.createElement("OPTION");
            optn.text = allCoders[i];
            optn.value = allCoders[i];
            selectBox.options.add(optn);
            if (array[allCoders[i]] == true) {
                optn.selected = true;
            }
        }
    }

    if (selectBox.length == 1) {
        selectBox.selectedIndex = 0;
    }
}
