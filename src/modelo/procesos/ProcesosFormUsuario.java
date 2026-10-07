/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import modelo.entidades.Usuario;
import vista.FormLoginUsuario;

/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormUsuario {
  
    public static void limpiarEntradas(FormLoginUsuario fm){
        fm.txtContrasena.setText("");
       
        fm.txtNomUsuario.setText("");
    }
    public static void Presentacion(FormLoginUsuario fm){
        fm.setVisible(true);
        fm.setTitle("Registrar Usuario");
    }
    public static Usuario capturarDatos(FormLoginUsuario fm){
        Usuario usu = new Usuario();
        usu.setUsername(fm.txtNomUsuario.getText());
       
 
        usu.setPassword(new String(fm.txtContrasena.getPassword() ));
        
        return usu;
    }


}
