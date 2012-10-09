window.VisualizeSimilarityClusterGraph ||= {}

VisualizeSimilarityClusterGraph.showGraph = (el) ->
  $(el).attr("disabled", "disabled")
  $(el).attr("value", "Loading...")
  $("#clusters").html("")
  
  # Fetch selected submissions
  options = $("#submissions option:selected")
  empty_option = null
  for i in [0..(options.length-1)]
    if $(options[i]).val() == ""
      empty_option = i
  if empty_option != null
    options.splice(empty_option, 1)
  submissionIds = (options.map ->
    return $(this).val()
  ).get()

  if submissionIds.length > 0
    # Create html container
    clusterId = submissionIds.join("_")
    $("#clusters").append "<div id=\"cluster_"+clusterId+"\" class=\"cluster\"></div>"
    
    # Get template and data for drawing
    $.get "/SSID/clusters/show_graph_partial", (html) ->
      clusterId = submissionIds.join("_")
      # Create canvas
      $("#cluster_"+clusterId).append html
      # Get extra description
      assignment_title = $("#submissions_assignment_selector option:selected").html()
      student_ids_string = submissionIds.join(", ")
      # Add description to title
      $("#cluster_"+clusterId+" h3 span").html(student_ids_string)
      $("#cluster_"+clusterId+" h3:eq(0)").before("<h3>Assignment: "+assignment_title+"</h3>")
      # Set canvas id
      $("#canvas_wrapper_").attr("id", "canvas_wrapper_"+clusterId)
      # Draw into html
      $.getJSON "/SSID/clusters/show_for_submission_ids", { "ids" : submissionIds }, (data) ->
        SubmissionCluster.drawCluster(clusterId, data)
        return
      return

  # Fetch selected cluster ids
  clusterIds = []
  clusterIdMembershipDict = {}
  for node in $("#similarity_clusters").find("input[name=submission_cluster_groups]:checked")
    clusterGroupId = $(node).attr("id").replace("cluster_group_", "")
    for clusterId in $(node).val().split(",")
      clusterIds.push clusterId
      clusterIdMembershipDict[clusterId] = clusterGroupId

  # Create containers for clusters so we can fix the order of clusters
  for clusterId in clusterIds
    $("#clusters").append "<div id=\"cluster_"+clusterId+"\" class=\"cluster\"></div>"
  
  # Create canvases for drawing
  for clusterId in clusterIds
    # Use closure, otherwise vars in callback will be wrong
    do (clusterId) ->
      $.get "/SSID/clusters/"+clusterId+"/show_graph_partial", (html) ->
        # Create html container
        $("#cluster_"+clusterId).append html
        # Get extra description from table
        tr_node = $("#cluster_group_"+clusterIdMembershipDict[clusterId]).closest("tr")
        assignment_title = $("td:eq(1)", tr_node).html()
        cut_off_criterion = $("td:eq(2)", tr_node).html()
        # Add description to title
        $("#cluster_"+clusterId+" h3:eq(0)").before("<h3>Assignment: "+assignment_title+" (Cut-Off Criterion "+cut_off_criterion+"%)</h3>")
        # Draw into html
        $.getJSON "/SSID/clusters/"+clusterId, (data) ->
          SubmissionCluster.drawCluster(clusterId, data)
          return
        return

  $(el).attr("value", "Show Graph")
  $(el).removeAttr("disabled")
  return

VisualizeSimilarityClusterGraph.selectAssignmentForNewClusterGroup = (el) ->
  $(el).parent("form").attr("action", $(el).val())
  return

VisualizeSimilarityClusterGraph.selectAssignmentForSubmissions = (el) ->
  $(el).nextAll("span").html("Loading...")
  $(el).nextAll("select").attr("disabled", "disabled")
  assignment_id = $(el).val()
  $.getJSON "/SSID/assignments/"+assignment_id+"/submissions", (data) ->
    options = ["<option value=\"\"></option>"]
    for submission in data
      options.push "<option value=\""+submission["id"]+"\">"+submission["student_id_string"]+"</option>"
    $("#submissions").html(options.join(""))
    $(el).nextAll("span").html("(selected 0 of "+(options.length-1)+")")
    $(el).nextAll("select").removeAttr("disabled")
    return
  return

window.Visualize ||= {}

Visualize.onLoad = ->
  $ ->
    $("#submissions option").click ->
      status_text = $(this).parent().next().html()
      options = $(this).parent().find(":selected")
      empty_option = null
      for i in [0..(options.length-1)]
        if $(options[i]).val() == ""
          empty_option = i
      if empty_option != null
        options.splice(empty_option, 1)
      $(this).parent().next().html(status_text.replace(/selected\s\d+/, "selected "+options.length))
      return

    $("#similarity_clusters td").click ->
      if $(this).parent().find("input").attr("checked")
        $(this).parent().find("input").removeAttr("checked")
      else
        $(this).parent().find("input").attr("checked", "checked")
      return
    $("#similarity_clusters input").click (event) ->
      event.stopPropagation()
      return
    return
  return
