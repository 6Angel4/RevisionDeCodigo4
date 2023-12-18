package rev_code_4;

/**
 * 	Cambios:
 * 
 * 	1- No utilice Scanner, porque no se me hace llamativo, en su lugar utilice JOptionPane, para que se genere
 * 	un cuadro de dialogo.
 * 	2- Hice unas que las opciones a ingresar de los jugadores sean numeros y constantes. Esto para facilitar la
 * 	entrada de los datos y las comparaciones para la logica del juego.
 * 	3- Puse scores de los jugadores y un contador para los intentos de inicio de juego
 * 	4- En el codigo original se usa un if y un switch (no recuerdo xd), en este caso utilice un ciclo do-while y
 * 	dentro de este hice uso de condicionales if, else y else-if para el ingreso a las opciones.
 * 	5- Esto se puede mejorar creando metodos para ciertas cosas, haciendo mas legible el codigo
 * 	6- Hice uso de outputs en consola, solo para saber que esta pasando.
 * 	
 *
 */

import javax.swing.JOptionPane;

public class Codigo4 {
	// Constantes para representar las opciones del juego
	static final int PIEDRA = 1;
	static final int PAPEL = 2;
	static final int TIJERA = 3;

	// Puntuación de los jugadores
	static int scoreJ1 = 0;
	static int scoreJ2 = 0;
	static int contador = 0; // Contador de intentos

	public static void main(String[] args) {
		// Mensaje de bienvenida
		JOptionPane.showMessageDialog(null, "Bienvenido al Juego\n" + "Piedra, Papel o Tijera");

		// Menú de opciones
		int opcionMenu = Integer
				.parseInt(JOptionPane.showInputDialog("Ingresa:\n" + "1) Jugar\n" + "2) Salir del Juego"));

		do {
			if (opcionMenu >= 3 || opcionMenu < 1) {
				contador += 1;
				// Mensaje de error y solicitud de opción válida
				opcionMenu = Integer.parseInt(JOptionPane
						.showInputDialog("Ingresa una opcion valida:\n" + "(Al tercer intento se cerrara el juego)"));
			} else if (opcionMenu == 1) {
				// Lógica del juego
				JOptionPane.showMessageDialog(null,
						"Reglas:\n" + "Cada Jugador debera de escoger su opcion a tirar, es decir:\n"
								+ "1 - para seleccionar PIEDRA\n" + "2 - para seleccionar PAPEL\n"
								+ "3 - para seleccionar TIJERA\n"
								+ "En caso de ya no querer jugar presionen 4 ambos jugadores");

				// Obtener las opciones de los jugadores
				int opcionJ1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu tirada J1: "));
				int opcionJ2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu tirada J2: "));

				if (opcionJ1 > 4 && opcionJ2 > 4 || opcionJ1 < 1 && opcionJ2 < 1) {
					JOptionPane.showMessageDialog(null, "Vuelvan a ingresar sus tiradas");
					opcionJ1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu tirada J1: "));
					opcionJ2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu tirada J2: "));
				} else if (opcionJ1 == 4 && opcionJ2 == 4) {
					// Ambos jugadores eligen salir del juego
					JOptionPane.showMessageDialog(null,
							"Adios\n Puntuacion\n" + "J1:" + scoreJ1 + " | " + "J2:" + scoreJ2);
					System.exit(1);
				} else if (opcionJ1 == opcionJ2) {
					// Empate
					JOptionPane.showMessageDialog(null,
							"Empate!\n" + "Puntuacion\n" + "J1:" + scoreJ1 + " | " + "J2:" + scoreJ2);
				} else if (opcionJ1 == 1 && opcionJ2 == 3 || opcionJ1 == 2 && opcionJ2 == 1
						|| opcionJ1 == 3 && opcionJ2 == 2) {
					// Jugador 1 gana
					JOptionPane.showMessageDialog(null, "Gana J1");
					scoreJ1 += 1;
				} else if (opcionJ2 == 1 && opcionJ1 == 3 || opcionJ2 == 2 && opcionJ1 == 1
						|| opcionJ2 == 3 && opcionJ1 == 2) {
					// Jugador 2 gana
					JOptionPane.showMessageDialog(null, "Gana J2");
					scoreJ2 += 1;
				}
				System.out.println("J1:" + opcionJ1 + " | " + "J2:" + opcionJ2);
			} else if (opcionMenu == 2) {
				// Mensaje de despedida y puntuación
				JOptionPane.showMessageDialog(null, "Adios\n Puntuacion\n" + "J1:" + scoreJ1 + " | " + "J2:" + scoreJ2);
				System.exit(1);
			}

			// Mostrar el número de intentos (para salir en caso de que el usuario coloque inputs erroneos)
			System.out.println("Contador " + contador);
			System.out.println();
		} while (contador != 3);
	}
}
