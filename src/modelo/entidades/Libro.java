/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.text.DecimalFormat;


/**
 "*/
    public class Libro {
            private int idLibro;
            private String tituloLibro;
            private String autor;
            private String categoria;
            private String editorial;
            private int cantidad;
          
        
        
        public Libro(){}

        
      public void prestar (int numero) {
        if( numero > 0 && numero <= cantidad)
        {
        cantidad -= numero;
        System.out.println(" Se prestaron " + numero + " libros.");
        }
        else {
     System.out.println( "Se prestaron " + numero + " libros.");
        }        
        
      }
    /*
      
       public void generarCodigo(){
    contador++;
        DecimalFormat df = new DecimalFormat("CB0000");
        setIdLibro(df.format(contador));
    }
*/
        public String estadoPrestamo(int librosPrestados){

         if(librosPrestados > 0)
             return "Tiene libros prestados";

         return "Sin prestamos";
     }
      
       public Object[] Registro(int num){
       
           Object[] fila={num,
       getIdLibro(), getTituloLibro(),getAutor(),getCategoria()
                ,getEditorial(),getCantidad()
                       };
        return fila;
    }
 /*=================GETTT AND SETTERSS=================*/
 
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
        
}
/*    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150),
    autor VARCHAR(100),
    categoria VARCHAR(100),
    editorial VARCHAR(100),
    stock INT*/