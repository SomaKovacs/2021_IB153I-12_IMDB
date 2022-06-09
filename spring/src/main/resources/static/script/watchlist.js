var user
fetch(`/user/current-user`).then(response => response.json()).then(response => user = response).then(() => {
    fetch(`/watchlist/${user.id}`).then(response => response.json()).then(response => createList(response))
})


function createList(data) {
    document.getElementById("container").innerHTML = "<h1>Watchlist</h1>"
    for (let id of data) {
        fetch(`/movie/${id.movie_id}`).then(response => response.json()).then(response => displayListItem(response))
    }
}

function displayListItem(movie) {
    console.log(movie)
    let genres_arr = []
    movie.genres.forEach(v => {
        genres_arr.push(v.id.genreName)
    })

    document.getElementById("container").innerHTML += `
        <div class="list-item">
            <p class="delete" id="${movie.id}">X</p>
            <img class="picture"
                src="${movie.picture}" alt="">
            <h2>${movie.title}</h2>
            <span class="info">${movie.release_year} • ${genres_arr.join(", ")}</span>
            <p>${movie.description.substring(0, 120) + "..."}</p>
        </div>`

    document.getElementById(movie.id).onclick = () => {
        fetch(`watchlist/${user.id}/${movie.id}`).then(response => response.json()).then(response => displayListItem(response))
    }
}

