package Controladores;

import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Ctrl_Producto {

    public boolean guardar(Producto objeto) {
        boolean respuesta = false;

        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_producto values (?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getPorcentajeIva());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e);
        }

        return respuesta;
    }

    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "select nombre from tb_producto where nombre = '" + producto + "';";
        Statement st;

        try {
            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;

        Connection cn = conexion.Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set nombre=?, cantidad = ?, precio = ?, descripcion = ?, porcentajeIva = ?, idCategoria = ?, estado = ? where idProducto = '" + idProducto + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeIva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close(); //cerramos la conexion
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }

        return respuesta;
    }

    public boolean eliminar(int idProducto) {
        boolean respuesta = false;

        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("delete from tb_producto where idProducto = '" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close(); //cerramos la conexion
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }

        return respuesta;
    }

    //ya usamos el calcular iva
    public double calcularIva(double precio, int porcentajeIVA) {
        double IVA = 0;
        switch (porcentajeIVA) {
            case 0:
                IVA = 0.0;
                break;
            case 12:
                IVA = precio * 0.12;
                break;
            default:
                break;
        }
        IVA = (double) Math.round(IVA * 100) / 100;
        return IVA;
    }

    //mis funciones
    /*
    public int obtenerIdCategoria(JComboBox<String> jCBCategoria) {
        // Obtiene la descripción seleccionada en el JComboBox
        String descripcion = (String) jCBCategoria.getSelectedItem();
        String sql = "select * from tb_categoria where descripcion = ?";
        int idCategoria = -1;

        try (
                Connection cn = conexion.Conexion.conectar(); 
                PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, descripcion);//cambie por 1
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                idCategoria = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el idCategoria: " + e);
        }

        return idCategoria; // Retorna el idCategoria obtenido
    }
    */ 
    /*
    public int obtenerIdCategoria(String idCategoria) {
        String sql = "select * from tb_categoria where descripcion = '" + idCategoria + "'";

        try (
            Connection cn = conexion.Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, idCatego);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener idCategoria: " + e.getMessage());
        }

        return idCategoria;
    }
*/
    /*
    public int obtenerIdCategoria(String idCategoria) {
        int obtenerIdCategoriasCB = 0;
        String sql = "select * from tb_categoria where descripcion = '" + idCategoria + "'";
        Statement st;
        try {
            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoriasCB = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id categoria: " + e);
        }
        return obtenerIdCategoriasCB;
    }
    //
*/
    
    public int idCategoria(String descripcionCategoria) {
    int idCategoria = -1;
    String sql = "SELECT idCategoria FROM tb_categoria WHERE descripcion = ?";

    try (
        Connection cn = conexion.Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql)) {
        
        pst.setString(1, descripcionCategoria);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            idCategoria = rs.getInt("idCategoria");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener id categoria: " + e);
    }
    
    return idCategoria;
}
    
}
