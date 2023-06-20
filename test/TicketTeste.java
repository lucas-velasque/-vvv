import model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTeste {
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket(1, 123456, "12:00", "14:00", "Primeira Classe");
    }

    @Test
    void testGetCodigo() {
        Assertions.assertEquals(1, ticket.getCodigo());
    }

    @Test
    void testSetCodigo() {
        ticket.setCodigo(2);
        Assertions.assertEquals(2, ticket.getCodigo());
    }

    @Test
    void testGetNumero() {
        Assertions.assertEquals(123456, ticket.getNumero());
    }

    @Test
    void testSetNumero() {
        ticket.setNumero(654321);
        Assertions.assertEquals(654321, ticket.getNumero());
    }

    @Test
    void testGetHoraPartida() {
        Assertions.assertEquals("12:00", ticket.getHoraPartida());
    }

    @Test
    void testSetHoraPartida() {
        ticket.setHoraPartida("14:30");
        Assertions.assertEquals("14:30", ticket.getHoraPartida());
    }

    @Test
    void testGetHoraChegada() {
        Assertions.assertEquals("14:00", ticket.getHoraChegada());
    }

    @Test
    void testSetHoraChegada() {
        ticket.setHoraChegada("16:30");
        Assertions.assertEquals("16:30", ticket.getHoraChegada());
    }

    @Test
    void testGetTipoPassagem() {
        Assertions.assertEquals("Primeira Classe", ticket.getTipoPassagem());
    }

    @Test
    void testSetTipoPassagem() {
        ticket.setTipoPassagem("Econômica");
        Assertions.assertEquals("Econômica", ticket.getTipoPassagem());
    }

    @Test
    void testImprimirTicket() {
        String expectedOutput = "Codigo: 1\n" +
                "Numero=123456\n" +
                "Hora de Partida: 12:00\n" +
                "Hora de Chegada: 14:00\n" +
                "Tipo de Passagem: Primeira Classe";
        Assertions.assertEquals(expectedOutput, ticket.imprimirTicket());
    }
}
