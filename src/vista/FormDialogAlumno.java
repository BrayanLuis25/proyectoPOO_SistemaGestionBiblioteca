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
import modelo.entidades.Alumno;
import modelo.procesos.ProcesosFormAlumno;


/**
 *
 * @author BrayanLuis
 */
public class FormDialogAlumno extends javax.swing.JDialog {
    int filaSelec = -1;
    /**
     * Creates new form FormDialogAlumno
     */
    public FormDialogAlumno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        //initComponents();  // Comentado correctamente para diseño manual
    
        
        this.setTitle("Mantenimiento Alumno");
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
        
         //===========id laumno
         
           lblIdAlum = new JLabel("Alumno:");

         txtIdAlum = new JTextField(20);
        /*==============CARRERA=============*/
       lblCarrera = new JLabel("Carrera");

    String[] opciones = { };
   cboCarrera = new JComboBox<>(opciones);
    cboCarrera.setPreferredSize(new Dimension(150,40));
        
   lblCiclo= new JLabel("Ciclo:");

           String[] opcionesFa = { };
    cboCiclo= new JComboBox<>(opcionesFa);
 cboCiclo.setPreferredSize(new Dimension(150,40));
        
        /*Correo=============*/
              
         lblCorreo = new JLabel("Correo:");

         txtCorreo = new JTextField(20);
        
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
        
        ///ID ALUMNO
        ///
           //fila 3
         gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(lblIdAlum, gbc);
               //su columna
        gbc.gridx = 3;
            gbc.gridy = 0;
        panel.add(txtIdAlum, gbc);
        
        ///
        
            //fila 6
             gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(lblCarrera, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(cboCarrera, gbc);
            
        //    //fila 7
             gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(lblCiclo, gbc);
            //su columna
        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(cboCiclo, gbc);
            
        
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
        gbc.gridy =4;
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
          
          txtIdAlum.setEnabled(false);
          
       add(panel,BorderLayout.NORTH);
       add(contenidPanelCent, BorderLayout.CENTER);       
        
       //LLAMADOS A  LOGICA inicializando programa
       ProcesosFormAlumno.cargCombo(this);
        AlumnoDao crud= new AlumnoDao();
        crud.mostrarEnTabla(tblTablaMost);
        
        
       btnGuardar.addActionListener( e -> {
          txtIdAlum.setEnabled(false);
          if(txtNombre.getText().trim().isEmpty()){
           
            JOptionPane.showMessageDialog(null,
                 "Ingrese sus Nombres ");
         return;
          }
             if(txtApellidos.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,
                 "Ingrese sus Apellidos ");
         return;
          }
                 System.out.println("Paso 1");
                 //VALIDA QUE EL USUARIO INGRESO EL DNI
                 if(txtDni.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Ingrese su DNI");
                return;
}
                 
                 //DAO DNI-VALIDA
         if(crud.existeDni(txtDni.getText().trim())){
         JOptionPane.showMessageDialog(null,
                 "EL DNI ya esta registrado");
         return;
         }
         
            System.out.println("Paso 2222");
        if(txtTelefono.getText().trim().isEmpty() ||

          txtCorreo.getText().trim().isEmpty() )
     {
           JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos");
           return;
}
        /*
         //LLAMADOS A  LOGICA inicializando programa
       ProcesosFormAlumno.cargCombo(this);
        AlumnoDao crud= new AlumnoDao();
        crud.mostrarEnTabla(tblTablaMost);
        */
              
  /* 2CASOS:
              
 // 1. import semana_01.Alumno;
No crea ningún objeto. Solo le dice al compilador que existe una clase llamada Alumno y que podrás usarla por su nombre.
Desde ese momento, Alumno puede usarse como un tipo de dato
 */
 // 2.contenedor de metoso staticos,parecido:
 //Math.sqrt(25);y Integer.parseInt("10");
 
       Alumno alum = ProcesosFormAlumno.capEntradaCombo(this);
     //  alum.setIdPersona( crud.generarCodigoAlumno());
       //AlumnoDao crud = new AlumnoDao();
       
       crud.registraAlumno(alum);
       crud.mostrarEnTabla(tblTablaMost);
       ProcesosFormAlumno.limpEntradas(this);
       });
       
       
      //  ProcesosFormAlumno.cargCombo(this);
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
        if (FormDialogAlumno.this.filaSelec < 0) {
            return;
        }
         //empeizade0        
        String IdAlumno = 
        tblTablaMost.getValueAt(filaSelec,1).toString() ;
   
        String nombres =tblTablaMost.getValueAt(filaSelec,2).toString();

