var page = parent.document.URL.split("/")
page = page[page.length - 1]

fetch("/user/current-user").then(response => response.json()).then(response => displayNav(response))

function displayNav(role) {
    document.getElementById("nav").innerHTML = `
    <div class="menu-container">
        <a class="imdb">IMDb</a>
        <img src="https://www.pngkey.com/png/full/332-3321462_mobile-menu-for-barefoot-resort-vacations-hamburger-menu.png"
            alt="" id="menu-icon">
    </div>
    <div id="menus">
        <a ${page == "" ? `class="active` : ""} href="/">Főoldal</a>
        <a ${page == "movies" ? `class="active` : ""} href="movies">Filmek</a>
        <a ${page == "actors" ? `class="active` : ""} href="actors">Színészek</a>
        ${role.roles == "ROLE_ADMIN" ?
            `
        <a ${page == "profile" ? `class="active` : ""} href="profile">Profil</a>
        <a ${page == "watchlist" ? `class="active` : ""} href="watchlist">Watchlist</a>
        <a ${page == "users" ? `class="active` : ""} href="users">Felhasználók</a>
        <a href="logout">Kijelentkezés</a>
        `
            : role.roles == "ROLE_USER" ?
                `
        <a ${page == "profile" ? `class="active` : ""} href="profile">Profil</a>
        <a ${page == "watchlist" ? `class="active` : ""} href="watchlist">Watchlist</a>
        <a  href="logout">Kijelentkezés</a>
        ` : `<a ${page == "login" ? `class="active` : ""} href="login">Bejelentkezés</a>`
        }
    </div >
    `
    menus = document.getElementById("menus")
    menuBtn = document.getElementById("menu-icon")
    menuBtn.onclick = () => {
        menus.style.display = menus.style.display == "flex" ? "none" : "flex"
    }
}