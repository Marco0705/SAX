// Importo las librerías necesarias
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Start {

	public static void main(String[] args) {
		try {
			// Creo la instancia para crear el documento xml
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Creo un documento vacío con la versión xml
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlVersion("1.0");

			// Creo el elemento raiz
			Element listaAlumnos = document.createElement("ListaDeAlumnos");
			document.appendChild(listaAlumnos);

			// Creo el primer alumno
			Element alumno1 = document.createElement("Alumno");
			listaAlumnos.appendChild(alumno1);

			Element nombre1 = document.createElement("Nombre");
			nombre1.appendChild(document.createTextNode("María"));
			alumno1.appendChild(nombre1);

			Element edad1 = document.createElement("Edad");
			edad1.appendChild(document.createTextNode("56"));
			alumno1.appendChild(edad1);

			// Creo el segundo alumno
			Element alumno2 = document.createElement("Alumno");
			listaAlumnos.appendChild(alumno2);

			Element nombre2 = document.createElement("Nombre");
			nombre2.appendChild(document.createTextNode("Paco"));
			alumno2.appendChild(nombre2);

			Element edad2 = document.createElement("Edad");
			edad2.appendChild(document.createTextNode("34"));
			alumno2.appendChild(edad2);

			// Creo la fuente de los datos para la transformación
			Source source = new DOMSource(document);

			// Creo el resultado de la transformación y le especifico dónde guardarlo
			Result result = new StreamResult(new java.io.File("D:\\Alumnos.xml"));

			// Creo un transformer para llevar a cabo la transformación
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			
			// Leo con SAX el documento XML
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			File f = new File("D:\\Alumnos.xml");
			AlumnosHandler handler = new AlumnosHandler();
			saxParser.parse(f, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
