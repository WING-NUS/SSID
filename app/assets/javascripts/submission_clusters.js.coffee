window.SubmissionCluster ||= {}

SubmissionCluster.drawClusters = ->
  $("div.cluster").each ->
    clusterId = $(this).attr("id").replace(/^cluster_/, "")
    $.getJSON "/SSID/clusters/"+clusterId, (data) ->
      SubmissionCluster.drawCluster(clusterId, data)
      return
    return
  return

SubmissionCluster.drawCluster = (clusterId, data) ->
  rgraph = new $jit.RGraph(
    'injectInto': 'canvas_wrapper_' + clusterId
    Node        : 'overridable': true, 'type': 'rectangle', 'color': 'white'
    Edge        : 'overridable': true, 'color': 'white'

    # Set polar interpolation, default was linear
    interpolation: 'polar'

    # Change father-child distance.
    levelDistance: 200

    # Create link tag as label
    # This method is called only once for each node/label crated.
    onCreateLabel: (domElement, node) ->
      if node.data.$type != "none"
        if node.data.is_plagiarism
          domElement.innerHTML = "<a href=\""+node.data.logUrl+"\" class=\"is_plagiarism\">"+node.name+"</a>"
        else
          domElement.innerHTML = "<a href=\""+node.data.logUrl+"\">"+node.name+"</a>"
      return
    
    # Center the label
    # This method is called when rendering/moving a label.
    onPlaceLabel: (domElement, node) ->
      style = domElement.style
      left = parseInt(style.left)
      width = domElement.offsetWidth
      style.left = (left - width / 4) + 'px'
      top = parseInt(style.top)
      height = domElement.offsetHeight
      style.top = (top - height / 2) + 'px'
      return
  )

  # Load JSON with node at index 0 as root and plot the graph
  rgraph.loadJSON(data, 0)
  rgraph.refresh()
  return

SubmissionCluster.onLoad = ->
  $ ->
    SubmissionCluster.drawClusters()
    return
