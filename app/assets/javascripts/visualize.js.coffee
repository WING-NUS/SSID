# ###
# This file is part of SSID.

# SSID is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.

# SSID is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.

# You should have received a copy of the GNU Lesser General Public License
# along with SSID.  If not, see <http://www.gnu.org/licenses/>.
# ###

# window.VisualizeSimilarityClusterGraph ||= {}
# window.VisualizeSimilarityClusterTable ||= {}
# window.VisualizeTopSimilarSubmissions  ||= {}
# window.Visualize ||= {}

# Visualize.clearResults = ->
#   $("#clusters").html("")
#   $("#ranking").html("")
#   $("#tables").html("")
#   return

# Visualize.registerSubmissionsOptionEvent = ->
#   $("#submissions option").click ->
#     status_text = $(this).parent().next().html()
#     options = $(this).parent().find(":selected")
#     empty_option = null
#     for i in [0..(options.length-1)]
#       if $(options[i]).val() == ""
#         empty_option = i
#     if empty_option != null
#       options.splice(empty_option, 1)
#     $(this).parent().next().html(status_text.replace(/selected\s\d+/, "selected "+options.length))
#     return
#   return

# Visualize.registerExistingClusterSubmissionsOptionEvent = ->
#   $("#existing_cluster_submissions option").click ->
#     status_text = $(this).parent().next().html()
#     options = $(this).parent().find(":selected")
#     empty_option = null
#     for i in [0..(options.length-1)]
#       if $(options[i]).val() == ""
#         empty_option = i
#     if empty_option != null
#       options.splice(empty_option, 1)
#     $(this).parent().next().html(status_text.replace(/selected\s\d+/, "selected "+options.length))
#     return
#   return

# VisualizeSimilarityClusterTable.registerRankingTableEvents = ->
#   $("table.ranking td.rank_check_box_cell").click ->
#     VisualizeSimilarityClusterTable.selectStudentIds($("input", this))
#     return

#   $("table.ranking td.rank_check_box_cell").hover(
#     ->
#       VisualizeSimilarityClusterTable.highlightStudentIds($("input", this))
#       return
#     ->
#       VisualizeSimilarityClusterTable.unhighlightStudentIds($("input", this))
#       return
#   )

#   $("table.ranking input").click (event) ->
#     VisualizeSimilarityClusterTable.selectStudentIds(this)
#     return

#   return

# VisualizeTopSimilarSubmissions.registerClusterTableEvents = (table) ->
#   $("td.check_box_cell", table).click ->
#     VisualizeSimilarityClusterTable.selectStudentIds($("input", this))
#     return

#   $("td.check_box_cell", table).hover(
#     ->
#       VisualizeSimilarityClusterTable.highlightStudentIds($("input", this))
#       return
#     ->
#       VisualizeSimilarityClusterTable.unhighlightStudentIds($("input", this))
#       return
#   )

#   $("input", table).click (event) ->
#     VisualizeSimilarityClusterTable.selectStudentIds(this)
#     return

#   return

# VisualizeSimilarityClusterTable.registerClusterTableEvents = (table) ->
#   $("td.check_box_cell", table).click ->
#     VisualizeSimilarityClusterTable.selectStudentIds($("input", this))
#     return

#   $("td.check_box_cell", table).hover(
#     ->
#       VisualizeSimilarityClusterTable.highlightStudentIds($("input", this))
#       return
#     ->
#       VisualizeSimilarityClusterTable.unhighlightStudentIds($("input", this))
#       return
#   )

#   $("input", table).click (event) ->
#     VisualizeSimilarityClusterTable.selectStudentIds(this)
#     return

#   $("td.hide_link_cell a", table).click ->
#     VisualizeSimilarityClusterTable.toggleStudentIds(this)
#     return false

#   return

# VisualizeSimilarityClusterTable.toggleStudentIds = (el) ->
#   # Get rows
#   rows = $(el).closest("tr").nextAll("tr")

