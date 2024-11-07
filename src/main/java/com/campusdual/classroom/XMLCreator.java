package com.campusdual.classroom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLCreator {
    static void createXML() throws ParserConfigurationException, TransformerException {
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("shoppinglist");
            document.appendChild(root);

            Element documents = document.createElement("items");
            root.appendChild(documents);

            documents.appendChild(createItem(document, "item", "quantity", "2", "Manzana"));
            documents.appendChild(createItem(document, "item", "quantity", "1", "Leche"));
            documents.appendChild(createItem(document, "item", "quantity", "3", "Pan"));
            documents.appendChild(createItem(document, "item", "quantity", "2", "Huevo"));
            documents.appendChild(createItem(document, "item", "quantity", "1", "Queso"));
            documents.appendChild(createItem(document, "item", "quantity", "1", "Cereal"));
            documents.appendChild(createItem(document, "item", "quantity", "4", "Agua"));
            documents.appendChild(createItem(document, "item", "quantity", "6", "Yogur"));
            documents.appendChild(createItem(document, "item", "quantity", "2", "Arroz"));
            writeToFile(document, "src/main/resources/shoppingList.xml");
            System.out.println("XML file created: shoppingList.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(Document document, String pathFile) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
        File file = new File(pathFile);
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

    private static Element createItem (Document document, String tagName, String attribute, String attrValue, String
            textComponent){
        Element item = document.createElement(tagName);
        item.setAttribute(attribute, attrValue);
        item.setTextContent(textComponent);
        return item;
    }

}