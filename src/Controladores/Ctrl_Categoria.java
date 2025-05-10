package Controladores;

import Modelo.Categoria;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JTextField;

public class Ctrl_Categoria {

    //Metodo para guardar productos ctrl categoria implementada!
    
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values (?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());//podria borrarlo xra que no me aparezca en la tabla
        
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto" + e);
        }
        return respuesta;
    }
    
    //Metodo para confirmar si existe la n-categoria en nuestra BD
    
    public boolean existeCategoria(String categoria){
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria + "';";
        Statement st;
        
        try {
            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar producto" + e);
        }
        return respuesta;
    }
    
    
    
    public boolean actualizar(Categoria categoria, int idCategoria){
        boolean respuesta = false;
        
        Connection cn = conexion.Conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set descripcion = ? where idCategoria = '" + idCategoria + "'");
            consulta.setString(1, categoria.getDescripcion());
            if(consulta.executeUpdate()>0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto!" + e);
        }
        return respuesta;
    }
    
    //Eliminar implementado!
    
    public boolean eliminar(int idCategoria){
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;
        
        try {
            cn = conexion.Conexion.conectar();
            consulta = cn.prepareStatement("delete from tb_categoria where idCategoria = ?");
            consulta.setInt(1, idCategoria);
            
            int filasEliminadas = consulta.executeUpdate();
            
            if(filasEliminadas > 0){
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria" + e);
        }
        try {
            if(consulta != null){
                consulta.close();
            }else if(cn != null){
                cn.close();
            }
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria!" + e);
        }
        return respuesta;
    }
    
    //Funcionando en Tabla_Categorias
    /*
    public void EnviarDatosCategoriaSeleccionada(int idCategoria, String jtfDescripcion){
        try {
            Connection cn = conexion.Conexion.conectar();
            PreparedStatement st = cn.prepareStatement("select * from tb_categoria where idCategoria = '" + idCategoria + "'");
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                jtfDescripcion = rs.getString("descripcion");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar categorias! en Enviar DATOS!" + e);
        }
    }
    */
    
    //Funcion casi insnsesa
    public void EnviarDatosCategoriaSeleccionada(int idCategoria, JTextField jtfDescripcion) {
    try {
            Connection con = Conexion.conectar(); //Establece la conexión con la bD
            PreparedStatement pst = con.prepareStatement("select * from tb_categoria where idCategoria = '" + idCategoria + "'"); //Crea un consulta 
            ResultSet rs = pst.executeQuery();//Realiza la consulta
            if (rs.next()) {
                jtfDescripcion.setText(rs.getString("descripcion"));
            }
            con.close();//finaliza la conexion
        } catch (SQLException e) {
            System.out.println("Error al seleccionar categorias " + e);
        }
}

}
