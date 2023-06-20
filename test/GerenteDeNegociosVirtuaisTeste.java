import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.GerenteDeNegociosVirtuais;
import model.Reserva;

public class GerenteDeNegociosVirtuaisTeste {

    private GerenteDeNegociosVirtuais gerente;
    private Reserva reserva;

    @Before
    public void setup() {
        gerente = new GerenteDeNegociosVirtuais();
        reserva = new Reserva();
        gerente.setReserva(reserva);
    }

    @Test
    public void testAprovarVenda() {
        gerente.aprovarVenda();
        boolean expected = true;
        boolean result = reserva.isStatus();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testDesaprovarReserva() {
        gerente.desaprovarReserva();
        boolean expected = false;
        boolean result = reserva.isStatus();
        Assert.assertEquals(expected, result);
    }
}
