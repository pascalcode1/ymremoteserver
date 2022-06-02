package ru.pascalcode.ymremote.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.ymremote.server.service.Command;
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
        if (YandexMusicService.getCommandByCode(code).equals(Command.RADIO)) {
            yandexMusicService.sendCommand(code);
            //KOSTYL: Вынужден закрыть приложение яндекс музыки чтоб все дальнейшие нажатия были предсказуемыми.
            environmentService.sendCommand("1Q");
            //Следующей строкой яндекс музыка стартанёт по новой.
        }
        yandexMusicService.sendCommand(code);
        if (keys != null) {
            environmentService.sendCommand(keys);
        }
    }
}