package ru.pascalcode.ymremote.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pascalcode.ymremote.server.utils.DesktopApi;

import java.util.Arrays;

@Slf4j
@Service
public class YandexMusicService {

    public void sendCommand(String code) {
        log.info("Sending command to Yandex Music");
        DesktopApi.execCommand(getCommandByCode(code));
    }

    public static Command getCommandByCode(String code) {
        return Arrays.stream(Command.values()).filter(v -> v.getCode().equals(code)).findFirst()
                .orElseThrow(() -> {
                    log.error("Command \"{}\" not found", code);
                    return new RuntimeException(String.format("Command \"%s\" not found", code));
                });
    }
}
