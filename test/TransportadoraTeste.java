import model.Modal;
import model.Transportadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TransportadoraTeste {
    private Transportadora transportadora;
    private Modal modal1;
    private Modal modal2;

    @BeforeEach
    void setUp() {
        transportadora = new Transportadora();
        modal1 = new Modal(1, 100, 2021, "Avião", "Boeing 747", true);
        modal2 = new Modal(2, 50, 2020, "Caminhão", "Volvo FH", false);
        transportadora.adicionarModal(modal1);
        transportadora.adicionarModal(modal2);
    }

    @Test
    void testGetCodigo() {
        transportadora.setCodigo(1);
        Assertions.assertEquals(1, transportadora.getCodigo());
    }

    @Test
    void testSetCodigo() {
        transportadora.setCodigo(1);
        Assertions.assertEquals(1, transportadora.getCodigo());
    }

    @Test
    void testGetModais() {
        List<Modal> modais = transportadora.getModais();
        Assertions.assertEquals(2, modais.size());
        Assertions.assertTrue(modais.contains(modal1));
        Assertions.assertTrue(modais.contains(modal2));
    }

    @Test
    void testSetModais() {
        List<Modal> modais = new ArrayList<>();
        modais.add(modal1);
        modais.add(modal2);
        transportadora.setModais(modais);
        Assertions.assertEquals(2, transportadora.getModais().size());
        Assertions.assertTrue(transportadora.getModais().contains(modal1));
        Assertions.assertTrue(transportadora.getModais().contains(modal2));
    }

    @Test
    void testAdicionarModal() {
        Modal modal3 = new Modal(3, 80, 2022, "Navio", "Cargueiro", true);
        transportadora.adicionarModal(modal3);
        List<Modal> modais = transportadora.getModais();
        Assertions.assertEquals(3, modais.size());
        Assertions.assertTrue(modais.contains(modal3));
    }

    @Test
    void testRemoverModal() {
        transportadora.removerModal(modal1);
        List<Modal> modais = transportadora.getModais();
        Assertions.assertEquals(1, modais.size());
        Assertions.assertFalse(modais.contains(modal1));
    }

    @Test
    void testRealizarManutencao() {
        transportadora.realizarManutencao(modal1);
        Assertions.assertTrue(modal1.isSituacao());
        transportadora.realizarManutencao(modal2);
        Assertions.assertFalse(modal2.isSituacao());
    }

    @Test
    void testInformarManutencao() {
        String result1 = transportadora.informarManutencao(modal1);
        Assertions.assertEquals("Modal Avião em manutencao!", result1);
        String result2 = transportadora.informarManutencao(modal2);
        Assertions.assertEquals("Modal não encontrado!", result2);
    }

    @Test
    void testVerificarStatusModal() {
        String result1 = transportadora.verificarStatusModal(modal1);
        Assertions.assertEquals("Em manutencao!", result1);
        String result2 = transportadora.verificarStatusModal(modal2);
        Assertions.assertEquals("Funcionando normalmente.", result2);
    }

    // ... demais testes para os métodos da classe Transportadora
}
