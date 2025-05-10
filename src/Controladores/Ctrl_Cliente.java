package Controladores;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Cliente {
    //guardamos cliente
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;

        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values (?,?,?,?,?,?,?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getCedula());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }

        return respuesta;
    }

    public boolean existeCliente(String cedula) {
        boolean respuesta = false;
        String sql = "select cedula from tb_cliente where cedula = '" + cedula + "';";
        Statement st;

        try {
            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;

        Connection cn = conexion.Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellido = ?, cedula = ?, telefono = ?, direccion = ?, estado = ? where idCliente = '" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close(); //cerramos la conexion
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }

        return respuesta;
    }

    public boolean eliminar(int idCliente) {
        
        boolean respuesta = false;

        Connection cn = conexion.Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("delete from tb_cliente where idCliente = '" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close(); //cerramos la conexion
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }

        return respuesta;
    }

}
