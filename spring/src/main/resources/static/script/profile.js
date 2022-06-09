var username = document.getElementById("username")
var email = document.getElementById("email")
var birthday = document.getElementById("birthday")
var picture = document.getElementById("picture")
var profileImg = document.getElementById("profile-img")
var user

displayData()
function displayData() {
    fetch(`/user/current-user`).then(response => response.json()).then(response => user = response).then(() => {
        username.value = user.userName
        email.value = user.email
        birthday.value = user.dateOfBirth
        picture.value = user.picture
        profileImg.src = user.picture == "" || user.picture == undefined ?
            "https://molsoft.hu/wp-content/uploads/2020/12/blank-profile-picture-973460_1280.png" : user.picture
    })
}


document.getElementById("submit").onclick = () => {
    data = {
        "active": user.active,
        "dateOfBirth": birthday.value,
        "email": email.value,
        "id": user.id,
        "picture": picture.value,
        "roles": user.roles,
        "userName": username.value,
    }
    fetch('/user', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    }).then(() => displayData())
}

