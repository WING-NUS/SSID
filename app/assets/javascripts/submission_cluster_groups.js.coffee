window.SubmissionClusterGroup ||= {}

SubmissionClusterGroup.disableUserDefinedTextField = ->
  $('#submission_cluster_group_cut_off_criterion').attr("disabled", "disabled")
  $('#submission_cluster_group_cut_off_criterion').addClass("disabled")

SubmissionClusterGroup.enableUserDefinedTextField = ->
  $('#submission_cluster_group_cut_off_criterion').removeAttr("disabled")
  $('#submission_cluster_group_cut_off_criterion').removeClass("disabled")

SubmissionClusterGroup.onLoad = ->
  $ ->
    $("table a").each ->
      Site.registerHighlightRowMethodsForLink(this)
      return
    return
