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

Site.registerActiveNavigationLink = (page) ->
  currentLocation = $(page)[0].location.href
  navigationLinks = $(page).find("ul#menu li")
  for link in navigationLinks
    if link.children[0].href == currentLocation
      $(link).addClass("active_menu_item")   
      break  
  return

Site.setClipHeight = (page) -> 
  divSiteClip = $(page).find("div.site-clip")
  clipWidth = $(divSiteClip).width();
  $(divSiteClip).css('height', 9*clipWidth/16.0);
  return

$(document).ready ->
  Site.setClipHeight($(this));

  if $(".site-introduction").length > 0
    $("body").css('background-image', "radial-gradient(
        at top right,
        #d4e5ea,
        white 75%
        )");
    $("body").css('background-repeat', "no-repeat");

  # if (window.location.pathname && !window.location.pathname.includes('cover'))
  #   $(".site-login").addClass("site-login-hidden")
  return
