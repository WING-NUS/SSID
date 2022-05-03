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

(function() {
    window.SubmissionSimilarity || (window.SubmissionSimilarity = {});
  
    SubmissionSimilarity.slideToLine = function(checkBox) {
      var s1y, s2y, startLine1, startLine2, values;
      values = $(checkBox).val().split("_");
      startLine1 = parseInt(values[0]);
      startLine2 = parseInt(values[2]);
      $("div.submission1").stop();
      $("div.submission2").stop();
      s1y = $("div.submission1 li:eq(" + startLine1 + ")").offset().top - $("div.submission1").offset().top;
      s2y = $("div.submission2 li:eq(" + startLine2 + ")").offset().top - $("div.submission2").offset().top;
      $("div.submission1").animate({
        scrollTop: '+=' + s1y
      }, 1000);
      return $("div.submission2").animate({
        scrollTop: '+=' + s2y
      }, 1000);
    };
  
    SubmissionSimilarity.highlightLines = function(checkBox) {
      var endLine1, endLine2, lineIdx, startLine1, startLine2, values, _i, _j;
      values = $(checkBox).val().split("_");
      startLine1 = parseInt(values[0]);
      endLine1 = parseInt(values[1]);
      startLine2 = parseInt(values[2]);
      endLine2 = parseInt(values[3]);
      $(checkBox).closest("tr").addClass("highlight");

      // differentiate colors
      let skeletonLines = $(checkBox).closest("input.skeleton-lines").val().split(/\s/)
      let skeletonIdxS1 = []
      let skeletonIdxS2 = []
      for (i = startLine1; i <= endLine1; ++i) {
        skeletonIdxS1.push(false);
      }

      for (i = startLine2; i <= endLine2; ++i) {
        skeletonIdxS2.push(false);
      }
      
      skeletonLines.forEach((skeletonLine) => {
        lineInfo = skeletonLine.split("_")
        skeletonStartLine1 = parseInt(lineInfo[0])
        skeletonEndLine1 = parseInt(lineInfo[1])
        skeletonStartLine2 = parseInt(lineInfo[2])
        skeletonEndLine2 = parseInt(lineInfo[3])

        for (i = 0; i < skeletonIdxS1.length; ++i) {
          if (skeletonStartLine1 <= i+startLine1 && i+startLine1 <= skeletonEndLine1) {
            skeletonIdxS1[i] = true;
          }
        }

        for (i = 0; i < skeletonIdxS2.length; ++i) {
          if (skeletonStartLine2 <= i+startLine2 && i+startLine2 <= skeletonEndLine2) {
            skeletonIdxS2[i] = true;
          }
        }                
      })






      for (lineIdx = _i = startLine1; startLine1 <= endLine1 ? _i <= endLine1 : _i >= endLine1; lineIdx = startLine1 <= endLine1 ? ++_i : --_i) {
        if (skeletonIdxS1[lineIdx - startLine1] == false) {
          $("div.submission1 li:eq(" + lineIdx + ")").addClass("highlight");
        } else {
          $("div.submission1 li:eq(" + lineIdx + ")").addClass("skeleton-highlight");
        }
      }

      for (lineIdx = _j = startLine2; startLine2 <= endLine2 ? _j <= endLine2 : _j >= endLine2; lineIdx = startLine2 <= endLine2 ? ++_j : --_j) {
        if (skeletonIdxS2[lineIdx - startLine2] == false) {
          $("div.submission2 li:eq(" + lineIdx + ")").addClass("highlight");
        } else {
          $("div.submission2 li:eq(" + lineIdx + ")").addClass("skeleton-highlight");
        }
      }
    };
  
    SubmissionSimilarity.unhighlightLines = function(checkBox) {
      var endLine1, endLine2, isChecked, lineIdx, startLine1, startLine2, values, _i, _j;
      isChecked = $(checkBox).is(":checked");
      if (!isChecked) {
        values = $(checkBox).val().split("_");
        startLine1 = parseInt(values[0]);
        endLine1 = parseInt(values[1]);
        startLine2 = parseInt(values[2]);
        endLine2 = parseInt(values[3]);
        $(checkBox).closest("tr").removeClass("highlight");
        for (lineIdx = _i = startLine1; startLine1 <= endLine1 ? _i <= endLine1 : _i >= endLine1; lineIdx = startLine1 <= endLine1 ? ++_i : --_i) {
          $("div.submission1 li:eq(" + lineIdx + ")").removeClass("highlight");
          $("div.submission1 li:eq(" + lineIdx + ")").removeClass("skeleton-highlight");
        }
        for (lineIdx = _j = startLine2; startLine2 <= endLine2 ? _j <= endLine2 : _j >= endLine2; lineIdx = startLine2 <= endLine2 ? ++_j : --_j) {
          $("div.submission2 li:eq(" + lineIdx + ")").removeClass("highlight");
          $("div.submission2 li:eq(" + lineIdx + ")").removeClass("skeleton-highlight");
        }
      }
    };
  
    SubmissionSimilarity.toggleRowHighlight = function(el) {
      var inputNode;
      inputNode = $(el).find("input.checkbox");
      if (inputNode.is(":checked")) {
        inputNode.prop("checked", false);
        SubmissionSimilarity.unhighlightLines(inputNode);
      } else {
        inputNode.prop("checked", true);
        SubmissionSimilarity.highlightLines(inputNode);
      }
    };
  
    SubmissionSimilarity.toggleAllRowHighlights = function(el) {
      var headerInputNode;
      headerInputNode = $(el);
      $("table.lines tbody tr").each(function() {
        var inputNode;
        inputNode = $(this).find("input.checkbox");
        if (headerInputNode.is(":checked") && !inputNode.is(":checked") || !headerInputNode.is(":checked") && inputNode.is(":checked")) {
          SubmissionSimilarity.toggleRowHighlight($(this));
        }
      });
    };
  
    SubmissionSimilarity.toggleGuilty = function(el) {
      var ids, url;
      ids = $(el).attr("id").replace(/toggle_guilty_/, "").split("_");
      if ($(el).is(":checked")) {
        url = "/submission_similarities/" + ids[0] + "/submissions/" + ids[1] + "/mark_as_guilty";
      } else {
        url = "/submission_similarities/" + ids[0] + "/submissions/" + ids[1] + "/mark_as_not_guilty";
      }
      $.ajax({
        context: this,
        url: url,
        type: "PUT"
      });
    };
  
    SubmissionSimilarity.onLoad = function() {
      return $(function() {
        $("body.submission_similarities_index table a").each(function() {
          Site.registerHighlightRowMethodsForLink(this);
        });
        prettyPrint();

        $("table.lines td").hover(function() {
          SubmissionSimilarity.slideToLine($(this).parent().find("input"));
          SubmissionSimilarity.highlightLines($(this).parent().find("input"));
        }, function() {
          SubmissionSimilarity.unhighlightLines($(this).parent().find("input"));
        });

        $("table.lines th.check_box_col").hover(
          function() {$("table.lines tbody tr").each(function() {
            var inputNode;
            inputNode = $(this).find("input.checkbox");
            if (!inputNode.is(":checked")) {
              SubmissionSimilarity.highlightLines(inputNode);
            }
          });
          }, 
          function() {$("table.lines tbody tr").each(function() {
            var inputNode;
            inputNode = $(this).find("input.checkbox");
            if (!inputNode.is(":checked")) {
              SubmissionSimilarity.unhighlightLines(inputNode);
            }
          });
        });
        
        $("table.lines td.check_box_col").on("click", function() {
          SubmissionSimilarity.toggleRowHighlight(this);
        });
        $("table.lines th.check_box_col input").on('click', function(event) {
          SubmissionSimilarity.toggleAllRowHighlights(this);
        });
        $("input.guilty_check_box").change(function() {
          SubmissionSimilarity.toggleGuilty(this);
        });
      });
    }; 
  }).call(this);