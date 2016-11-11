package com.roisoftstudio.animalshelter.domain.animal;

public class Animal {
    private final long id;
    private final String content;

    public Animal(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
