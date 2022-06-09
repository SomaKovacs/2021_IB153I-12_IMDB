let id = parent.document.URL.substring(parent.document.URL.indexOf('=') + 1, parent.document.URL.length)

var xmlhttp = new XMLHttpRequest()
xmlhttp.onload = function () {
    let person = JSON.parse(this.responseText)
    displayData(person)
}
xmlhttp.open("GET", `/person/${id}`)
xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
xmlhttp.send()

function displayData(person) {
    document.getElementById("id").value = person.id
    document.getElementById("picture").value = person.picture
    document.getElementById("name").value = person.name
    document.getElementById("description").value = person.description
    document.getElementById("dateOfBirth").value = person.dateOfBirth
}

btn = document.getElementById("submit").onclick = function () {
    picture = document.getElementById("picture").value
    name = document.getElementById("name").value
    description = document.getElementById("description").value
    dateOfBirth = document.getElementById("dateOfBirth").value
    roles = person.roles

    var xmlhttp = new XMLHttpRequest()
    xmlhttp.onload = function () {}
    xmlhttp.open("PUT", "/actor");
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify({"id": id, "picture": picture , "name": name , "description": description, "dateOfBirth": dateOfBirth, "roles": roles}))
    window.location.href = "/actors"
}