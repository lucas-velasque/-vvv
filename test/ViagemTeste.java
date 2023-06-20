import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import model.Viagem;
import model.Cidade;

public class ViagemTeste {

    private Viagem viagem;
    private Cidade cidadeOrigem;
    private Cidade cidadeDestino;

    @Before
    public void setup() {
        cidadeOrigem = new Cidade("Origem", "OR");
        cidadeDestino = new Cidade("Destino", "DE");
        viagem = new Viagem(123, cidadeOrigem, cidadeDestino, true, false);
    }

    @Test
    public void testGetCodigo() {
        int expected = 123;
        int result = viagem.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCodigo() {
        int expected = 456;
        viagem.setCodigo(expected);
        int result = viagem.getCodigo();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCidadeOrigem() {
        Cidade expected = cidadeOrigem;
        Cidade result = viagem.getCidadeOrigem();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCidadeOrigem() {
        Cidade expected = new Cidade("Nova Origem", "NO");
        viagem.setCidadeOrigem(expected);
        Cidade result = viagem.getCidadeOrigem();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCidadeDestino() {
        Cidade expected = cidadeDestino;
        Cidade result = viagem.getCidadeDestino();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCidadeDestino() {
        Cidade expected = new Cidade("Novo Destino", "ND");
        viagem.setCidadeDestino(expected);
        Cidade result = viagem.getCidadeDestino();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsViagemDireta() {
        boolean expected = true;
        boolean result = viagem.isViagemDireta();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetViagemDireta() {
        boolean expected = false;
        viagem.setViagemDireta(expected);
        boolean result = viagem.isViagemDireta();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testIsViagemEscala() {
        boolean expected = false;
        boolean result = viagem.isViagemEscala();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetViagemEscala() {
        boolean expected = true;
        viagem.setViagemEscala(expected);
        boolean result = viagem.isViagemEscala();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCliente() {
        Cliente expected = null;
        Cliente result = viagem.getCliente();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetCliente() {
        Cliente expected = new Cliente("João", "123456789");
        viagem.setCliente(expected);
        Cliente result = viagem.getCliente();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetReserva() {
        Reserva expected = null;
        Reserva result = viagem.getReserva();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetReserva() {
        Reserva expected = new Reserva(789, "Econômica");
        viagem.setReserva(expected);
        Reserva result = viagem.getReserva();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetModais() {
        List<Modal> expected = new ArrayList<>();
        List<Modal> result = viagem.getModais();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testSetModais() {
        List<Modal> expected = new ArrayList<>();
        expected.add(new Modal(1, 100, 2022, "Avião", "Boeing 747", true));
        expected.add(new Modal(2, 50, 2021, "Trem", "Expresso", true));
        viagem.setModais(expected);
        List<Modal> result = viagem.getModais();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMostrarRoteiro() {
        String expected = "Cidade de origem: Origem OR\nCidade de destino: Destino DE";
        String result = viagem.mostrarRoteiro();
        Assert.assertEquals(expected, result);
    }
}
