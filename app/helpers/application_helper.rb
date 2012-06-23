=begin
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
=end

# Methods added to this helper will be available to all templates in the application.
module ApplicationHelper
  def version
    "1.0"
  end

  def system
    "Student Submissions Integrity Diagnosis (SSID) System v" +  version
  end

  def highlightColor_row
    "rgb(250,230,142)"
  end

  def highlightColor_link
    "#FF6C00"
  end

  def genHelp(text)
    #"<sub>[<a href=\"\" title=\"#{text}\" onclick=\"return false;\">?</a>]</sub>"
    text = escape_javascript(text)
    "[<a href=\"\" style=\"text-decoration: none; background-color: transparent; color: inherit;\" onclick=\"return false;\" onmouseover=\"Tip('" + h(text) + "')\" onmouseout=\"UnTip();\">?</a>]"
  end
end
