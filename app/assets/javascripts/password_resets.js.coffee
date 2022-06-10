# Place all the behaviors and hooks related to the matching controller here.
# All this logic will automatically be available in application.js.
# You can use CoffeeScript in this file: http://coffeescript.org/

window.PasswordReset ||= {}

PasswordReset.validatePassword = -> 
  $("form#reset-password").submit (event) ->
    if ($("div.new-password > input").val().length == 0)
      $("div.new-password > p").text("New password cannot be blank").show();
      event.preventDefault();
    else if ($("div.new-password > input").val().length < 8)
      $("div.new-password > p").text("New password must be at least 8 characters long").show();
      event.preventDefault();
    else if ($("div.new-password > input").val().match(/[a-z]+/) == null)
      $("div.new-password > p").text("New password must contain at least 1 lower case character").show();
      event.preventDefault();    
    else if ($("div.new-password > input").val().match(/[A-Z]+/) == null)
      $("div.new-password > p").text("New password must contain at least 1 upper case character").show();
      event.preventDefault();   
    else if ($("div.new-password > input").val().match(/[0-9~!@#$%^&*()+=|]+/) == null)
      $("div.new-password > p").text("New password must contain at least 1 digit or special character").show();
      event.preventDefault();      
    
    if ($("div.new-password > input").val() != $("div.confirm-new-password > input").val())
      $("div.confirm-new-password > p").text("Confirm new password does not match new password").show(); 
      event.preventDefault();
    return
  return 

PasswordReset.resetForm = -> 
  $("div.new-password > input").keyup (event) -> 
    $("input.submit").removeAttr('disabled');
    $("div.new-password > p").hide();
    $("div.confirm-new-password > p").hide(); 

  $("div.confirm-new-password > input").keyup (event) -> 
    $("input.submit").removeAttr('disabled');
    $("div.new-password > p").hide();
    $("div.confirm-new-password > p").hide(); 
  return 

$(document).ready ->
  $ ->
    PasswordReset.validatePassword()
    PasswordReset.resetForm()
    return