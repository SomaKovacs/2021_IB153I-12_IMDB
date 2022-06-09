//Ennyi card van oldalanként
const CARD_PER_PAGE = 16
var url = parent.document.URL.split("/")
url = url[url.length - 1].substr(0, url.length + 1) == "movie" ? "movie" : "person"
var data

fetch(url + `/list`).then(response => response.json()).then(response => data = response)
    .then(() => displayCards(1))
    .then(() => displayPageBtns(Math.floor(data.length / CARD_PER_PAGE) + 1))


//Card-ok generálása, megjelenítése
function displayCards(page) {
    let cards = document.getElementById("cards")
    cards.innerHTML = ""

    let start = (page - 1) * CARD_PER_PAGE
    let end = start + (start + CARD_PER_PAGE > data.length ? data.length % start : CARD_PER_PAGE)


    for (let i = start; i < end; i++) {
        let id = (url == "movie" ? "m" : "a") + "-" + i
        let path = url == "movie" ? "movie" : "actor"
        let title = url == "movie" ? data[i].title : data[i].name

        cards.innerHTML +=
            `<a href="/${path}?id=${data[i].id}" class="scroll-anim card" id="${id}">
                ${url == "movie" ?
                `<div class="percent">
                    <p>68%</p>
                </div>` : ""}
                <img alt="${title}"
                    src="${data[i].picture}">
                <p>
                    ${title}
                </p>
            </a>`
    }

    //.....
    let script = document.createElement("script")
    script.src = "/script/scroll.js"
    document.documentElement.firstChild.appendChild(script)

    document.getElementById("loader").remove()
}


//Alsó navigációs panel létrehozása a megjelenített kártyák függvényében
function displayPageBtns(btnCount) {
    var pagination = document.getElementById("pagination")
    for (let i = 0; i < btnCount; i++) {
        const content = document.createTextNode(`${i + 1}`)
        const btn = document.createElement("a")
        btn.href = "#"
        btn.appendChild(content)
        btn.classList.add(`page-btn`)
        btn.setAttribute("id", `#page-${i + 1}`);
        btn.onclick = () => {
            displayCards(i + 1)
            btn.classList.add("active")
        }
        pagination.appendChild(btn)
    }
}

