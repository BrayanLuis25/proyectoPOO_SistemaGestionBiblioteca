/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

        
package modelo.dao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.conexion.*;

import modelo.entidades.Alumno;
import modelo.entidades.Libro;
import modelo.interfaces.AlumnoInterface;
/**
 *
 * @author BrayanLuis
 */
//dao solo datos puros,s e cocnencta con la base de datos, pero hay mala practica mezcla datos con la interfzgraficajtable,defaulttable y joption
public class AlumnoDao  extends MySQLCnn implements AlumnoInterface{
        //constructor
    public AlumnoDao(){}
    //metodo para mostrar los reg. en la tabla
    @Override //SOBREESCRIBIENDO
    public void mostrarEnTabla(JTable tabla){
        String titulo[]={"Num.","Codigo","Nombres",
            "Apellidos","DNI","Telefono","Correo",
            "Carrera","Ciclo","EstadoPrestamo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        tabla.setModel(modelo);
        int cantReg=0;
        try{
            //4. Ejuctamos la consulta
            rs = st.executeQuery("select * "+ "from persona p "+
                    "INNER JOIN alumno a "
            + "ON p.idPersona = a.idPersona");
            //5. Recorremos el resultado
            while(rs.next()){
            cantReg++;
        //creamos al objeto AsistenteGerencia y captura el result set conjunto de resulados de la base dea dtos para traerlo
            Alumno ag = new Alumno();
            ag.setIdPersona(rs.getInt(1));
            ag.setNombres(rs.getString(2));
            ag.setApellidos(rs.getString(3));
            ag.setDni(rs.getString(4));
            ag.setTelefono(rs.getString(5));
            ag.setCorreo(rs.getString(6));
            
            
                 ag.setCarrera(rs.getString(8));
                  ag.setCiclo(rs.getString(9));
        
                  
                  int cantidad = obtenerCantidadLibros(
        ag.getIdPersona()
        );
            modelo.addRow(ag.Registro(cantReg,cantidad));
            }
           // con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
                    "ERROR: no se pueden mostrar los registros");
             JOptionPane.showMessageDialog(null,ex.toString()); 
            
        }
    }
    //CASO1: ag.setIdPersona(rs.getString(1)); :............
    /*Se hace para convertir una fila de tu tabla de MySQL en un objeto de Java. Una vez 
    que el objeto u tiene estos datos guardados, puedes pasarlo a otras ventanas para saber,
    por ejemplo, qué usuario está usando el sistema en ese momento y mostrar su nombre
    en la pantalla.
    
   
     CASO2:  Se usa ps.setString porque los datos que vas a enviar a la base de datos 
    son de tipo texto (cadenas de caracteres) y se deben validar como tales.
    DONDE SE MREPLAZA LE PRIMER ? POR 1 O 2 EN METOD REGISTRAR() DE ABAJO;
   
    ps: Es la variable de tu objeto PreparedStatement, que contiene la consulta SQL precompilada [1, 2].setString: Le indica a Java que el valor que vas a enviar 
    es una cadena de texto (String) [1]. El driver de la base de datos se encargará de ponerle las comillas automáticamente y proteger tu código contra Inyección SQL [1].1 (Columna / Parámetro 1): Representa 
    el primer signo de interrogación (?) que pusiste en tu consulta SQL, de izquierda a derecha [1, 2]. No se refiere estrictamente al nombre de la columna en la tabla, sino al orden de los parámetros 
    en tu sentencia SQL [1, 2].ag.getIdPersona(): 
    Es el método que obtiene el valor real (el ID) desde tu objeto o entidad (posiblemente un objeto "Agenda" o "Agente") [2]
    
*/
    
   /*============================OBTENERCANTIDAD DE LIBROS===================*/

