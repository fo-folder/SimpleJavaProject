import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

/**
 * Тут проводятся сложные операции по извлечению JSON из HTML и записи их в виде объектов
 */
public class Utils {
    public static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try {
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();

            //Parse the content to Document object
            return builder.parse(new InputSource(new StringReader(xmlString)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //формируется медведь из полученного ответа
    public static Bear responseToBear(ResponseBody responseBody) {
        Document htmlBody = Utils.convertStringToXMLDocument(responseBody.asString()); //тут вызываю метод.asString()
        NodeList nodes = htmlBody.getElementsByTagName("body"); //извлекается содержимое из тега body
        Node node = nodes.item(0); // первый элемент
        String json = node.getTextContent();

        Bear bear = new Gson().fromJson(json, Bear.class); //запись полученного JSON в объект медведя
        return bear;
    }

    //формируется список объектов медведей
    public static List<Bear> responseToBears(ResponseBody responseBody) {
        ObjectMapper mapper = new ObjectMapper();

        Bear[] bearsArr = {};

        try {
            // convert JSON array to Array objects
            bearsArr = mapper.readValue(responseBody.asString(), Bear[].class);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // convert JSON array to List of objects
        return Arrays.asList(bearsArr);
    }
}
