window.Site ||= {}

Site.highlightRowOfLink = (link) ->
  $(link).closest("tr").addClass("highlight")
  return

Site.unhighlightRowOfLink = (link) ->
  $(link).closest("tr").removeClass("highlight")
  return

Site.registerHighlightRowMethodsForLink = (link) ->
  $(link).hover(
    ->
      Site.highlightRowOfLink(this)
      return
    ->
      Site.unhighlightRowOfLink(this)
      return
  )
  return
