var data = []

getData()

function getData() {
    var xmlhttp = new XMLHttpRequest()
    xmlhttp.onload = function () {
        data = JSON.parse(this.responseText)
        displayUsers()
    }
    xmlhttp.open("GET", "/user/list")
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    xmlhttp.send()
}

function displayUsers() {
    let end = data.length
    let table = document.getElementById("users");

    for (let i = 0; i < end; i++) {
        let row = table.insertRow(i + 1);
        let cell0 = row.insertCell(0);
        cell0.innerHTML = data[i].userName;
        let cell1 = row.insertCell(1);
        cell1.innerHTML = data[i].email;
        let cell2 = row.insertCell(2);
        cell2.innerHTML = data[i].dateOfBirth;
        let cell3 = row.insertCell(3);
        cell3.innerHTML = data[i].roles;
        let cell4 = row.insertCell(4);
        cell4.innerHTML = data[i].id;
    }
}

btn = document.getElementById("submit").onclick = function () {
    userid = document.getElementById("userid").value
    var xmlhttp = new XMLHttpRequest()
    xmlhttp.onload = function () {}
    xmlhttp.open("DELETE", "/user/" + userid);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify(userid))
}

