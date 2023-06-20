import model.Modal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModalTeste {
    private Modal modal;

    @BeforeEach
    void setUp() {
        modal = new Modal();
    }

    @Test
    void testGetCodigo() {
        modal.setCodigo(1);
        Assertions.assertEquals(1, modal.getCodigo());
    }

    @Test
    void testSetCodigo() {
        modal.setCodigo(1);
        Assertions.assertEquals(1, modal.getCodigo());
    }

    @Test
    void testGetCapacidade() {
        modal.setCapacidade(100);
        Assertions.assertEquals(100, modal.getCapacidade());
    }

    @Test
    void testSetCapacidade() {
        modal.setCapacidade(100);
        Assertions.assertEquals(100, modal.getCapacidade());
    }

    @Test
    void testGetAnoFabricacao() {
        modal.setAnoFabricacao(2021);
        Assertions.assertEquals(2021, modal.getAnoFabricacao());
    }

    @Test
    void testSetAnoFabricacao() {
        modal.setAnoFabricacao(2021);
        Assertions.assertEquals(2021, modal.getAnoFabricacao());
    }

    @Test
    void testGetTipo() {
        modal.setTipo("Avião");
        Assertions.assertEquals("Avião", modal.getTipo());
    }

    @Test
    void testSetTipo() {
        modal.setTipo("Avião");
        Assertions.assertEquals("Avião", modal.getTipo());
    }

    @Test
    void testGetModelo() {
        modal.setModelo("Boeing 747");
        Assertions.assertEquals("Boeing 747", modal.getModelo());
    }

    @Test
    void testSetModelo() {
        modal.setModelo("Boeing 747");
        Assertions.assertEquals("Boeing 747", modal.getModelo());
    }

    @Test
    void testIsSituacao() {
        modal.setSituacao(true);
        Assertions.assertTrue(modal.isSituacao());
    }

    @Test
    void testSetSituacao() {
        modal.setSituacao(true);
        Assertions.assertTrue(modal.isSituacao());
    }

    @Test
    void testGetQtdPessoas() {
        modal.setQtdPessoas(200);
        Assertions.assertEquals(200, modal.getQtdPessoas());
    }

    @Test
    void testSetQtdPessoas() {
        modal.setQtdPessoas(200);
        Assertions.assertEquals(200, modal.getQtdPessoas());
    }

    // ... demais testes para os métodos da classe Modal
}
