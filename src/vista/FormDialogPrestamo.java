/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import com.mysql.cj.MysqlConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.dao.PrestamoDao;
import modelo.entidades.Alumno;
import modelo.entidades.Prestamo;
import modelo.entidades.Usuario;
import modelo.procesos.ProcesosFormAlumno;
import modelo.procesos.ProcesosFormPrestamo;

/**
 *
 * @author BrayanLuis
 */
public class FormDialogPrestamo extends javax.swing.JDialog {
    int filaSelec = -1;
private Usuario usuarioLog;
final int COL_ID_PRESTAMO = 1;
final int COL_ID_PERSONA = 2;
final int COL_ID_LIBRO = 3;
final int COL_NOM_PERSONA = 4;
final int COL_NOM_LIBRO= 5;
final int COL_ESTADO= 8;
final int COL_CANTIDAD=9;
    /**
     * Creates new form FormDialogPrestamo
     */
    public FormDialogPrestamo(java.awt.Frame parent, boolean modal,
            Usuario usuarioLog) {
        super(parent, modal);
        initComponents();
        this.usuarioLog= usuarioLog;
         //initComponents();  // Comentado correctamente para diseño manual
       
        
        this.setTitle("Mantenimiento Prestamos");
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

        /*===========ALUMNO=============*/
       lblNomAlumno = new JLabel("Persona:");

        txtNomAlumno = new JTextField(20);

        /*===========LIBROOOO================*/
       lblNomLibro= new JLabel("Libro:");

        txtNomLibro = new JTextField(20);
        //===============PRESTAMO ID
        
          lblIdPrestamo= new JLabel("Id Prestamo:");

        txtIdPrestamo = new JTextField(20);
            /*==========FECHA PRESTAMO=============*/
            
             /*==========ID LIBRO && ID PERSONA DEL  PRESTAMO=============*/
            lblIdLibroUpdate = new JLabel("id Libro");
            txtIdLibroUpdate = new JTextField(20);
            
            lblIdPersonaUpdate = new JLabel("id Persona");
            txtIdPersonaUpdate = new JTextField(20);
            /*
      lblFechaPrestamo= new JLabel("Fecha Prestamo:");

       txtFechaPrestamo= new JTextField(20);
         //==========FECHA DEVOLUCION============
            
         lblFechaDevolucion = new JLabel("Fecha Devolucion:");

         txtFechaDevolucion = new JTextField(20); 
        */
                
                /*==========ESTADOOOO============*/
              
         lblEstado = new JLabel("Estado:");
  String[] opciones = { };
   cboEstado= new JComboBox<>(opciones);
    cboEstado.setPreferredSize(new Dimension(150,40));
         
         
           /*==========CANTIDAD LIBROS============*/
              
         lblCantidadlibro = new JLabel("Cantidad Libros:");

         txtCantidadLibro = new JTextField(14);
         
        /* 
        ==============CARRERA=============
       lblCarrera = new JLabel("Carrera");

    String[] opciones = { };
   cboCarrera = new JComboBox<>(opciones);
    cboCarrera.setPreferredSize(new Dimension(150,40));
        
   lblCiclo= new JLabel("Ciclo:");

           String[] opcionesFa = { };
    cboCiclo= new JComboBox<>(opcionesFa);
 cboCiclo.setPreferredSize(new Dimension(150,40));
        */
 
        
 /*==========================BOTONESSSSSSS===================0==*/
        /*=============BOTON GUARDAR===========*/

        btnGuardar = new JButton("Registrar");
    btnGuardar.setPreferredSize(new Dimension(150,40));
    
        /*=============BOTON CONSULTARR===========*/
            btnConsultar = new JButton("Consultar");
    btnConsultar.setPreferredSize(new Dimension(150,40));

        /*=============BOTON ACTUALIZAR===========*/
             btnActualizar = new JButton("Actualizar");
    btnActualizar.setPreferredSize(new Dimension(150,40));

    
        /*=============BOTON ELIMINAR====================*/
             btnEliminar = new JButton("Eliminar");
    btnEliminar.setPreferredSize(new Dimension(150,40));


        // FILA 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblNomAlumno, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtNomAlumno, gbc);

        // FILA 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblNomLibro, gbc);

        gbc.gridx = 1;
         gbc.gridy = 1;
        panel.add(txtNomLibro, gbc);
        
         //fila ID PRESTAMO
         gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblIdPrestamo, gbc);
               //su columna
        gbc.gridx = 1;
            gbc.gridy = 2;
        panel.add(txtIdPrestamo, gbc);
      
