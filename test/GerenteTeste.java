import model.Funcionario;
import model.Gerente;
import model.PontoDeVenda;
import model.Reserva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GerenteTeste {
    private Gerente gerente;
    private PontoDeVenda pontoDeVenda;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        pontoDeVenda = new PontoDeVenda();
        pontoDeVenda.setCodigo(1);
        pontoDeVenda.setNome("Loja A");

        gerente = new Gerente();
        gerente.setCodigo(1);
        gerente.setNome("John Doe");
        gerente.setEndereco("123 Main St");
        gerente.setPontoDeVenda(pontoDeVenda);

        funcionario = new Funcionario();
        funcionario.setCodigo(2);
        funcionario.setNome("Jane Smith");
        funcionario.setEndereco("456 Elm St");
    }

    @Test
    void testGetPontoDeVenda() {
        Assertions.assertEquals(pontoDeVenda, gerente.getPontoDeVenda());
    }

    @Test
    void testSetPontoDeVenda() {
        PontoDeVenda novoPontoDeVenda = new PontoDeVenda();
        novoPontoDeVenda.setCodigo(2);
        novoPontoDeVenda.setNome("Loja B");

        gerente.setPontoDeVenda(novoPontoDeVenda);

        Assertions.assertEquals(novoPontoDeVenda, gerente.getPontoDeVenda());
    }

    @Test
    void testAprovarVenda() {
        Reserva reserva = new Reserva();
        reserva.setStatus(false);
        gerente.setReserva(reserva);

        gerente.aprovarVenda();

        Assertions.assertTrue(reserva.isStatus());
    }

    @Test
    void testDesaprovarVenda() {
        Reserva reserva = new Reserva();
        reserva.setStatus(true);
        gerente.setReserva(reserva);

        gerente.desaprovarVenda();

        Assertions.assertFalse(reserva.isStatus());
    }

    @Test
    void testAlocarFuncionario() {
        gerente.alocarFuncionario(funcionario);

        Assertions.assertEquals(1, pontoDeVenda.getFuncionario().size());
        Assertions.assertEquals(funcionario, pontoDeVenda.getFuncionario().get(0));
    }

    @Test
    void testDesalocarFuncionario() {
        gerente.alocarFuncionario(funcionario);
        gerente.desalocarFuncionario(funcionario);

        Assertions.assertEquals(0, pontoDeVenda.getFuncionario().size());
    }

    // ... demais testes para os métodos da classe Gerente
}
