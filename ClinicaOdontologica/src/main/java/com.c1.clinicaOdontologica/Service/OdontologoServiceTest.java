package Service;

import Dao.Implemt.OdontologoDaoH2;
import Entity.Odontologo;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static junit.framework.TestCase.*;

public class OdontologoServiceTest {

    private static Connection connection = null;
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    public void odontologoPrueba(){
        Odontologo odontologoT = new Odontologo(3, 7334, "Dani", "Perez");
        Odontologo odontologoR = odontologoService.registroOdontologo(odontologoT);

        assertNotNull(odontologoR);
        assertEquals(7334, odontologoR.getMatricula());

    }

    @Test
    public void odontologoListaPrueba(){
        List<Odontologo> listaOdontologosTest = odontologoService.listaOdontologos();
        assertFalse(listaOdontologosTest.isEmpty());
    }

}
