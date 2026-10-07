/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import javax.swing.DefaultComboBoxModel;
import modelo.entidades.Libro;
import vista.FormDialogLibro;
import vista.FormDialogPrestamo;


/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormLibro {
    public static void cargCombox(FormDialogLibro fmli){
    // Arreglos con datos de ejemplo para el libro
        String[] categorias = {"Novela", "Ciencia", "Historia", "Tecnología", "Biografía"};
        String[] editoriales = {"Planeta", "Alfaguara", "Anagrama", "Paidós", "O'Reilly"};
        
        // Carga de modelos en los JComboBox correspondientes
        fmli.cboCategoria.setModel(new DefaultComboBoxModel<>(categorias));
        fmli.cboEditorial.setModel(new DefaultComboBoxModel<>(editoriales));
        
    }
    public static void limpCombox(FormDialogLibro fmli){
    // Limpieza de campos de texto según la clase Libro
        fmli.txtTituloLibro.setText(""); 
        fmli.txtTituloLibro.setText(""); 
        fmli.txtAutor.setText(""); 
        fmli.txtCantidad.setText(""); // Campo numérico se limpia como texto vacío
        
        // Restablecer selección de combos
        fmli.cboCategoria.setSelectedIndex(0); 
        fmli.cboEditorial.setSelectedIndex(0); 
        
        // Mover el foco del teclado al primer campo
        fmli.txtTituloLibro.requestFocus(); 
        
    }
    public static Libro capturaEntrada(FormDialogLibro fmli){
        
   Libro lib;
   lib= new Libro();
       //lib.generarCodigo();
    lib.setTituloLibro(fmli.txtTituloLibro.getText());
    lib.setAutor(fmli.txtAutor.getText());
    lib.setCategoria(fmli.cboCategoria.getSelectedItem().toString());
   lib.setEditorial(fmli.cboEditorial.getSelectedItem().toString());
   lib.setCantidad(cantidadLibroInt(fmli));
   return lib;
    }
    
    public static int cantidadLibroInt(FormDialogLibro fmli){
return Integer.parseInt(fmli.txtCantidad.getText());
}

    //=============================ACTUALLIZAR======================================
    public static Libro capturaActualizacion(FormDialogLibro fmli){

    Libro lib = new Libro();

    lib.setIdLibro(
        Integer.parseInt(fmli.txtIdLibro.getText())
    );

    lib.setTituloLibro(fmli.txtTituloLibro.getText());
    lib.setAutor(fmli.txtAutor.getText());
    lib.setCategoria(
        fmli.cboCategoria.getSelectedItem().toString()
    );
    lib.setEditorial(
        fmli.cboEditorial.getSelectedItem().toString()
    );
    lib.setCantidad(
        Integer.parseInt(fmli.txtCantidad.getText())
    );

    return lib;
}
    
}
