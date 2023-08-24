package Dao;

import org.apache.log4j.Logger;

import java.security.cert.Extension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDH2 {
    
    private static final Logger logger = Logger.getLogger(BDH2.class);
    private static final String CREATE="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(20) NOT NULL, " +
            "APELLIDO VARCHAR(20) NOT NULL)";
    public static void crearTabla(){
        Connection connection = null;
        try{
            connection = getConnnection();

            //CREACION DE LA TABLA ODONTOLOGO
            Statement statement = connection.createStatement();
            statement.execute(CREATE);


        }catch (Exception e){
            logger.info(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.info(ex.getMessage());
            }
        }
    }

    // CONEXION BASE DE DATOS H2
    public static Connection getConnnection() throws Exception{
        Class.forName("org.h2.Driver");
        logger.info("conexion con Driver exitosa");
        return DriverManager.getConnection("jdbc:h2:~/BDodontologos","admin","admin");
    }
}
