/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author edu
 */
public class Main {

    public static void main(String[] args) {
        String fichero = "personas.csv";
        System.out.println("Lectura del Fichero");
        List<String> listaFichero = ClaseFicheros.leerFichero(fichero);
        for (String leer : listaFichero) {
            System.out.println(leer);
        }
        System.out.println("Creacion de la lista de Personas");
        List<Persona> lista = ClaseFicheros.crearListaPersonas(listaFichero);
        for (Persona persona : lista) {
            System.out.println(persona);
        }
        System.out.println("Conjunto de Géneros");
        Set<String> genero = ClaseFicheros.conjuntoGenero(listaFichero);
        genero.forEach(System.out::println);
        System.out.println("Creación Map");
        Map<String, Integer> map = ClaseFicheros.contadorGeneros(listaFichero);
        map.forEach((llave, valor) -> System.out.println(llave + ", " + valor));
    }
}
