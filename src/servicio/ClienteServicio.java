package servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

// Crea la clase ClienteServicio
public class ClienteServicio implements clienteServicioInterface {

	// Crea atributo List<Cliente> listaClientes
	List<Cliente> listaClientes; 
	
	// Genera constructor de ClienteServicio que tiene listaClientes como nueva ArrayList
	public ClienteServicio() {
		listaClientes = new ArrayList<>();
	}
	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	// Genera método público sin valor de retornolistarClientes
	@Override
	public void listarClientes() {
		if (listaClientes != null) {
			// Implementa ciclo para recorrer cada uno de los clientes
			for (Cliente cliente : listaClientes) { 
				System.out.println("-------------Datos del Cliente-------------\n" + "\n" + 
									"RUN del Cliente: " + cliente.getRunCliente() + "\n"	+ 
									"Nombre del Cliente: " + cliente.getNombreCliente() + "\n"	+ 
									"Apellido del Cliente: " + cliente.getApellidoCliente() + "\n"	+ 
									"Años como Cliente: " + cliente.getAniosCliente() + "\n"	+ 
									"Categoría del Cliente: " + cliente.getNombreCategoria() + "\n" +
									"----------------------------------------");
			}
		} else {
			System.out.println("No se puede(n) listar el/los cliente(s) - Sin clientes guardados");
		}
		Utilidad.stopAndContinue();
	}
	
	// Genera public void del método agregarCliente
	@Override
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum activo) { // Pasando parámetros de la clase Cliente
		
		// Guarda clientes en una instancia de cliente
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, activo);
		
		// Agrega nuevo cliente a listaClientes
		if (listaClientes != null) {
			listaClientes.add(cliente);
			// Uso de iteración de la libreria Stream (stream + forEach)
			listaClientes.stream().forEach(System.out::println);
			System.out.println("a sido agragado");
		} else {
		System.out.println("Dato ingresado es invalido - Favor reintentar");
		}
	}
	
	// Genera public void del método editarCliente
		public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum activo) {	// Pasandole parámetros de la clase Cliente
	}
	
	// Crea getter de listaCliente 
	public List<Cliente> getListaClientes() {
		return listaClientes; // Retorna listaClientes
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public void editarCliente(Cliente cliente) {	
	}
	public String agregarCliente(Cliente cliente) { // sobrecarga metodo
		return "a sido agragado";
	}
}