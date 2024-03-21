/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;

/**
 *
 * @author edu
 */
public record Persona(int id, String nombre, String apellido, String email,
        String genero, LocalDate fecha_nacimiento, boolean jubilado, String ciudad) {

}