    @Override
    public int obtenerCantidadLibros(int idPersona){
//OTRO resutlo resutlset
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
    
public boolean existeDni(String dni){
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
    public void registraAlumno(Alumno ag){
        int idGenerado=0;
        try{
            //modificar informacion de la BD
            /*returnkey:despues de isner traem el id que mysqlgenero*/
            ps = con.prepareStatement(
  "INSERT INTO persona(nombres,apellidos,dni,telefono,correo) VALUES(?,?,?,?,?);",
            st.RETURN_GENERATED_KEYS
            );
         
                  
            //ps.setInt(1, ag.getIdPersona());
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
              
              //2.inserta al alumno
         ps = con.prepareStatement(

            "INSERT INTO alumno(idPersona,carrera,ciclo)VALUES(?,?,?);" );
         //   ps.setInt(1,ag.getIdPersona());
                ps.setInt(1, idGenerado);
               ps.setString(2, ag.getCarrera());
               ps.setString(3, ag.getCiclo());
            
            ps.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,
                    "Un Alumno registrado con exito");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, 
                    ex.toString());
        }
    }
    
    @Override
    public void actualizarAlumno(Alumno al){

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
             
        ps.setString(1, al.getNombres());
        ps.setString(2, al.getApellidos());
        ps.setString(3, al.getDni());
        ps.setString(4, al.getTelefono());
        ps.setString(5, al.getCorreo());
        ps.setInt(6, al.getIdPersona());
    
System.out.println("ID: " + al.getIdPersona());
System.out.println("Nombre: " + al.getNombres());
        ps.executeUpdate();

         ps = con.prepareStatement(
            "UPDATE alumno SET "
          + "carrera=?, "
          + "ciclo=? "
          + "WHERE idPersona=?"
        );

        ps.setString(1, al.getCarrera());
        ps.setString(2, al.getCiclo());
        ps.setInt(3, al.getIdPersona());

        ps.executeUpdate();
        
        
        JOptionPane.showMessageDialog(
                null,
                "Un alumno actualizado");

    }catch(Exception ex){

        JOptionPane.showMessageDialog(
                null,
                ex.toString());

    
    }
   }
    @Override
public void eliminarAlumno(int idPersona){
//eliminar primera el alumno leugo la persona por la la relacion hijo .padre
    try{

        // 1. Eliminar de alumno
        ps = con.prepareStatement(
            "DELETE FROM alumno WHERE idPersona=?"
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
            "Alumno eliminado correctamente"
        );

    }catch(Exception ex){

        JOptionPane.showMessageDialog(
            null,
            ex.toString()
        );
    }
}
    
    /*
       public String generarCodigoAlumno() {
    String codigo = "CALU0001";

    try {
        ps = con.prepareStatement(
                       "SELECT idPersona FROM alumno ORDER BY idPersona DESC LIMIT 1"
        );

        rs = ps.executeQuery();

        if(rs.next() && rs.getString(1) != null){
            String last = rs.getString(1);

            int num = Integer.parseInt(last.replace("CALU",""));
            num++;

            codigo = String.format("CALU%04d", num);
        }

    } catch(Exception e){
        e.printStackTrace();
    }

    return codigo;
}
    */
}

/*
Qué hace exactamente esta línea?ps: 
Es la variable de tu objeto PreparedStatement, 
que contiene la consulta SQL precompilada [1, 2].setString: 
Le indica a Java que el valor que vas a
enviar es una cadena de texto (String) [1].
El driver de la base de datos se encargará de ponerle las 
comillas automáticamente y proteger tu código contra Inyección SQL [1].
1 (Columna / Parámetro 1):
Representa el primer signo de interrogación (?) que pusiste en tu consulta SQL, de izquierda a derecha [1,
2]. No se refiere estrictamente al nombre de la columna en la tabla, sino al orden de los parámetros en tu sentencia SQL [1, 2].ag.getIdPersona(): 
Es el método que obtiene el valor real (el ID) desde tu objeto
o entidad (posiblemente un objeto "Agenda" o "Agente") [2].

*/
