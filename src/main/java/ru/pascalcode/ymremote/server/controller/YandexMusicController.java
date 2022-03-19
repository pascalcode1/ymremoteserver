package ru.pascalcode.ymremote.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.ymremote.server.service.SendCommandService;

@RestController
@RequestMapping("yandexmusic")
public class YandexMusicController {

    final SendCommandService sendCommandService;

    public YandexMusicController(SendCommandService sendCommandService) {
        this.sendCommandService = sendCommandService;
    }

    @GetMapping("{code}")
    public boolean playPause(@PathVariable String code) {
        return sendCommandService.sendCommand(code);
    }
}
