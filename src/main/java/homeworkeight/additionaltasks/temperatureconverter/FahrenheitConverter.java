package homeworkeight.additionaltasks.temperatureconverter;

public class FahrenheitConverter extends BaseConverter{

    public double convert(double celsiusTemperature) {
        return 1.8 * celsiusTemperature + 32;
    }
}
