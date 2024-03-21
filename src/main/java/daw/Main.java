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
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author edu
 */
public class Main {

    public static void main(String[] args) {
        String fichero = "personas.csv";
        List<String> listaFichero = leerFichero(fichero);
        for (String leer : listaFichero) {
            System.out.println(leer);
        }
        List<Persona> lista = crearListaPersonas(listaFichero);
        for (Persona persona : lista) {
            System.out.println(persona);
        }
        Set<String> genero = conjuntoGenero(listaFichero);
        genero.forEach(System.out::println);
    }

    private static List<String> leerFichero(String fichero) {
        List<String> lista = new ArrayList();
        try {
            lista = Files.readAllLines(Paths.get(fichero));
            lista.remove(0);
        } catch (IOException ioe) {
            System.out.println("Error, No se a leido el fichero");
        }
        return lista;
    }

    private static List<Persona> crearListaPersonas(List<String> fichero) {
        DateTimeFormatter formatted = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Persona> lista = new ArrayList();
        for (String persona : fichero) {
            String[] array = persona.split(",");
            LocalDate fecha = LocalDate.parse(array[5], formatted);
            boolean jubilado = Boolean.parseBoolean(array[6]);
            Persona nuevo = new Persona(Integer.parseInt(array[0]), array[1],
                    array[2], array[3], array[4], fecha,
                    jubilado, array[7]);
            lista.add(nuevo);
        }
        return lista;
    }

    private static Set<String> conjuntoGenero(List<String> fichero) {
        Set<String> lista = new TreeSet();
        for (String genero : fichero) {
            String[] array = genero.split(",");
            lista.add(array[4]);
        }
        try {
            Files.write(Paths.get("genero.txt"), lista);
        } catch (IOException ioe) {
            System.out.println("No se ha podido crear el .txt");
        }
        return lista;
    }
}
