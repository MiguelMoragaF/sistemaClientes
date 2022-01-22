package vista;

import servicio.ClienteServicio;
import servicio.ArchivoServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import java.util.Scanner;
import utilidades.Utilidad;
import java.util.List;
import modelo.CategoriaEnum;
import modelo.Cliente;

// Crea la clase Menu
public class Menu {

	// Atributos:
	// clienteServicio, instancia de ClienteServicio
	ClienteServicio clienteServicio = new ClienteServicio();
	// archivoServicio, instancia de ArchivoServicio.
	ArchivoServicio archivoServicio = new ArchivoServicio();
	// exportadorCsv, instancia de ExportarCsv
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	// exportarTxt, instancia de ExportarTxt
	ExportadorTxt exportarTxt = new ExportadorTxt(); 

	// Define String para exportar el archivo
	String fileName = "Clientes";
	// Define String para importar el archivo
	String fileName1 = "DBClientes.csv";

	// scanner, instancia de Scanner para recibir valores a través de teclado
	protected Scanner scanner = new Scanner(System.in);

	// iniciarMenu, muestra el menu principal
	public final void iniciarMenu() { // no se sobreescribe iniciarMenu
		// Contiene implementación al inicio de la clase para formar el menú
		System.out.println("1. Listar Cliente\n" + 
							"2. Agregar Cliente\n" + 
							"3. Editar Cliente\n" + 
							"4. Cargar Datos\n" + 
							"5. Exportar Datos\n" + 
							"6. Salir"); 
		System.out.println("Ingrese una opción: \n");
		// Recibe entrada de teclado a través scanner
		String selecion = scanner.nextLine();

		// Lógica para denotar los demás métodos en base a la entrada del teclado
		switch (selecion) { // Métodos para la construcción y selección del menu:
		case "1": // listarCliente
			listarClientes();
			break;
		case "2": // agregarCliente
			agregarCliente();
			break;
		case "3": // editarCliente
			editarCliente();
			break;
		case "4": // importarDatos
			cargarDatos();
			break;
		case "5": // exportarDatos
			exportarDatos();
			break;
		case "6": // terminarPrograma
			terminarPrograma();
		default:
			System.out.println("Opción no valida - favor reintetar");
		}
		Utilidad.limpiarPantalla();
		// Muestra menu principal y recibe entrada de teclado para derivar a demas metodos
		iniciarMenu();
	}
	
	// Implementación de métodos nombrados previamente
	// listarClientes, muestra lista de clientes agregados (por importación o agregando a mano)
	private void listarClientes() {
		clienteServicio.listarClientes();
		Utilidad.stopAndContinue();
	}

