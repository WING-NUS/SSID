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
      Site.registerHighlightLink(this, "tr");
      return
    return