#   if rows.first().css("display") == "none"
#     $(el).html($(el).html().replace(/^Expand/, "Collapse"))
#     rows.each (row_idx, row_el) ->
#       $(row_el).css("display", "table-row")
#       return
#   else
#     $(el).html($(el).html().replace(/^Collapse/, "Expand"))
#     rows.each (row_idx, row_el) ->
#       $(row_el).css("display", "none")
#       return
#   return

# VisualizeSimilarityClusterTable.selectStudentIds = (el) ->
#   className = $(el).val()
#   isChecked = $(el).attr("checked")
#   $("table input[value="+className+"]").each (inputIdx, inputEl) ->
#     if isChecked
#       $(inputEl).closest("tr").removeClass("highlight")
#       $(inputEl).removeAttr("checked")
#     else
#       $(inputEl).closest("tr").addClass("highlight")
#       $(inputEl).attr("checked", "checked")
#     return
#   return

# VisualizeSimilarityClusterTable.highlightStudentIds = (el) ->
#   className = $(el).val()
#   $("table input[value="+className+"]").each (inputIdx, inputEl) ->
#     $(inputEl).closest("tr").addClass("highlight")
#     return
#   return

# VisualizeSimilarityClusterTable.unhighlightStudentIds = (el) ->
#   className = $(el).val()
#   isChecked = $(el).attr("checked")
#   if !isChecked
#     $("table input[value="+className+"]").each (inputIdx, inputEl) ->
#       $(inputEl).closest("tr").removeClass("highlight")
#       return
#   return

# VisualizeTopSimilarSubmissions.showTable = (el) ->
#   $(el).attr("disabled", "disabled")
#   $(el).attr("value", "Loading...")
#   $("#tables").html("")

#   # Fetch selected students
#   options = $("#submissions option:selected")
#   empty_option = null
#   for i in [0..(options.length-1)]
#     if $(options[i]).val() == ""
#       empty_option = i
#   if empty_option != null
#     options.splice(empty_option, 1)
#   studentIds = (options.map ->
#     return $(this).val()
#   ).get()

#   # Init GET data
#   data = {}

#   # Fetch assignment_id / course_id
#   if $("#submissions_assignment_selector option:selected").html() == "All"
#     data["course_id"] = $("#submissions_assignment_selector").val()
#   else
#     data["assignment_id"] = $("#submissions_assignment_selector").val()

#   # Fetch num to display
#   data["num_display"] = $("#num_most_similar_submissions").val()

#   # Create containers
#   for studentId in studentIds
#     $("#tables").append("<table id=\"table_student_"+studentId+"\"></table>")

#   # Fill each container
#   for studentId in studentIds
#     do (studentId) ->
#       data["studentId"] = studentId
#       $.get("./students/"+studentId+"/submission_similarities/show_table_partial", data,
#         (html) ->
#           $("#table_student_"+studentId).replaceWith html
#           VisualizeTopSimilarSubmissions.registerClusterTableEvents($("#table_student_"+studentId))
#           VisualizeTopSimilarSubmissions.drawBars($("#table_student_"+studentId))
#           return
#         "html"
#       )

#   $(el).attr("value", "Show Tables")
#   $(el).removeAttr("disabled")
#   return

# VisualizeTopSimilarSubmissions.drawBars = (table) ->
#   $("span.similarity_value", table).each ->
#     similarity = parseFloat $(this).html().replace(/%$/, "")
#     similarity_class = Math.floor(similarity/10) * 10
#     if similarity_class < 50
#       similarity_class = 40
#     bar = $(this).prev()
#     bar.addClass("legend_"+similarity_class)
#     bar.css("width", (0.8 * similarity).toString() + "%")
#     return
#   return

# VisualizeSimilarityClusterTable.showTable = (el) ->
#   $(el).attr("disabled", "disabled")
#   $(el).attr("value", "Loading...")
#   $("#ranking").html("")
#   $("#clusters").html("")

#   # Fetch selected students
#   options = $("#existing_cluster_submissions option:selected")
#   empty_option = null
#   for i in [0..(options.length-1)]
#     if $(options[i]).val() == ""
#       empty_option = i
#   if empty_option != null
#     options.splice(empty_option, 1)
#   existing_cluster_studentIds = (options.map ->
#     return $(this).val()
#   ).get()

