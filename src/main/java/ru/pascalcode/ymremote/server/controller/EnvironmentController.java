package ru.pascalcode.ymremote.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.ymremote.server.service.EnvironmentService;

@RestController
@RequestMapping("environment")
@RequiredArgsConstructor
public class EnvironmentController {

    private final EnvironmentService environmentService;

    @GetMapping("volumeup")
    public void volumeUp() {
        environmentService.callVolumeSlider();
        environmentService.sendCommand("0UUUUUUUUUUE");
    }

    @GetMapping("volumedown")
    public void volumeDown() {
        environmentService.callVolumeSlider();
        environmentService.sendCommand("0DDDDDDDDDDE");
    }

    @GetMapping("screensaver")
    public void runScreenSaver() {
        environmentService.runScreenSaver();
    }
}
