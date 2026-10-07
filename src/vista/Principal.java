/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import modelo.dao.DocenteDao;
import modelo.dao.UsuarioDao;
import modelo.dao.UsuarioRolDao;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;

/**
 *
 * @author BrayanLuis
 */
public class Principal extends javax.swing.JFrame {
private Usuario usuarioLog;

    /**
     * Creates new form Principal
     */
    public Principal( Usuario user){
        
        this.usuarioLog = user;

        System.out.println("Gestione el sitio : "+ usuarioLog.getUsername());
       
        //================= JFRAME
        setTitle("Sistema Biblioteca");
        
        setSize(1100, 800);
        setPreferredSize(new Dimension(1100, 800));
        setMinimumSize(new Dimension(1100, 800));
        setLocationRelativeTo(null);
        // LayoutPrincipal-ContenedorPrinciapl
        setLayout(new BorderLayout());
        
       //======================= TITULO =========================================
       tituloSGB = new JLabel("Bienvenido al Sistema G.B");
       Color tituloSGBcolor = new Color(102,125,197);//azul acero
        tituloSGB.setForeground(tituloSGBcolor);
        // este titulo es de AWT tituloSGB.setAlignment(Label.CENTER);

      // PERO CON TITULO EN SWING es:
      //tituloSGB.setAlignmentX(JLabel.CENTER);
      
            
      tituloSGB.setAlignmentX(Component.CENTER_ALIGNMENT);
        //===================Tamaño==================
        tituloSGB.setFont(new Font("Segoe UI", Font.BOLD, 25));
        //tituloSGB.setMaximumSize(new Dimension(200,50));
         tituloSGB.setPreferredSize(new Dimension(200,50));
         
/*================titulo ROLL=================================*/
     rolTituloSGB= new JLabel("Saludos "+usuarioLog.getUsername());

        rolTituloSGB.setForeground(tituloSGBcolor);
        // este titulo es de AWT tituloSGB.setAlignment(Label.CENTER);

            
     rolTituloSGB.setAlignmentX(Component.CENTER_ALIGNMENT);
        //===================Tamaño==================
        rolTituloSGB.setFont(new Font("Segoe UI", Font.BOLD, 20));
        //tituloSGB.setMaximumSize(new Dimension(200,50));
         rolTituloSGB.setPreferredSize(new Dimension(200,50));
  
               
        //Colores
        //Color fondoColor = new Color(245, 246, 250);
        //Color botonColor = new Color(78, 115, 223);
       // Color sidebarColor = new Color(30, 30, 47);
 
        //2.sidebar: este panel es el comopnente visual q divide la pantalla
              sidebar = new JPanel(){
              
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
           
                sidebar.setOpaque(false);      
                //======BOTON DOCENTE EN SOURCE================================
         //3. BOTON DOCENTE, creando EL BOTON EL CODIGO FUENTE
       Color botonColorAlumn = new Color(232,220,200);//beige antiguo
       Color botonColorDoc = new Color(200,176,138);//pergamino
       Color botonColorLib = new Color(232,220,200);
    
       Color botonColorPrestamo = new Color(200,176,138);//pergamino
         
        btnMantnmAlumno = crearBtn("Mantenimiento Alumno",botonColorAlumn,
                "src/img/graduado.png");
    
      
        
        btnMantnmDocente = crearBtn("Mantenimiento Docentes", botonColorDoc,
                   "src/img/instructor.png" );
      
                
        btnMantnmLibro = crearBtn("Mantenimiento Libros", botonColorLib,
              "src/img/libro.png"  
         );
         

        btnMantnmPrestamos = crearBtn("Mantenimiento Prestamos", botonColorPrestamo,
                            "src/img/prestamoLibro.png");
 
        
        btnCerrarSesion = crearBtn("Cerrar Sesion", botonColorAlumn,
                "src/img/cerrar-sesion.png");
        
        btnregresarDABbiblio = crearBtn("Regresar a Panel Biblioteca", botonColorDoc,
                "src/img/usuario.png");
        
        btnMantnmDevoluciones = crearBtn("Mantenimiento Devoluciones", botonColorLib,
              "src/img/libro.png"  
         );
        
          btnMantnmReportes = crearBtn("Reportes Prestamo", botonColorLib,
              "src/img/inmigracion.png"  
         );
              
        //sidebar.setBackground(sidebarColor);
        //ancho fijo sidebar, mas importa el ancho asi pongo 280,0
        sidebar.setPreferredSize(new Dimension(350,700));
        //LAYOUT SIDEBAR VERITCAL
        sidebar.setLayout(new BoxLayout(sidebar,BoxLayout.Y_AXIS));
        //agrendo el titulo
        
        //separacion inicial
        sidebar.add(Box.createVerticalStrut(10));
        
        sidebar.add(tituloSGB);
            sidebar.add(Box.createVerticalStrut(35));
        //ROL TITULO
           sidebar.add(rolTituloSGB);
           sidebar.add(Box.createVerticalStrut(35));
           
          //3.AGRENDAO BOTONES COMPONETES A SIDEBAR
         sidebar.add(btnMantnmAlumno);
         sidebar.add(Box.createVerticalStrut(35));
         
     
          //3.AGRENDAO COMPONETES A SIDEBAR
         sidebar.add(btnMantnmDocente);
         sidebar.add(Box.createVerticalStrut(35));
         
             //agrenado compoente boton a sidebar
         sidebar.add(btnMantnmLibro);
         sidebar.add(Box.createVerticalStrut(35));
         //agrenado compoente boton a sidebar
         sidebar.add(btnMantnmPrestamos);
         sidebar.add(Box.createVerticalStrut(35));
         //agregnaod componente boton devoluciones a sidebar
         
         sidebar.add(btnMantnmDevoluciones);
         sidebar.add(Box.createVerticalStrut(35));
         
         //agregando CERRAR SESION
         sidebar.add(btnCerrarSesion);
         sidebar.add(Box.createVerticalStrut(35));
         
            //agregando regresar a PANEL BIBLIOTECA
         sidebar.add(btnregresarDABbiblio);
         sidebar.add(Box.createVerticalStrut(35));
         
         //agregando REPORTES
          sidebar.add(btnMantnmReportes);
         sidebar.add(Box.createVerticalStrut(35));
         
         
       // sidebar.setBorder(BorderFactory.createEmptyBorder(20,15,20,15);
        
                
        //==========BOTONESSS PROGRAMADOS EN DESIGN, REPRESENTACION EN SOURCE=======================
        /*
       //BOTONE ALUMNO, solo espcificando dimensiones 
       btnMantnmAlumno.setMaximumSize(new Dimension(220,60));
              btnMantnmAlumno.setPreferredSize(new Dimension(220,60));
        //BOTON LIBRO
        Color botonColorLib = new Color(2,192,142);
        btnMantnmLibro = crearBoton("Mantenimiento Libros", botonColorLib);
     
         */
        //MOUSE EVENTO LISTENER BOTON ALUMNO
           btnMantnmAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt){
               btnMantnmAlumno.setForeground(new Color(140,106,74));//BRONCEOSUCRO
               //bronce oscuro actual
               }//0,86,179 COLOR AZUL ELECTRICO
               
               public void mouseExited(java.awt.event.MouseEvent evt){
               btnMantnmAlumno.setForeground(new Color(200,176,138));
              //beige antiguo
               }//0,123,255 COLOR AZUL CIELO CLARO
               
             }
             );
         /*
           btnProcsa.addActionLsitener(this) this= objeto del Jframe
           el jframe recibe el evento , es decir el formularo recibe un evento por
           elc omopnete button
           en contraste con
           MouseListener
          el que recibe un enveot es el mouse adapterm no el jframe direcatemnet
           , usa otro objeto lsiitern por separado
           ambos usan el sistema de evento de Swing
           */
        //MOUSE EVENTO LISTENER BOTON; DOCENTE
             btnMantnmDocente.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt){
               btnMantnmDocente.setForeground(new Color(122,92,61));//MARRON CUERO
               //bronce oscuro actual
               }//0,86,179 COLOR AZUL ELECTRICO
               
               public void mouseExited(java.awt.event.MouseEvent evt){
               btnMantnmDocente.setForeground(new Color(200,176,138));
              //beige antiguo
               }//0,123,255 COLOR AZUL CIELO CLARO
               
             }
             );
        //MOUSE EVENOT LSITENER BOTON; LIBROS
          btnMantnmLibro.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt){
               btnMantnmLibro.setForeground(new Color(140,106,74));//BRONCEOSUCRO
               //bronce oscuro actual
               }//0,86,179 COLOR AZUL ELECTRICO
               
               public void mouseExited(java.awt.event.MouseEvent evt){
               btnMantnmLibro.setForeground(new Color(200,176,138));
              //beige antiguo
               }//0,123,255 COLOR AZUL CIELO CLARO
               
             }
             );
        
        
        
      
     
         //MOUSE EVENTO LISTENER BOTON;PRESTANOS
           btnMantnmPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt){
               btnMantnmPrestamos.setForeground(new Color(122,92,61));
               //bronce oscuro actual
               }//0,86,179 COLOR AZUL ELECTRICO
               
               public void mouseExited(java.awt.event.MouseEvent evt){
               btnMantnmPrestamos.setForeground(new Color(200,176,138));
              //beige antiguo
               }//0,123,255 COLOR AZUL CIELO CLARO
              }   
               /*
       Color botonColorAlumn = new Color(122,92,61);//MARRON CUERO
       Color botonColorDoc = new Color(140,106,74);//BRONCE OSCURO
               */
       
            );
           
           
           
           
      
              btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt){
               btnCerrarSesion.setForeground(new Color(140,106,74));//BRONCEOSUCRO
               //bronce oscuro actual
               }//0,86,179 COLOR AZUL ELECTRICO
               
               public void mouseExited(java.awt.event.MouseEvent evt){
               btnCerrarSesion.setForeground(new Color(200,176,138));
              //beige antiguo
               }//0,123,255 COLOR AZUL CIELO CLARO
               
             }
             );
              
                 btnregresarDABbiblio.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt){
               btnregresarDABbiblio.setForeground(new Color(122,92,61));//MARRON CUERO
               //bronce oscuro actual
               }//0,86,179 COLOR AZUL ELECTRICO
               
               public void mouseExited(java.awt.event.MouseEvent evt){
               btnregresarDABbiblio.setForeground(new Color(200,176,138));
              //beige antiguo
               }//0,123,255 COLOR AZUL CIELO CLARO
               
             }
             );
       
         
             
         
         //4.AGREGANDO PANEL CONTENIDO- otro lado del jframe que se diivdio en 2
             Color fondoColor = new Color(47,74,58);
             Color fondoLetraColor= new Color(200,176,138);
         contenido = new JPanel();
   
   
         contenido.setLayout(new BorderLayout());
         JLabel bienvenida = new JLabel("Bienvenido gestione el sistema");
         
         
         String rutaIcon= "src/img/bibliotecafondo.jpg";
             
         //cargar archivos
        ImageIcon icon = new ImageIcon(rutaIcon);
           Image imga = icon.getImage().getScaledInstance(
       1100, 1100, Image.SCALE_SMOOTH
    );
           ImageIcon iconoRedimensionado = new ImageIcon(imga);
           JLabel etiquetaImagen = new JLabel(iconoRedimensionado);
            
         
         contenido.add(etiquetaImagen, BorderLayout.CENTER);
     
         
         bienvenida.setFont(new Font("Segoe UI", Font.BOLD, 30));
         bienvenida.setForeground(fondoLetraColor);
         bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
       contenido.add(bienvenida, BorderLayout.NORTH);
      
            
         /*
         
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
    /*
         */
         
         
         
         //add(sidebar);
         //5. AGREGAR AL JFRAME
         //.WEST no significa que el JFrame esté en WEST; significa que
         //el panel sidebar está colocado en la zona WEST del JFrame.
         add(sidebar, BorderLayout.WEST);
         add(contenido,BorderLayout.CENTER);
    
         //=================OCULTAR BOTON SWING:================================
         //el rol actual es igual al que busco ==
          if(tieneRol("Docente")){
              
              btnMantnmAlumno.setVisible(false);
              btnMantnmLibro.setVisible(false);
              btnregresarDABbiblio.setVisible(false);
          }
            if(tieneRol("Alumno")){
              
           
              btnMantnmDocente.setVisible(false);
                 btnMantnmLibro.setVisible(false);
                   btnregresarDABbiblio.setVisible(false);
          }
               if(tieneRol("Bibliotecario")){
               btnregresarDABbiblio.setVisible(false);
          }
            
         
         //============SEGUNDA PARTE LLAMADAS
         
         //el objeto usuario tiene ROLESS=======================
         //DOCENTE NO ESTA,ETNONCES DOCENTE NO PERMITE LLAMAR
         btnMantnmAlumno.addActionListener(e->{
             
             
               if(tieneRol("Administrador")|| tieneRol("Bibliotecario")
                       || tieneRol("Alumno")){

               //btnMantnmAlumno.setEnabled(true);

   

             FormDialogAlumno ventana = new FormDialogAlumno(this, rootPaneCheckingEnabled);
         ventana.setVisible(true);
         
         
               }
               else {
                   JOptionPane.showMessageDialog(null, "No tiene permisos para acceder");
               }
         });
         
         
                  //============SEGUNDA PARTE LLAMADAS
         btnMantnmDocente.addActionListener(e->{
             
              if(tieneRol("Administrador")|| tieneRol("Bibliotecario")
                       || tieneRol("Docente")){
             FormDialogDocente ventanaDoc = new FormDialogDocente(this,rootPaneCheckingEnabled);
         ventanaDoc.setVisible(true);
         
         

// IMPORTANTE: recargar datos
                  DocenteDao dao = new DocenteDao();
        dao.mostrarEnTabla(ventanaDoc.tblTablaMost);
              }
              
              
         });
         
         /*
         // 'this' es el JFrame (padre) y 'true' define que es una ventana modal
         */
         btnMantnmLibro.addActionListener(e->{
             
                 if(tieneRol("Administrador")|| tieneRol("Bibliotecario")
                     ){
                     
                FormDialogLibro ventanaLib = new FormDialogLibro(this, true);
         ventanaLib.setVisible(true);
                 }
                 
                  else {
                   JOptionPane.showMessageDialog(null, "No tiene permisos para acceder");
               }
      });
         
         // ULTIMO BUTTON PRESTAMOS LLAMAOD
           btnMantnmPrestamos.addActionListener(e->{
             
                if(tieneRol("Administrador")|| tieneRol("Bibliotecario")
                       || tieneRol("Docente")|| tieneRol("Alumno")) {
                FormDialogPrestamo ventanaPrest = new FormDialogPrestamo(this, true,usuarioLog);
         ventanaPrest.setVisible(true);
         
                }
      });
           
           btnMantnmDevoluciones.addActionListener(e->{
               
          if(tieneRol("Administrador")|| tieneRol("Bibliotecario")
         || tieneRol("Docente")|| tieneRol("Alumno")) {
           FormDialogDevolucion ventanadevolu = new FormDialogDevolucion(this, true, usuarioLog);
          
           ventanadevolu.setVisible(true);
                            }
           });
           
           btnCerrarSesion.addActionListener(e-> {
           usuarioLog = null;
           this.dispose();
           FormLoginUsuario frmusuario = new FormLoginUsuario();
           frmusuario.setLocationRelativeTo(null);
           frmusuario.setVisible(true);
               
           });
           
         btnMantnmReportes.addActionListener(e->{
         if(tieneRol("Administrador")|| tieneRol("Bibliotecario")
         || tieneRol("Docente")|| tieneRol("Alumno")) {
           FormDialogReportes ventanadevolu = new FormDialogReportes(this, true, usuarioLog);
          
           ventanadevolu.setVisible(true);
                            }
         });
         
  btnregresarDABbiblio.addActionListener(e->{
                this.dispose();
               String rol = obtenerRol(usuarioLog);
               
           if(rol.equals("Administrador")){
           FormDialogAdBibliotecario regAdminDBiblio = new FormDialogAdBibliotecario
            (this, rootPaneCheckingEnabled, usuarioLog);
           regAdminDBiblio.setVisible(true);
            System.out.println("El Rol permitido es "+obtenerRol(usuarioLog));
           
           }
           else {
               
           FormLoginUsuario frmlogin = new FormLoginUsuario();
           frmlogin.setVisible(true);
          
           }
           
           });

    }
    
        public static String obtenerRol(Usuario usuarioLog){
     for(Rol r : usuarioLog.getRoles()){
    
         return r.getNombreRol();
        
     }
     return "---";
    }
    //Si el nombre del rol actual es igual al rol que estoy buscando,
    //devuelve verdadero...
    private boolean tieneRol(String nombreRol){

    for(Rol r : usuarioLog.getRoles()){

        if(r.getNombreRol().equalsIgnoreCase(nombreRol)){//ignoraminiy maysu
            return true;
        }
    }

    return false;
}

    
    
