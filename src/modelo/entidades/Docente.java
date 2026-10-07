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

    //static int contador;
  //  static{contador=0;}
 
    public Docente(){}
    
       public String estadoPrestamo(int librosPrestados){

         if(librosPrestados > 0)
             return "Tiene " + librosPrestados + " libros prestados";

         return "Sin prestamos";
     }
       
     public Object[] Registro(int num,int cantidadPrestamo
        ){
        Object[] fila={num,
            getIdPersona(),getNombres(),getApellidos(),
                       getDni(),getTelefono(),getCorreo(),getEspecialidad(),
                       getFacultad()
                        ,estadoPrestamo(cantidadPrestamo)
                       };
        return fila;
    }
     /*
    public void generarCodigo(){
    contador++;
        DecimalFormat df = new DecimalFormat("CDOC0000");
        super.setIdPersona(df.format(contador));
    }
*/
     
     
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
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
   
*/