/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import modelo.clasesAbstractas.Persona;

/**
 *
 * @author BrayanLuis
 */
public class Docente extends Persona{
        private String especialidad;
    private String facultad;

    static int contador;
    static{contador=0;}
    
    public Docente(String especialidad, String facultad, int idPersona,
       String nombres, String apellidos, String dni, String telefono, String correo) {
        super(idPersona, nombres, apellidos, dni, telefono, correo);
        this.especialidad = especialidad;
        this.facultad = facultad;
        
           if(idPersona>contador)
            contador =idPersona;
    }
    
   public Docente( String nombres, String apellidos, String dni, String telefono, String correo,
           String especialidad, String facultad) {
        super(contador++, nombres, apellidos, dni, telefono, correo);
        this.especialidad = especialidad;
        this.facultad = facultad;
    }
   
   
   
}
