btn = document.getElementById("submit").onclick = function () {
  username = document.getElementById("username").value
  password = document.getElementById("password").value
  email = document.getElementById("email").value
  birthday = document.getElementById("birthday").value

  var xmlhttp = new XMLHttpRequest()
  xmlhttp.onload = function () {
    //console.log(this.responseText)
    document.getElementById("error").innerHTML = this.responseText ? "Sikertelen" : "Sikeres" + " regisztráció."
  }
  xmlhttp.open("POST", "/registration");
  xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xmlhttp.send(JSON.stringify({ "userName": username, "password": password, "email": email, "birthDay": birthday }))
}