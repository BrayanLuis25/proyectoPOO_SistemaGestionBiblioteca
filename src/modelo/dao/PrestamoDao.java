/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.clasesAbstractas.Persona;
import modelo.conexion.MySQLCnn;
import modelo.entidades.Alumno;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;
import modelo.interfaces.PrestamoInterface;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author BrayanLuis
 */
   /*
    
     private String idPrestamo;

    // Relaciones
    private Alumno alumno;
    private Libro libro;

    // Datos del préstamo
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    private String estado;

    private int cantidadLibros;
    */
public class PrestamoDao extends MySQLCnn implements PrestamoInterface{
    
 
    public PrestamoDao(){}
    
    @Override
    public void mostrarEnTabla(JTable tablapres){
    
    String titulo[]={"Num","Codigo","IdPersona",
        "IdLibro","Nombre de Persona", "Nombre de Libro",
    "Fecha de Prestamo", "Fecha de Devolucion", "Estado","Cantidad"};
    
     DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tablapres.setModel(modelo);
          int cantReg=0;
        try{
            //4. Ejuctamos la consulta
            rs = st.executeQuery(
             "SELECT pr.idPrestamo, " +
              "pr.idPersona, " +
               "pr.idLibro, " +
                            
                   "p.nombres, " +
                    "l.titulo, " +   
                  
                    "pr.fechaPrestamo, " +
                    "pr.fechaDevolucion, " +
                    "pr.estado, " +
                    "pr.cantidadLibros " +
                            
                    "FROM prestamo pr " +
                
                    "INNER JOIN persona p ON pr.idPersona = p.idPersona " +
                    "INNER JOIN libro l ON pr.idLibro = l.idLibro"    
             );
    
            //5. Recorremos el resultado
            while(rs.next()){
            cantReg++;
            //creamos al objeto prestamo.... AsistenteGerencia
            Prestamo prest = new Prestamo();
            prest.setIdPrestamo(rs.getInt(1));    
            //Alumno alum = new Alumno();
            Persona per= new Persona() {
            };
           per.setIdPersona(rs.getInt(2));
            
           per.setNombres(rs.getString(4));
           
            Libro lib = new Libro();
            lib.setIdLibro(rs.getInt(3));
            lib.setTituloLibro(rs.getString(5));
            
            prest.setPer(per);
            prest.setLibro(lib);
            
            prest.setFechaPrestamo(rs.getTimestamp(6).toLocalDateTime());
            
            prest.setFechaDevolucion(rs.getTimestamp(7).toLocalDateTime());
           
            prest.setEstado(rs.getString(8));
            
            prest.setCantidadLibros(rs.getInt(9));
 
            modelo.addRow(prest.Registro(cantReg));
            }
          //  con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "ERROR: no se pueden mostrar los registros");
             JOptionPane.showMessageDialog(null,ex.toString()); 
            
        }
    
    }
    @Override
   public  int obtenerCantidadLibros(int idPrestamo){
       return 0;
    }
   @Override
    public void registraPrestamo(Prestamo presta){
        
        //enviar objetopost
        try{

            ps = con.prepareStatement(

            "INSERT INTO prestamo"
          + "(idPersona,idLibro,"
          + "fechaPrestamo,fechaDevolucion,estado,cantidadLibros)"
          + "VALUES(?,?,?,?,?,?)"
 );
 //  ps.setInt(1, presta.getIdPrestamo());
                
            ps.setInt(1, presta.getPer().getIdPersona());
            
            ps.setInt(2, presta.getLibro().getIdLibro());
            
            ps.setTimestamp(3,java.sql.Timestamp.
                    valueOf(presta.getFechaPrestamo()));
           
            ps.setTimestamp(4,java.sql.Timestamp.
                    valueOf(presta.getFechaDevolucion()));
            ps.setString(5, presta.getEstado());
           ps.setInt(6, presta.getCantidadLibros());
           
            System.out.println(presta.getFechaPrestamo());
            System.out.println(presta.getFechaDevolucion());

           
            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Prestamo registrado con éxito");

        }catch(Exception ex){

            JOptionPane.showMessageDialog(
                    null,
                    ex.toString());
        }
    }
    @Override
    public void actualizarPrestamo(Prestamo p) {
 try{

        ps = con.prepareStatement(
            "UPDATE prestamo SET "
          + "idPersona=?, "
          + "idLibro=?, "
          + "estado=?, "
          + "cantidadLibros=? "
          + "WHERE idPrestamo=?"
        );

        ps.setInt(1,
            p.getPer().getIdPersona());

        ps.setInt(2,
            p.getLibro().getIdLibro());

        ps.setString(3,
            p.getEstado());

        ps.setInt(4,
            p.getCantidadLibros());

        ps.setInt(5,
            p.getIdPrestamo());

        ps.executeUpdate();

    }catch(Exception ex){
        JOptionPane.showMessageDialog(
            null,
            ex.toString()
        );
    }
    }

    
    
    
    
    @Override
    public void eliminarPrestamo(int idPrestamo) {
       try{

        ps = con.prepareStatement(
            "DELETE FROM prestamo "
          + "WHERE idPrestamo=?"
        );

        ps.setInt(1, idPrestamo);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(
            null,
            "Préstamo eliminado"
        );

    }catch(Exception ex){

        JOptionPane.showMessageDialog(
            null,
            ex.toString()
        );
    }
    }

