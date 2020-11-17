package ru.sbt.mipt.oop.home;

import org.springframework.stereotype.Component;
import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class SmartHome implements Actionable {

    private Collection<Room> rooms;
    private Alarm alarm;

    public SmartHome(Collection<Room> rooms, Alarm alarm) {
        this.alarm = alarm;
        this.rooms = rooms;
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void execute(Action action) {
        action.accept(this);
        for (Room room : rooms){
            room.execute(action);
        }
    }
}
