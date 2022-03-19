package ru.pascalcode.ymremote.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pascalcode.ymremote.server.utils.DesktopApi;

@Slf4j
@Service
public class SendCommandService {

    public boolean sendCommand(Command command) {
        log.info("Sending command to Yandex Music");
        DesktopApi.browse(command);
        return true;
    }
}
