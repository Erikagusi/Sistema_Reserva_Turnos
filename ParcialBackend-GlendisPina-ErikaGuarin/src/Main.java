import Dao.BDH2;
import Dao.Implemt.OdontologoDaoH2;
import Dao.Implemt.OdontologoDaoMen;
import Entity.Odontologo;
import Service.OdontologoService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BDH2.crearTabla();

        Odontologo odontologo1 = new Odontologo(1,1234,"Glendi","Piña");
        Odontologo odontologo2 = new Odontologo(2,9234,"Erika","Guarin");

        //Estamos instanciando el service para usar H2
        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
        odontologoService.registroOdontologo(odontologo1);
        odontologoService.registroOdontologo(odontologo2);
        System.out.println("*************************************");
        System.out.println("Listamos todos los Odontologos en H2");
        odontologoService.listaOdontologos();
        System.out.println("*************************************");

        //Usaremos el array List
        OdontologoService odontologoService1 = new OdontologoService(new OdontologoDaoMen(new ArrayList<>()));
        odontologo1.setId(1);
        odontologo2.setId(2);
        odontologoService1.registroOdontologo(odontologo1);
        odontologoService1.registroOdontologo(odontologo2);
        System.out.println("*************************************");
        System.out.println("Listamos todos los Odontologos en Memoria");
        odontologoService1.listaOdontologos();





    }
}