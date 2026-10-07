/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import java.time.LocalDateTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.clasesAbstractas.Persona;
import modelo.entidades.Alumno;
import modelo.entidades.Docente;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;
import vista.FormDialogPrestamo;

/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormPrestamo {
// static Usuario usuarioLog;
       public static void cargCombox(FormDialogPrestamo fmprest){
     String[] estado = {"Prestado", "Devuelto"};
       
        
        // Carga de modelos en los JComboBox correspondientes
        fmprest.cboEstado.setModel(new DefaultComboBoxModel<>(estado));
      
        }
    public static void limpCombox(FormDialogPrestamo fmprest){
    
        fmprest.txtNomAlumno.setText("");
        fmprest.txtNomLibro.setText("");
      
        fmprest.txtCantidadLibro.setText("");
        
     
        fmprest.requestFocus();
        //  fmprest.txtFechaPrestamo.setText("");
       //fmprest.txtFechaDevolucion.setText("");
    }
   public static Prestamo capturaEntrada(FormDialogPrestamo fmprest)
    {
        /*
        Entonces para registrar o actualizar un préstamo, la base de datos únicamente necesita:
    per.setIdPersona(...);

No necesita saber si ese id pertenece a un Alumno o a un Docente.
        */
        ////referncia per de tipoPersona
 
        //Polimorfismo = una referencia padre mira a un objeto hijo (ES UN)
        /*
        La idea que sí es correcta

        Alumno hereda de Persona, por lo tanto un Alumno puede ser tratado como una Persona.

        Por eso Java permite:

        Persona x = new Alumno();
        */
        Persona per;
      
        /*
        if (obtenerRol(fmprest.getUsuarioLog()).equalsIgnoreCase("Alumno")||
                 obtenerRol(fmprest.getUsuarioLog()).equalsIgnoreCase("Administrador")||
           obtenerRol(fmprest.getUsuarioLog()).equalsIgnoreCase("Bibliotecario")) {
           per = new Alumno(); // como alumno e sun persona,java permite usar una referencia Persona
        } 
        else if (obtenerRol(fmprest.getUsuarioLog()).equalsIgnoreCase("Docente")||
                 obtenerRol(fmprest.getUsuarioLog()).equalsIgnoreCase("Administrador")||
                
             obtenerRol(fmprest.getUsuarioLog()).equalsIgnoreCase("Bibliotecario")) {
            per = new Docente();
        } */
        //Porque el polimorfismo ocurre cuando la referencia padre apunta a un objeto hijo.
        per = new Alumno(); 
        per = new Docente();
     
             if( per != null){ 
                           
        per.setIdPersona(
                idPersona(fmprest)
        );

        Libro lib = new Libro();
        
        lib.setIdLibro(idLibro(fmprest)
          
        );

        Prestamo prest = new Prestamo();
        //prest.generarCodigoPrest();
        
        //
        prest.setPer(per);//guarda o tiene(como una caja) referencias (tiene un persona)
        prest.setLibro(lib);

        prest.setFechaPrestamo(LocalDateTime.now());
        
        prest.setFechaDevolucion(
            LocalDateTime.now().plusDays(7)
        );

        prest.setEstado(
            fmprest.cboEstado.getSelectedItem().toString()
        );

        prest.setCantidadLibros(
            cantidadLibroInt(fmprest)
        );

        
        return prest;
             }

    return null;
    }
   
   public static Prestamo capturaActualizacion(FormDialogPrestamo fmpresta){
    //sobre esteobejtoprest con referencia unica ejecuta el metodo
        Persona per;
       per = new Persona() {};
        /*   per = new Alumno();
        
        //solo ejecuta uno      
          per = new Docente();
        */
      //PERSONAUPDATE
        per.setIdPersona(
                idPersonaAc(fmpresta)
        );

        Libro lib = new Libro();
        //libroUPDATE
        lib.setIdLibro(idLibroAc(fmpresta)
          
        );

        Prestamo prest = new Prestamo();
        //prest.generarCodigoPrest();
       
        prest.setIdPrestamo(Integer.parseInt(fmpresta.txtIdPrestamo.getText()));
        
        prest.setPer(per);//guarda o tiene(como una caja) referencias (tiene un persona)
        prest.setLibro(lib);

        /*
        prest.setFechaPrestamo(LocalDateTime.now());
        
        prest.setFechaDevolucion(
            LocalDateTime.now().plusDays(7)
        );

        */
        prest.setEstado(
            fmpresta.cboEstado.getSelectedItem().toString()
        );

        prest.setCantidadLibros(
            cantidadLibroInt(fmpresta)
        );

    //Devuelve la referencia al objeto ya construido.
    
    //2.El método encapsula la creación e inicialización del objeto, devolviendo una
    //instancia completamente configurada.
        return prest;
    
   
}

    
       public static String obtenerRol(Usuario usuarioLog){
     for(Rol r : usuarioLog.getRoles()){
         return r.getNombreRol();
         
     }
     return "---";
    }
       
         public static int idLibro(FormDialogPrestamo fmprest ){
    return Integer.parseInt(fmprest.txtNomLibro.getText());
    }
    public static int idPersona(FormDialogPrestamo fmprest ){
    return Integer.parseInt(fmprest.txtNomAlumno.getText());
    }
    public static int cantidadLibroInt(FormDialogPrestamo fmprest){
    return Integer.parseInt(fmprest.txtCantidadLibro.getText());
    }

    public static int idPersonaAc(FormDialogPrestamo fmpresta){
    return Integer.parseInt(
        fmpresta.txtIdPersonaUpdate.getText()
    );
}

public static int idLibroAc(FormDialogPrestamo fmpresta){
    return Integer.parseInt(
        fmpresta.txtIdLibroUpdate.getText()
    );
}
    

}

   

   /*


   Persona per = null;
         Prestamo prest = new Prestamo();

        if (obtenerRol().equalsIgnoreCase("Alumno")) {
            per = new Alumno();
             
            per.setIdPersona(
            fmprest.txtNomAlumno.getText() );
            
           

        Libro lib = new Libro();
              prest.setPer(per);
              prest.setLibro(lib);
              
                lib.setIdLibro(
            fmprest.txtNomLibro.getText()
    );
                prest.generarCodigo();
                   prest.setFechaPrestamo(LocalDateTime.now());
            //FECHA DEVOLUCION AUTOMATICA
            prest.setFechaDevolucion(
            LocalDateTime.now().plusDays(7)
        );
    
   
    prest.setEstado(
        fmprest.cboEstado.getSelectedItem().toString()
    );
    prest.setCantidadLibros( cantidadLibroInt(fmprest));

            
        } else if (obtenerRol().equalsIgnoreCase("Docente")) {
            per = new Docente();
      
   
 

 
    }
        return prest;
*/