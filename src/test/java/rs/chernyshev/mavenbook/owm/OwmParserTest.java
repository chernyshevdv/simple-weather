package rs.chernyshev.mavenbook.owm;

import junit.framework.TestCase;
import rs.chernyshev.mavenbook.weather.OpenWeatherMapParser;
import rs.chernyshev.mavenbook.weather.Weather;

import java.io.InputStream;

public class OwmParserTest extends TestCase {
    public OwmParserTest(String name){
        super(name);
    }

    public void testParser() throws Exception {
        InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new OpenWeatherMapParser().parse(nyData);
        assertEquals("New York", weather.getCity());
        // assertEquals("NY", weather.getRegion());
        assertEquals("US", weather.getCountry());
        assertEquals("16.98", weather.getTemp());
        assertEquals("15.86", weather.getChill());
        assertEquals("43", weather.getHumidity());
    }
}
