package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.devices.Device;

import java.util.Collection;

public class Room {
    private Collection<Device> devices;
    private String name;

    public Room(String name, Collection<Device> devices) {
        this.devices = devices;
        this.name = name;
    }

    public Collection<Device> getDevices() {
        return devices;
    }

    public String getName() {
        return name;
    }
}
