let id = parent.document.URL.substring(parent.document.URL.indexOf('=') + 1, parent.document.URL.length)

fetch(`/person/${id}`).then(response => response.json())
    .then(response => displayMovie(response))

update()
function update() {
    link = "/updateActor?id=" + id
    document.getElementById("update").innerHTML =
        `
    <button class="btn" onclick="location.href=link">Színész módosítása</button>
    `
}


function displayMovie(person) {
    document.getElementById("picture").src = person.picture
    document.getElementById("name").innerHTML = person.name
    document.getElementById("description").innerHTML = person.description
    document.getElementById("birthday").innerHTML = person.dateOfBirth
    document.getElementById("roles").innerHTML = person.roles
}
