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
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(20) NOT NULL, APELLIDO VARCHAR(20) NOT NULL);" +
            "DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, CEDULA VARCHAR (20) NOT NULL, FECHA_INGRESO DATE NOT NULL, DOMICILIO_ID):" +
            "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE DOMICILIOS(ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(100) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR (100) NOT NULL, PROVINCIA VARCHAR (100) NOT NULL)";

    public static void crearTabla(){
        Connection connection = null;
        try{
            connection = getConnnection();

            //CREACION DE LA TABLA ODONTOLOGO
            Statement statement = connection.createStatement();
            statement.execute(CREATE);
            logger.info("Datos cargados");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    // CONEXION BASE DE DATOS H2
    public static Connection getConnnection() throws Exception{
        Class.forName("org.h2.Driver");
        logger.info("conexion con Driver exitosa");
        return DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica","admin","admin");
    }
}
