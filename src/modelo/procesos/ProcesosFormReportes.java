/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.procesos;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vista.FormDialogReportes;

/**
 *
 * @author BrayanLuis
 */
public class ProcesosFormReportes {


    //==================== LIMPIAR ====================
    public static void limpiar(FormDialogReportes frm){

        frm.cboEstado.setSelectedIndex(0);

        frm.txtIdPrestamo.setText("");

        frm.txtIdPrestamo.requestFocus();
    }

    /*
    //==================== VALIDAR ====================
    public static boolean validar(FormDialogReportes frm){

        if(frm.cboEstado.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(
                null,
                "Seleccione un estado."
            );
            return false;
        }

        return true;
    }
    */
}
      //==================== CARGAR COMBOS ====================
    
    /*
    public static void cargarCombos(FormDialogReportes frm){

        String estados[] = {
            "Seleccione...",
            "Todos",
            "Prestado",
            "Devuelto"
        };

        frm.cboEstado.setModel(
            new DefaultComboBoxModel<>(estados)
        );
    }
*/