/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.dao.AlumnoDao;
import modelo.dao.DocenteDao;
import modelo.entidades.Alumno;
import modelo.entidades.Docente;
import modelo.procesos.ProcesosFormAlumno;
import modelo.procesos.ProcesosFormDocente;

/**
 *
 * @author BrayanLuis
 */


public class FormDialogDocente extends javax.swing.JDialog {
    int filaSelec = -1;
    /**
     * Creates new form FormDialogDocente
     */
    public FormDialogDocente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
       //initComponents();
        this.setTitle("Mantenimiento Docente");
     setSize(900,600);
   
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panel = new JPanel();
           Color background = new Color(242,242,242);
        panel.setBackground(background);
        
       // panel.setBorder(BorderFactory.createEmp
       
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
            //// Aquí se quedan las herramientas de construcción:
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        /*NOMBRES*/
       lblNombre = new JLabel("Nombre:");

        txtNombre = new JTextField(20);

        /*===========APELLIDOS================*/
       lblApellidos= new JLabel("Apellidos:");

        txtApellidos = new JTextField(20);
            /*==========DNII=============*/
            
      lblDni= new JLabel("Dni:");

       txtDni = new JTextField(20);
         /*==========Telefono=============*/
            
         lblTelefono = new JLabel("Telefono:");

         txtTelefono = new JTextField(20);
        
           /*Correo=============*/
              
         lblCorreo = new JLabel("Correo:");

         txtCorreo = new JTextField(20);
         
            //=======idDocente
                  
         lblIdDcoente = new JLabel("ID Docente:");

         txtIdDocente = new JTextField(20);
         
        /*=========ESPECIALIDAD=============*/
       lblEspecialidad = new JLabel("Especialidad:");

    String[] opciones = { 
           };
   cboEspecialidad = new JComboBox<>(opciones);
    cboEspecialidad.setPreferredSize(new Dimension(150,40));
        
   lblFacultad = new JLabel("Facultad:");

           String[] opcionesFa = { };
    cboFacultad = new JComboBox<>(opcionesFa);
 cboFacultad.setPreferredSize(new Dimension(150,40));
        
      
        
 /*==========================BOTONESSSSSSS===================0==*/
        /*=============BOTON GUARDAR===========*/

        btnGuardar = new JButton("Registrar");
    btnGuardar.setPreferredSize(new Dimension(150,40));
    
        /*=============BOTON CONSULTARR===========*/
            btnConsultar = new JButton("Consultar");
    btnConsultar.setPreferredSize(new Dimension(150,40));

             btnActualizar = new JButton("Actualizar");
        /*=============BOTON ACTUALIZAR===========*/
    btnActualizar.setPreferredSize(new Dimension(150,40));

    
        /*=============BOTON ELIMINAR====================*/
             btnEliminar = new JButton("Eliminar");
    btnEliminar.setPreferredSize(new Dimension(150,40));


        // FILA 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtNombre, gbc);

        // FILA 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblApellidos, gbc);

        gbc.gridx = 1;
         gbc.gridy = 1;
        panel.add(txtApellidos, gbc);
        //fila 3
         gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblDni, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 2;
        panel.add(txtDni, gbc);

                //fila 4 telefono
         gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblTelefono, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 3;
        panel.add(txtTelefono, gbc);
        
               //fila 4 CORREO
         gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblCorreo, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 4;
        panel.add(txtCorreo, gbc);
        
        //IDALUMNO
        ///ID ALUMNO
            ///
            //fila 3
            gbc.gridx = 2;
            gbc.gridy = 0;
            panel.add(lblIdDcoente, gbc);
            //su columna
            gbc.gridx = 3;
            gbc.gridy = 0;
            panel.add(txtIdDocente, gbc);

