package homeworkeight.additionaltasks.temperatureconverter;

public class KelvinConverter extends BaseConverter{

    public double convert(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }
}
