/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo10_historialdenavegacion;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Grupo10_HistorialDeNavegacion {

    public static void main(String[] args) {
        historialNavegacion();
    }

    public static void historialNavegacion() {
        Stack<String> atras = new Stack<>();
        Stack<String> adelante = new Stack<>();
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        String URL = "";

        while (opcion != 4) {
            try {
                System.out.println(" --- OPCIONES --- ");
                System.out.println(" 1 - Visitar una nueva página web");
                System.out.println(" 2 - Retroceder");
                System.out.println(" 3 - Avanzar");
                System.out.println(" 4 - Salir");
                System.out.print("Seleccione una opción: ");
                opcion = leer.nextInt();
                leer.nextLine(); // limpiar buffer
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción válida");
                leer.nextLine(); // limpiar entrada inválida
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la URL de la página que desea visitar...");
                    URL = leer.nextLine();
                    atras.push(URL);
                    System.out.println("URL ACTUAL: " + atras.peek());
                    adelante.clear();
                    break;

                case 2:
                    if (atras.size() <= 1) {
                        System.out.println("No hay página a la que puedas retroceder");
                    } else {
                        System.out.println("Retrocediendo...");
                        adelante.push(atras.pop());
                        System.out.println("URL ACTUAL: " + atras.peek());
                    }
                    break;

                case 3:
                    if (adelante.isEmpty()) {
                        System.out.println("No hay página a la que puedas avanzar");
                    } else {
                        System.out.println("Avanzando...");
                        atras.push(adelante.pop());
                        System.out.println("URL ACTUAL: " + atras.peek());
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del historial de navegación...");
                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }
}
