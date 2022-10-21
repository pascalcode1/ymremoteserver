package ru.pascalcode.ymremote.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.ymremote.server.service.EnvironmentService;
import ru.pascalcode.ymremote.server.service.YandexMusicService;

@RestController
@RequestMapping("environment")
@RequiredArgsConstructor
public class EnvironmentController {

    private final EnvironmentService environmentService;

    private final YandexMusicService yandexMusicService;

    @GetMapping("volumeup")
    public void volumeUp() {
        environmentService.volumeUp();
    }

    @GetMapping("volumedown")
    public void volumeDown() {
        environmentService.volumeDown();
    }

    @GetMapping("restartym")
    public void closeYandexMusic() {
        yandexMusicService.sendCommand("");
        environmentService.sendCommand("1Q1");
        yandexMusicService.sendCommand("");
    }

    @GetMapping("screensaver")
    public void runScreenSaver() {
        environmentService.runScreenSaver();
    }
}
