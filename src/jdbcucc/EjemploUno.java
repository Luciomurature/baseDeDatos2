package jdbcucc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

//project structure y agregar la libreria de mysql

public class EjemploUno{

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/ucc2019","root", "lucio123");
//        Statement s = c.createStatement(); //statement = sentencia.
//        int filas = s.executeUpdate("INSERT INTO productos (nombre, precio) VALUES ('Harina', 115)"); //para sql dinámico
        //PreparedStatement pst = c.prepareStatement("INSERT INTO productos (nombre, precio) VALUES ('Pan', 35)"); //está prearmada, es estática
        //ahora la ejecuto
        //int filas = pst.executeUpdate(); //no necesito pasarle la sentencia SQL como parámetro

        //insertamos muchos productos con variables
        PreparedStatement pst = c.prepareStatement("INSERT INTO productos (nombre, precio) VALUES (?,?)"); //los signos de pregunta son placeholder, el primero se llama 1 y el segundo se llama 2, tengo que ser conciente del tipo de datos.

        for(int i = 0; i < 100; i++){
            pst.setInt(2, 50+i);
            pst.setString(1, "Factura"+(i));
            pst.executeUpdate();

        }
    }

}