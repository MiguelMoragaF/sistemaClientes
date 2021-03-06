package servicio;

import modelo.CategoriaEnum;
import modelo.Cliente;

// Declaración de intereses
public interface clienteServicioInterface {
	
	void listarClientes(); 
	void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum activo); 
	void editarCliente(Cliente cliente);
}