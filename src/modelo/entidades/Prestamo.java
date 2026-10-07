/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Date;
import modelo.clasesAbstractas.Persona;

/**
 *
 * @author BrayanLuis
 */

public class Prestamo {
   private int idPrestamo;

    // Relaciones
    //private Alumno alumno;
   private Persona per;
    private Libro libro;

    // Datos del préstamo
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    private String estado;

    private int cantidadLibros;
    
    
    /*
        public void generarCodigo(){
        contador++;
        DecimalFormat df = new DecimalFormat("CB0000");
        setIdPrestamo(df.format(contador));
    }
    */

        public String estadoPrestamo(int librosPrestados){

         if(librosPrestados > 0)
             return "Tiene libros prestados";

         return "Sin prestamos";
     }
      
       public Object[] Registro(int num
        ){
        Object[] fila={num,
       getIdPrestamo(),getPer().getIdPersona(),getLibro().getIdLibro(), 
       getPer().getNombres(),getLibro().getTituloLibro(),getFechaPrestamo(),
       getFechaDevolucion(),getEstado(),getCantidadLibros()
                
                       };
        return fila;
    }
       
       /*=====00GETTT AND SETTETRS==============*/

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }



    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }
       
       
    
}
