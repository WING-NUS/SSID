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


var checkbox = document.getElementById('assignment_mapbox');
var details_div = document.getElementById('map_file_details');
checkbox.onchange = function () {
    if (this.checked) {
        details_div.style['display'] = 'block';
    } else {
        details_div.style['display'] = 'none';
    }
};
window.addEventListener('DOMContentLoaded', () => {
    console.log($('which-form').val());
    if ($('#which-form').val() === "update_assignment") {
        document.querySelector('#assignment_title').disabled = true;
        document.querySelector('#assignment_language').disabled = true;
        document.querySelector('#assignment_min_match_length').disabled = true;
        document.querySelector('#assignment_ngram_size').disabled = true;
    }
})

$("#assignment_file").attr("onchange", "onAssignmentFileInputChange(this)");

function onAssignmentFileInputChange(fileInput) {
    console.log("duh")
    if (fileInput.files[0] == undefined) {
        return;
    }
    let reader = new FileReader();
    reader.onload = (ev) => {
        JSZip.loadAsync(ev.target.result)
            .then(function (zip) {
                var zipObjectNames = Object.keys(zip.files);
                var fileNames = zipObjectNames.filter(
                    (x) => x.charAt(x.length - 1) != "/"
                );

                // Reset existing file list
                $("#student_submissions_zip_files_list").empty();

                // Set label of the file list
                if (fileNames.length > 10) {
                    $("#student_submissions_zip_files_list_label").text("Files inside (showing first 10):");
                } else if (fileNames.length == 0) {
                    $("#student_submissions_zip_files_list_label").text("The zip file is empty.");
                } else {
                    $("#student_submissions_zip_files_list_label").text("Files inside:");
                }

                // Display the first ten files
                for (let i = 0; i < Math.min(10, fileNames.length); i++) {
                    let fileName = fileNames[i];
                    $("#student_submissions_zip_files_list").append(
                        "<li><a href=# id=preview_file_" + i + ">" + fileName + "</a></li>"
                    );

                    let handleClick = function () {
                        zip
                            .file(fileName)
                            .async("string")
                            .then((fileContent) => {
                                previewRawFile(fileName, fileContent);
                                return false;
                            });
                    };

                    $("#preview_file_" + i).click(handleClick);
                }

                // Indicate that there are more files if there are > 10 files
                if (fileNames.length > 10) {
                    $("#student_submissions_zip_files_list").append("<li>...</li>");
                }
            })
            .catch((err) => {
                console.error("Error trying to unzip and process", filename);
                console.error(err);
            });
    };
    reader.onerror = (err) => {
        console.error("Error trying to read file", err);
    };
    reader.readAsArrayBuffer(fileInput.files[0]);
}

$("#assignment_mapfile").attr("onchange", "onAssignmentMapFileInputChange(this)");

function onAssignmentMapFileInputChange(fileInput) {
    if (fileInput.files[0] == undefined) {
        return;
    }

    let fileName = fileInput.files[0].name;
    let reader = new FileReader();

    // Reset existing file list
    $("#map_files_list").empty();

    // Show newly chosen file
    $("#map_files_list").prepend("<br>");

    $("#map_files_list").append(
        "<li><a href=# id=preview_map_file>" + fileName + "</a></li>"
    );

    reader.onload = function () {
        callback(reader.result);
    }

    reader.readAsText(fileInput.files[0]);

    reader.onerror = (err) => {
        console.error("Error trying to read file", err);
    };

    let handleClick = () => previewRawFile(fileName, reader.result);

    $("#preview_map_file").click(handleClick);
}

function previewRawFile(fileName, fileContent) {
    let newWindow = window.open("about:blank");
    newWindow.document.write("<title>" + fileName + "</title>");
    newWindow.document.write("<pre>" + fileContent + "</pre>");
}