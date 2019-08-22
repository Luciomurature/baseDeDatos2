package jdbcucc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//project structure y agregar la libreria de mysql

public class EjemploDos {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/ucc2019", "root", "lucio123");
        PreparedStatement pst = c.prepareStatement("SELECT id, nombre, precio FROM productos");
        ResultSet rs = pst.executeQuery();

        while(rs.next()){ //el metodo next pasa a la primera fila, desde el BOF (que es nada), y cuando EOF devuelve falso.
            int idProducto = rs.getInt(1); //si pongo un numero, es el numero ordinal de columnas, si pongo la string, es el nombre de la columna
            String nombre = rs.getString("nombre"); //versión por nombre
            int precio = rs.getInt("precio");
            System.out.printf("%s\t%s\t%s\n", idProducto, nombre, precio);
        }
    }

}