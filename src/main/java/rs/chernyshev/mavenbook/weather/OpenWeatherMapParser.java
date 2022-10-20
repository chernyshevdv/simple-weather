package rs.chernyshev.mavenbook.weather;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Map;
import java.util.logging.Logger;

public class OpenWeatherMapParser {
    private static Logger log = Logger.getLogger(OpenWeatherMapParser.class.getName());

    public Weather parse(InputStream inputStream) throws Exception {
        Weather weather = new Weather();
        log.info("Creating XML reader...");
        SAXReader xmlReader = createXmlReader();
        Document doc = xmlReader.read(inputStream);
        log.info("Parsing XML response");
        weather.setCity(doc.valueOf("/current/city/@name"));
        weather.setCountry(doc.valueOf("/current/city/country"));
        weather.setTemp(doc.valueOf("/current/temperature/@value"));
        weather.setChill(doc.valueOf("/current/feels_like/@value"));
        weather.setHumidity(doc.valueOf("/current/humidity/@value"));

        return weather;
    }

    private SAXReader createXmlReader() {
        DocumentFactory factory = new DocumentFactory();
        SAXReader xmlReader = new SAXReader();
        xmlReader.setDocumentFactory(factory);

        return xmlReader;
    }
}
