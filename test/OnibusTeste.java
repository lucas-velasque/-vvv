import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Onibus;

public class OnibusTeste {

    private Onibus onibus;

    @Before
    public void setup() {
        onibus = new Onibus(1, 50, 2019, "Urbano", "Mercedes-Benz", true);
    }

    @Test
    public void testGetCodigo() {
        int expected = 1;
        int result = onibus.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 2;
        onibus.setCodigo(expected);
        int result = onibus.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCapacidade() {
        int expected = 50;
        int result = onibus.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCapacidade() {
        int expected = 60;
        onibus.setCapacidade(expected);
        int result = onibus.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetAnoFabricacao() {
        int expected = 2019;
        int result = onibus.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetAnoFabricacao() {
        int expected = 2020;
        onibus.setAnoFabricacao(expected);
        int result = onibus.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetTipo() {
        String expected = "Urbano";
        String result = onibus.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTipo() {
        String expected = "Rodoviário";
        onibus.setTipo(expected);
        String result = onibus.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetModelo() {
        String expected = "Mercedes-Benz";
        String result = onibus.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetModelo() {
        String expected = "Scania";
        onibus.setModelo(expected);
        String result = onibus.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsSituacao() {
        boolean expected = true;
        boolean result = onibus.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetSituacao() {
        boolean expected = false;
        onibus.setSituacao(expected);
        boolean result = onibus.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        String expected = "Codigo: 1 Onibus [capacidade=50, anoFabricacao=2019, tipo=Urbano, modelo=Mercedes-Benz, situacao=true]";
        String result = onibus.toString();
        Assert.assertEquals(expected, result);
    }
}
