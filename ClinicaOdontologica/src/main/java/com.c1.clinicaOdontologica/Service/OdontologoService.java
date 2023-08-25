package Service;

import Dao.IDao;
import Entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoService {

    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    private IDao<Odontologo> odontologoIDao ;

    public OdontologoService(IDao<Odontologo>odontologoIDao){
        this.odontologoIDao = odontologoIDao;}

    public Odontologo registroOdontologo(Odontologo odontologo){
        return odontologoIDao.registroOdontologo(odontologo);
    }

    public List<Odontologo> listaOdontologos(){
        return odontologoIDao.listaOdontologos();
    }

}
