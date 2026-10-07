/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import modelo.dao.AlumnoDao;
import modelo.dao.DocenteDao;
import modelo.entidades.Alumno;
import vista.FormDialogAlumno;

/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormAlumno {
    
    public static void cargCombo(FormDialogAlumno fm){
      
        //"Sistemas", "Derecho", "Administración",
           //                 "Contabilidad", "Psicología"
         fm.cboCarrera.removeAllItems();
        fm.cboCarrera.addItem("Sistemas");
        fm.cboCarrera.addItem("Derecho");
        fm.cboCarrera.addItem("Administración");
        fm.cboCarrera.addItem("Contabilidad");
        fm.cboCarrera.addItem("Psicología");
          
        //"V", "VI", "VII", "VIII","IX","X"
        fm.cboCiclo.removeAllItems();
        fm.cboCiclo.addItem("V");
        fm.cboCiclo.addItem("VI");
        fm.cboCiclo.addItem("VII");
        fm.cboCiclo.addItem("VIII");
        fm.cboCiclo.addItem("IX");
        fm.cboCiclo.addItem("X");
    }
    
     public static  void limpEntradas(FormDialogAlumno fm){
    fm.txtNombre.setText("");
     fm.txtApellidos.setText("");
      fm.txtDni.setText("");
       fm.txtTelefono.setText("");
       fm.txtCorreo.setText("");
       fm.cboCarrera.setSelectedIndex(0);
       fm.cboCiclo.setSelectedIndex(0);
       fm.txtNombre.requestFocus();
     }
     
      public static Alumno capEntradaCombo(FormDialogAlumno fm){
    Alumno ag = new Alumno();
     

    //ag.generarCodigo();
    ag.setNombres(fm.txtNombre.getText());
    ag.setApellidos(fm.txtApellidos.getText());
    ag.setDni(fm.txtDni.getText());
    ag.setTelefono(fm.txtTelefono.getText());
    ag.setCorreo(fm.txtCorreo.getText());
    ag.setCarrera(fm.cboCarrera.getSelectedItem().toString());
    ag.setCiclo(fm.cboCiclo.getSelectedItem().toString());
            
    
    return ag;
    }
    public static Alumno capturaActualizacion(FormDialogAlumno fma){
    
       
    Alumno ag = new Alumno();
     

    //ag.generarCodigo();
    ag.setIdPersona( Integer.parseInt(fma.txtIdAlum.getText() ));
    
    ag.setNombres(fma.txtNombre.getText());
    ag.setApellidos(fma.txtApellidos.getText());
    ag.setDni(fma.txtDni.getText());
    ag.setTelefono(fma.txtTelefono.getText());
    ag.setCorreo(fma.txtCorreo.getText());
    ag.setCarrera(fma.cboCarrera.getSelectedItem().toString());
    ag.setCiclo(fma.cboCiclo.getSelectedItem().toString());
            
    
    return ag;
    
    }
    
}
