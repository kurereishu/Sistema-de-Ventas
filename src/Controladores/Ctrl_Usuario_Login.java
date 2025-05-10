package Controladores;

import Modelo.UsuarioLogin;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ctrl_Usuario_Login {
    
    //metodo iniciar sesion
    public boolean loginUser(UsuarioLogin objeto){
        boolean respuesta=false;
        Connection cn=Conexion.conectar();
        String sql="select usuario,password from tb_usuario where usuario='"+objeto.getUsuario()+"'and password='"+objeto.getPassword()+"'";
        //
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                respuesta=true;
            }
        }catch(SQLException e){
            System.out.println("Error al Iniciar Sesion ");
            JOptionPane.showMessageDialog(null,"Error al Iniciar Sesion " );
        }
        return respuesta;
    }
}