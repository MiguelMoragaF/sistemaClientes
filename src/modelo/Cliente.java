package modelo;

// Crea la clase Cliente en package modelo
public class Cliente {

	// Requisitos
	private String runCliente, nombreCliente, apellidoCliente, aniosCliente; 
	private CategoriaEnum nombreCategoria;
	
	// Genera constructor con párametros
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}

	// Genera getter y setter correspondientes
	public String getRunCliente() {
		return runCliente;
	}
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getAniosCliente() {
		return aniosCliente;
	}
	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}
	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	// Genera toString para los parámetros
	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria + "]";
	}		
}
