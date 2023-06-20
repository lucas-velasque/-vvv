import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Aviao;

public class AviaoTeste {

    private Aviao aviao;

    @Before
    public void setup() {
        aviao = new Aviao(1, 200, 2018, "Comercial", "Boeing 747", true);
    }

    @Test
    public void testGetCodigo() {
        int expected = 1;
        int result = aviao.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 2;
        aviao.setCodigo(expected);
        int result = aviao.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCapacidade() {
        int expected = 200;
        int result = aviao.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCapacidade() {
        int expected = 250;
        aviao.setCapacidade(expected);
        int result = aviao.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetAnoFabricacao() {
        int expected = 2018;
        int result = aviao.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetAnoFabricacao() {
        int expected = 2020;
        aviao.setAnoFabricacao(expected);
        int result = aviao.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetTipo() {
        String expected = "Comercial";
        String result = aviao.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTipo() {
        String expected = "Cargueiro";
        aviao.setTipo(expected);
        String result = aviao.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetModelo() {
        String expected = "Boeing 747";
        String result = aviao.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetModelo() {
        String expected = "Airbus A380";
        aviao.setModelo(expected);
        String result = aviao.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsSituacao() {
        boolean expected = true;
        boolean result = aviao.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetSituacao() {
        boolean expected = false;
        aviao.setSituacao(expected);
        boolean result = aviao.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        String expected = "Codigo: 1 Aviao [capacidade=200, anoFabricacao=2018, tipo=Comercial, modelo=Boeing 747, situacao=true]";
        String result = aviao.toString();
        Assert.assertEquals(expected, result);
    }
}