            //fila 6
             gbc.gridx = 2;
            gbc.gridy = 1;
        panel.add(lblEspecialidad, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(cboEspecialidad, gbc);
            
        //    //fila 7
             gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(lblFacultad, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(cboFacultad, gbc);
            
        
        // FILA 8  BUTTON GUARDAR-REGISTRAR
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(btnGuardar, gbc);

        add(panel);
        add(panel,BorderLayout.NORTH);
        // FILA BUTTON CONSULTAR
         gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(btnConsultar, gbc);

           // FILA BUTTON ACTUALIZAR
         gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(btnActualizar, gbc);
           // FILA BUTTON eLIMINAR
         gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(btnEliminar, gbc);

        //PARTE DE PANEL CENTER  NORTEARRIBA Y CENTER DEBAJO
        
       tblTablaMost = new JTable();
         scroll =  new JScrollPane(tblTablaMost);
        contenidPanelCent = new JPanel();
          contenidPanelCent.setLayout(new BorderLayout());
          contenidPanelCent.add(scroll, BorderLayout.CENTER);
          
       add(panel);
       add(panel,BorderLayout.NORTH);
       add(contenidPanelCent, BorderLayout.CENTER);      
       
       
        //LLAMADOS A  LOGICA inicializando programa
        ProcesosFormDocente.cargCombo(this);
        DocenteDao daoCrud= new DocenteDao();
        
       
      
           
        daoCrud.mostrarEnTabla(tblTablaMost);
        
       btnGuardar.addActionListener( e -> {
           
     

        if(txtNombre.getText().trim().isEmpty()){
  JOptionPane.showMessageDialog(null,

       "Ingrese sus Nombres "); return;}


    
           if(txtApellidos.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null,
        "Ingrese sus Apellidos "); return;
                }
           
           //VALIDAR LECTURA DATO, QUE INGRESO EL SUAIRO
           
                if(txtDni.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null,
                 "Ingrese su DNI");
         return;
     }
                //VALIDAR DESDE DAO
               if(daoCrud.existeDniD(txtDni.getText())){
        JOptionPane.showMessageDialog(null,
       "EL DNI ya esta registrados");
                return;
       }

 if(txtTelefono.getText().trim().isEmpty() ||

   txtCorreo.getText().trim().isEmpty() 

 ){

    JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos..");

    return;

}
         
      Docente doce = ProcesosFormDocente.capEntradaCombo(this);
     // doce.setIdPersona(daoCrud.generarCodigoDocente());
     //DocenteDao daocrud = new DocenteDao();
     
       daoCrud.registrarDocente(doce);
       daoCrud.mostrarEnTabla(tblTablaMost);
       ProcesosFormDocente.limpEntradas(this);
       });
       
         tblTablaMost.addMouseListener(new MouseAdapter() {
    @Override       
    public void mouseClicked(MouseEvent e) {
                filaSelec = tblTablaMost.getSelectedRow();

        if(filaSelec < 0){
            return;
        }

        String idPersona =
            tblTablaMost.getValueAt(filaSelec,1).toString();

        String nombres =
            tblTablaMost.getValueAt(filaSelec,2).toString();

        String apellidos =
            tblTablaMost.getValueAt(filaSelec,3).toString();

        String dni =
            tblTablaMost.getValueAt(filaSelec,4).toString();

        String telefono =
            tblTablaMost.getValueAt(filaSelec,5).toString();

        String correo =
            tblTablaMost.getValueAt(filaSelec,6).toString();

        String especialidad =
            tblTablaMost.getValueAt(filaSelec,7).toString();

        String facultad =
            tblTablaMost.getValueAt(filaSelec,8).toString();

        txtIdDocente.setText(idPersona);
        txtIdDocente.setEnabled(false);

        txtNombre.setText(nombres);
        txtApellidos.setText(apellidos);
        txtDni.setText(dni);
        txtTelefono.setText(telefono);
        txtCorreo.setText(correo);

        cboEspecialidad.setSelectedItem(especialidad);
        cboFacultad.setSelectedItem(facultad); 
    }
    });
                
