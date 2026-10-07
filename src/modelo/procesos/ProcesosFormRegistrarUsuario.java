/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import javax.swing.DefaultComboBoxModel;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;
import vista.FormRegistrarUsuario;

/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormRegistrarUsuario {
    
    public static int obtenerIdRol(FormRegistrarUsuario frgu){
     
      int roles =0;
     String rol = frgu.cboroles.getSelectedItem().toString();
      
 

    switch(rol){

        case "Administrador":
            roles= 1;
            break;

        case "Bibliotecario":
           roles= 2;
              break;

        case "Alumno":
         roles=  3;
            break;

        case "Docente":
         roles= 4;
            break;

        default:
            return 0;
    }
     return roles;
  
    }
      public static void limpiarEntradas(FormRegistrarUsuario fm){
        fm.txtContrasena.setText("");
       
        fm.txtNomUsuario.setText("");
    }
    public static void Presentacion(FormRegistrarUsuario fm){
        fm.setVisible(true);
        fm.setTitle("Registrar Usuario");
    }
    public static Usuario capturarDatos(FormRegistrarUsuario fm){

   Usuario usu = new Usuario();

        usu.setUsername(fm.txtNomUsuario.getText());
       
 
        usu.setPassword(new String(fm.txtContrasena.getPassword() ));
        
        return usu;
    }

}
