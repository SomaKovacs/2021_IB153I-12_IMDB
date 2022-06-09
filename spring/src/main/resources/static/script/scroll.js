var controller = new ScrollMagic.Controller({ globalSceneOptions: { triggerHook: 0.85 } });

var elements = document.getElementsByClassName("scroll-anim")
for (element of elements) {
    new ScrollMagic.Scene({ triggerElement: `#${element.id}` })
        .setClassToggle(`#${element.id}`, "display")
        //.addIndicators()
        .addTo(controller)
}



