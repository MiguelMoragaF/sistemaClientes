package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.CategoriaEnum;
import modelo.Cliente;

//Crea la clase ArchivoServicio que extiende de Exportador
public class ArchivoServicio extends Exportador {
	Scanner scanner = new Scanner(System.in);
	
	// Requisitos:
	// Crea método cargarDatos
	public List<Cliente> cargarDatos(String fileName1) { // Recibe por parámetro un String fileName
		// String fileName indica el nombre del archivo a cargar.
		
		// Implementaciones correspondientes
		List<Cliente> listaClientes = new ArrayList<Cliente>(); 
		String ruta = scanner.nextLine();
		String archivo = ruta + File.separator + fileName1;

		// Uso de FileReader y BufferedReader (para lectura de archivos)
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(new File(archivo));
			br = new BufferedReader(fr);
			String linea; 
			while ((linea = br.readLine()) != null) {
				String[] valores = linea.split(","); 
				CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO; 
				Cliente cliente = new Cliente(valores[0], valores[1], valores[2], valores[3], nombreCategoria);  
				listaClientes.add(cliente); 
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se a logrado cargar el archivo - favor reintentar" + e.toString());
		} finally {
			try {
			} catch (Exception error) {
				System.out.println("No se a logrado crear el archivo - favor reintentar");
			}
		}
		return listaClientes;
	}



	// Crea metodo exportar
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// Mismos parámetros

		// Exportar la lista de productos en un archivo .txt
		if (listaClientes == null) {
			System.out.println("Lista ahun está vacía");
		} else {
			System.out.println("Exportar Datos\n"
								+ "Ingresar ruta donde se exportara archivo clientes.txt: ");
			String ruta = scanner.nextLine();
			String archivo = ruta + "/" + fileName;
			File fl = new File(archivo);
			if (fl.exists()) {
				fl.delete();
			}

			try {
				PrintWriter pWriter = new PrintWriter(new FileWriter(archivo));
				listaClientes.forEach(cliente -> {
					pWriter.append("-------------Datos del Cliente-------------\n");
					pWriter.append("RUN del Cliente: " + cliente.getRunCliente() + "\n");
					pWriter.append("Apellido del Cliente: " + cliente.getNombreCliente() + "\n");
					pWriter.append("Apellido del Cliente: " + cliente.getApellidoCliente() + "\n");
					pWriter.append("Años como Cliente: " + cliente.getAniosCliente() + "\n");
					pWriter.append("Categoría del Cliente: " + cliente.getNombreCategoria() + "\n");
					pWriter.append("-------------------------------------------\n"); 
				});
				pWriter.close();
				System.out.println("Cliente(s) exportado(s) correctamente");
			} catch (IOException error) {
				System.out.println("Error al crear el archivo - Favor intente nuevamente");
			} finally {
				System.out.println("-------------------------------------------\n");
			}
		}
	}
}