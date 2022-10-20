package rs.chernyshev.mavenbook.weather;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Configure Log4j
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));

        // Read zip code from the command line
        // If not supplied use 30315
        String city = "Belgrade";
        String country = "RS";
        try {
            city = args[0];
            country = args[1];
        } catch (Exception e){}

        // Start the program
        new Main(city, country).start();
    }

    private String city, country;

    public Main(String city, String country){
        this.city = city;
        this.country = country;
    }

    public void start() throws Exception {
        // Retrieve data
        InputStream dataIn = new OpenWeatherMapRetriever().retrieve(city, country);

        // Parse data
        Weather weather = new OpenWeatherMapParser().parse(dataIn);

        // Format (print) data
        System.out.println(new WeatherFormatter().format(weather));
    }
}
