window.Assignment ||= {}

Assignment.onLoad = ->
  $ ->
    $("table a").each ->
      Site.registerHighlightRowMethodsForLink(this)
      return
    return
