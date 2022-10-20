package rs.chernyshev.mavenbook.owm;

import org.apache.commons.io.IOUtils;
import junit.framework.TestCase;
import rs.chernyshev.mavenbook.weather.OpenWeatherMapParser;
import rs.chernyshev.mavenbook.weather.Weather;
import rs.chernyshev.mavenbook.weather.WeatherFormatter;

import java.io.InputStream;

public class WeatherFormatterTest extends TestCase {
    public WeatherFormatterTest(String name){
        super(name);
    }

    public void testFormat() throws Exception {
        InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new OpenWeatherMapParser().parse(nyData);
        String formattedResult = new WeatherFormatter().format(weather);
        InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.dat");
        assertEquals(IOUtils.toString(expected).trim(),
                        formattedResult.trim());
    }
}
