function addScrollMagic() {
    var controller = new ScrollMagic.Controller({ globalSceneOptions: { triggerHook: 0.9 } });

    for (let i = 1; i <= 3; i++) {
        new ScrollMagic.Scene({ triggerElement: `#comment-${i}` })
            .setClassToggle(`#comment-${i}`, "display")
            //.addIndicators()
            .addTo(controller);
    }
}