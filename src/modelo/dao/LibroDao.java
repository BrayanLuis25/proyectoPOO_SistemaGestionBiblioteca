package modelo.dao;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.conexion.*;
import modelo.entidades.Libro;

public class LibroDao extends MySQLCnn{

    public LibroDao(){}

    // MOSTRAR TABLA
    public void mostrarEnTabla(JTable tabla){

        String titulo[]={
            "Num.","Codigo","Titulo",
            "Autor","Categoria",
            "Editorial","Cantidad"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(null,titulo);

        tabla.setModel(modelo);

        int cantReg = 0;

        try{

            rs = st.executeQuery(
                    "SELECT * FROM libro"
            );

            while(rs.next()){

                cantReg++;

                Libro li = new Libro();

                li.setIdLibro(rs.getInt(1));
                li.setTituloLibro(rs.getString(2));
                li.setAutor(rs.getString(3));
                li.setCategoria(rs.getString(4));
                li.setEditorial(rs.getString(5));
                li.setCantidad(rs.getInt(6));

                modelo.addRow(
                        li.Registro(cantReg)
                );
            }

          //  con.close();

        }catch(Exception ex){

            JOptionPane.showMessageDialog(
                    null,
                    ex.toString());
        }
    }

    // REGISTRAR LIBRO
    public void registrarLibro(Libro li){
           
        try{

            ps = con.prepareStatement(

            "INSERT INTO libro"
          + "(titulo,autor,"
          + "categoria,editorial,stock)"
          + "VALUES(?,?,?,?,?)"
 
            );

       
            ps.setString(1, li.getTituloLibro());
            ps.setString(2, li.getAutor());
            ps.setString(3, li.getCategoria());
            ps.setString(4, li.getEditorial());
            ps.setInt(5, li.getCantidad());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Libro registrado");

        }catch(Exception ex){

            JOptionPane.showMessageDialog(
                    null,
                    ex.toString());
        }
    }
    //==========ACTUALIZAR LIBRO=========================================
    
    public void actualizarLibro(Libro li){

    try{

        ps = con.prepareStatement(
            "UPDATE libro "
          + "SET titulo=?, "
          + "autor=?, "
          + "categoria=?, "
          + "editorial=?, "
          + "stock=? "
          + "WHERE idLibro=?"
        );

        ps.setString(1, li.getTituloLibro());
        ps.setString(2, li.getAutor());
        ps.setString(3, li.getCategoria());
        ps.setString(4, li.getEditorial());
        ps.setInt(5, li.getCantidad());

        ps.setInt(6, li.getIdLibro());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Libro actualizado");

    }catch(Exception ex){

        JOptionPane.showMessageDialog(
                null,
                ex.toString());

    }
}
    
       public void eliminarLibro(int idLibro){
           try {
           ps = con.prepareStatement(
           "DELETE FROM libro where idLibro=?"
           );
           ps.setInt(1, idLibro);
           ps.executeUpdate();
           
           }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.toString());
           }
       }
}
/*
    // ps.setInt(1, li.getIdLibro());
            // ps.setInt(1, idGenerado);
 int idGenerado=0;
 rs = ps.getGeneratedKeys();

        if (rs.next()) {
            idGenerado = rs.getInt(1);
        }
*/