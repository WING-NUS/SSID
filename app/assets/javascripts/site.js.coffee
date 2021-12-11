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

Site.registerDefaultActiveNavigationLink = () -> 
  $("ul#menu li a:first").closest("li").addClass("active_menu_item");
  return

$(document).ready ->
  if $("ul#menu").length > 0
    $(".site_header").addClass("site_header_background");
  return
