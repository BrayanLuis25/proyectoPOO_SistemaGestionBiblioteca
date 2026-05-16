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
public class Alumno extends Persona {
    
        private String codigoAlumno;
    private String carrera;
    private String ciclo;

    static int contador;
    static{
        contador =0;
    }
    public Alumno(int idPersona, String nombres, String apellidos, String dni,
            String telefono,String correo,
            String codigoAlumno, String carrera, String ciclo) {
        super(idPersona,nombres,apellidos,dni,telefono,correo);
        
        this.codigoAlumno = codigoAlumno;
        this.carrera = carrera;
        this.ciclo = ciclo;
        if(idPersona>contador)
            contador =idPersona;
        
    }

    public Alumno( String nombres, String apellidos, String dni, String telefono,
            String correo,
            String codigoAlumno, String carrera, String ciclo) {
        super(contador++, nombres, apellidos, dni, telefono, correo);
        
        this.codigoAlumno = codigoAlumno;
        this.carrera = carrera;
        this.ciclo = ciclo;
    }
    
    

    
}
