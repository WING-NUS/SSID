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

Site.highlightLink = (link, parentElement) ->
  $(link).closest(parentElement).addClass("highlight")
  return

Site.unhighlightLink = (link, parentElement) ->
  $(link).closest(parentElement).removeClass("highlight")
  return

Site.registerHighlightLink = (link, parentElement) ->
  $(link).hover(
    ->
      Site.highlightLink(this, parentElement)
      return
    ->
      Site.unhighlightLink(this, parentElement)
      return
  )
  return

$(document).ready ->
  if $("ul#menu").length > 0
    $(".site_header").addClass("site_header_background");
  return