       btnActualizar.addActionListener(e-> {
       if (filaSelec >= 0) {
       try {
         
    Docente doc = ProcesosFormDocente.capturaActualizacion(this);
        daoCrud.actualizarDocente(doc);
            daoCrud.mostrarEnTabla(tblTablaMost);
      ProcesosFormDocente.limpEntradas(this);
           JOptionPane.showMessageDialog(null,"SE ACTUALIZO EL REGISTRO!!");
          }catch(Exception ex){
            JOptionPane.showMessageDialog( //mustra el error real
                null,
                ex.toString() );   
           }
  }else {
      JOptionPane.showMessageDialog(null, "Seleccione una fila primero");
  }

       
       });
       
         btnEliminar.addActionListener(e->{
  
  
  int fila;
        // Es el dibujo. Su única tarea es recibir la información del modelo y mostrársela 
        //al usuario en forma de filas y columnas, además de permitirle hacer clic o interactuar con ellas.
        fila = tblTablaMost.getSelectedRow();
        if(fila >= 0){
            int opcion = JOptionPane.showConfirmDialog(null, " ¿Desea eliminar el registro?",
                    "Confirmar..!!",
                    JOptionPane.YES_NO_OPTION //SI ES SI O NO ACA TIENE  LA S  DOS OPCIONESS.
        );
            //Si presiona "SI"
            if(opcion == JOptionPane.YES_OPTION){
             int idPersona = Integer.parseInt(
                tblTablaMost.getValueAt(fila,1).toString()
            );

            daoCrud.eliminarDocente(idPersona);

            daoCrud.mostrarEnTabla(tblTablaMost);
            ProcesosFormDocente.limpEntradas(this);
             //tienes getowcount 2 registros ocuan el espacio o indice 0 y 1, el sigueinte ocupra el indice2
             //entonce s 2<2??
                }
        }else 
            JOptionPane.showMessageDialog(null, "Operacion cancelada ");
    

  
  
  
  });
       
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDialogDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDialogDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDialogDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDialogDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDialogDocente dialog = new FormDialogDocente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    //LEER O MODIFICAR
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
  private javax.swing.JPanel panel;
 private javax.swing.JButton button;
 
  private javax.swing.JLabel lblIdDcoente;
 public javax.swing.JTextField txtIdDocente;
 private javax.swing.JLabel lblNombre;
 public javax.swing.JTextField txtNombre;
 
 private javax.swing.JLabel lblApellidos;
  public javax.swing.JTextField txtApellidos;
  
   private javax.swing.JLabel lblDni;
  public javax.swing.JTextField txtDni;
  
   private javax.swing.JLabel lblTelefono;
  public javax.swing.JTextField txtTelefono;
  
    
   private javax.swing.JLabel lblCorreo;
  public javax.swing.JTextField txtCorreo;
  
   private javax.swing.JLabel lblEspecialidad;
  public javax.swing.JComboBox<String>  cboEspecialidad;
  
     private javax.swing.JLabel lblFacultad;
     public  javax.swing.JComboBox<String>  cboFacultad;
  
  

public javax.swing.JButton btnGuardar;

private javax.swing.JButton btnConsultar;
private javax.swing.JButton btnActualizar;
private javax.swing.JButton btnEliminar;

  public javax.swing.JTable tblTablaMost;
    private javax.swing.JScrollPane scroll;
    
    private javax.swing.JPanel contenidPanelCent;
              
  
}
/*

Los 3 ajustes necesarios en tu código
Agrega el panel al diálogo: Creaste el JPanel, pero olvidaste añadirlo a la ventana con add(panel, BorderLayout.CENTER);.
Si no lo añades, la ventana se verá gris y vacía.
Cambia setLocationRelativeTo(null): Lo pusiste como null, lo que centra el diálogo en medio de la pantalla completa.
Si quieres que se centre justo encima de tu formulario principal (el padre), cámbialo por setLocationRelativeTo(parent);.
El título: Dice "Mantenimiento Libro" dentro de una clase llamada FormDialogDocente. Solo cámbialo a "Mantenimiento Docente" para que coincida.
*/