/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.interfaces;

import javax.swing.JTable;
import modelo.entidades.Prestamo;

/**
 *
 * @author BrayanLuis
 */
public interface PrestamoInterface {

   void mostrarEnTabla(JTable tabla);
int obtenerCantidadLibros(int idPrestamo);
public void registraPrestamo(Prestamo presta);
public void actualizarPrestamo(Prestamo p);
public void eliminarPrestamo(int idPrestamo);

public void descontarLibroPrest(Prestamo prestalib);

  public void mostrarEnTablaPrestados(JTable tabla, int buscar);
public void aumentarStock(Prestamo aumentStock);
public void actualizarEstadoDevuelto(Prestamo descontarStock);

  public void reportePrestamos(String estado);

}
