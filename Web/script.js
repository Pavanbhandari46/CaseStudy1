function validateForm() {
    var un = document.loginform.usr.value;
    var pw = document.loginform.pword.value;
    var checkbox = document.getElementById("checkbox").checked;

    var username = "LTI"; 
    var password = "123";
    if ((un == username) && (pw == password)) {
        alert ("Login was successful");
        if (checkbox) {
            setCookie("username", un, 1);
            setCookie("password", pw, 1);
        }
        return true;
    }
    else {
        alert ("Login was unsuccessfull.............");
        document.getElementById("error-message").innerHTML = "Incorrect Username/Password invaild!";
        return false;
    }
  }

  function checkCookie() {
      var usernameCookie = getCookie("username");
      var passwordCookie = getCookie("password");
      if (usernameCookie != "" && passwordCookie != "") {
          if (usernameCookie == "LTI" && passwordCookie == "123") {
            window.location = "welcome.html";
          }
      }
  }

  function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

  function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
      var c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }