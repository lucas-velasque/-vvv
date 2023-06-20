import model.Funcionario;
import model.PontoDeVenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PontoDeVendaTeste {
    private PontoDeVenda pontoDeVenda;

    @BeforeEach
    void setUp() {
        pontoDeVenda = new PontoDeVenda();
        pontoDeVenda.setCodigo(1);
        pontoDeVenda.setNome("Loja A");
        pontoDeVenda.setCnpj("123456789");
        pontoDeVenda.setEndereco("123 Main St");
        pontoDeVenda.setTelefone(987654321);
        pontoDeVenda.setFuncionario(new ArrayList<>());
    }

    @Test
    void testGetCodigo() {
        Assertions.assertEquals(1, pontoDeVenda.getCodigo());
    }

    @Test
    void testSetCodigo() {
        pontoDeVenda.setCodigo(2);
        Assertions.assertEquals(2, pontoDeVenda.getCodigo());
    }

    // Testes para os demais getters e setters

    // ... demais testes para os getters e setters

    @Test
    void testAdicionarFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(1);
        funcionario.setNome("John Doe");
        funcionario.setEndereco("123 Main St");

        pontoDeVenda.adicionarFuncionario(funcionario);

        List<Funcionario> funcionarios = pontoDeVenda.getFuncionario();
        Assertions.assertEquals(1, funcionarios.size());
        Assertions.assertEquals("John Doe", funcionarios.get(0).getNome());
    }

    @Test
    void testRemoverFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setCodigo(1);
        funcionario.setNome("John Doe");
        funcionario.setEndereco("123 Main St");

        pontoDeVenda.adicionarFuncionario(funcionario);
        pontoDeVenda.removerFuncionario(funcionario);

        List<Funcionario> funcionarios = pontoDeVenda.getFuncionario();
        Assertions.assertEquals(0, funcionarios.size());
    }

    // ... demais testes para os métodos de adicionar e remover funcionários
}
