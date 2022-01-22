package servicio;

import java.util.List;
import modelo.Cliente;

// Crea clase abstracta Exportador
public abstract class Exportador {
	
	// Crea método abstracto para exportar 
	public abstract void exportar (String fileName, List<Cliente>listaClientes); //
	// Parámetros String fileName y List<Cliente> listaClientes
}
