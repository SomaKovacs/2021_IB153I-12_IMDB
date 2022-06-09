var controller = new ScrollMagic.Controller({ globalSceneOptions: { triggerHook: 0.7 } });

for (let i = 1; i <= 3; i++) {
    new ScrollMagic.Scene({ triggerElement: `#content${i}` })
        .setClassToggle(`#text-content${i}, #img${i}`, "display")
        .addTo(controller);
}


