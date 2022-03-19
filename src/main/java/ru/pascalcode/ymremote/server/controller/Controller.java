package ru.pascalcode.ymremote.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.ymremote.server.service.Command;
import ru.pascalcode.ymremote.server.service.SendCommandService;

@RestController
@RequestMapping("remote")
public class Controller {

    final SendCommandService sendCommandService;

    public Controller(SendCommandService sendCommandService) {
        this.sendCommandService = sendCommandService;
    }

    @GetMapping("playpause")
    public boolean playPause() {
        sendCommandService.sendCommand(Command.PLAY_PAUSE);
        return true;
    }

    @GetMapping("next")
    public boolean next() {
        sendCommandService.sendCommand(Command.NEXT);
        return true;
    }
}