#   # Init
#   clusterIds = []
#   clusterIdMembershipDict = {}

#   if existing_cluster_studentIds.length > 0
#     # Get assignment_id / course_id
#     existing_clusters_data = { "student_ids" : existing_cluster_studentIds }
#     if $("#existing_clusters_assignment_selector option:selected").html() == "All"
#       existing_clusters_data["course_id"] = $("#existing_clusters_assignment_selector").val()
#     else
#       existing_clusters_data["assignment_id"] = $("#existing_clusters_assignment_selector").val()

#     # Find cluster Ids and cluster Group Ids using ajax
#     $.getJSON "./clusters/ids_and_group_ids_for_student_ids", existing_clusters_data, (data) ->
#       for dict in data
#         clusterIds.push dict["id"]
#         clusterIdMembershipDict[dict["id"]] = dict["group_id"]
#       # Fetch selected cluster ids
#       for node in $("#similarity_clusters").find("input[name=submission_cluster_groups]:checked")
#         clusterGroupId = $(node).attr("id").replace("cluster_group_", "")
#         for clusterId in $(node).val().split(",")
#           if !clusterIdMembershipDict[clusterId]
#             clusterIds.push clusterId
#             clusterIdMembershipDict[clusterId] = clusterGroupId
#       VisualizeSimilarityClusterTable.drawTables(el, clusterIds)
#       return
#   else
#     # Fetch selected cluster ids
#     for node in $("#similarity_clusters").find("input[name=submission_cluster_groups]:checked")
#       clusterGroupId = $(node).attr("id").replace("cluster_group_", "")
#       for clusterId in $(node).val().split(",")
#         if !clusterIdMembershipDict[clusterId]
#           clusterIds.push clusterId
#           clusterIdMembershipDict[clusterId] = clusterGroupId
#     VisualizeSimilarityClusterTable.drawTables(el, clusterIds)
#   return

# VisualizeSimilarityClusterTable.drawTables = (el, clusterIds) ->
#   if clusterIds.length > 0
#     $("#ranking").html("<h3>Student Submission Similarity Ranking</h3>\nStudent IDs from the shown cluster tables, ranked by number of cluster occurrences:")
#     $("#clusters").html("<h3>Submission Similarity Cluster Tables</h3>")

#   # Draw Ranking table
#   $.get("./clusters/show_ranking_partial", { "clusterIds" : clusterIds },
#     (html) ->
#       $("#ranking").append html
#       VisualizeSimilarityClusterTable.registerRankingTableEvents()
#       return
#     "html"
#   )

#   # Create containers for clusters so we can fix the order of clusters
#   for clusterId in clusterIds
#     $("#clusters").append "<table id=\"cluster_"+clusterId+"\" class=\"cluster\"></table>"
  
#   # Create tables
#   for clusterId in clusterIds
#     # Use closure, otherwise vars in callback will be wrong
#     do (clusterId) ->
#       $.get("./clusters/"+clusterId+"/show_table_partial",
#         (html) ->
#           $("#cluster_"+clusterId).replaceWith html
#           VisualizeSimilarityClusterTable.registerClusterTableEvents($("#cluster_"+clusterId))
#           return
#         "html"
#       )
#       return

#   $(el).attr("value", "Show Tables")
#   $(el).removeAttr("disabled")
#   return

# VisualizeSimilarityClusterGraph.showGraph = (el) ->
#   $(el).attr("disabled", "disabled")
#   $(el).attr("value", "Loading...")
#   $("#clusters").html("")
  
#   # Fetch selected submissions
#   options = $("#submissions option:selected")
#   empty_option = null
#   for i in [0..(options.length-1)]
#     if $(options[i]).val() == ""
#       empty_option = i
#   if empty_option != null
#     options.splice(empty_option, 1)
#   submissionIds = (options.map ->
#     return $(this).val()
#   ).get()

#   if submissionIds.length > 0
#     # Create html container
#     clusterId = submissionIds.join("_")
#     $("#clusters").append "<div id=\"cluster_"+clusterId+"\" class=\"cluster\"></div>"
    
