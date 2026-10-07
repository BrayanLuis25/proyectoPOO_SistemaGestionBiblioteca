package modelo.dao;

import javax.swing.JOptionPane;
import modelo.conexion.MySQLCnn;
import modelo.dao.UsuarioRolDao;
import modelo.entidades.Usuario;

public class UsuarioDao extends MySQLCnn {
    
    public UsuarioDao(){}

public Usuario login(String username, String password) {

    Usuario u = null;

    String sql = "SELECT idUsuarioSistema, username, password " +
                 "FROM usuario_sistema WHERE username = ?";

    try {
        ps = con.prepareStatement(sql);

        ps.setString(1, username);

        rs = ps.executeQuery();

        // 1.usuario no existe
        if (!rs.next()) {
            return null;
        }

        String passwordBD = rs.getString("password");

        // 2.password incorrecta
        if (!passwordBD.equals(password)) {
            return null;
           
        }

        // 3.usuario válido
        u = new Usuario();
        u.setIdUsuarioSistema(rs.getInt("idUsuarioSistema"));
        u.setUsername(rs.getString("username"));

        // 🔥fireonfire cargar roles
        UsuarioRolDao urDAO = new UsuarioRolDao();
        u.setRoles(urDAO.obtenerRolesPorUsuario(u.getIdUsuarioSistema()));

    } catch (Exception e) {
        e.printStackTrace();
    }

    return u;
}
/*Se hace para convertir una fila de tu tabla de MySQL en un objeto de Java. Una vez que el objeto u tiene estos datos guardados,
puedes pasarlo a otras ventanas para saber, por ejemplo, qué usuario está usando el sistema en ese momento y mostrar su nombre
en la pantalla.*/
  /*=========================================*/
   /*REGISTRARRRRRRR*/
    public int registrar(Usuario u, int idRolPorDefecto) {

    int idGenerado = -1;

    String sql = "INSERT INTO usuario_sistema(username, password) VALUES (?, ?)";

    try {
        ps = con.prepareStatement(
                sql,
                st.RETURN_GENERATED_KEYS
        );
       
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.executeUpdate();

        rs = ps.getGeneratedKeys();

        if (rs.next()) {
            idGenerado = rs.getInt(1);
        }

        // .PASO 2: asignar rol por defecto
        UsuarioRolDao urDAO = new UsuarioRolDao();
        urDAO.asignarRol(idGenerado, idRolPorDefecto);

    } catch (Exception e) {
        e.printStackTrace();
    }

    return idGenerado;
}

    /*
    /caso 1:ag.setIdPersona(rs.getString(1));....
    caso2:  Se usa ps.setString porque los datos que vas a enviar a la base de datos 
    son de tipo texto (cadenas de caracteres) y se deben validar como tales.*/
}

/* FormRegistrarUsuario registUsu = new FormRegistrarUsuario();¿Qué hace?: Crea una copia en la memoria de
la ventana de registro (el formulario).En lenguaje simple: 
Prepara la ventana tras bambalinas, pero todavía no la muestra en la pantalla.*/