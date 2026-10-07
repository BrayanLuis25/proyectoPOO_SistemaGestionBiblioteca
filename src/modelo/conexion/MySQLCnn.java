/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.conexion;

/**
 *
 * @author BrayanLuis
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class MySQLCnn {
     public Connection con;
    public Statement st;
    public PreparedStatement ps;
    public ResultSet rs;
    public MySQLCnn(){
    try{
        //1.Cargar el driver jdbc
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. Realizo la conexion a la BD.
        con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/sistemagestbiblio","root","Brayan1999!");
        //3.Establecer la conexion
        st = con.createStatement();
        JOptionPane.showMessageDialog(null,
                "Conectado correctamente a la BD");
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, 
                "ERROR: no se puede conectar a la BD");
    }
    
    }

    /*
        //statemaent = permite traer informacion de la BD
    //MOTRAR, BUSCAR
    //preparaeStamentent(ps):
    ✔ Sirve para:
Ejecutar SQL
Insertar datos
Actualizar datos
Eliminar datos
Evitar SQL Injection
    Es el objeto que envía la consulta a la base de datos.
 
    // MODIFICAR LA BD:elete,update; es decir el Crud completo:consula,lee,actualiza,elimina
    
    /*
    
    
    RS:Es el objeto que recibe los datos que devuelve la BD.
    Un ResultSet (o conjunto de resultados) es el objeto en Java (que forma parte de JDBC) que almacena y 
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
    


   
}
