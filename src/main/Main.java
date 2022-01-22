// Por Miguel Moraga
// Fecha: 11/01/2022
// Versión: 1.3

/*Descripción:  la pastelería “Bon Bon Jovi” pide crear un software, 
 * donde pueda tener un control de sus clientes, 
 * evitando así que vayan a su local rival “Dominic Completto”*/

package main;

import vista.Menu;

// Crear la clase Main
public class Main {

	// Crea método public static void main
	public static void main(String[] args) {

	// Instancia para iniciar el menú
		Menu menu = new Menu();
		menu.iniciarMenu(); // Inicia menú
	}
}