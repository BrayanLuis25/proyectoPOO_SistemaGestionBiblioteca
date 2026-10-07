/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

import java.util.List;




/**
 *
 * @author BrayanLuis
 */
public  class Usuario {
    
        private int idUsuarioSistema;
    private String username;
    private String password;

    private List<Rol>roles;
    /*
    protected int idUsuario;
    protected String nombres;
    protected String dni;

    public abstract void mostrarRol();
*/
  //metodo para registrar en la tabla
    public Object[] Registro(int num){
        Object[] fila ={num,username,password,
            roles
        };
        return fila;
    }
    
    public int getIdUsuarioSistema() {
        return idUsuarioSistema;
    }

    public void setIdUsuarioSistema(int idUsuarioSistema) {
        this.idUsuarioSistema = idUsuarioSistema;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    /*
    // LOGIN
public Usuario login(String username, String password)
{}
// REGISTRAR USUARIO
public int registrar(Usuario u) // devuelve id generado
{}
// BUSCAR POR ID
public Usuario buscarPorId(int id)
{}
// BUSCAR POR USERNAME
public Usuario buscarPorUsername(String username)
{}
// LISTAR TODOS
public List<Usuario> listar(){

}
}
*/
    
}
