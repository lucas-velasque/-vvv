import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Cliente;
import model.Pagamento;

public class PagamentoTeste {

    private Pagamento pagamento;
    private Cliente cliente;

    @Before
    public void setup() {
        cliente = new Cliente("João", "123456789");
        pagamento = new Pagamento(1, 100.0f, 1, true);
        pagamento.setCliente(cliente);
    }

    @Test
    public void testGetCodigo() {
        int expected = 1;
        int result = pagamento.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 2;
        pagamento.setCodigo(expected);
        int result = pagamento.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetValor() {
        float expected = 100.0f;
        float result = pagamento.getValor();
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void testSetValor() {
        float expected = 200.0f;
        pagamento.setValor(expected);
        float result = pagamento.getValor();
        Assert.assertEquals(expected, result, 0.001);
    }

    @Test
    public void testGetQtdParcelas() {
        int expected = 1;
        int result = pagamento.getQtdParcelas();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetQtdParcelas() {
        int expected = 2;
        pagamento.setQtdParcelas(expected);
        int result = pagamento.getQtdParcelas();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsStatus() {
        boolean expected = true;
        boolean result = pagamento.isStatus();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetStatus() {
        boolean expected = false;
        pagamento.setStatus(expected);
        boolean result = pagamento.isStatus();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsAprovado() {
        boolean expected = false;
        boolean result = pagamento.isAprovado();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetAprovado() {
        boolean expected = true;
        pagamento.setAprovado(expected);
        boolean result = pagamento.isAprovado();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testVerificarPagamento() {
        int expected = 1;
        int result = pagamento.verificarPagamento();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testProcessarPagamento() {
        Pagamento expected = pagamento;
        Pagamento result = pagamento.processarPagamento(pagamento);
        Assert.assertEquals(expected, result);
    }
}

