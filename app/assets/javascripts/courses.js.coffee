window.Course ||= {}

Course.onLoad = ->
  $ ->
    $("table a").each ->
      Site.registerHighlightRowMethodsForLink(this)
      return
    return
