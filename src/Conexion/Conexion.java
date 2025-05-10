//Esta clase permite comprobar que los datos ingresados sean correctos 
//o no, emitiendo un mensaje de error.
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {//comprobacion de que los datos coinciden con la base de datos.

    public static Connection conectar(){
    try{
        Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/dbjavamysql","root","agosto28");//aqui podemos conectar a la base de datos
        //Connection = va a tomar los parametros que son de la base de datos,usuaurio, contraseña...
        return cn;
    }catch(SQLException e){
        System.out.println("Error en la conexion local "+e);
    }
    return null;
    }
}

