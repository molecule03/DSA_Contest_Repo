package LLD.Design_Patterns.Structrual;

public class Facade {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater();
        homeTheater.turnOn();
    }
}

class HomeTheater{
    Amplifier amplifier = new Amplifier();
    Lights lights = new Lights();
    Speaker speaker = new Speaker();

    public void turnOn(){
        amplifier.turnOn();
        lights.turnOn();
        speaker.turnOn();;
        System.out.println("HomeTheater Turned On");
    }
}
class Amplifier{
    public void turnOn(){
        System.out.println("Amplifier Turned On");
    }
}
class Lights{
    public void turnOn(){
        System.out.println("Lights Turned On");
    }
}
class Speaker{
    public void turnOn(){
        System.out.println("Speaker Turned On");
    }
}
