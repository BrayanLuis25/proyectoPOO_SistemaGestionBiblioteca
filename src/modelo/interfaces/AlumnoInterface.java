/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.interfaces;

import javax.swing.JTable;
import modelo.entidades.Alumno;

/**
 *
 * @author BrayanLuis
 */
public interface AlumnoInterface {
   void mostrarEnTabla(JTable tabla);
int obtenerCantidadLibros(int idAlumno);
public void registraAlumno(Alumno ag);
  public void actualizarAlumno(Alumno al);
  public void eliminarAlumno(int idPersona);
}