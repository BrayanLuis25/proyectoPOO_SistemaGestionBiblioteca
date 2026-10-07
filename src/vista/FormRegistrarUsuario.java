/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.dao.UsuarioDao;

import modelo.entidades.Usuario;
import modelo.procesos.ProcesosFormRegistrarUsuario;

/**
 *
 * @author BrayanLuis
 */
public class FormRegistrarUsuario extends javax.swing.JFrame {
private Usuario usuarioLog;
    /**
     * Creates new form FormLoginUsuario
     */
    public FormRegistrarUsuario(Usuario user) {
            this.usuarioLog = user;
      //  System.out.println(usuarioLog.getUsername());
        if(usuarioLog != null){
    System.out.println("Soy un"+usuarioLog.getUsername()+ "\n"+"Registrando a otro rol...");

}
        //initComponents();
        setTitle("Registrar Usuario");
        setSize(700,700);
          
        setPreferredSize(new Dimension(700,700));
         setMinimumSize(new Dimension(700, 700));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Color fondo = new Color(47, 74, 58);
        Color texto = new Color(200, 176, 138);

        /*
        // ===== PANEL TITULO =====
         panelTitulo = new JPanel();
        panelTitulo.setBackground(fondo);
*/
  

      panelFormulario = new JPanel(){
              
                      protected void paintComponent(Graphics g){
              super.paintComponent(g);
              
              Graphics2D g2d = (Graphics2D)g;
                  GradientPaint gp = new GradientPaint(
                  0,0,new Color(140,106,74),
                  getWidth(),getHeight(),new Color(
                  230,220,200));
                  //23,162,184 y 122,63,194
                  g2d.setPaint(gp);
                  g2d.fillRect(0, 0,getWidth(), getHeight());
                  }

      };
        
      /*
    1.GridBagLayout: es el administrador de diseño que permite colocar componentes
      en una cuadrícula flexible (filas y columnas), controlando posición, tamaño y alineación. */
        GridBagLayout gbl = new GridBagLayout();
        panelFormulario.setLayout(gbl);
        //// Aquí se quedan las herramientas de construcción:
       /*
    2.GridBagConstraints: es el objeto donde se configuran las reglas de 
        cada componente (fila, columna, márgenes, expansión, etc.).
        */
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10,10,10,10);
        
            lblTitulo = new JLabel("Registrar Usuario");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(texto);
        
        /*

        // ===== PANEL FORMULARIO =====
        panelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBackground(fondo);
        panelFormulario.setBorder(
                BorderFactory.createEmptyBorder(20, 40, 20, 40));
*/
      
        lblUsuario = new JLabel("Nombre deUsuario:");
                txtNomUsuario = new JTextField(30);
        //lblUsuario.setForeground(Color.WHITE);

        lblClave = new JLabel("Contraseña:");
       // lblClave.setForeground(Color.WHITE);
   txtContrasena = new JPasswordField(30);

     
    
/*
        // ===== PANEL BOTONES =====
        JPanel panelBotones = new JPanel();
*/
    lblRoles = new JLabel("Roles:");


    String[] opciones = {   "Seleccione..","Administrador", "Bibliotecario",
        "Alumno","Docente"};
   cboroles = new JComboBox<>(opciones);
    cboroles.setPreferredSize(new Dimension(300,60));
    
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setPreferredSize(new Dimension(300,60));
        
        btnIrViewAdBibliotecario = new JButton("Ir a panel Bibliotecario");
          btnIrViewAdBibliotecario.setPreferredSize(new Dimension(300,60));
          
          
            // FILA 1
        gbc.gridx = 0;
        gbc.gridy = 0;

        panelFormulario.add(lblTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(lblUsuario, gbc);

        // FILA 2
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(txtNomUsuario, gbc);

        gbc.gridx = 0;
         gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(lblClave, gbc);
        
        
        gbc.gridx = 0;
         gbc.gridy = 4;
        panelFormulario.add(txtContrasena, gbc);
        
        //fila 3
         gbc.gridx = 0;
        gbc.gridy = 5;
          gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(lblRoles, gbc);
        //su columna
        gbc.gridx = 0;
            gbc.gridy = 6;
        panelFormulario.add(cboroles, gbc);
        
             //su columna
        gbc.gridx = 0;
            gbc.gridy = 7;
        panelFormulario.add(btnRegistrar, gbc);
        
        
             //su columna
        gbc.gridx = 0;
            gbc.gridy = 8;
        panelFormulario.add(btnIrViewAdBibliotecario, gbc);

       
            
      
       

        add(panelFormulario,BorderLayout.CENTER);
        
          
     

    btnRegistrar.addActionListener(e -> {
        
          // 1. Capturar la contraseña de forma segura como char[]
    char[] passwordChars = txtContrasena.getPassword();
    
    // 2. Convertir el char[] a String para pasarlo al método
    String passwordString = new String(passwordChars);
    
    
    
    // 4. (Opcional) Borrar el arreglo de la memoria por seguridad
    java.util.Arrays.fill(passwordChars, '0');
 

    Usuario usuario =
            ProcesosFormRegistrarUsuario.capturarDatos(this);
    
   int idRol =
            ProcesosFormRegistrarUsuario
                    .obtenerIdRol(this);

    if(idRol == 0){

        JOptionPane.showMessageDialog(
                this,
                " Seleccione un rol"
        );

        return;
    }
  /*a la base ded aots le mandas el rol que captura seugn su id*/
    UsuarioDao dao = new UsuarioDao();
    int idUsuario = dao.registrar(usuario, idRol);
    if(idUsuario>0){
        JOptionPane.showMessageDialog(null, "Se registro un usuario!");}
    else
        JOptionPane.showMessageDialog(this, "Error al registrar el usuario...");
    
    
  
});
    
    btnIrViewAdBibliotecario.addActionListener(e->{
         this.dispose(); //cerra el jframe este objeto FORMREGISTRARUSUARIOprimero en formualrio relaciones asi jframe y jdialog
 FormDialogAdBibliotecario regrevistaBi = new FormDialogAdBibliotecario
        (this, rootPaneCheckingEnabled,usuarioLog);
    regrevistaBi.setLocationRelativeTo(null);//Despues de hacer this.dispose(), ya no debes usar this.Se usa this SOLO SRIVE SI LA VENTANA PADRE SIGUE VIVA
   //ventana realtiva al padre que puede ser jframe , insntacia otro dialog se le pasa el this del padre
    regrevistaBi.setVisible(true);
    //cerrando el formRegistrarusuario y vas al btnLogin
   

    });
    

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(FormLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLoginUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
         
                new FormRegistrarUsuario(null).setVisible(true);
            }
        });
    }
/*
    ==================================00000MAIN==================================
    El main() es útil cuando:

Quieres arrancar toda la aplicación.

Quieres probar una ventana de forma independiente.
    */
    // Variables declaration - do not modify                     
    // End of variables declaration                   
     // Variables declaration - do not modify                     
    // End of variables declaration                   
  private javax.swing.JPanel panelTitulo;
  

  private javax.swing.JLabel lblTitulo;
  private javax.swing.JLabel lblUsuario;
  private javax.swing. JLabel lblClave;

    public javax.swing.JTextField txtNomUsuario;
    public javax.swing.JPasswordField txtContrasena;

      private javax.swing.JLabel lblRoles;
    public javax.swing.JComboBox<String> cboroles;
    private javax.swing.JButton btnRegistrar;
      private javax.swing.JButton btnIrViewAdBibliotecario;
      
    private javax.swing.JButton btnSalir;
  
      private javax.swing.JPanel panelFormulario;
      

}
