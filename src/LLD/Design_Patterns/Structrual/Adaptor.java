package LLD.Design_Patterns.Structrual;

public class Adaptor {
    public static void main(String[] args) {
        USATemperature usaSensor = new USATemperature();
        Temperature indianSensor = new IndianTemperatureAdapter(usaSensor);
        System.out.println(indianSensor.getTemperature());
    }
}

interface Temperature {
    public double getTemperature();
}

class IndianTemperatureAdapter implements Temperature {
    USATemperature usaTemperature;

    IndianTemperatureAdapter(USATemperature usaTemperature) {
        this.usaTemperature = usaTemperature;
    }

    public double getTemperature() {
        double fahrenheit = usaTemperature.getFahrenheit();
        double celsuis = (fahrenheit - 32.0) / 1.8;
        return celsuis;
    }
}

class USATemperature {
    double temp = 80;

    public double getFahrenheit() {
        return temp;
    }
}
