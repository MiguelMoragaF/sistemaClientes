package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;

// Crea clase ExportadorCsv que extiende de Exportador
public class ExportadorCsv extends Exportador {
	Scanner scanner = new Scanner(System.in);
	
	// Crea metodo exportar
	@Override
	public void exportar(String fileName1, List<Cliente> listaClientes) {
		// par?metros String fileName y una List<Cliente> listaClientes

		// Implementaciones correspondientes
		// Exportar la lista de clientes en un archivo .csv
		if (listaClientes == null) {
			System.out.println("Lista ahun esta vacia");
		} else {
			System.out.println("---------Exportar Datos en Windows---------------\n" + 
								"Ingresa la ruta en donde desea exportar el archivo clientes.csv: ");
			String ruta = scanner.nextLine();
			String archivo = ruta + "/" + fileName1;
			File fl = new File(archivo);
			if (fl.exists()) {
				fl.delete();
			}

			try {
				// Uso de PrintWriter y Filewriter para la exportaci?n de archivos
				PrintWriter pWriter = new PrintWriter(new FileWriter(archivo));
				listaClientes.forEach(cliente -> {
					pWriter.append("-------------Datos del Cliente-------------\n");
					pWriter.append("RUN del Cliente: " + cliente.getRunCliente() + "\n");
					pWriter.append("Apellido del Cliente: " + cliente.getNombreCliente() + "\n");
					pWriter.append("Apellido del Cliente: " + cliente.getApellidoCliente() + "\n");
					pWriter.append("A?os como Cliente: " + cliente.getAniosCliente() + "\n");
					pWriter.append("Categor?a del Cliente: " + cliente.getNombreCategoria() + "\n");
					pWriter.append("-------------------------------------------\n");
				});
				pWriter.close();
				System.out.println("Datos de clientes exportados correctamente en formato csv.");
			} catch (IOException error) {
				System.out.println("Error al crear el archivo - Favor intente nuevamente");
			} finally {
				System.out.println("-------------------------------------------\n");
			}
		}
	}
}