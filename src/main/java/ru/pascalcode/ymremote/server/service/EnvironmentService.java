package ru.pascalcode.ymremote.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.pascalcode.ymremote.server.utils.DesktopApi;

import java.awt.*;
import java.awt.event.KeyEvent;

@Slf4j
@Service
public class EnvironmentService {

    static {
        System.setProperty("java.awt.headless", "false");
    }

    private final Robot robot;

    private final static int DEFAULT_DELAY = 100;

    public EnvironmentService() throws AWTException {
        this.robot = new Robot();
    }

    public void sendCommand(String keys) {
        log.info("Sending keys press commands to environment");
        char[] keysArray = keys.toUpperCase().toCharArray();
        for (int i = 0; i < keysArray.length; i++) {
            char key = keysArray[i];
            defineKey(key);
        }
    }

    private void defineKey(char key) {
        if (Character.isDigit(key)) {
            int delayInSeconds = Integer.parseInt(Character.toString(key));
            if (delayInSeconds == 0) {
                robot.delay(DEFAULT_DELAY);
            } else {
                robot.delay(delayInSeconds * 1000);
            }
        } else {
            switch (key) {
                case 'Q': // Закрытие приложения (яндекс музыки)
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.keyPress(KeyEvent.VK_F4);
                    robot.keyRelease(KeyEvent.VK_F4);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    break;
                case 'L':
                    pressKey(KeyEvent.VK_LEFT);
                    break;
                case 'R':
                    pressKey(KeyEvent.VK_RIGHT);
                    break;
                case 'U':
                    pressKey(KeyEvent.VK_UP);
                    break;
                case 'D':
                    pressKey(KeyEvent.VK_DOWN);
                    break;
                case 'T':
                    pressKey(KeyEvent.VK_TAB);
                    break;
                case 'Y': // Типа обратный Tab. Тот, что с шифтом. Хз почему Y. WHY Y????????
                    robot.keyPress(KeyEvent.VK_SHIFT);
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                    robot.keyRelease(KeyEvent.VK_TAB);
                    break;
                case 'E':
                    pressKey(KeyEvent.VK_ENTER);
                    break;
                default:
                    throw new RuntimeException("Unknown command: " + key);
            }
        }
    }

    private void pressKey(int event) {
        robot.keyPress(event);

        robot.keyRelease(event);
    }

    public void callVolumeSlider() {
        DesktopApi.execCommand("C:\\Windows\\System32\\SndVol.exe -f 49825268");
    }

    public void runScreenSaver() {
        DesktopApi.execCommand("explorer C:\\Windows\\System32\\screensaver.scr");
    }

}




