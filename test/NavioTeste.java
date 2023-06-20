import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Navio;

public class NavioTeste {

    private Navio navio;

    @Before
    public void setup() {
        navio = new Navio(1, 500, 2015, "Cruzeiro", "Royal Caribbean", true);
    }

    @Test
    public void testGetCodigo() {
        int expected = 1;
        int result = navio.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 2;
        navio.setCodigo(expected);
        int result = navio.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCapacidade() {
        int expected = 500;
        int result = navio.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCapacidade() {
        int expected = 600;
        navio.setCapacidade(expected);
        int result = navio.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetAnoFabricacao() {
        int expected = 2015;
        int result = navio.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetAnoFabricacao() {
        int expected = 2018;
        navio.setAnoFabricacao(expected);
        int result = navio.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetTipo() {
        String expected = "Cruzeiro";
        String result = navio.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTipo() {
        String expected = "Carga";
        navio.setTipo(expected);
        String result = navio.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetModelo() {
        String expected = "Royal Caribbean";
        String result = navio.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetModelo() {
        String expected = "MSC Cruzeiros";
        navio.setModelo(expected);
        String result = navio.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsSituacao() {
        boolean expected = true;
        boolean result = navio.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetSituacao() {
        boolean expected = false;
        navio.setSituacao(expected);
        boolean result = navio.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        String expected = "Codigo: 1 Navio [capacidade=500, anoFabricacao=2015, tipo=Cruzeiro, modelo=Royal Caribbean, situacao=true]";
        String result = navio.toString();
        Assert.assertEquals(expected, result);
    }
}
