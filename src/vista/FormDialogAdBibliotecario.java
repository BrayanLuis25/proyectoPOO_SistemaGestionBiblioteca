/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import modelo.entidades.Usuario;

/**
 *
 * @author BrayanLuis
 */
public class FormDialogAdBibliotecario extends javax.swing.JDialog {
private Usuario usuarioLog;
    /**
     * Creates new form FormDialogAdBibliotecario
     */
    public FormDialogAdBibliotecario(java.awt.Frame parent, boolean modal,Usuario user) {
        super(parent, modal);
        //initComponents();
            this.usuarioLog = user;
        System.out.println("Pantalla G.Bibliocario,ahora hay un:"+ usuarioLog.getUsername());
         setTitle("Gestion Rol Biblioteca");
        setSize(900,600);
          
        setPreferredSize(new Dimension(900,600));
        // setMinimumSize(new Dimension(700, 700));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

   
           
           /*CA DA CONTENEDOR TIENE SU PROPIO LAYOUT EL JFRAME:TIENE AL BORDERLAYOUT
           -EL JPANEL TIEEN A SU PRIPIO LAYOUT(GRUDBAGLAYOUT) Y TENDEOTR TIEEN COMPONNEES
    1.GridBagLayout: es el administrador de diseño que permite colocar componentes
      en una cuadrícula flexible (filas y columnas), controlando posición, tamaño y alineación. */
//PERO AQUI NO USO GRIDBAGLAYOUT

 
         
         // //1.CREA EL PANEL
         panelBienvFormulario = new JPanel(){
              
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
         //3.CREANDO COMPONENTES
 //============================ TITULO =============
       tituloSGB = new JLabel("Bienvenido "+ usuarioLog.getUsername());
       Color tituloSGBcolor = new Color(102,125,197);//azul acero
        tituloSGB.setForeground(tituloSGBcolor);

            
      tituloSGB.setAlignmentX(Component.CENTER_ALIGNMENT);
        //===================Tamaño==================
        tituloSGB.setFont(new Font("Segoe UI", Font.BOLD, 25));
        //tituloSGB.setMaximumSize(new Dimension(200,50));
         tituloSGB.setPreferredSize(new Dimension(200,50));
          //4.======BOTON DOCENTE EN SOURCE================================
          //BOTON DOCENTE, creando EL BOTON EL CODIGO FUENTE
       Color botonColorAlumn = new Color(232,220,200);//beige antiguo
       Color botonColorDoc = new Color(200,176,138);//pergamino
       Color botonColorLib = new Color(232,220,200);
    btnRegistrarUsuario= crearBtn("Registrar al Usuario",botonColorAlumn,
                "src/img/ingeniero.png");
    
      
        
        btnIrAlSistema = crearBtn("Ir gestionar el sistema", botonColorDoc,
                   "src/img/usuario.png" );
        
        //CERRANDO SESION:
            btnCerrarSesion = crearBtn("Cerrar Sesion", botonColorAlumn,
                "src/img/cerrar-sesion.png");
              
        
        panelBienvFormulario.setPreferredSize(new Dimension(350,700));
        //LAYOUT SIDEBAR VERITCAL
        panelBienvFormulario.setLayout(new BoxLayout(panelBienvFormulario,BoxLayout.Y_AXIS));
        //agrendo el titulo
        //separacion inicial
        panelBienvFormulario.add(Box.createVerticalStrut(10));
        
        panelBienvFormulario.add(tituloSGB);
         panelBienvFormulario.add(Box.createVerticalStrut(40));
        
          //3.AGRENDAO BOTONES COMPONETES A SIDEBAR
         panelBienvFormulario.add(btnRegistrarUsuario);
         panelBienvFormulario.add(Box.createVerticalStrut(35));
         
     
          //3.AGRENDAO COMPONETES A SIDEBAR
         panelBienvFormulario.add(btnIrAlSistema);
         panelBienvFormulario.add(Box.createVerticalStrut(35));
         
         //3.AGREGANDO CERRAR SESION
         panelBienvFormulario.add(btnCerrarSesion);
         panelBienvFormulario.add(Box.createVerticalStrut(35));
         
         //4.AGREGANDO PANEL CONTENIDO- otro lado del jframe que se diivdio en 2
             Color fondoColor = new Color(47,74,58);
             Color fondoLetraColor= new Color(200,176,138);
         contenido = new JPanel();
         contenido.setBackground(fondoColor);

         contenido.setLayout(new BorderLayout());
         JLabel bienvenida = new JLabel("Bienvenido bibliotecario gestione el sistema");
         bienvenida.setFont(new Font("Segoe UI", Font.BOLD, 30));
         bienvenida.setForeground(fondoLetraColor);
         bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
         contenido.add(bienvenida, BorderLayout.CENTER);
         
         //add(sidebar);
         //5. AGREGAR AL JFRAME
         //.WEST no significa que el JFrame esté en WEST; significa que
         //el panel sidebar está colocado en la zona WEST del JFrame.
         add(panelBienvFormulario, BorderLayout.WEST);
         add(contenido,BorderLayout.CENTER);
         
         btnRegistrarUsuario.addActionListener(e-> {
             FormRegistrarUsuario registUsuario= new FormRegistrarUsuario(usuarioLog);
             registUsuario.setLocationRelativeTo(null);
             registUsuario.setVisible(true);
          this.dispose();
         });
         btnIrAlSistema.addActionListener(e->{ 
             
             
          Principal irprincipalGB= new Principal(user);
         irprincipalGB.setLocationRelativeTo(this);
         irprincipalGB.setVisible(true);
          this.dispose();
         });
         
            btnCerrarSesion.addActionListener(e-> {
           usuarioLog = null;
           this.dispose();
           FormLoginUsuario frmusuario = new FormLoginUsuario();
           frmusuario.setLocationRelativeTo(null);
           frmusuario.setVisible(true);
               
           });
        
}
    
private JButton crearBtn(String text, Color colorbtn, String rutaIcon){
      JButton btn = new JButton(text);
      
      
            ImageIcon icon = new ImageIcon(rutaIcon);

    Image img = icon.getImage().getScaledInstance(
        24, 24, Image.SCALE_SMOOTH
    );

      
        btn.setIcon(new ImageIcon(img));
      
      btn.setBorderPainted(false);
      btn.setForeground(colorbtn);
      btn.setContentAreaFilled(false);
      btn.setFocusPainted(false);
      btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
      btn.setAlignmentX(Component.CENTER_ALIGNMENT);
      // btn.setMaximumSize(new Dimension(220,60));
      btn.setPreferredSize(new Dimension(220, 60));
      // Color botonColorPrest = new Color(0,123,255); //azul link
      // btnMantnmPrestamos = crearBoton("Prestamos", botonColorPrest);
      //  btn.setForeground(new Color(245,246,250));
      btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
      btn.setIconTextGap(5);


        
                return btn;
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
            java.util.logging.Logger.getLogger(FormDialogAdBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDialogAdBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDialogAdBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDialogAdBibliotecario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDialogAdBibliotecario dialog = new FormDialogAdBibliotecario(new javax.swing.JFrame(), true, null);
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
           private javax.swing.JButton btnCerrarSesion;
           
   private javax.swing.JButton jButton1;
    // End of variables declaration                   
    private javax.swing.JButton btnRegistrarUsuario;
       private javax.swing.JButton btnIrAlSistema;
       
  
  
     
        
        
    //jpanel 1
      private javax.swing.JLabel tituloSGB;
    private javax.swing.JPanel panelBienvFormulario;
        
        
    //jpanel 2, parte 2 del jframe donde rendereiza
    private javax.swing.JPanel contenido;
     private java.awt.Label bienvenida;
    

      
}
