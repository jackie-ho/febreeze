package ho.jackie.febreezehack;

/**
 * Created by JH on 3/4/17.
 */

public class Weather {

    double dewPoint;
    double temperature;
    double humidity;
    double cloudCover;
    double pressure;
    double windSpeed;
    String summary;

    public double getDewPoint() {
        return dewPoint;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity*100;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getSummary() {
        return summary;
    }
}
