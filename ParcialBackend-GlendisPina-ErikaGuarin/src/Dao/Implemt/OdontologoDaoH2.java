package Dao.Implemt;

import Dao.BDH2;
import Dao.IDao;
import Entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private static  final String INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?,?)";
    private static final String SELECT ="SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo registroOdontologo (Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = BDH2.getConnnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, odontologo.getId());
            ps.setInt(2, odontologo.getMatricula());
            ps.setString(3, odontologo.getNombre());
            ps.setString(4,odontologo.getApellido());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                odontologo.setId(rs.getInt(1));
            }
            connection.commit();

        logger.info("Odontologo Guardado " + odontologo.getNombre());
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                logger.info(ex.getMessage());
            }

        }
        return odontologo;

    }
    @Override
    public List<Odontologo>listaOdontologos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = BDH2.getConnnection();
            PreparedStatement ps = connection.prepareStatement(SELECT);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
            }
            logger.info("Listado de odontologos registrados: " + odontologos.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return odontologos;
        }

    }

