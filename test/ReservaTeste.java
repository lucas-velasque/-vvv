import model.Reserva;
import model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTeste {
    private Reserva reserva;

    @BeforeEach
    void setUp() {
        reserva = new Reserva();
    }

    @Test
    void testGetCodigo() {
        reserva.setCodigo(1);
        Assertions.assertEquals(1, reserva.getCodigo());
    }

    @Test
    void testSetCodigo() {
        reserva.setCodigo(1);
        Assertions.assertEquals(1, reserva.getCodigo());
    }

    @Test
    void testGetData() {
        reserva.setData("2023-06-18");
        Assertions.assertEquals("2023-06-18", reserva.getData());
    }

    @Test
    void testSetData() {
        reserva.setData("2023-06-18");
        Assertions.assertEquals("2023-06-18", reserva.getData());
    }

    @Test
    void testGetValor() {
        reserva.setValor(100.0f);
        Assertions.assertEquals(100.0f, reserva.getValor(), 0.001);
    }

    @Test
    void testSetValor() {
        reserva.setValor(100.0f);
        Assertions.assertEquals(100.0f, reserva.getValor(), 0.001);
    }

    @Test
    void testIsStatus() {
        reserva.setStatus(true);
        Assertions.assertTrue(reserva.isStatus());
    }

    @Test
    void testSetStatus() {
        reserva.setStatus(true);
        Assertions.assertTrue(reserva.isStatus());
    }

    @Test
    void testGetTipoPassagem() {
        reserva.setTipoPassagem("Econômica");
        Assertions.assertEquals("Econômica", reserva.getTipoPassagem());
    }

    @Test
    void testSetTipoPassagem() {
        reserva.setTipoPassagem("Econômica");
        Assertions.assertEquals("Econômica", reserva.getTipoPassagem());
    }

    @Test
    void testGetTicket() {
        Ticket ticket = new Ticket();
        reserva.setTicket(ticket);
        Assertions.assertEquals(ticket, reserva.getTicket());
    }

    @Test
    void testSetTicket() {
        Ticket ticket = new Ticket();
        reserva.setTicket(ticket);
        Assertions.assertEquals(ticket, reserva.getTicket());
    }

    @Test
    void testGetNumero() {
        reserva.setNumero(123);
        Assertions.assertEquals(123, reserva.getNumero());
    }

    @Test
    void testSetNumero() {
        reserva.setNumero(123);
        Assertions.assertEquals(123, reserva.getNumero());
    }

    @Test
    void testGetHoraPartida() {
        reserva.setHoraPartida("12:00");
        Assertions.assertEquals("12:00", reserva.getHoraPartida());
    }

    @Test
    void testSetHoraPartida() {
        reserva.setHoraPartida("12:00");
        Assertions.assertEquals("12:00", reserva.getHoraPartida());
    }

    @Test
    void testGetHoraChegada() {
        reserva.setHoraChegada("15:00");
        Assertions.assertEquals("15:00", reserva.getHoraChegada());
    }

    @Test
    void testSetHoraChegada() {
        reserva.setHoraChegada("15:00");
        Assertions.assertEquals("15:00", reserva.getHoraChegada());
    }

    @Test
    void testEmitirTicket() {
        reserva.emitirTicket();

        Assertions.assertNotNull(reserva.getTicket());
        Assertions.assertEquals(reserva.getCodigo(), reserva.getTicket().getCodigo());
        Assertions.assertEquals(reserva.getNumero(), reserva.getTicket().getNumero());
        Assertions.assertEquals(reserva.getHoraPartida(), reserva.getTicket().getHoraPartida());
        Assertions.assertEquals(reserva.getHoraChegada(), reserva.getTicket().getHoraChegada());
        Assertions.assertEquals(reserva.getTipoPassagem(), reserva.getTicket().getTipoPassagem());
    }

    // ... demais testes para os métodos da classe Reserva
}
