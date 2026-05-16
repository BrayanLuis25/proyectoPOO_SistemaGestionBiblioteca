/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author BrayanLuis
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
 
/*

  
        
        //================= JFRAME
        setTitle("Sistema Libroteca");
        setSize(900, 600);
        setPreferredSize(new Dimension(900, 600));
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        // LayoutPrincipal-ContenedorPrinciapl
        setLayout(new BorderLayout());
        
              // ========= TITULO ===========
        JLabel tituloSGB = new JLabel("Bienvenido al Sistema G.B");
        tituloSGB.setForeground(Color.WHITE);
            
        //===================Tamaño==================
        tituloSGB.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tituloSGB.setMaximumSize(new Dimension(350,70));
         tituloSGB.setPreferredSize(new Dimension(350,70));
        
        //Colores
        Color fondoColor = new Color(245, 246, 250);
        Color botonColor = new Color(78, 115, 223);
        Color sidebarColor = new Color(30, 30, 47);
 
        //2.sidebar: este panel es el comopnente visual q divide la pantalla
              sidebar = new JPanel();
        sidebar.setBackground(sidebarColor);
        //ancho fijo sidebar, mas importa el ancho asi pongo 280,0
        sidebar.setPreferredSize(new Dimension(280,700));
        //LAYOUT SIDEBAR VERITCAL
        sidebar.setLayout(new BoxLayout(sidebar,BoxLayout.Y_AXIS));
        //
        sideBar.setBorder(BorderFactory.createEmptyBorder(20,15,20,15)
        */
        //==========BOTONESSS PROGRAMADOS EN DESIGN, REPRESENTACION EN SOURCE=======================
        /*
       //BOTONE ALUMNO, solo espcificando dimensiones 
       btnMantnmAlumno.setMaximumSize(new Dimension(220,60));
              btnMantnmAlumno.setPreferredSize(new Dimension(220,60));
        //BOTON LIBRO
        Color botonColorLib = new Color(2,192,142);
        btnMantnmLibro = crearBoton("Mantenimiento Libros", botonColorLib);
     
         */
        //======BOTON DOCENTE EN SOURCE================================
         //3. BOTON DOCENTE, creando EL BOTON EL CODIGO FUENTE
           Color botonColorDoc = new Color(25,227,225);
           btnMantnmDocente = crearBoton("Mantenimineto Docentes", botonColorDoc);
          
           //AGRENGADO boton PRESTAMOS
           Color botonColorPrest = new Color(255,72,142);
           btnMantnmPrestamos = crearBoton("Prestamos", botonColorPrest);
           
         //3.AGRENDAO COMPONETES A SIDEBAR
         sidebar.add(btnMantnmDocente);
         sidebar.add(Box.createVerticalStrut(15));
         
         //agrenado compoente boton a sidebar
         sidebar.add(btnMantnmPrestamos);
         sidebar.add(Box.createVerticalStrut(25));
         
         
         
         //4.AGREGANDO PANEL CONTENIDO- otro lado del jframe que se diivdio en 2
                 Color fondoColor = new Color(245, 246, 250);
         contenido = new JPanel();
         contenido.setBackground(fondoColor);
         contenido.setLayout(new BorderLayout());
         JLabel bienvenida = new JLabel("Bienvenido gestione el sistema");
         bienvenida.setFont(new Font("Segoe UI", Font.BOLD, 30));
         bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
         contenido.add(bienvenida, BorderLayout.CENTER);
         
         
         //5. AGREGAR AL JFRAME
         add(sidebar, BorderLayout.WEST);
         add(contenido,BorderLayout.CENTER);
    
         
         //============SEGUNDA PARTE LLAMADAS
         btnMantnmAlumno.addActionListener(e->{
             FormDialogAlumno ventana = new FormDialogAlumno(this, rootPaneCheckingEnabled);
         ventana.setVisible(true);
         });
    }
    //======METODO CREARE BOTON
    private JButton crearBoton(String texto, Color color){
        JButton btn = new JButton(texto);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(220,60));
        btn.setPreferredSize(new Dimension(220,60));
       
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

        sidebar = new javax.swing.JPanel();
        tituloSGB = new java.awt.Label();
        jPanel2 = new javax.swing.JPanel();
        btnMantnmAlumno = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnMantnmLibro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));

        sidebar.setBackground(new java.awt.Color(30, 30, 47));
        sidebar.setMaximumSize(null);
        sidebar.setMinimumSize(null);
        sidebar.setPreferredSize(new java.awt.Dimension(280, 700));
        sidebar.setLayout(new javax.swing.BoxLayout(sidebar, javax.swing.BoxLayout.Y_AXIS));

        tituloSGB.setAlignment(java.awt.Label.CENTER);
        tituloSGB.setBackground(new java.awt.Color(18, 33, 101));
        tituloSGB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloSGB.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloSGB.setForeground(new java.awt.Color(255, 249, 243));
        tituloSGB.setMaximumSize(new java.awt.Dimension(350, 70));
        tituloSGB.setMinimumSize(new java.awt.Dimension(290, 60));
        tituloSGB.setName(""); // NOI18N
        tituloSGB.setPreferredSize(new java.awt.Dimension(350, 70));
        tituloSGB.setText("Sistema Gestion Bibliotecaria");
        sidebar.add(tituloSGB);

        jPanel2.setMaximumSize(new java.awt.Dimension(0, 20));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        sidebar.add(jPanel2);

        btnMantnmAlumno.setBackground(new java.awt.Color(47, 0, 182));
        btnMantnmAlumno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMantnmAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnMantnmAlumno.setText("Mantenimiento Alumno");
        btnMantnmAlumno.setAlignmentX(0.5F);
        btnMantnmAlumno.setAlignmentY(0.9F);
        btnMantnmAlumno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMantnmAlumno.setIconTextGap(0);
        btnMantnmAlumno.setMargin(new java.awt.Insets(2, 40, 3, 14));
        btnMantnmAlumno.setMaximumSize(new java.awt.Dimension(220, 60));
        btnMantnmAlumno.setPreferredSize(new java.awt.Dimension(220, 60));
        btnMantnmAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantnmAlumnoActionPerformed(evt);
            }
        });
        sidebar.add(btnMantnmAlumno);

        jPanel3.setMaximumSize(new java.awt.Dimension(0, 20));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        sidebar.add(jPanel3);

        btnMantnmLibro.setBackground(new java.awt.Color(2, 192, 142));
        btnMantnmLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMantnmLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnMantnmLibro.setText("Mantenimiento Libros\n");
        btnMantnmLibro.setAlignmentX(0.5F);
        btnMantnmLibro.setAlignmentY(0.9F);
        btnMantnmLibro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMantnmLibro.setMaximumSize(new java.awt.Dimension(220, 60));
        btnMantnmLibro.setPreferredSize(new java.awt.Dimension(220, 60));
        sidebar.add(btnMantnmLibro);

        jPanel1.setMaximumSize(new java.awt.Dimension(0, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 10));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        sidebar.add(jPanel1);

        getContentPane().add(sidebar, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMantnmAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantnmAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMantnmAlumnoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMantnmAlumno;
    private javax.swing.JButton btnMantnmLibro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel sidebar;
    private java.awt.Label tituloSGB;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton btnMantnmDocente;
        private javax.swing.JButton btnMantnmPrestamos;
    
    //jpanel 2, parte 2 del jframe donde rendereiza
    private javax.swing.JPanel contenido;
     private java.awt.Label bienvenida;
     
}