        //fila 3---acrualizarrrr ID LIRBO
         gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblIdLibroUpdate, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 2;
        panel.add(txtIdLibroUpdate, gbc);
        
        // ACTUALIZAR IDPERSONSA
         gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblIdPersonaUpdate, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 3;
        panel.add(txtIdPersonaUpdate, gbc);
   
        
          ///
        /*
        //fila 3
         gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblFechaPrestamo, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 2;
        panel.add(txtFechaPrestamo, gbc);

                //fila 4 telefono
         gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblFechaDevolucion, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 3;
        panel.add(txtFechaDevolucion, gbc);
        */
        
        //--------------------------------------------------------------
        
        /*otro lado de la pantalla paralleo los comopnetes restantes*/
            //fila 6
             gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(lblEstado, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(cboEstado, gbc);
            
        //    //fila 7
             gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(lblCantidadlibro, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(txtCantidadLibro, gbc);
            
        
        // FILA 8  BUTTON GUARDAR-REGISTRAR
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(btnGuardar, gbc);

        add(panel);
        add(panel,BorderLayout.NORTH);
        // FILA BUTTON CONSULTAR
         gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(btnConsultar, gbc);

           // FILA BUTTON ACTUALIZAR
         gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(btnActualizar, gbc);
           // FILA BUTTON eLIMINAR
         gbc.gridx = 3;
        gbc.gridy = 3;
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
    
   //=====================CARGANDO OCULTOS EN FALSO=========================
       lblIdLibroUpdate.setVisible(false);
       txtIdLibroUpdate.setVisible(false);
       
       lblIdPersonaUpdate.setVisible(false);
       txtIdPersonaUpdate.setVisible(false);
       
       //LLAMADOS A  LOGICA inicializando programa
        ProcesosFormPrestamo.cargCombox(this);
        PrestamoDao daoCrud= new PrestamoDao();
        daoCrud.mostrarEnTabla(tblTablaMost);
        
        ocultarColumnas();
        
        //=============================BOTON GUARDAR============================
        btnGuardar.addActionListener( e -> {
       
            
        String alu2 =ProcesosFormPrestamo.obtenerRol(usuarioLog);
        
           Prestamo alum = ProcesosFormPrestamo.capturaEntrada(this);
           
           
            daoCrud.registraPrestamo(alum);
            
            //=======DESCEUNTOOOOO DE CANTIDDAD DE LIBROS===============
            daoCrud.descontarLibroPrest(alum);
           daoCrud.mostrarEnTabla(tblTablaMost);
            ProcesosFormPrestamo.limpCombox(this);
 
            ocultarColumnas();          
        });
      //  ProcesosFormAlumno.cargCombo(this);

        tblTablaMost.addMouseListener(new MouseAdapter() {
         @Override       
         public void mouseClicked(MouseEvent e) {

     filaSelec = tblTablaMost.getSelectedRow();

     if(filaSelec < 0){
     return;
     }
         String idPrestamo =
         tblTablaMost.getValueAt(filaSelec,COL_ID_PRESTAMO).toString();
          String presona =
         tblTablaMost.getValueAt(filaSelec,COL_ID_PERSONA).toString();
         String libro =
         tblTablaMost.getValueAt(filaSelec,COL_ID_LIBRO).toString();

           String nombrePersona =
         tblTablaMost.getValueAt(filaSelec,COL_NOM_PERSONA).toString();
           
           String nombreLibro =
         tblTablaMost.getValueAt(filaSelec,COL_NOM_LIBRO).toString();
         String estado =
         tblTablaMost.getValueAt(filaSelec,COL_ESTADO).toString();
         String cantidad =
         tblTablaMost.getValueAt(filaSelec,COL_CANTIDAD).toString();

         txtIdPrestamo.setText(idPrestamo);
         txtIdPrestamo.setEnabled(false);

         txtIdPersonaUpdate.setText(presona);

         txtIdLibroUpdate.setText(libro);

         txtNomAlumno.setText(nombrePersona);
         txtNomLibro.setText(nombreLibro);

         cboEstado.setSelectedItem(estado);

         txtCantidadLibro.setText(cantidad);
         }

       });
          
  btnActualizar.addActionListener(e-> {
     
         
      
  if (filaSelec >= 0) {
      
       try {
             

    
       /*
                  lblIdLibroUpdate.setVisible(true);
       txtIdLibroUpdate.setVisible(true);
       
       lblIdPersonaUpdate.setVisible(true);
       txtIdPersonaUpdate.setVisible(true);
           */
       
       /*
       Prestamo p es una referencia a un objeto que ya tiene todos sus datos configurados
       (idPrestamo, Persona, Libro, estado, cantidadLibros).
    Con PreparedStatement ps tomas esos datos:
       */
           
        Prestamo prest = ProcesosFormPrestamo.capturaActualizacion(this);
        daoCrud.actualizarPrestamo(prest);
        
        daoCrud.descontarLibroPrest(prest);
        //daoCrud.actualizarEstadoDevuelto(prest);
      //  daoCrud.aumentarStock(prest);
        
        daoCrud.mostrarEnTabla(tblTablaMost);
         ProcesosFormPrestamo.limpCombox(this);
        ocultarColumnas();
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
             int idPrestamo = Integer.parseInt(
                tblTablaMost.getValueAt(fila,1).toString()
            );

            daoCrud.eliminarPrestamo(idPrestamo);

            daoCrud.mostrarEnTabla(tblTablaMost);
            ProcesosFormPrestamo.limpCombox(this);
             //tienes getowcount 2 registros ocuan el espacio o indice 0 y 1, el sigueinte ocupra el indice2
             //entonce s 2<2??
                }
        }else 
            JOptionPane.showMessageDialog(null, "Operacion cancelada ");
    

  
  
  
  });
  
    }
   private void ocultarColumnas(){
        tblTablaMost.getColumnModel().getColumn(2).setMinWidth(0);
     tblTablaMost.getColumnModel().getColumn(2).setMaxWidth(0);

     tblTablaMost.getColumnModel().getColumn(3).setMinWidth(0);
     tblTablaMost.getColumnModel().getColumn(3).setMaxWidth(0);
   }
         public Usuario getUsuarioLog(){
        return usuarioLog;
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
            java.util.logging.Logger.getLogger(FormDialogPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDialogPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDialogPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDialogPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDialogPrestamo dialog = new FormDialogPrestamo(new javax.swing.JFrame(), true,null);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

 private javax.swing.JPanel panel;
  
 public javax.swing.JLabel lblIdPrestamo;
 public javax.swing.JTextField txtIdPrestamo;
 
 public javax.swing.JLabel lblNomAlumno;
 public javax.swing.JTextField txtNomAlumno;
 
 public javax.swing.JLabel lblNomLibro;
  public javax.swing.JTextField txtNomLibro;
  
   public javax.swing.JLabel lblCantidadlibro;
  public javax.swing.JTextField txtCantidadLibro;
  
   public javax.swing.JLabel lblEstado;
  public javax.swing.JComboBox<String>  cboEstado;
  
  //ACTUALIZANDO IDS
   public javax.swing.JLabel lblIdPersonaUpdate;
 public javax.swing.JTextField txtIdPersonaUpdate;
 
    public javax.swing.JLabel lblIdLibroUpdate;
        public javax.swing.JTextField txtIdLibroUpdate;

  
  //paneo y scrol pueden ser private

public javax.swing.JButton btnGuardar;

public javax.swing.JButton btnConsultar;
public javax.swing.JButton btnActualizar;
public javax.swing.JButton btnEliminar;

  public javax.swing.JTable tblTablaMost;
    private javax.swing.JScrollPane scroll;
    
    private javax.swing.JPanel contenidPanelCent;
    
    /*
       public javax.swing.JLabel lblFechaPrestamo;
  public javax.swing.JTextField txtFechaPrestamo;
  
   public javax.swing.JLabel lblFechaDevolucion;
  public javax.swing.JTextField txtFechaDevolucion;
    */
}
