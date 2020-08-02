package design_pattern.command;

interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("开灯");
    }

    public void off() {
        System.out.println("关灯");
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command{
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class RemoteController{
    public Command[] onCommandList = new Command[7];
    public Command[] offCommandList = new Command[7];

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommandList[slot] = onCommand;
        offCommandList[slot] = offCommand;
    }

    public void pressOnButton(int slot){
        onCommandList[slot].execute();
    }

    public void pressOffButton(int slot){
        offCommandList[slot].execute();
    }
}


public class CommandTest {
    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        remoteController.setCommand(2,lightOnCommand,lightOffCommand);
        remoteController.pressOffButton(2);



    }
}