        String apellidos =
            tblTablaMost.getValueAt(filaSelec,3).toString();
    
        String dni = tblTablaMost.getValueAt(filaSelec, 4).toString();
        String telefono  = tblTablaMost.getValueAt(filaSelec, 5).toString();

        String correo =
        tblTablaMost.getValueAt(filaSelec,6).toString();
        
        String carrera =
        tblTablaMost.getValueAt(filaSelec,7).toString();
        
        String ciclo =
        tblTablaMost.getValueAt(filaSelec,8).toString();
         // int cantidad = Integer.parseInt((String) tblTablaMost.getValueAt(filaSelec, 6));
         
            txtIdAlum.setText(IdAlumno);
            txtIdAlum.setEnabled(false);
            txtNombre.setText(nombres);
            txtApellidos.setText(apellidos);
            txtDni.setText(dni);
            txtTelefono.setText(telefono);
            txtCorreo.setText(correo);
            cboCarrera.setSelectedItem(carrera);
            cboCiclo.setSelectedItem(ciclo);

  

    }
        
  });
          
  btnActualizar.addActionListener(e-> {
     
     txtIdAlum.setEnabled(false);   
      
  if (filaSelec >= 0) {
       try {
         
  Alumno alum = ProcesosFormAlumno.capturaActualizacion(this);
        crud.actualizarAlumno(alum);
            crud.mostrarEnTabla(tblTablaMost);
            ProcesosFormAlumno.limpEntradas(this);
    
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
  
  txtIdAlum.setEnabled(true);
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

            crud.eliminarAlumno(idPersona);

            crud.mostrarEnTabla(tblTablaMost);
            ProcesosFormAlumno.limpEntradas(this);
             //tienes getowcount 2 registros ocuan el espacio o indice 0 y 1, el sigueinte ocupra el indice2
             //entonce s 2<2??
                }
        }else 
            JOptionPane.showMessageDialog(null, "Operacion cancelada ");
    

  
  
  
  });

    }

    /*
    e -> { ... } reemplaza a todo el método: La flecha -> 
    sustituye de forma directa a toda la declaración de private void 
    btnRegistrarActionPerformed(java.awt.event.ActionEvent evt).
    
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(FormDialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDialogAlumno dialog = new FormDialogAlumno(new javax.swing.JFrame(), true);
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
   public javax.swing.JLabel lblIdAlum;
 public javax.swing.JTextField txtIdAlum;

 
 public javax.swing.JLabel lblNombre;
 public javax.swing.JTextField txtNombre;
 
 public javax.swing.JLabel lblApellidos;
  public javax.swing.JTextField txtApellidos;
  
   public javax.swing.JLabel lblDni;
  public javax.swing.JTextField txtDni;
  
   public javax.swing.JLabel lblTelefono;
  public javax.swing.JTextField txtTelefono;
  
    
   public javax.swing.JLabel lblCorreo;
  public javax.swing.JTextField txtCorreo;
  
   public javax.swing.JLabel lblCarrera;
  public javax.swing.JComboBox<String>  cboCarrera;
  
     public javax.swing.JLabel lblCiclo;
       public javax.swing.JComboBox<String>  cboCiclo;
  
  //paneo y scrol pueden ser private
 private javax.swing.JLabel lblAutor;
private javax.swing.JTextField txtAutor;
public javax.swing.JButton btnGuardar;

public javax.swing.JButton btnConsultar;
public javax.swing.JButton btnActualizar;
public javax.swing.JButton btnEliminar;

  public javax.swing.JTable tblTablaMost;
    private javax.swing.JScrollPane scroll;
    
    private javax.swing.JPanel contenidPanelCent;
}

/*
1. JFrame → ventana principal setSize(900,600) Aquí no hay otro contenedor “padre” decidiendo el tamaño. El JFrame es la ventana principal 
del sistema operativo. Entonces: setSize() define el tamaño REAL. Y: setMinimumSize(...) evita que el usuario reduzca
demasiado la ventana.
2. JPanel → contenedor interno El JPanel normalmente vive dentro de un layout: BorderLayout FlowLayout GridLayout 
Entonces el panel NO controla totalmente su tamaño. El layout le pregunta: “¿qué tamaño prefieres?” y por eso existe: preferredSize 3. JButton con BoxLayout BoxLayout sí mira mucho: preferredSize maximumSize 
minimumSize porque organiza componentes uno debajo de otro.
Si no limitas tamaño: BoxLayout puede estirar el botón horizontalmente o verticalmente. Por eso: btn.setMaximumSize(...) sirve como “tope”. 
Idea teórica importante Cada layout manager interpreta tamaños distinto. BorderLayout Usa mucho: preferredSize de WEST/EAST. BoxLayout Usa: preferredSize maximumSize alignment 
GridLayout Ignora casi todos los tamaños y hace todo igual. Entonces No existe: “una única medida oficial”

¡Excelente resumen! Tu análisis teórico de cómo Java Swing maneja los tamaños es 100% correcto. Has capturado perfectamente la esencia de Swing: el Layout Manager manda, y cada uno tiene sus propias reglas de juego.
Aquí tienes un desglose estructurado para complementar y consolidar tus apuntes:
📌 Comportamiento de Tamaños por Layout
BorderLayout
NORTH / SOUTH: Respeta solo el preferredSize de la altura. Ignora el ancho.
EAST / WEST: Respeta solo el preferredSize del ancho. Ignora la altura.
CENTER: Ignora cualquier tamaño sugerido. Se estira para llenar todo el espacio restante.
FlowLayout
Respeta estrictamente el preferredSize de todos sus componentes.
Si la ventana se achica, los componentes "fluyen" a la siguiente línea.
BoxLayout
Intenta respetar el preferredSize.
Si hay espacio extra, estira los componentes hasta su maximumSize.
Si falta espacio, los encoge hasta su minimumSize.
Usa alignmentX y alignmentY para alinear los bordes.
GridLayout
Regla de oro: Ignora preferredSize, minimumSize y maximumSize.
Divide el espacio en partes exactamente iguales para todos los componentes.
💡 3 Buenas Prácticas Clave en Swing
Evita setSize() en componentes internos: Modificar el tamaño manualmente (setSize, setBounds) en componentes dentro de un contenedor con Layout Manager no funciona o causa errores visuales.
Usa pack() en el JFrame: En lugar de darle un tamaño fijo al JFrame con setSize(900, 600), puedes usar frame.pack(). Esto calcula automáticamente el tamaño óptimo de la ventana basándose en los preferredSize de los paneles internos.
Componentes invisibles en BoxLayout: Para dejar espacios en blanco en BoxLayout, no uses márgenes. Usa componentes invisibles de la clase Box:
Box.createRigidArea(new Dimension(0, 20)); (Espacio fijo)
Box.createVerticalGlue(); (Espacio elástico que empuja los componentes)
Si estás diseñando una interfaz específica, dime:
¿Qué tipo de pantalla estás construyendo? (Login, tabla de datos, menú...)
¿Qué Layouts estás combinando actualmente?
Puedo darte el código de ejemplo exacto para estructurar tu diseño de forma limpia.





se breve en entonces en jpanl borderlayout no impor el amximsize ni el minimum sizze solo el preferered size?
Sí, es exacto. En un JPanel con BorderLayout, el layout ignora por completo el maximumSize y el minimumSize de los componentes.
Solo le importa el preferredSize, y lo hace con reglas estrictas:
NORTH / SOUTH: Solo mira el alto (height) preferido. El ancho lo estira a la fuerza.
EAST / WEST: Solo mira el ancho (width) preferido. El alto lo estira a la fuerza.
CENTER: Ignora todo. Se estira sí o sí para llenar el espacio que sobre.
Para ajustar los tamaños en tu diseño actual, dime:
¿En qué zona (NORTH, CENTER, etc.) está fallando el tamaño?
¿Qué componente se está deformando o estirando de más?





pero porque
Porque BorderLayout fue diseñado bajo una filosofía de "llenar espacios" y no de "respetar límites". Su prioridad es que la ventana nunca tenga huecos vacíos al estirarse.
Funciona así por estas razones técnicas:
Algoritmo simple: Para calcular el diseño rápido, el layout solo pide un dato (preferredSize). Si tuviera que calcular mínimos y máximos de 5 zonas a la vez, el código interno sería ineficiente.
Zonas con roles fijos:
Las zonas NORTH/SOUTH están pensadas para barras de herramientas o menús. El layout asume que siempre deben ocupar todo el ancho disponible.
Las zonas EAST/WEST son para paneles laterales. El layout asume que siempre deben ocupar todo el alto disponible.
El CENTER es el área principal (como un editor de texto o un mapa). El layout asume que el usuario siempre querrá que esa zona crezca al máximo si la ventana se agranda.
Si el usuario estira la ventana, BorderLayout está obligado a agrandar los componentes. Si respetara el maximumSize, quedarían huecos vacíos y fondos grises en la ventana, lo cual se ve mal visualmente.
Para darte una solución rápida, dime:
¿Qué componente se está estirando y se ve mal?
¿Quieres que se quede de un tamaño fijo o que deje de deformarse?







*/