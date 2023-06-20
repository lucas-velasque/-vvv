import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Cidade;

public class CidadeTeste {

    private Cidade cidade;

    @Before
    public void setup() {
        cidade = new Cidade("Rio de Janeiro", 1, "RJ");
    }

    @Test
    public void testGetNome() {
        String expected = "São Paulo";
        String result = cidade.getNome();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetNome() {
        String expected = "Rio de Janeiro";
        cidade.setNome(expected);
        String result = cidade.getNome();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCodigo() {
        int expected = 1;
        int result = cidade.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 2;
        cidade.setCodigo(expected);
        int result = cidade.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetIdentificador() {
        String expected = "SP";
        String result = cidade.getIdentificador();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetIdentificador() {
        String expected = "RJ";
        cidade.setIdentificador(expected);
        String result = cidade.getIdentificador();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        String expected = "Cidade{" +
                "nome='São Paulo', " +
                "codigo=1, " +
                "identificador='SP'}";
        String result = cidade.toString();
        Assert.assertEquals(expected, result);
    }
}