    @Override
    public void descontarLibroPrest(Prestamo prestalib) {
    try{
    
    
        ps = con.prepareStatement(
            "UPDATE libro SET stock = stock - ? WHERE idLibro = ?"
        );

        ps.setInt(1, prestalib.getCantidadLibros());
        ps.setInt(2, prestalib.getLibro().getIdLibro());

        ps.executeUpdate();
          }catch(Exception ex){

        JOptionPane.showMessageDialog(
            null,
            ex.toString()
        );
    }
        //========================DEVOLUCIONESSSSSSSSSSSSSS============================
    }
      @Override
    public void aumentarStock(Prestamo descontarStock) {
        
         try{
        ps = con.prepareStatement(
            "UPDATE libro SET stock = stock + ? WHERE idLibro = ?"
        );

        ps.setInt(1, descontarStock.getCantidadLibros());
        ps.setInt(2, descontarStock.getLibro().getIdLibro());

        ps.executeUpdate();

    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.toString());
    }
        
    }
    

    @Override
    public void actualizarEstadoDevuelto(Prestamo p) {
        
            try{
        ps = con.prepareStatement(
            "UPDATE prestamo SET estado='Devuelto', fechaDevolucion=CURDATE() WHERE idPrestamo=?"
        );

        ps.setInt(1, p.getIdPrestamo());
        ps.executeUpdate();

    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex.toString());
    }
        

    }
//====================tabladevolucionesssssssssssssssssss
  //consultabd y llena jtable,armado seleccionao los ids de otrora metodos
    @Override
    public void mostrarEnTablaPrestados(JTable tabla, int buscar) {

    String titulo[] = {
        "Num", "IdPrestamo", "IdPersona", "IdLibro",
        "Nombre Persona", "Nombre Libro",
        "Fecha Prestamo", "Fecha Devolucion",
        "Estado", "Cantidad"
    };

    DefaultTableModel modelo = new DefaultTableModel(null, titulo);
    //modelo.setRowCount(0);
    
    tabla.setModel(modelo);

    int cantReg = 0;
    //estadointe
    boolean encontrado = false;
    try {

          ps = con.prepareStatement(
            "SELECT pr.idPrestamo, " +
            "pr.idPersona, " +
            "pr.idLibro, " +
            "p.nombres, " +
            "l.titulo, " +
            "pr.fechaPrestamo, " +
            "pr.fechaDevolucion, " +
            "pr.estado, " +
            "pr.cantidadLibros " +
            "FROM prestamo pr " +
            "INNER JOIN persona p ON pr.idPersona = p.idPersona " +
            "INNER JOIN libro l ON pr.idLibro = l.idLibro " +
            "WHERE pr.idPrestamo= ? "+
            "AND pr.estado = 'Prestado'"

          );

          ps.setInt(1, buscar);
          rs = ps.executeQuery(); // SIN ESTO rs queda null
        while (rs.next()) {
            
             encontrado = true;
             
            cantReg++;

            Prestamo prest = new Prestamo();
            prest.setIdPrestamo(rs.getInt(1));

            Persona per = new Persona() {};
            per.setIdPersona(rs.getInt(2));
            per.setNombres(rs.getString(4));

            Libro lib = new Libro();
            lib.setIdLibro(rs.getInt(3));
            lib.setTituloLibro(rs.getString(5));

            prest.setPer(per);
            prest.setLibro(lib);

            prest.setFechaPrestamo(
                rs.getTimestamp(6) != null ? rs.getTimestamp(6).toLocalDateTime() : null
            );

            prest.setFechaDevolucion(
                rs.getTimestamp(7) != null ? rs.getTimestamp(7).toLocalDateTime() : null
            );

            prest.setEstado(rs.getString(8));
            prest.setCantidadLibros(rs.getInt(9));

            
            
            modelo.addRow(prest.Registro(cantReg));
        }
       

     
              if (buscar >0 && !encontrado) {
                        JOptionPane.showMessageDialog(null,
                            "El préstamo no existe o ya fue devuelto.");
                    }
        

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(null,
            "ERROR: no se pueden mostrar los préstamos activos");

        JOptionPane.showMessageDialog(null, ex.toString());
    }
}
  
    //==================================REPORTESS==========================
    @Override
    public void reportePrestamos(String estadoSeleccionado) {

    try {

        JasperReport reporte =
                JasperCompileManager.compileReport(
                        "src/reportes/rptPrestamos.jrxml");

        Map<String, Object> params =  new HashMap<>();
        params.put("estado", estadoSeleccionado);
        
         st = con.createStatement();
 rs = st.executeQuery(
    "SELECT COUNT(*) FROM prestamo");

if (rs.next()) {
    System.out.println("Cantidad de préstamos: " + rs.getInt(1));
}
        JasperPrint imprimir =
                JasperFillManager.fillReport(
                        reporte,
                        params,
                        con);

        JasperViewer.viewReport(imprimir, false);

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(null,
                ex.toString());

    }

}
    
    
 }


/*

   //statemaent = permite traer informacion de la BD
    //MOTRAR, BUSCAR
    //preparaeStamente: objeto que 
    // MODIFICAR LA BD:elete,update; es decir el Crud completo:consula,lee,actualiza,elimina
    
    /*
    
    
    RS:Un ResultSet (o conjunto de resultados) es el objeto en Java (que forma parte de JDBC) que almacena y 
    organiza los datos obtenidos tras ejecutar una consulta a una base de datos.
    ...al ahcer sleect*form tb_productos
    todo los resutlados de  los registros de la tabla productos
    se mostrar en la app java usando result set ,los datos de cad aregistro
    
    
    
    
    */
    /*
    Una consulta o query es una solicitud de información o datos que se realiza a una base de datos o motor de búsqueda.
    Generalmente, se formula con palabras
    clave o parámetros específicos para obtener resultados relevantes.
    */
    