//devuevle un button, un objeto asi como una persona ,un doctor
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
    /*
    ¿Por qué es mejor poner true directamente?
Seguridad: Te aseguras al 100% de que el usuario no pueda dar clics en el Frame de fondo mientras llena los datos del docente.
Legibilidad: Cualquiera que lea tu código sabrá al instante que esa ventana bloquea la pantalla principal, sin tener que descifrar qué hace la variable rootPaneCheckingEnabled.
    */
    //======METODO CREARE BOTON
/*
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

*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 153));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));


        sidebar.setBackground(new java.awt.Color(30, 30, 47));
        sidebar.setPreferredSize(new java.awt.Dimension(280, 700));
        sidebar.setLayout(new javax.swing.BoxLayout(sidebar, javax.swing.BoxLayout.Y_AXIS));

        //jButton1.setText("jButton1");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jButton1)
                .addContainerGap(532, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton1)
                .addContainerGap(611, Short.MAX_VALUE))
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
                Usuario user = null;
                new Principal(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton btnMantnmDocente;
       private javax.swing.JButton btnMantnmAlumno;
     private javax.swing.JButton btnMantnmLibro;
        private javax.swing.JButton btnMantnmPrestamos;
            private javax.swing.JButton btnMantnmDevoluciones;
        
            
                   private javax.swing.JButton btnMantnmReportes;
              private javax.swing.JButton btnCerrarSesion;
       private javax.swing.JButton  btnregresarDABbiblio;
    //jpanel 1
      private javax.swing.JLabel tituloSGB;
          private javax.swing.JLabel rolTituloSGB;
      private javax.swing.JPanel sidebar;
        
        
    //jpanel 2, parte 2 del jframe donde rendereiza
    private javax.swing.JPanel contenido;
     private java.awt.Label bienvenida;
     
}
