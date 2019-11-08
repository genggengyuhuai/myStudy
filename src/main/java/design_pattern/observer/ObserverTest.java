package design_pattern.observer;

import java.util.Collections;
import java.util.Observable;
import java.util.Observer;


//内部维护有 观察者数组
class WeatherData extends Observable {

    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        setChanged();
        notifyObservers(temperature);
    }

    public WeatherData(float temperature) {
        this.temperature = temperature;
    }
}

class App implements Observer{

    private float temperature;

    private String otherField;

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Float){
            this.temperature = (Float) arg;
        }
    }

    public App(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }
}

/**
 * @author lihaoyu
 * @date 2019/9/27 9:32
 */
public class ObserverTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(3L);
        App app = new App(0L);
        weatherData.addObserver(app);
        weatherData.setTemperature(5L);
        System.out.println(app.getTemperature());
    }
}
