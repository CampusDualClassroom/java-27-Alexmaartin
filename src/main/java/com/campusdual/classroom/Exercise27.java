package com.campusdual.classroom;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
import java.io.FileWriter;
import java.io.IOException;

public class Exercise27 {
    public static void main(String[] args) {
        try {
            XMLCreator.createXML();
            System.out.println("Archivo XML creado.");

            JSONCreator.createDocument();
            System.out.println("Archivo JSON creado.");
        } catch (Exception e) {
            System.err.println("Error al crear los archivos: " + e.getMessage());
        }
    }
}







