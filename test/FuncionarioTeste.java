import model.Cliente;
import model.Funcionario;
import model.Reserva;
import model.Pagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FuncionarioTeste {
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario();
        funcionario.setCodigo(1);
        funcionario.setNome("John Doe");
        funcionario.setEndereco("123 Main St");
        funcionario.setReservas(new ArrayList<>());
    }

    @Test
    void testGetCodigo() {
        Assertions.assertEquals(1, funcionario.getCodigo());
    }

    @Test
    void testSetCodigo() {
        funcionario.setCodigo(2);
        Assertions.assertEquals(2, funcionario.getCodigo());
    }

    // Testes para os demais getters e setters

    // ... demais testes para os getters e setters

    @Test
    void testVenderPassagem() {
        Cliente cliente = new Cliente();
        cliente.setNome("Jane Doe");

        Cliente clienteVendido = funcionario.venderPassagem(cliente);

        Assertions.assertNotNull(clienteVendido);
        Assertions.assertEquals("Jane Doe", clienteVendido.getNome());
    }

    @Test
    void testVerificarPagamento() {
        Cliente cliente = new Cliente();
        cliente.setPagamento(null);

        String resultado = funcionario.verificarPagamento(cliente);

        Assertions.assertEquals("Pagamento não confirmado", resultado);
    }

    @Test
    void testConfirmarReserva() {
        Cliente cliente = new Cliente();
        Reserva reserva = new Reserva();
        cliente.setPagamento(new Pagamento());
        cliente.setReservas(new ArrayList<>());
        cliente.getReservas().add(reserva);

        String resultado = funcionario.confirmarReserva(cliente);

        Assertions.assertEquals("Reserva confirmada!", resultado);
        Assertions.assertTrue(reserva.isStatus());
    }

    // ... demais testes para os métodos de reserva, pagamento, etc.
}
