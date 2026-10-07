/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import modelo.dao.DocenteDao;
import modelo.entidades.Alumno;
import modelo.entidades.Docente;
import vista.FormDialogAlumno;
import vista.FormDialogDocente;

/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormDocente {
  public static void cargCombo(FormDialogDocente fm){
      
      /*
         String[] opciones = { "Desarrollo de Software", "Derecho Penal", 
        "Finanzas Públicas", "Anatomía Humana", "Gestión de Proyectos"
           };
   cboEspecialidad = new JComboBox<>(opciones);
    cboEspecialidad.setPreferredSize(new Dimension(150,40));
        
   lblFacultad = new JLabel("Facultad:");

           String[] opcionesFa = { "Ingenieria" , 
               "Derecho", "Ciencias de la Salud", "Ciencias empresarial"};
      */
     //"Sistemas", "Derecho", "Administración",
           //                 "Contabilidad", "Psicología"
         fm.cboEspecialidad.removeAllItems();
        fm.cboEspecialidad.addItem("Desarrollo de Software" );
        fm.cboEspecialidad.addItem("Derecho Penal");
        fm.cboEspecialidad.addItem("Finanzas Pública");
        fm.cboEspecialidad.addItem("Anatomía Humana");
        fm.cboEspecialidad.addItem("Gestión de Proyectos");
          
        //"V", "VI", "VII", "VIII","IX","X"
        fm.cboFacultad.removeAllItems();
        fm.cboFacultad.addItem("Ingenieria");
        fm.cboFacultad.addItem("Derecho");
        fm.cboFacultad.addItem("Ciencias de la Salud");
        fm.cboFacultad.addItem("Ciencias Empresariales");
        fm.cboFacultad.addItem("Biologia");
 ;
    }
    
     public static  void limpEntradas(FormDialogDocente fm){
    fm.txtNombre.setText("");
     fm.txtApellidos.setText("");
      fm.txtDni.setText("");
       fm.txtTelefono.setText("");
       fm.txtCorreo.setText("");
       fm.cboEspecialidad.setSelectedIndex(0);
       fm.cboFacultad.setSelectedIndex(0);
       
       fm.txtNombre.requestFocus();
     }
     
      public static Docente capEntradaCombo(FormDialogDocente fm){
          
          
   Docente ag = new Docente();

    ag.setNombres(fm.txtNombre.getText());
    ag.setApellidos(fm.txtApellidos.getText());
    ag.setDni(fm.txtDni.getText());
    ag.setTelefono(fm.txtTelefono.getText());
    ag.setCorreo(fm.txtCorreo.getText());
    ag.setEspecialidad(fm.cboEspecialidad.getSelectedItem().toString());
    ag.setFacultad(fm.cboFacultad.getSelectedItem().toString());
            
    
    return ag;
    }
      
 public static Docente capturaActualizacion(FormDialogDocente fmdoc){
   Docente doc = new Docente();
     //ag.generarCodigo();
    doc.setIdPersona( Integer.parseInt(fmdoc.txtIdDocente.getText() ));
    
    doc.setNombres(fmdoc.txtNombre.getText());
    doc.setApellidos(fmdoc.txtApellidos.getText());
    doc.setDni(fmdoc.txtDni.getText());
    doc.setTelefono(fmdoc.txtTelefono.getText());
    doc.setCorreo(fmdoc.txtCorreo.getText());
    doc.setEspecialidad(fmdoc.cboEspecialidad.getSelectedItem().toString());
    doc.setFacultad(fmdoc.cboFacultad.getSelectedItem().toString());         
    return doc;
     }
}
