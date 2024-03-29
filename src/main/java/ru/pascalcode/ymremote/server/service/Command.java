package ru.pascalcode.ymremote.server.service;

import lombok.Getter;

@Getter
public enum Command {

    EMPTY("", "Обращение к яндекс музыки без комманд"),

    PLAY_PAUSE("playpause", "Воспроизведение / пауза"),

    NEXT("next", "Следующий трек"),

    PREVIOUS("previous", "Предыдущий трек"),

    LIKE("like", "Поставить лайк"),

    DISLIKE("dislike", "Поставить дислайк"),

    RADIO("radio", "Перейти на вкладку \"Радио\""),

    SEARCH("search", "переход в режим поиска");

    private static final String LINK_PREFIX = "yandexmusic://";

    Command(String code, String description) {
        this.code = code;
        this.description = description;
        this.link = LINK_PREFIX + code;
    }

    private final String code;

    private final String description;

    private final String link;
}
