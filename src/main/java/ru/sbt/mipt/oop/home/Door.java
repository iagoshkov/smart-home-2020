package ru.sbt.mipt.oop.home;

import ru.sbt.mipt.oop.home.action.Action;
import ru.sbt.mipt.oop.home.action.ActionType;
import ru.sbt.mipt.oop.home.action.Actionable;

public class Door implements Actionable, Device {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    @Override
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
    public void execute(Action action) {
        if (action.getActionType() == ActionType.DOOR_CLOSED) {
            setOpen(false);
        } else if (action.getActionType() == ActionType.DOOR_OPEN) {
            setOpen(true);
        }
    }
}
