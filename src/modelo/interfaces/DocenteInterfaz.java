/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.interfaces;

import javax.swing.JTable;

import modelo.entidades.Docente;

/**
 *
 * @author BrayanLuis
 */
public interface DocenteInterfaz {
       void mostrarEnTabla(JTable tabla);
int obtenerCantidadLibros(int idAlumno);
public void registrarDocente(Docente ag);
    public void actualizarDocente(Docente doc);
    public void eliminarDocente(int idDocente);
    
}
