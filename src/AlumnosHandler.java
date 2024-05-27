
// Importo las librerías necesarias
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AlumnosHandler extends DefaultHandler {
	private boolean listaDeAlumnos = false;
	private boolean alumno = false;
	private boolean nombre = false;
	private boolean edad = false;

	// Constructor vacío heredando los atributos de la clase padre
	public AlumnosHandler() {
		super();
	}

	// Método para el principio del documento
	@Override
	public void startDocument() throws SAXException {

		System.out.println("Comienzo del documento XML");
	}

	// Método para el fin del docuemento
	@Override
	public void endDocument() throws SAXException {

		System.out.println("Fin del documento XML");
	}

	// Método para nombrar los principios de elementos
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("listadealumnos")) {
			listaDeAlumnos = true;
			System.out.println("Principio Elemento: " + qName);
		} else if (qName.equalsIgnoreCase("alumno")) {
			alumno = true;
			System.out.println("Principio Elemento: " + qName);
		} else if (qName.equalsIgnoreCase("nombre")) {
			nombre = true;
			System.out.println("Principio Elemento: " + qName);
		} else if (qName.equalsIgnoreCase("edad")) {
			edad = true;
			System.out.println("Principio Elemento: " + qName);
		}

	}

	// Método para nombrar el final de los elementos
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equalsIgnoreCase("listadealumnos")) {
			listaDeAlumnos = true;
			System.out.println("Fin Elemento: " + qName);
		} else if (qName.equalsIgnoreCase("alumno")) {
			alumno = true;
			System.out.println("Fin Elemento: " + qName);
		} else if (qName.equalsIgnoreCase("nombre")) {
			nombre = true;
			System.out.println("Fin Elemento: " + qName);
		} else if (qName.equalsIgnoreCase("edad")) {
			edad = true;
			System.out.println("Fin Elemento: " + qName);
		}
	}

	// Método para nombrar los caracteres, si tuviese datos, si no, aparecen en
	// blanco
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		if (listaDeAlumnos) {
			System.out.println("Caracteres: " + new String(ch, start, length));
			listaDeAlumnos = false;
		} else if (alumno) {
			System.out.println("Caracteres: " + new String(ch, start, length));
			alumno = false;
		} else if (nombre) {
			System.out.println("Caracteres: " + new String(ch, start, length));
			nombre = false;
		} else if (edad) {
			System.out.println("Caracteres: " + new String(ch, start, length));
			edad = false;
		}
	}
}
