package conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.Connection;

public class cnx {

    private static final String URL = "jdbc:mysql://localhost:3306/java_db?" + "autoReconnect=true&useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static Connection cx = null;
    public static Connection getConexion(){

        try{
            if(cx == null){
                Class.forName(DRIVER);
                cx = DriverManager.getConnection(URL, USER, PASS);
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("ERROR:" + e);
        }

        return cx;

    }

    public void cerrar() throws SQLException {
        if (cx != null) if (!cx.isClosed()) {
            cx.close();

        }
    }

}
