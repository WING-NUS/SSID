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

    $("table.lines th.check_box_col input").click (event) ->
      SubmissionSimilarity.toggleAllRowHighlights(this)
      event.stopPropagation()
      return
    
    $("input.guilty_check_box").change ->
      SubmissionSimilarity.toggleGuilty(this)
      return

#   $("table.lines th input").attr("checked", "checked")
#   SubmissionSimilarity.toggleAllRowHighlights($("table.lines th input"))

    return
