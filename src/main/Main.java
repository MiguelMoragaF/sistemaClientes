// Por Miguel Moraga
// Fecha: 11/01/2022
// Versi�n: 1.3

/*Descripci�n:  la pasteler�a �Bon Bon Jovi� pide crear un software, 
 * donde pueda tener un control de sus clientes, 
 * evitando as� que vayan a su local rival �Dominic Completto�*/

package main;

import vista.Menu;

// Crear la clase Main
public class Main {

	// Crea m�todo public static void main
	public static void main(String[] args) {

	// Instancia para iniciar el men�
		Menu menu = new Menu();
		menu.iniciarMenu(); // Inicia men�
	}
}