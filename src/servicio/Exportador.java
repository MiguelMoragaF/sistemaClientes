package servicio;

import java.util.List;
import modelo.Cliente;

// Crea clase abstracta Exportador
public abstract class Exportador {
	
	// Crea m�todo abstracto para exportar 
	public abstract void exportar (String fileName, List<Cliente>listaClientes); //
	// Par�metros String fileName y List<Cliente> listaClientes
}