#     # Get template and data for drawing
#     $.get "./clusters/show_graph_partial", (html) ->
#       clusterId = submissionIds.join("_")
#       # Create canvas
#       $("#cluster_"+clusterId).append html
#       # Get extra description
#       assignment_title = $("#submissions_assignment_selector option:selected").html()
#       student_ids_string = submissionIds.join(", ")
#       # Add description to title
#       $("#cluster_"+clusterId+" h3 span").html(student_ids_string)
#       $("#cluster_"+clusterId+" h3:eq(0)").before("<h3>Assignment: "+assignment_title+"</h3>")
#       # Set canvas id
#       $("#canvas_wrapper_").attr("id", "canvas_wrapper_"+clusterId)
#       # Draw into html
#       $.getJSON "./clusters/show_for_submission_ids", { "ids" : submissionIds }, (data) ->
#         SubmissionCluster.drawCluster(clusterId, data)
#         return
#       return

#   # Fetch selected students
#   options = $("#existing_cluster_submissions option:selected")
#   empty_option = null
#   for i in [0..(options.length-1)]
#     if $(options[i]).val() == ""
#       empty_option = i
#   if empty_option != null
#     options.splice(empty_option, 1)
#   existing_cluster_studentIds = (options.map ->
#     return $(this).val()
#   ).get()

#   # Init
#   clusterIds = []
#   clusterIdMembershipDict = {}

#   if existing_cluster_studentIds.length > 0
#     # Get assignment_id / course_id
#     existing_clusters_data = { "student_ids" : existing_cluster_studentIds }
#     if $("#existing_clusters_assignment_selector option:selected").html() == "All"
#       existing_clusters_data["course_id"] = $("#existing_clusters_assignment_selector").val()
#     else
#       existing_clusters_data["assignment_id"] = $("#existing_clusters_assignment_selector").val()

#     # Find cluster Ids and cluster Group Ids using ajax
#     $.getJSON "./clusters/ids_and_group_ids_for_student_ids", existing_clusters_data, (data) ->
#       for dict in data
#         clusterIds.push dict["id"]
#         clusterIdMembershipDict[dict["id"]] = dict["group_id"]
#       # Fetch selected cluster ids
#       for node in $("#similarity_clusters").find("input[name=submission_cluster_groups]:checked")
#         clusterGroupId = $(node).attr("id").replace("cluster_group_", "")
#         for clusterId in $(node).val().split(",")
#           if !clusterIdMembershipDict[clusterId]
#             clusterIds.push clusterId
#             clusterIdMembershipDict[clusterId] = clusterGroupId
#       VisualizeSimilarityClusterGraph.drawClusters(el, clusterIds, clusterIdMembershipDict)
#       return
#   else
#     # Fetch selected cluster ids
#     for node in $("#similarity_clusters").find("input[name=submission_cluster_groups]:checked")
#       clusterGroupId = $(node).attr("id").replace("cluster_group_", "")
#       for clusterId in $(node).val().split(",")
#         if !clusterIdMembershipDict[clusterId]
#           clusterIds.push clusterId
#           clusterIdMembershipDict[clusterId] = clusterGroupId
#     VisualizeSimilarityClusterGraph.drawClusters(el, clusterIds, clusterIdMembershipDict)
#   return

# VisualizeSimilarityClusterGraph.drawClusters = (el, clusterIds, clusterIdMembershipDict) ->
#   # Create containers for clusters so we can fix the order of clusters
#   for clusterId in clusterIds
#     $("#clusters").append "<div id=\"cluster_"+clusterId+"\" class=\"cluster\"></div>"
  
