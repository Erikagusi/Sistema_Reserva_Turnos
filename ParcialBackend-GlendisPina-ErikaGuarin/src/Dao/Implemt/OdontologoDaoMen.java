package Dao.Implemt;

import Dao.IDao;
import Entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoMen implements IDao <Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoMen.class);
    private List<Odontologo> odontologoList;



    public OdontologoDaoMen(List<Odontologo> odontologoList) {
        this.odontologoList = odontologoList;
    }

    public List<Odontologo> getOdontologoList() {
        return odontologoList;
    }

    public void setOdontologoList(List<Odontologo> odontologoList) {
        this.odontologoList = odontologoList;
    }

    @Override
    public Odontologo registroOdontologo(Odontologo o) {
        odontologoList.add(o);
        logger.info("Odontologo registrado: "+ o.getNombre());
        return o;
    }

    @Override
    public List<Odontologo> listaOdontologos() {
        logger.info("Mostarndo Listado de Odontologos: "+ odontologoList.toString());
        return odontologoList;
    }
}
