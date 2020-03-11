package ru.sbt.mipt.oop.objects;

import ru.sbt.mipt.oop.Actionable;

import java.util.function.Consumer;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void execute(Consumer<Object> action) {
        action.accept(this);
    }
}