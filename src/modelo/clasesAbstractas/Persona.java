/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.clasesAbstractas;

/**
 *
 * @author BrayanLuis
 */
public  abstract class Persona {
    protected int idPersona;
    protected String nombres;
    protected String apellidos;
    protected String dni;
    protected String telefono;
    protected String correo;

    public Persona(int idPersona, String nombres, String apellidos, String dni, String telefono, String correo) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }
    
}
