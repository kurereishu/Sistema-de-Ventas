package Tablas_SQL;

import Controladores.Ctrl_Producto;
import conexion.Conexion;
import java.sql.Connection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Tablas_MySQL {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private Ctrl_Producto ctrl_Producto;

    public Tablas_MySQL() {
        this.con = Conexion.conectar();
        this.ctrl_Producto = new Ctrl_Producto();
    }

    public void cargarTablaCategorias(DefaultTableModel modelo, JTable tabla) {
        String sql = "select * from tb_categoria";
        Connection con = null;
        ResultSet rs = null;
        try {
            con = conexion.Conexion.conectar();
            rs = con.createStatement().executeQuery(sql);

            // Limpiar el modelo de la tabla antes de agregar nuevas filas
            modelo.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("idCategoria");
                String descripcion = rs.getString("descripcion");
                int estado = rs.getInt("estado");//anadi estado
                modelo.addRow(new Object[]{id, descripcion, estado}); //anadi estado
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla de categorias!" + e);
        }
    }

    public void cargarCBCategorias(JComboBox jCBCategoria) {
        con = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCBCategoria.removeAllItems();
            jCBCategoria.addItem("Seleccione una categoria");
            while (rs.next()) {
                jCBCategoria.addItem(rs.getString("descripcion"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar el CB de categorias");
        }
    }

    public void cargarTablaProducto(DefaultTableModel modelo, JTable tabla) {
        String sql = "SELECT p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion AS categoriaDescripcion, p.estado  FROM tb_producto AS p JOIN tb_categoria AS c ON p.idCategoria = c.idCategoria;";
        ResultSet rs = null;
        try {
            con = conexion.Conexion.conectar();
            rs = con.createStatement().executeQuery(sql);

            // Limpiar el modelo de la tabla antes de agregar nuevas filas
            modelo.setRowCount(0);

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                int cantidad = rs.getInt("cantidad");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");
                int porcentajeIva = rs.getInt("porcentajeIva");
                String descripcionCategoria = rs.getString("categoriadescripcion");
                int estado = rs.getInt("estado"); //anadi estado

                double ivaCalculado = ctrl_Producto.calcularIva(precio, porcentajeIva);

                modelo.addRow(new Object[]{idProducto, nombre, cantidad, precio, descripcion, ivaCalculado, descripcionCategoria, estado}); //anadi estado
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla de productos!" + e);
        }

    }

    /*
   public String relacionarCategoria(int idProducto) { //puede que no utilice
    String descripcionCategoria = "";
    String sql = "select * from tb_producto where idProducto = '" + idProducto + "'";
    
    try (Connection cn = Conexion.conectar();
         PreparedStatement pst = cn.prepareStatement(sql)) {
        
        pst.setInt(1, idProducto);
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            descripcionCategoria = rs.getString("descripcion");
        }
        
    } catch (SQLException e) {
        System.out.println("Error al cargar el idCategoria: " + e);
    }
    return descripcionCategoria;
}*/
    public void cargarTablaClientes(DefaultTableModel modelo, JTable tabla) {
        String sql = "select * from tb_cliente";
        ResultSet rs;
        try {
            con = Conexion.conectar();
            rs = con.createStatement().executeQuery(sql);

            modelo.setRowCount(0); //limpiar la tabla.

            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String cedula = rs.getString("cedula");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                int estado = rs.getInt("estado");

                modelo.addRow(new Object[]{idCliente, nombre, apellido, cedula, telefono, direccion, estado});
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar la tabla de clientes");
        }
    }

    //Clientes
    
    public void cargarCBClientes(JComboBox jCBClientesFactura) {
        con = conexion.Conexion.conectar();
        String sql = "select * from tb_cliente";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCBClientesFactura.removeAllItems();
            jCBClientesFactura.addItem("Seleccione un cliente:");
            while (rs.next()) {
                jCBClientesFactura.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar el CB de clientes");
        }
    }

    public void cargarCBProductos(JComboBox jCBProductoFactura) {
        con = conexion.Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCBProductoFactura.removeAllItems();
            jCBProductoFactura.addItem("Seleccione un producto:");
            while (rs.next()) {
                jCBProductoFactura.addItem(rs.getString("nombre"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar el CB de productos");
        }
    }

    
    
}
