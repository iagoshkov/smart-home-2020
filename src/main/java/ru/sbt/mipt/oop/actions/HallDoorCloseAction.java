package ru.sbt.mipt.oop.actions;

import ru.sbt.mipt.oop.components.Light;
import ru.sbt.mipt.oop.sensor.command.CommandType;
import ru.sbt.mipt.oop.sensor.command.SensorCommand;
import ru.sbt.mipt.oop.sensor.command.senders.CommandSender;
import ru.sbt.mipt.oop.sensor.command.senders.ICommandSender;

public class HallDoorCloseAction implements Action{
    private final String objectId;

    public HallDoorCloseAction(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public void act(Actionable actionable) {
        actionable.execute(component -> {
                if (component instanceof Light) {
                    Light light = (Light) component;
                    light.setOff();

                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    ICommandSender commandSender = new CommandSender();
                    commandSender.send(command);
                }
        });
    }
}
