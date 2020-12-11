package apiHelper;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Parsers {


	public JsonElement asJson(HttpResponse response) throws ParseException, IOException {
		String output = asString(response);
		return this.asJson(output);
	}

	public JsonElement asJson(String json) throws ParseException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement jsonObject = parser.parse(json);
		return jsonObject;
	}


	public String asString(HttpResponse response) throws IOException {

		if (response.getEntity() == null) {

			return "";

		}

		else {
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		}
	}


	public Document asXML(CloseableHttpResponse response)
			throws ParseException, IOException, ParserConfigurationException, SAXException {
		String output = asString(response);
		return this.asXML(output);
	}
	public Document asXML(String xml) throws IOException, ParserConfigurationException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(xml)));
		return doc;
	}

	
	
	

	
	
	
	
	
}
