package test;

import static org.junit.Assert.assertEquals;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

//@DisplayName("Tests Clase ClienteServicio")
public class ClienteServicioTest {
	private static Logger logger = Logger.getLogger("test.servicio.ClienteServicioTest"); 
	//private final ClienteServicio clienteServicio = new ClienteServicio(); 

	private ClienteServicio servicio;  
	
	@Before
	public void setup() {
		servicio = new ClienteServicio(); 
	}
	
	// Pruebas unitarias clase ClienteServicio
	// Crea Método agrearClienteTest (verifica funcionamiento de agregarCliente)
	@Test
	public void agregarClienteTest() {
		logger.info("info agregar cliente");
		Cliente unCliente = new Cliente("11.111.111-1", "Luis", "Jara", "9", CategoriaEnum.ACTIVO); 
		String respuestaServicio = servicio.agregarCliente(unCliente);
		assertEquals("a sido agragado", respuestaServicio); 
	}
	
	// Crea Método agrearClienteNullTest para verificar el funcionamiento en en casos nulos
	@Test
	public void agrearClienteNullTest() {
		logger.info("info agregar cliente");
		Cliente ClienteNull = null; 
		String respuestaServicio = servicio.agregarCliente(ClienteNull);
		assertEquals("a sido agragado", respuestaServicio); 
	}
	
	@Test
	public void testClienteServicio() {
	}
	@Test
	public void testClienteServicioListOfCliente() {
	}
	@Test
	public void testListarClientes() {
	}
	@Test
	public void testAgregarClienteStringStringStringStringCategoriaEnum() {
	}
	@Test
	public void testEditarClienteStringStringStringStringCategoriaEnum() {
	}
	@Test
	public void testGetListaClientes() {
	}
	@Test
	public void testSetListaClientes() {
	}
	@Test
	public void testEditarClienteCliente() {
	}
	@Test
	public void testAgregarClienteCliente() {
	}
}