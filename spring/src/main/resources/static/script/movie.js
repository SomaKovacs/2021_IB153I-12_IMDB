let id = parent.document.URL.substring(parent.document.URL.indexOf('=') + 1, parent.document.URL.length)
let user
fetch(`/user/current-user`).then(response => response.json()).then(response => user = response)

update()
function update() {
    link = "/updateMovie?id=" + id
    document.getElementById("update").innerHTML =
        `
    <button class="btn" onclick="location.href=link">Film módosítása</button>
    `
}


// #region -----Display Movie----- 
fetch(`/movie/${id}`).then(response => response.json())
    .then(response => displayData(response))

function displayData(movie) {
    document.getElementById("picture").src = movie.picture
    document.getElementById("title").innerHTML = movie.title
    document.getElementById("release-year").innerHTML = movie.release_year
    document.getElementById("description").innerHTML = movie.description
    document.getElementById("duration").innerHTML =
        Math.floor(movie.duration / 60) + " óra " + movie.duration % 60 + " perc"

    let genres_arr = []
    movie.genres.forEach(v => {
        genres_arr.push(v.id.genreName)
    })
    document.getElementById("genres").innerHTML = genres_arr.join(", ")
}

// #endregion

// #region -----Display Ratings----- 

fetch("/rating/list").then(response => response.json()).then(response => displayRatings(response))

function displayRatings(ratings) {
    ratings.forEach(v => {
        if (v.movieId == id) {
            console.log(v)
            addRating(v)
        }
    })
}


function addRating(rating) {
    // user/id
    /*
    let username
    fetch(`/user/${rating.userId}`).then(response => response.json()).then(response => username = response)*/
    let str = ""
    str += `
    <div class="comment" id="comment-${rating.id}">
        <h2>username</h2>
        <span class="date">febr. 13 12:22</span>
        <div class="stars">`

    for (let i = 0; i < rating.star; i++) {
        str += `<div class="star"></div>`
    }

    str +=
        `</div>
        <p>${rating.message}</p>
    </div>
    `
    document.getElementById("comments").innerHTML += str
}

//#endregion

// #region -----Send Rating----- 
let message = document.getElementById("message")
let submit = document.getElementById("submit")

submit.onclick = () => {
    console.log("VADBSF")
    data = {
        "id": 0,
        "message": message.value,
        "movieId": id,
        "star": 2,
        "userId": user.id
    }
    console.log(data)

    fetch('/rating', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    }).then(response => console.log(response))
}

// #endregion
