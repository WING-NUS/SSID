# Place all the behaviors and hooks related to the matching controller here.
# All this logic will automatically be available in application.js.
# You can use CoffeeScript in this file: http://coffeescript.org/

window.PasswordReset ||= {}

$(document).ready ->
  $("form#reset-password").submit (event) ->
    if ($("div.new-password > input").val().length == 0)
      $("div.new-password > p").text("New password cannot be blank").show();
      event.preventDefault();
    else if ($("div.new-password > input").val().length < 6)
      $("div.new-password > p").text("New password must be at least 6 characters long").show();
      event.preventDefault();
    
    if ($("div.new-password > input").val() != $("div.confirm-new-password > input").val())
      $("div.confirm-new-password > p").text("Confirm new password does not match new password").show(); 
      event.preventDefault();
    return

  $("div.new-password > input").keyup (event) -> 
    $("input.submit").removeAttr('disabled');
    $("div.new-password > p").hide();
    $("div.confirm-new-password > p").hide(); 
  return