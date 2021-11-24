/* Update action url when delete action is triggered */
$(".dropdown-item").click((event) => {
  if ($(event.target).is('[data-bs-toggle=modal]')) {
    var modal = $(event.target);
    var url = $(modal).data("bs-url");
    $(".modal-footer > .button_to").attr("action", url);
  }

})
