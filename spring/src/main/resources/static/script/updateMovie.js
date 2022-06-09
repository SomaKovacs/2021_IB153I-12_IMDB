let id = parent.document.URL.substring(parent.document.URL.indexOf('=') + 1, parent.document.URL.length)

var xmlhttp = new XMLHttpRequest()
xmlhttp.onload = function () {
    let movie = JSON.parse(this.responseText)
    displayData(movie)
}
xmlhttp.open("GET", `/movie/${id}`)
xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
xmlhttp.send()

function displayData(movie) {
    document.getElementById("id").value = movie.id
    document.getElementById("picture").value = movie.picture
    document.getElementById("title").value = movie.title
    document.getElementById("release_year").value = movie.release_year
    document.getElementById("description").value = movie.description
    document.getElementById("duration").value = movie.duration
}

btn = document.getElementById("submit").onclick = function () {
    picture = document.getElementById("picture").value
    title = document.getElementById("title").value
    release_year = document.getElementById("release_year").value
    description = document.getElementById("description").value
    duration = document.getElementById("duration").value
    genres = movie.genres
    participateDtoList = movie.participateDtoList

    var xmlhttp = new XMLHttpRequest()
    xmlhttp.onload = function () {}
    xmlhttp.open("PUT", "/movie");
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify({ "participateDtoList": participateDtoList, "genres": genres, "id": id, "picture": picture, "title": title, "release_year": release_year, "description": description, "duration": duration }))
    window.location.href = "/movies"
}