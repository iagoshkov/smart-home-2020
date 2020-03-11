package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.DoorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.LightCommands.TurnTheLightOffCommand;
import static ru.sbt.mipt.oop.ObjectType.*;

public class HallDoorEventHandler implements EventHandler {
    private final SmartHome smartHome;

    public HallDoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void HandleEvent(SensorEvent event) {
        if (event.getType() == DOOR && ((DoorEvent) event).getDoorEventType() == DOOR_CLOSED) {
            Action checkTheHallDoor = new Action((HomeObject homeObject) -> {
               if (homeObject.getObjectType() == ROOM && homeObject.getId().equals("hall")) {
                   Action action = new Action((HomeObject currentRoomObject) -> {
                       if (currentRoomObject.getObjectType() == DOOR && currentRoomObject.getId().equals(event.getObjectId())) {
                           TurnOffAllTheLights();
                       }
                   });
                   ((Room) homeObject).execute(action);
               }
            });
            smartHome.execute(checkTheHallDoor);
        }
    }

    private void TurnOffAllTheLights() {
        Action action = new Action((HomeObject homeObject) -> {
            if (homeObject.getObjectType() == LIGHT) {
                TurnTheLightOffCommand((Light) homeObject);
            }
        });
        smartHome.execute(action);
    }
}
