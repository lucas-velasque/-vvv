import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Trem;

public class TremTeste {

    private Trem trem;

    @Before
    public void setup() {
        trem = new Trem(1, 300, 2010, "Passageiro", "VLT", true);
    }

    @Test
    public void testGetCodigo() {
        int expected = 1;
        int result = trem.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 2;
        trem.setCodigo(expected);
        int result = trem.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCapacidade() {
        int expected = 300;
        int result = trem.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCapacidade() {
        int expected = 400;
        trem.setCapacidade(expected);
        int result = trem.getCapacidade();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetAnoFabricacao() {
        int expected = 2010;
        int result = trem.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetAnoFabricacao() {
        int expected = 2015;
        trem.setAnoFabricacao(expected);
        int result = trem.getAnoFabricacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetTipo() {
        String expected = "Passageiro";
        String result = trem.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetTipo() {
        String expected = "Carga";
        trem.setTipo(expected);
        String result = trem.getTipo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetModelo() {
        String expected = "VLT";
        String result = trem.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetModelo() {
        String expected = "Trem-Bala";
        trem.setModelo(expected);
        String result = trem.getModelo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsSituacao() {
        boolean expected = true;
        boolean result = trem.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetSituacao() {
        boolean expected = false;
        trem.setSituacao(expected);
        boolean result = trem.isSituacao();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        String expected = "Codigo: 1 Trem [capacidade=300, anoFabricacao=2010, tipo=Passageiro, modelo=VLT, situacao=true]";
        String result = trem.toString();
        Assert.assertEquals(expected, result);
    }
}