#   # Create canvases for drawing
#   for clusterId in clusterIds
#     # Use closure, otherwise vars in callback will be wrong
#     do (clusterId) ->
#       $.get "./clusters/"+clusterId+"/show_graph_partial", (html) ->
#         # Create html container
#         $("#cluster_"+clusterId).append html
#         # Get extra description from table
#         tr_node = $("#cluster_group_"+clusterIdMembershipDict[clusterId]).closest("tr")
#         assignment_title = $("td:eq(1)", tr_node).html()
#         cut_off_criterion = $("td:eq(2)", tr_node).html()
#         # Add description to title
#         $("#cluster_"+clusterId+" h3:eq(0)").before("<h3>Assignment: "+assignment_title+" (Cut-Off Criterion "+cut_off_criterion+"%)</h3>")
#         # Draw into html
#         $.getJSON "./clusters/"+clusterId, (data) ->
#           SubmissionCluster.drawCluster(clusterId, data)
#           return
#         return
#       return

#   $(el).attr("value", "Show Graphs")
#   $(el).removeAttr("disabled")
#   return

# VisualizeSimilarityClusterGraph.selectAssignmentForNewClusterGroup = (el) ->
#   $(el).parent("form").attr("action", $(el).val())
#   return

# VisualizeSimilarityClusterGraph.selectAssignmentForSubmissions = (el) ->
#   $(el).nextAll("span").first().html("Loading...")
#   $(el).nextAll("select").first().attr("disabled", "disabled")
#   assignment_id = $(el).val()
#   $.getJSON "./assignments/"+assignment_id+"/submissions", (data) ->
#     options = ["<option value=\"\"></option>"]
#     for submission in data
#       options.push "<option value=\""+submission["id"]+"\">"+submission["student_id_string"]+"</option>"
#     $("#submissions").html(options.join(""))
#     $(el).nextAll("span").first().html("(selected 0 of "+(options.length-1)+")")
#     $(el).nextAll("select").first().removeAttr("disabled")
#     Visualize.registerSubmissionsOptionEvent()
#     return
#   return

# VisualizeTopSimilarSubmissions.selectAssignmentForSubmissions = (el) ->
#   $(el).nextAll("span").first().html("Loading...")
#   $(el).nextAll("select").first().attr("disabled", "disabled")
#   assignment_id = $(el).val()
#   $.getJSON "./assignments/"+assignment_id+"/submissions", (data) ->
#     options = ["<option value=\"\"></option>"]
#     for submission in data
#       options.push "<option value=\""+submission["student_id"]+"\">"+submission["student_id_string"]+"</option>"
#     $("#submissions").html(options.join(""))
#     $(el).nextAll("span").first().html("(selected 0 of "+(options.length-1)+")")
#     $(el).nextAll("select").first().removeAttr("disabled")
#     Visualize.registerSubmissionsOptionEvent()
#     return
#   return

# VisualizeSimilarityClusterGraph.selectAssignmentForExistingClusters = (el) ->
#   $(el).nextAll("span").first().html("Loading...")
#   $(el).nextAll("select").first().attr("disabled", "disabled")
#   # Get assignment_id / course_id
#   selected_id = $(el).val()
#   if $("option:selected", el).html() == "All"
#     url = "./courses/"+selected_id+"/cluster_students"
#   else
#     url = "./assignments/"+selected_id+"/cluster_students"

#   $.getJSON url, (data) ->
#     options = ["<option value=\"\"></option>"]
#     for student in data
#       options.push "<option value=\""+student["id"]+"\">"+student["id_string"]+"</option>"
#     $("#existing_cluster_submissions").html(options.join(""))
#     $(el).nextAll("span").first().html("(selected 0 of "+(options.length-1)+")")
#     $(el).nextAll("select").first().removeAttr("disabled")
#     Visualize.registerExistingClusterSubmissionsOptionEvent()
#     return
#   return

# window.Visualize ||= {}

# Visualize.onLoad = ->
#   $ ->
#     Visualize.registerSubmissionsOptionEvent()
#     Visualize.registerExistingClusterSubmissionsOptionEvent()

#     $("#similarity_clusters td").click ->
#       if $(this).parent().find("input").attr("checked")
#         $(this).parent().find("input").removeAttr("checked")
#       else
#         $(this).parent().find("input").attr("checked", "checked")
#       return

#     $("#similarity_clusters input").click (event) ->
#       event.stopPropagation()
#       return
    
#     $("#clear_results").click ->
#       Visualize.clearResults()
#       return

#     return
#   return
