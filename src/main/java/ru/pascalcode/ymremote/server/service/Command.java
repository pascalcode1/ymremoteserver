package ru.pascalcode.ymremote.server.service;

import lombok.Getter;

@Getter
public enum Command {

    PLAY_PAUSE("yandexmusic://playpause", "Воспроизведение / пауза"),

    NEXT("yandexmusic://next", "Следующий трек");

    Command(String link, String description) {
        this.link = link;
        this.description = description;
    }

    private String link;

    private String description;
}
