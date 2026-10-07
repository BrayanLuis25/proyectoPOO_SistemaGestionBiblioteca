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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.dao.AlumnoDao;
import modelo.dao.LibroDao;
import modelo.entidades.Alumno;
import modelo.entidades.Libro;
import modelo.procesos.ProcesosFormAlumno;
import modelo.procesos.ProcesosFormLibro;

/**
 *
 * @author BrayanLuis
 */
public class FormDialogLibro extends javax.swing.JDialog {

    //FILA EN AMBITO GLOBAL INICIAL
   int filaSelec= -1;

    /**
     * Creates new form FormDialogLibro
     */
    public FormDialogLibro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //this.rootParent = parent;
       // initComponents(); //Comentado correctamente para diseño manual

        
        this.setTitle("Mantenimiento Libro");
     setSize(900,600);
   
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        panel = new JPanel();
           Color background = new Color(242,242,242);
        panel.setBackground(background);
        
       // panel.setBorder(BorderFactory.createEmp
       
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
            //// Aquí se quedan las herramientas de construcción:
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);

        /* ============Titulo Libro========*/
       lblTituloLibro= new JLabel("Titlulo de Libro:");

        txtTituloLibro = new JTextField(20);

        /*=========== Autorrr================*/
       lblAutor= new JLabel("Autor:");

        txtAutor = new JTextField(20);
            /*==========CANTIDAD=============*/
            
      lblCantidad= new JLabel("Cantidad:");

       txtCantidad = new JTextField(20);
       
       //===========idlibro
             lblIdLibro= new JLabel("ID Libro:");

       txtIdLibro = new JTextField(20);
         /*==========Telefono=============*/
         /*==========Telefono=============*/
          
      
             /*Correo=============*/
        
        
        
        /*==============CATEGORIAS=============*/
       lblCategoria= new JLabel("Categorias:");

    String[] opciones = { };
   cboCategoria = new JComboBox<>(opciones);
    cboCategoria.setPreferredSize(new Dimension(150,40));
        
         /*============== EDITORIAL=============*/
   lblEditorial= new JLabel("Editorial:");

           String[] opcionesFa = { };
    cboEditorial= new JComboBox<>(opcionesFa);
 cboEditorial.setPreferredSize(new Dimension(150,40));
        
    
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
        panel.add(lblTituloLibro, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtTituloLibro, gbc);

        // FILA 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblAutor, gbc);

        gbc.gridx = 1;
         gbc.gridy = 1;
        panel.add(txtAutor, gbc);
        //fila 3
         gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblCantidad, gbc);
        //su columna
        gbc.gridx = 1;
            gbc.gridy = 2;
        panel.add(txtCantidad, gbc);
        //int fila 4
        
              //fila 3
         gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblIdLibro, gbc);
               //su columna
        gbc.gridx = 1;
            gbc.gridy = 3;
        panel.add(txtIdLibro, gbc);

            //COMBO BOX: CAETEGORIA Y EDITORIAL
            //fila 6
             gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(lblCategoria, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(cboCategoria, gbc);
            
        //    //fila 7
             gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(lblEditorial, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(cboEditorial, gbc);
            
        
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
        
       
       //LLAMADOS A  LOGICA inicializando programa
        ProcesosFormLibro.cargCombox(this);
        LibroDao daoCrud= new LibroDao();
        daoCrud.mostrarEnTabla(tblTablaMost);

        /*
        El objeto Modelo: Es el "cerebro" o almacén. Es un objeto en memoria que guarda
        la lista de datos estructurados..
        El objeto Tabla: Es la "pantalla". Es un objeto visual que se conecta al modelo,
        extrae sus datos y los dibuja en la pantalla para el usuario.
        */
        
  btnGuardar.addActionListener(e-> {
       /*
      Se dice "cargar los datos en los controles" porque estás copiando o transfiriendo los datos desde la fila seleccionada del JTable hacia los JTextField y JComboBox.

JTable
   ↓ copiar datos
JTextField / JComboBox
      */
      
       Libro lib = ProcesosFormLibro.capturaEntrada(this);
      
     //  LibroDao crud = new LibroDao();
       daoCrud.registrarLibro(lib);
       daoCrud.mostrarEnTabla(tblTablaMost);
       ProcesosFormLibro.limpCombox(this);
       
       });
        //================CAPTURA EN TABLA PARA ACTUALIZARRRR LIBRO==================
  tblTablaMost.addMouseListener(new MouseAdapter() {
    @Override       
    public void mouseClicked(MouseEvent e) {
    //    txtNombre.setText(modelTabla.getValueAt(filaSelecc,1).toString() );
            
            //LECTURA DE DATOS
      //  Usamos el nombre exacto de tu variable global: filaSelec
       // FormDialogLibro.this.filaSelec = tblTablaMost.getSelectedRow();
        
       
        filaSelec=  tblTablaMost.getSelectedRow();
          // Validación temprana por si hacen clic en el vacío de la tabla
        if (FormDialogLibro.this.filaSelec < 0) {
            return;
        }
                 
        String IdLibro = 
        tblTablaMost.getValueAt(filaSelec,1).toString() ;
   
        String titulo =tblTablaMost.getValueAt(filaSelec,2).toString();

        String autor =
            tblTablaMost.getValueAt(filaSelec,3).toString();
    
        String categoria = tblTablaMost.getValueAt(filaSelec, 4).toString();
        String editorial  = tblTablaMost.getValueAt(filaSelec, 5).toString();

        String cantidad =
        tblTablaMost.getValueAt(filaSelec,6).toString();
         // int cantidad = Integer.parseInt((String) tblTablaMost.getValueAt(filaSelec, 6));
         
              txtIdLibro.setText(IdLibro);
              txtIdLibro.setEnabled(false);
    txtTituloLibro.setText(titulo);
    txtAutor.setText(autor);

    cboCategoria.setSelectedItem(categoria);
    cboEditorial.setSelectedItem(editorial);

    txtCantidad.setText(cantidad);

    }
        
  });
          
  btnActualizar.addActionListener(e-> {
            /*
       private int idLibro;
            private String tituloLibro;
            private String autor;
            private String categoria;
            private String editorial;
            private int cantidad;
        
      */
  if (filaSelec >= 0) {
       try {
         
  Libro lib = ProcesosFormLibro.capturaActualizacion(this);
daoCrud.actualizarLibro(lib);
            daoCrud.mostrarEnTabla(tblTablaMost);
  ProcesosFormLibro.limpCombox(this);
    
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
             int idLibro = Integer.parseInt(
                tblTablaMost.getValueAt(fila,1).toString()
            );

            daoCrud.eliminarLibro(idLibro);

            daoCrud.mostrarEnTabla(tblTablaMost);
            ProcesosFormLibro.limpCombox(this);
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
            java.util.logging.Logger.getLogger(FormDialogLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDialogLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDialogLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDialogLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDialogLibro dialog = new FormDialogLibro(new javax.swing.JFrame(), true);
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
  
 public javax.swing.JLabel lblIdLibro;
 public javax.swing.JTextField txtIdLibro;
 
 public javax.swing.JLabel lblTituloLibro;
 public javax.swing.JTextField txtTituloLibro;
 
 public javax.swing.JLabel lblAutor;
  public javax.swing.JTextField txtAutor;
  
   public javax.swing.JLabel lblCantidad;
  public javax.swing.JTextField txtCantidad;
  

  
  //COMBOS CATEGORIA, EDITORIAL
   public javax.swing.JLabel lblCategoria;
  public javax.swing.JComboBox<String>  cboCategoria;
  
   public javax.swing.JLabel lblEditorial;
   public javax.swing.JComboBox<String>  cboEditorial;
  
  //paneo y scrol pueden ser private

public javax.swing.JButton btnGuardar;

public javax.swing.JButton btnConsultar;
public javax.swing.JButton btnActualizar;
public javax.swing.JButton btnEliminar;

  public javax.swing.JTable tblTablaMost;
    private javax.swing.JScrollPane scroll;
    
    private javax.swing.JPanel contenidPanelCent;
   

}
