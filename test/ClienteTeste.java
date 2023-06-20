import model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTeste {
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNome("John Doe");
        cliente.setSenha("password");
        cliente.setProfissao("Developer");
        cliente.setCpf(123456789);
        cliente.setTelefone(987654321);
        cliente.setEndereco("123 Main St");
        cliente.setLogin("johndoe");
        cliente.setCodClient("ABC123");
        cliente.setTipoPagamento("Crédito");
    }

    @Test
    void testSalvar() {
        Cliente cliente = new Cliente();

        Assertions.assertDoesNotThrow(() -> {
            cliente.cadastrarCliente(cliente);
        });
    }

    @Test
    void testAuth() {
        Cliente cliente = new Cliente();

        Assertions.assertTrue(cliente.authCliente(cliente));
    }

    @Test
    void testCodCliente() {
        String codCliente = cliente.codCliente();

        Assertions.assertNotNull(codCliente);
        Assertions.assertEquals(8, codCliente.length());
    }

    // Teste dos getters e setters

    @Test
    void testGetNome() {
        Assertions.assertEquals("John Doe", cliente.getNome());
    }

    @Test
    void testSetNome() {
        cliente.setNome("Jane Doe");
        Assertions.assertEquals("Jane Doe", cliente.getNome());
    }

    // Teste dos demais getters e setters

    // ... demais testes para os getters e setters

    // Testes para os métodos de reserva, pagamento, etc.

    // ... demais testes para os métodos de reserva, pagamento, etc.
}
