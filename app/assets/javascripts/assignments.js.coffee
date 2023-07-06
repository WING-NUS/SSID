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

window.Assignment ||= {}

Assignment.updateAdvancedOptions = ->
  $("#assignment_used_fingerprints").click (event) ->
    used_fingerprints = $('input[name="assignment[used_fingerprints]"]:checked');
    if used_fingerprints.length > 0    
      $('input[name="assignment[ngram_size]"]').val(5);    
    else
      $('input[name="assignment[ngram_size]"]').val(4);      
  return  
     
$(document).ready ->
  $ -> 
    if $("#status").length > 0
      $("#status").load statusURL
    Assignment.updateAdvancedOptions()
    return
    # setInterval (->
    #   $("#status").load statusURL
    # ), 3000
