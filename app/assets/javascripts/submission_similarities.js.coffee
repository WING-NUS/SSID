###
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
###

window.SubmissionSimilarity ||= {}

SubmissionSimilarity.highlightLines = (checkBox) ->
  # Get lines
  values = $(checkBox).val().split("_")
  startLine1 = parseInt values[0]
  endLine1 = parseInt values[1]
  startLine2 = parseInt values[2]
  endLine2 = parseInt values[3]

  # Add highlights
  $(checkBox).closest("tr").addClass("highlight")
  for lineIdx in [startLine1..endLine1]
    $("div.submission1 li:eq("+lineIdx+")").addClass("highlight")
  for lineIdx in [startLine2..endLine2]
    $("div.submission2 li:eq("+lineIdx+")").addClass("highlight")

  return

SubmissionSimilarity.unhighlightLines = (checkBox) ->
  isChecked = $(checkBox).attr("checked")

  if !isChecked
    # Get lines
    values = $(checkBox).val().split("_")
    startLine1 = parseInt values[0]
    endLine1 = parseInt values[1]
    startLine2 = parseInt values[2]
    endLine2 = parseInt values[3]

    # Remove highlights
    $(checkBox).closest("tr").removeClass("highlight")
    for lineIdx in [startLine1..endLine1]
      $("div.submission1 li:eq("+lineIdx+")").removeClass("highlight")
    for lineIdx in [startLine2..endLine2]
      $("div.submission2 li:eq("+lineIdx+")").removeClass("highlight")

  return
  
SubmissionSimilarity.toggleRowHighlight = (el) ->
  inputNode = $(el).find("input")
  if inputNode.attr("checked")
    inputNode.removeAttr("checked")
    SubmissionSimilarity.unhighlightLines(inputNode)
  else
    inputNode.attr("checked", "checked")
    SubmissionSimilarity.highlightLines(inputNode)
  return

SubmissionSimilarity.toggleAllRowHighlights = (el) ->
  headerInputNode = $(el)
  $("table.lines tbody tr").each ->
    inputNode = $(this).find("input")
    if headerInputNode.attr("checked") && !inputNode.attr("checked") || !headerInputNode.attr("checked") && inputNode.attr("checked")
      SubmissionSimilarity.toggleRowHighlight($(this))
    return
  return

SubmissionSimilarity.toggleGuilty = (el) ->
  ids = $(el).attr("id").replace(/toggle_guilty_/, "").split("_")
  if $(el).attr("checked")
    url = "/SSID/submission_similarities/"+ids[0]+"/submissions/"+ids[1]+"/mark_as_guilty"
  else
    url = "/SSID/submission_similarities/"+ids[0]+"/submissions/"+ids[1]+"/mark_as_not_guilty"
  $.ajax
    url: url
    type: "PUT"
  return

SubmissionSimilarity.onLoad = ->
  $ ->
    $("body.submission_similarities_index table a").each ->
      Site.registerHighlightRowMethodsForLink(this)
      return

    prettyPrint()

    $("table.lines td").hover(
      ->
        SubmissionSimilarity.highlightLines($(this).parent().find("input"))
        return
      ->
        SubmissionSimilarity.unhighlightLines($(this).parent().find("input"))
        return
    )

    $("table.lines td").click ->
      SubmissionSimilarity.toggleRowHighlight($(this).parent())
      return

    $("table.lines td input").click (event) ->
      event.stopPropagation()
      return

    $("table.lines th.check_box_col").click ->
      inputNode = $(this).find("input")
      if inputNode.attr("checked")
        inputNode.removeAttr("checked")
      else
        inputNode.attr("checked", "checked")
      SubmissionSimilarity.toggleAllRowHighlights(inputNode)
      return

    $("table.lines th.check_box_col").hover(
      ->
        $("table.lines tbody tr").each ->
          inputNode = $(this).find("input")
          if !inputNode.attr("checked")
            SubmissionSimilarity.highlightLines(inputNode)
          return
        return
      ->
        $("table.lines tbody tr").each ->
          inputNode = $(this).find("input")
          if !inputNode.attr("checked")
            SubmissionSimilarity.unhighlightLines(inputNode)
          return
        return
    )

    $("table.lines th.check_box_col input").click (event) ->
      SubmissionSimilarity.toggleAllRowHighlights(this)
      event.stopPropagation()
      return
    
    $("input.guilty_check_box").change ->
      SubmissionSimilarity.toggleGuilty(this)
      return

    return

$(document).ready ->
  $(".slideleft .button").click ->
    $lefty = $(this).parent()
    (if parseInt($lefty.css("left"), 10) is 0 then $(this).text("SHOW") else $(this).text("HIDE"))
    $lefty.animate left: (if parseInt($lefty.css("left"), 10) is 0 then 100 - $lefty.outerWidth() else 0)