	// agregarCliente, solicita ingreso de datos y llena objeto de tipo Cliente
	private void agregarCliente() {
		// Solicita ingreso de datos
		System.out.println("-------------Crear Cliente-------------\n" 
							+ "Ingresa RUN del Cliente: \n");
		String runCliente = scanner.nextLine();
		System.out.println("Ingresa Nombre del Cliente: \n");
		String nombreCliente = scanner.nextLine();
		System.out.println("Ingresa Apellido del Cliente: \n");
		String apellidoCliente = scanner.nextLine();
		System.out.println("Ingresa años como Cliente: \n");
		String aniosCliente = scanner.nextLine();
		System.out.println("---------------------------------------");

		// Llena objeto de tipo Cliente
		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);
		Utilidad.stopAndContinue();
	}

	// editarCliente, permite edición de algún o cambiar el estado del cliente
	private void editarCliente() {
		System.out.println("-------------Editar Cliente-------------\n" + "Seleccione qué desea hacer: \n"
				+ "1.-Cambiar el estado del Cliente\n" + "2.-Editar los datos ingresados del Cliente\n" + "\n"
				+ "Ingrese opcion: \n" + "----------------------------------------");
		int opEditar = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Ingrese RUN del Cliente a editar: ");
		String runEdit = scanner.nextLine();
		List<Cliente> listaClientes = clienteServicio.getListaClientes();
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(runEdit)) {
				if (opEditar == 1) {
					actualizarEstadoCliente(cliente);
				} else if (opEditar == 2) {
					actualizarDatosCliente(cliente);
				}
			}
		}
	}

	// Permite la edición de algún cliente
	private void actualizarDatosCliente(Cliente cliente) {
		System.out.println("----Actualizando datos del Cliente-----\n" + "\n" + 
							"1.-El RUN del Cliente es: " + cliente.getRunCliente() + "\n" + 
							"2.-El Nombre del Cliente es: " + cliente.getNombreCliente() + "\n" + 
							"3.-El Apellido del Cliente es: " + cliente.getApellidoCliente() + "\n"	+ 
							"4.-Los años como Cliente son: " + cliente.getAniosCliente() + " años\n" + "\n"	+ 
							"Ingrese opcion a editar de los datos del cliente: " + "\n" + 
							"----------------------------------------");
		int opCliente = scanner.nextInt();
		scanner.nextLine();
		switch (opCliente) {
		case 1:
			System.out.println("1.-Ingrese nuevo RUN del Cliente: ");
			String runCliente = scanner.nextLine();
			cliente.setRunCliente(runCliente);
			System.out.println("----------------------------------------\n" 
								+ "Datos cambiados con éxito");
			break;
		case 2:
			System.out.println("2.-Ingrese nuevo Nombre del Cliente: ");
			String nombreCliente = scanner.nextLine();
			cliente.setNombreCliente(nombreCliente);
			System.out.println("----------------------------------------\n" 
								+ "Datos cambiados con éxito");
			break;
		case 3:
			System.out.println("3.-Ingrese nuevo Apellido del Cliente: ");
			String apellidoCliente = scanner.nextLine();
			cliente.setApellidoCliente(apellidoCliente);
			System.out.println("----------------------------------------\n" 
								+ "Datos cambiados con éxito");
			break;
		case 4:
			System.out.println("4.-Ingrese nuevo Nombre del Cliente: ");
			String aniosCliente = scanner.nextLine();
			cliente.setAniosCliente(aniosCliente);
			System.out.println("----------------------------------------\n" 
								+ "Datos cambiados con éxito");
			break;
		default:
			System.out.println("Opción invalidad - Favor reintentar");
		}
		Utilidad.stopAndContinue();
	}

	// Para cambiar el estado del cliente.
	private void actualizarEstadoCliente(Cliente cliente) {
		System.out.println("-----Actualizando estado del Cliente----\n" + 
							"El estado actual es: " + cliente.getNombreCategoria() + "\n" + 
							"1.-Si desea cambiar el estado del Cliente a Inactivo\n" + 
							"2.-Si desea mantener el estado del cliente Activo\n" + "\n" + 
							"Ingrese opcion: " + "\n" + 
							"----------------------------------------");
		int opCliente = scanner.nextInt();
		scanner.nextLine();
		switch (opCliente) {
		case 1:
			CategoriaEnum nombreCategoriaInactivo = CategoriaEnum.INACTIVO;
			cliente.setNombreCategoria(nombreCategoriaInactivo);
			System.out.println("----------------------------------------\n" 
								+ "Datos cambiados con éxito");
			break;
		case 2:
			CategoriaEnum nombreCategoriaActivo = CategoriaEnum.ACTIVO;
			cliente.setNombreCategoria(nombreCategoriaActivo);
			System.out.println("----------------------------------------\n" 
								+ "Datos cambiados con éxito");
			break;
		default:
			System.out.println("Opción invalidad - Favor reintentar");
		}
		Utilidad.stopAndContinue();
	}

	// cargarDatos, ejecuta la carga de datos del archivo “DBClientes.csv”
	private void cargarDatos() {
		System.out.println("---------Cargar Datos en Windows---------------\n" + "\n"
							+ "Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: \n");
		List<Cliente> listaClientes = archivoServicio.cargarDatos(fileName1);
		if (listaClientes != null && !listaClientes.isEmpty()) {
			clienteServicio.setListaClientes(listaClientes);
			System.out.println("-----------------------------------------------\n" 
								+ "Datos cargados correctamente en la lista");
			Utilidad.stopAndContinue();
		}
	}

	// exportarDatos, llama método para exportar clientes en formato “.txt” o “.csv”.
	private void exportarDatos() {
		System.out.println("---------Exportar Datos-----------\n" + 
							"Seleccione el formato a exportar: \n" + 
							"1.-Formato csv\n" + 
							"2.-Formato txt\n" + "\n" + 
							"Ingrese una opción para exportar: \n" + 
							"----------------------------------");
		List<Cliente> listaClientes = clienteServicio.getListaClientes();
		int op = scanner.nextInt();
		switch (op) {
		case 1: // En formato “.txt”
			exportadorCsv.exportar(fileName1, listaClientes);
			Utilidad.stopAndContinue();
			break;
		case 2: // En formato “.csv”
			exportarTxt.exportar(fileName + ".txt", listaClientes);
			Utilidad.stopAndContinue();
			break;
		default:
			System.out.println("Opción invalida - Favor reintentar");
		}
	}

	// terminarPrograma, finaliza la ejecución del sistema
	private void terminarPrograma() {
		System.out.println("Abandonando el sistema de clientes...");
		Utilidad.tiempoDeEspera();
		System.out.println("Acaba de salir del sistema");
		Utilidad.stopAndContinue();
		System.exit(0);
	}
}