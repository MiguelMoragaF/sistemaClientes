package utilidades;

// Crea la clase Utilidad
public class Utilidad {

	// Crea método reutilizable para manu 
	//limpiar pantalla
	public static void limpiarPantalla() {
		for (int i=0; i<20; i++) {
			System.out.println(""); 
		}
		System.out.flush();
	}
	
	// Crea método reutilizable para mostrar mensajes (imprimir una linea)
	public void printLine(String mensaje) {
		System.out.println(mensaje); 
	}
	
	public static void stopAndContinue() {
		// Llama a los metodos limpiezaDePantalla y tiempoDeEspera
		tiempoDeEspera();
		limpiarPantalla();
	}

	// Crea metodo tiempoDeEspera
	public static void tiempoDeEspera() {
		int tiempoEspera = 10;
		try {
			for (int i = 0; i < tiempoEspera; i++)
				Thread.sleep(150);
		} catch (InterruptedException ie) {
			System.out.println("Tiempo de espera interrumpido");
		}
	}
}