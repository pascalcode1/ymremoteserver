package ru.pascalcode.ymremote.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.ymremote.server.service.EnvironmentService;
import ru.pascalcode.ymremote.server.service.YandexMusicService;

@RestController
@RequestMapping("yandexmusic")
@RequiredArgsConstructor
public class YandexMusicController {

    private final YandexMusicService yandexMusicService;

    private final EnvironmentService environmentService;

    @GetMapping(value = {"{code}", "{code}/{keys}"})
    public void sendToYandexMusic(@PathVariable String code,
                                  @PathVariable(required = false) String keys) {
        yandexMusicService.sendCommand(code);
        if (keys != null) {
            environmentService.sendCommand(keys);
        }
    }
}