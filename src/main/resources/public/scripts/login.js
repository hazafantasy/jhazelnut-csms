
function doLogin() {
  var inputEmail = $("#email").val();
  var inputPass = $("#pass").val();

  $("#divErrMsg").hide();

  //Make the login validation
  var request = $.ajax({
    method: "POST",
    url: "/loginvalidation",
    dataType: "json",
    data: {
      user: inputEmail,
      pass: inputPass
    }
  });

  request.done(doLoginDoneCallBack);
  request.fail(doLoginFailCallBack);
}

//Executed when request is done succesfully
function doLoginDoneCallBack(msg) {
  if(msg.jhlContent == "OK") {
    window.location.replace("/dashboard");
  } else {
    $("#divErrMsg").show();
  }
}

//Executed when server timeout or bad request
//(no internet or connection lost)
function doLoginFailCallBack(jqXHR, textStatus) {
  alert( "Request failed: " + textStatus );
}
