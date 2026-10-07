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
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.dao.UsuarioDao;
import modelo.dao.UsuarioRolDao;
import modelo.entidades.Rol;

import modelo.entidades.Usuario;
import modelo.procesos.ProcesosFormRegistrarUsuario;
import modelo.procesos.ProcesosFormUsuario;
import vista.FormRegistrarUsuario;

/**
 *
 * @author BrayanLuis
 */
public class FormLoginUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FormLoginUsuario
     */
    public FormLoginUsuario() {
        //initComponents();
        setTitle("Login Usuarios");
        setSize(700,500);
        setPreferredSize(new Dimension(700,500));

        setMinimumSize(new Dimension(700, 500));
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
                  0,0,new Color(47,74,58),
                  getWidth(),getHeight(),new Color(
                  74,52,39));
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
        
            lblTitulo = new JLabel("Login Usuario de Biblioteca");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(texto);
        
                Color fondoColor = new Color(47,74,58);
             Color fondoLetraColor= new Color(255,242,255);
      
      
        lblUsuario = new JLabel("Usuario:");
                txtNomUsuario = new JTextField(30);
        //lblUsuario.setForeground(Color.WHITE);

        lblUsuario.setForeground(fondoLetraColor);
        
        
        lblClave = new JLabel("Contraseña:");
       // lblClave.setForeground(Color.WHITE);
       lblClave.setForeground(fondoLetraColor);
   txtContrasena = new JPasswordField(30);

     
    
/*
        // ===== PANEL BOTONES =====
        JPanel panelBotones = new JPanel();
*/
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setPreferredSize(new Dimension(300,80));
        
        /*
        btnRegistrar = new JButton("Registrar");
          btnRegistrar.setPreferredSize(new Dimension(300,80));
          */
          
            // FILA 1
        gbc.gridx = 0;
        gbc.gridy = 0;
    //  panelFormulario.add(Box.createVerticalStrut(20));
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
        panelFormulario.add(btnIngresar, gbc);
        //su columna
        
        /*
        gbc.gridx = 0;
            gbc.gridy = 6;
        panelFormulario.add(btnRegistrar, gbc);

       */
            
      
       

        add(panelFormulario,BorderLayout.CENTER);
        
          
        btnSalir = new JButton("Salir");

btnIngresar.addActionListener(e -> {
    // 1. Capturar la contraseña de forma segura como char[]
    char[] passwordChars = txtContrasena.getPassword();
    
    // 2. Convertir el char[] a String para pasarlo al método
    String passwordString = new String(passwordChars);
    // 4. (Opcional) Borrar el arreglo de la memoria por seguridad
    java.util.Arrays.fill(passwordChars, '0'); 
    UsuarioDao usrDao= new UsuarioDao();
    //EJECUTAR EL LOGIN, DEVUEVLE UN USAURIO Y LO GAURDO EN REFERNECIA USER DE TIPO USAURIO
    
  Usuario user = usrDao.login(txtNomUsuario.getText(), //No es “muchos objetos”, sino una sola instancia de Usuario (un objeto en memoria) que el DAO te devuelve.
         //Ambos son referencias a objetos, solo cambia quién lo crea. //Siempre navegas usando referencai que apuntan a objetos
          passwordString);   
  if(user != null){ //es difenret de vaico la dm, osea si hay un user
      JOptionPane.showMessageDialog(null,"Bienvenido "+
              user.getUsername());
     // FormDialogPrestamo vistaPrestamo = new FormDialogPrestamo(user);
     //System.out.println(user.getRoles());
     String rol = obtenerRol(user);
//System.out.println("Rol = [" + obtenerRol(user) + "]");
        if(rol.equals("Administrador")){
                System.out.println("ENTRO el " + "Rol de = [" + obtenerRol(user) + "]");
        FormDialogAdBibliotecario vistaGestUsers= new FormDialogAdBibliotecario(
                this, rootPaneCheckingEnabled,user);
        vistaGestUsers.setVisible(true);
        }
        else {
              System.out.println("ENTRO A PRINCIPAL");
        Principal vistaPrincipal= new Principal(user);
          vistaPrincipal.setVisible(true);

        }
  //Principal vistaprincipal= new Principal(user);

  //cerrar este formLoginUsuario,prevaimten se fue al principal
  this.dispose();
   }
  else { 
 mensajeError("Usuario o contraseña incorrectas" );
   
  }
  
});


    }
      public static String obtenerRol(Usuario usuarioLog){
     for(Rol r : usuarioLog.getRoles()){
    
         return r.getNombreRol();
        
     }
     return "---";
    }
    //metodos del este formulario
    void mensajeError(String s) {
		
    JOptionPane.showMessageDialog(
        this,
        s,
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
	}
    /*
btnRegistrar.addActionListener(e->{
    FormRegistrarUsuario registUsu= new FormRegistrarUsuario();
    //LLAMADOS A  LOGICA inicializando programa


      
   
         
registUsu.setLocationRelativeTo(this);
        registUsu.setVisible(true);

      this.dispose();
    });
*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
                new FormLoginUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
     // Variables declaration - do not modify                     
    // End of variables declaration                   
  private javax.swing.JPanel panelTitulo;
  

  private javax.swing.JLabel lblTitulo;
  private javax.swing.JLabel lblUsuario;
  private javax.swing. JLabel lblClave;

    public javax.swing.JTextField txtNomUsuario;
    public javax.swing.JPasswordField txtContrasena;

    private javax.swing.JButton btnIngresar;
    //  private javax.swing.JButton btnRegistrar;
      
    private javax.swing.JButton btnSalir;
  
      private javax.swing.JPanel panelFormulario;
      

}
