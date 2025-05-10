package Controladores;

import Modelo.CabeceraVenta;
import Modelo.DetalleVenta;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ctrl_RegistrarVenta {

    public static int idCabeceraRegistrada;

    java.math.BigDecimal iDColVar;

    private int idProducto;
    //private int idCliente;
    private String nombre;
    private int cantidadProductoBBDD;
    private double precioUnitario;
    private int porcentajeIva;
    private double iva;
    //private int estado;

    private double subtotalGeneral;
    private double ivaGeneral;
    private double totalPagarGeneral;

    public ArrayList<DetalleVenta> listaProductosF;

    /*
    public boolean guardar(CabeceraVenta objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = iDColVar.intValue();
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta: " + e);
        }
        return respuesta;
    }
     */
    
        // Variable de instancia para almacenar el ID de la cabecera registrada

        
    //inicio
        public boolean guardar(CabeceraVenta objeto) {
            boolean respuesta = false;
            Connection cn = conexion.Conexion.conectar();
            try {
                PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values(?,?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                consulta.setInt(1, 0);//id
                consulta.setInt(2, objeto.getIdCliente());
                consulta.setDouble(3, objeto.getValorPagar());
                consulta.setString(4, objeto.getFechaVenta());
                consulta.setInt(5, objeto.getEstado());

                if (consulta.executeUpdate() > 0) {
                    respuesta = true;
                }

                ResultSet rs = consulta.getGeneratedKeys();
                while (rs.next()) {
                    idCabeceraRegistrada = rs.getInt(1);
                }

                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al guardar cabecera de venta: " + e);
            }
            return respuesta;
        }

        public int getIdCabeceraRegistrada() {
            return idCabeceraRegistrada;
        }
        //fin

    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_detalle_venta values(?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());
            //consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(7, objeto.getIva());
            consulta.setDouble(8, objeto.getTotalPagar());
            consulta.setInt(9, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }
        return respuesta;
    }

    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "update tb_cabecera_venta set idCliente = ?, estado = ? "
                    + "where idCabeceraVenta ='" + idCabeceraVenta + "'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta: " + e);
        }
        return respuesta;
    }

    public boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

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

    /*
    public void DatosDelProducto(String jCBProductoFactura) {

        try {
            String sql = "select * from tb_producto where nombre = ?";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                 nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                 precioUnitario = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                calcularIva(precioUnitario, porcentajeIva);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto!" + e);
        }
    }
     */
 /*
        public void DatosDelProducto(String nombreProducto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.conectar();// obtener conexión a la base de datos
            String query = "SELECT idProducto, nombre, cantidad, precio, iva FROM tb_producto WHERE nombre = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nombreProducto);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                iva = rs.getDouble("iva");
            } else {
                throw new SQLException("Producto no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener datos del producto!" + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
     */
    public void DatosDelProducto(String nombreProducto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.conectar();// obtener conexión a la base de datos
            String query = "select * from tb_producto where nombre = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nombreProducto);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                iva = rs.getDouble("PorcentajeIva");
            } else {
                throw new SQLException("Producto no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener datos del producto!" + e.getMessage() + idProducto + iva);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CalcularTotalPagar() { //Arreglar 
        subtotalGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProductosF) {
            subtotalGeneral += elemento.getSubTotal();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        // Redondear decimales
        this.subtotalGeneral = Math.round(subtotalGeneral * 100) / 100.0;
        this.ivaGeneral = Math.round(ivaGeneral * 100) / 100.0;
        this.totalPagarGeneral = Math.round(totalPagarGeneral * 100) / 100.0;
    }

    //Correciones a listaTablaProductosFactura de JFMenu
    public void listaTablaProductosFactura(DefaultTableModel modeloDatosProductos) {
        modeloDatosProductos.setRowCount(listaProductosF.size());
        for (int i = 0; i < listaProductosF.size(); i++) {
            modeloDatosProductos.setValueAt(i + 1, i, 0);
            modeloDatosProductos.setValueAt(listaProductosF.get(i).getNombre(), i, 1);
            modeloDatosProductos.setValueAt(listaProductosF.get(i).getCantidad(), i, 2);
            modeloDatosProductos.setValueAt(listaProductosF.get(i).getPrecioUnitario(), i, 3);
            modeloDatosProductos.setValueAt(listaProductosF.get(i).getSubTotal(), i, 4);
            //modeloDatosProductos.setValueAt(listaProductosF.get(i).getDescuento(), i, 5);
            modeloDatosProductos.setValueAt(listaProductosF.get(i).getIva(), i, 5);
            modeloDatosProductos.setValueAt(listaProductosF.get(i).getTotalPagar(), i, 6);
            modeloDatosProductos.setValueAt("Eliminar", i, 7);
        }
    }

    //constructor
    public Ctrl_RegistrarVenta(ArrayList<DetalleVenta> listaProductosF) {
        this.listaProductosF = listaProductosF;
    }
    //Fin de correciones

    public boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
    public void ObtenerIdCliente(String jCBFacturaClientes){
        try{
            String sql = "select * from tb_cliente where concat(nombre,' ',apellido) = '" + jCBFacturaClientes + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
        }catch(SQLException e){
            System.out.println("Error al obtener idCliente " + e);
        }
    }
     */
    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadProductoBBDD() {
        return cantidadProductoBBDD;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getIva() {
        return iva;
    }

    public double getSubtotalGeneral() {
        return subtotalGeneral;
    }
    /*
    public double getDescuentoGeneral() {
        return descuentoGeneral;
    }
    */
    public double getIvaGeneral() {
        return ivaGeneral;
    }

    public double getTotalPagarGeneral() {
        return totalPagarGeneral;
    }

    public ArrayList<DetalleVenta> getListaProductosF() {
        return listaProductosF;
    }

    public static void setIdCabeceraRegistrada(int idCabeceraRegistrada) {
        Ctrl_RegistrarVenta.idCabeceraRegistrada = idCabeceraRegistrada;
    }

    /*
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
     */
    public void setTotalPagarGeneral(double totalPagarGeneral) {
        this.totalPagarGeneral = totalPagarGeneral;
    }

    public void restarStockProd(int idProducto, int cantidad) {
        int cantidadProductosBD = 0;

        // Primer bloque para obtener la cantidad actual del producto
        try {
            Connection cn = Conexion.conectar();
            String sql = "select idProducto, cantidad from tb_producto where idProducto = '" + idProducto + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cantidadProductosBD = rs.getInt("cantidad");
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la cantidad del producto: " + e);
        }

        // Segundo bloque para actualizar la cantidad del producto
        try {
            Connection cn = Conexion.conectar();
            String sqlUpdate = "update tb_producto set cantidad=? where idProducto = ?";
            PreparedStatement consulta = cn.prepareStatement(sqlUpdate);
            int cantidadNueva = cantidadProductosBD - cantidad;
            consulta.setInt(1, cantidadNueva);
            consulta.setInt(2, idProducto);
            consulta.executeUpdate();
            consulta.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al realizar la resta del stock de productos: " + e);
        }

    }

}
