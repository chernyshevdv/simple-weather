package rs.chernyshev.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

public class OpenWeatherMapRetriever {
    private static Logger log = Logger.getLogger(OpenWeatherMapRetriever.class.getName());
    private String appId = "4d7cd4e57a5f5cc7f3ac6321ecd8463a";

    public InputStream retrieve(String city, String country) throws Exception {
        log.info(String.format("Retrieving Weather data for %s/%s", city, country));
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&mode=xml&units=metric&appid=%s",
                city, country, appId);
        URLConnection conn = new URL(url).openConnection();

        return conn.getInputStream();
    }

}
