package com.campusdual.classroom;


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







