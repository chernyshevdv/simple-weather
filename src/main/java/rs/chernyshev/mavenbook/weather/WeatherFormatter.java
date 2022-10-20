package rs.chernyshev.mavenbook.weather;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.logging.Logger;

public class WeatherFormatter {
    private static Logger log = Logger.getLogger(WeatherFormatter.class.getName());

    public String format(Weather weather) throws Exception {
        log.info("Formatting Weather data");
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("output.vm"));
        VelocityContext context = new VelocityContext();
        context.put("weather", weather);
        StringWriter writer = new StringWriter();
        ve.evaluate(context, writer, "", reader);
        return writer.toString();
    }
}
