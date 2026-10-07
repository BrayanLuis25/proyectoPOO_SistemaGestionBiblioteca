/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;
import modelo.conexion.MySQLCnn;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;

/**
 *
 * @author BrayanLuis
 */
public class UsuarioRolDao extends MySQLCnn{
    
    
    public List<Rol> obtenerRolesPorUsuario(int idUsuarioSistema) {

    List<Rol> listaRol = new ArrayList<>();

    String sql =
        "SELECT r.idRol, r.nombreRol " +
        "FROM rol r " +
        "INNER JOIN usuario_roles ur ON r.idRol = ur.idRol " +
        "WHERE ur.idUsuarioSistema = ?";

    try {
   ps = con.prepareStatement(
sql);       
        ps.setInt(1, idUsuarioSistema);
     
        rs = ps.executeQuery();

        while (rs.next()) {

            Rol r = new Rol();
            r.setIdRol(rs.getInt("idRol"));
            r.setNombreRol(rs.getString("nombreRol"));

            listaRol.add(r);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return listaRol;
}
    
    /*=========================================*/
 /* ASIGNAR ROLLL===============*/
public void asignarRol(int idUser, int idRol) {

    String sql = "INSERT INTO usuario_roles(idUsuarioSistema, idRol) VALUES (?, ?)";

    try {

    ps = con.prepareStatement(sql); // <-- FALTA ESTO
        ps.setInt(1, idUser);
        ps.setInt(2, idRol);
        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}