/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.entidades;

import java.text.DecimalFormat;
import modelo.clasesAbstractas.Persona;

/**
 *
 * @author BrayanLuis
 */

public class Alumno extends Persona {
    
    
    private String carrera;
    private String ciclo;

   // static int contador;
   
    //Actual a usar
    public Alumno(){}
    
    // no se da uso


/*
    public void generarCodigo(){
    contador++;
        DecimalFormat df = new DecimalFormat("CB0000");
        super.setIdPersona(df.format(contador));
    }
*/
        public String estadoPrestamo(int librosPrestados){

         if(librosPrestados > 0)
             return "Tiene " + librosPrestados + " libros prestados";

         return "Sin prestamos";
     }
        
     public String cantidadLibros(int cantidad){

         return "Libros prestados: " + cantidad;
     }
     /*
      public void prestar (int numero) {
 if( numero > 0 && numero <= cantidad)
{
    cantidad -= numero;
    System.out.println(" Se prestaron " + numero + " libros.");

    } else {
    System.out.println( "Se prestaron " + numero + " libros.");
    } 
     */
     
     //LECTURA DE DATOS
     //El método no crea un objeto nuevo, sino que extrae los datos de un objeto que ya existe y los mete dentro de un arreglo.

         public Object[] Registro(int num,int cantidadPrestamo
        ){
        Object[] fila={num,
            getIdPersona(),getNombres(),getApellidos(),
                       getDni(),getTelefono(),getCorreo(),getCarrera(),
                       getCiclo()
                        ,estadoPrestamo(cantidadPrestamo)
                       };
        return fila;
    }
     
         
         /*
         
1. El Objeto Completo (Alumno alu = new Alumno())
Qué es: Es la entidad viva en tu programa.
Cómo funciona: Contiene toda la lógica, validaciones y requiere que uses set para asignarle valores
         y get para extraerlos individualmente uno por uno.
Problema visual: No puedes meter un objeto Alumno directamente en una fila de una tabla de interfaz gráfica (como un JTable),
         porque la tabla no sabría cómo dibujar al alumno.

2. Tu método Registro (El "Extractor" de Datos)
Qué es: Es una foto plana o un resumen estructurado del objeto.
Cómo funciona: Al llamarlo, el método hace el trabajo sucio por ti. Va al objeto, ejecuta todos los getNombres(), 
         getApellidos(), etc., y los mete ordenadamente en un arreglo indexado ([0], [1], [2]).
Gran ventaja: Te devuelve un Object[] listo para ser usado directamente por componentes visuales (como modeloTabla.addRow(fila)).
         Ya no tienes que escribir 10 líneas de get cada vez que quieras mostrar al alumno en pantalla.

     
         */
/*============================GETTTTTT AND SETTTEERSSSSS===============*/
 

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

   
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
     
     
     
     
}


  /*
    public Alumno(String idPersona, String nombres, String apellidos, String dni,
            String telefono,String correo,
            String codigoAlumno, String carrera, String ciclo) {
        super(idPersona,nombres,apellidos,dni,telefono,correo);
        
        this.codigoAlumno = codigoAlumno;
        this.carrera = carrera;
        this.ciclo = ciclo;
        if((int)idPersona >contador)
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
   
    */