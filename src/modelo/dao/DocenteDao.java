/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.conexion.MySQLCnn;
import modelo.entidades.Alumno;
import modelo.entidades.Docente;
import modelo.interfaces.DocenteInterfaz;

/**
 *
 * @author BrayanLuis
 */
public class DocenteDao extends MySQLCnn implements DocenteInterfaz{
    
        public DocenteDao(){}
    //metodo para mostrar los reg. en la tabla
    @Override //SOBREESCRIBIENDO
    public void mostrarEnTabla(JTable tabla){
        String titulo[]={"Num.","Codigo","Nombres",
            "Apellidos","DNI","Telefono","Correo",
            "Especialidad","Facultad","EstadoPrestamo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);
        int cantReg=0;
        try{
            //4. Ejuctamos la consulta
            rs = st.executeQuery("select * "+ "from persona p "+
                    "INNER JOIN docente d "
            + "ON p.idPersona = d.idPersona");
            //5. Recorremos el resultado
            while(rs.next()){
            cantReg++;
        //creamos al objeto AsistenteGerencia y captura el result set conjunto de resulados de la base dea dtos para traerlo
          Docente ag = new Docente();
            ag.setIdPersona(rs.getInt(1));
            ag.setNombres(rs.getString(2));
            ag.setApellidos(rs.getString(3));
            ag.setDni(rs.getString(4));
            ag.setTelefono(rs.getString(5));
            ag.setCorreo(rs.getString(6));
            
            
                 ag.setEspecialidad(rs.getString(8));
                  ag.setFacultad(rs.getString(9));
        
                  
                  int cantidad = obtenerCantidadLibros(
        ag.getIdPersona()
        );
            modelo.addRow(ag.Registro(cantReg,cantidad));
            }
          //  con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "ERROR: no se pueden mostrar los registros");
             JOptionPane.showMessageDialog(null,ex.toString()); 
            
        }
    }
    
    
    @Override
    public int obtenerCantidadLibros(int idPersona){
         ResultSet rs2;
    int cantidad = 0;

    try{

        ps = con.prepareStatement(

        "SELECT COUNT(*) "
      + "FROM Prestamo "
      + "WHERE idPersona = ? "
      + "AND estado='Prestado'"

        );

        ps.setInt(1, idPersona);

        rs2 = ps.executeQuery();

        if(rs2.next()){

            cantidad = rs2.getInt(1);
        }

    }catch(Exception ex){

        JOptionPane.showMessageDialog(
                null,
                ex.toString());
    }

    return cantidad;
}
    
    public boolean existeDniD(String dni){
    try{
        ps = con.prepareStatement(
            "SELECT dni FROM persona WHERE dni = ?"
        );
        ps.setString(1, dni);

        rs = ps.executeQuery();

        return rs.next(); // true si encontró un registro
    }catch(Exception e){
        e.printStackTrace();
    }
    return false;
}
/*==================================*/

//metodo para agregar al asistente
    
    @Override
    public void registrarDocente(Docente ag){
        int idGenerado= 0;
        try{
            //modificar informacion de la BD
            ps = con.prepareStatement(
  "INSERT INTO persona(nombres,apellidos,dni,telefono,correo) VALUES(?,?,?,?,?);"
            ,     st.RETURN_GENERATED_KEYS);
            
           // ps.setInt(1, ag.getIdPersona());
            ps.setString(1, ag.getNombres());
            ps.setString(2,ag.getApellidos());
            ps.setString(3, ag.getDni());
            ps.setString(4, ag.getTelefono());
            ps.setString(5, ag.getCorreo());
              ps.executeUpdate();
            
               rs = ps.getGeneratedKeys();

        if (rs.next()) {
            idGenerado = rs.getInt(1);
        }
        
         ps = con.prepareStatement(

            "INSERT INTO docente(idPersona,especialidad,facultad)VALUES(?,?,?);" );
          //  ps.setSTRING(1,ag.getIdPersona());
            ps.setInt(1, idGenerado);
               ps.setString(2, ag.getEspecialidad());
               ps.setString(3, ag.getFacultad());
            
            ps.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,
                    "Un Docente registrado con exito");
        }catch(Exception ex){
            ex.printStackTrace(); // 🔥 IMPORTANTE
            JOptionPane.showMessageDialog(null, 
                    "ERROR: no se puede registrar");
        }
    }
    @Override
    public  void actualizarDocente(Docente doc){
      try{

        ps = con.prepareStatement(
                "UPDATE persona "
               +"SET nombres=?, "
               +  "apellidos=?, "
               +  "dni=?, "
               +  "telefono=?, "
              +  "correo=? "
               + "WHERE idPersona=?"
              );
        ps.setString(1, doc.getNombres());
        ps.setString(2, doc.getApellidos());
        ps.setString(3, doc.getDni());
        ps.setString(4, doc.getTelefono());
        ps.setString(5, doc.getCorreo());
        ps.setInt(6, doc.getIdPersona());
        
        System.out.println("ID: " + doc.getIdPersona());

        System.out.println("Nombre: " + doc.getNombres());
    
        System.out.println("Docente: " + doc.getEspecialidad());
        ps.executeUpdate();

        ps = con.prepareStatement(
        "UPDATE docente SET "
        + "especialidad=?, "
        + "facultad=? "
        + "WHERE idPersona=?");
         ps.setString(1, doc.getEspecialidad());
         ps.setString(2, doc.getFacultad());
         ps.setInt(3, doc.getIdPersona());
          ps.executeUpdate();
        JOptionPane.showMessageDialog(  null, "Un Docente actualizado");
        }catch(Exception ex){
        JOptionPane.showMessageDialog(  null,ex.toString()); }
      
    }

    @Override
     public  void eliminarDocente(int idPersona){
          try{

        // 1. Eliminar de alumno
        ps = con.prepareStatement(
            "DELETE FROM docente WHERE idPersona=?"
        );

        ps.setInt(1, idPersona);
        ps.executeUpdate();

        // 2. Eliminar de persona
        ps = con.prepareStatement(
            "DELETE FROM persona WHERE idPersona=?"
        );

        ps.setInt(1, idPersona);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(
            null,
            "Docente eliminado correctamente"
        );

    }catch(Exception ex){

        JOptionPane.showMessageDialog(
            null,
            ex.toString()
        );
    }
     }
    /*
    public String generarCodigoDocente() {
    String codigo = "CDOC0001";

    try {
        ps = con.prepareStatement(

            "SELECT idPersona FROM docente ORDER BY idPersona DESC LIMIT 1"
    

        );

        rs = ps.executeQuery();

        if(rs.next() && rs.getString(1) != null){
            String last = rs.getString(1);

            //CONVERITR Y AUMENTAR,QUITAR CDOC
            int num = Integer.parseInt(last.replace("CDOC",""));
            num++;

            codigo = String.format("CDOC%04d", num);
        }

    } catch(Exception e){
        e.printStackTrace();
    }

    return codigo;
}
*/
    
}
