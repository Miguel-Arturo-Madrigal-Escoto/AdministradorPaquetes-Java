package main;

import java.io.IOException;
import java.util.Scanner;
import domain.*;

public class Menu {

    public static void main(String[] args) throws IOException {
        Paqueteria paqueteria = new Paqueteria();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("1. Agregar paquete");
            System.out.println("2. Eliminar paquete");
            System.out.println("3. Ordenar por origen (ascendente)");
            System.out.println("4. Ordenar peso (descendente)");
            System.out.println("5. Mostrar");
            System.out.println("6. Guardar (archivo)");
            System.out.println("7. Recuperar (archivo)");
            System.out.println("0. Salir");
            System.out.print("-> Elige una opcion: ");
            opcion = scanner.nextLine();

            switch (opcion) {

                case "0":
                    scanner.close();
                    break;

                case "1":
                    int id;
                    String origen, destino;
                    float peso;

                    System.out.println("Ingrese el id: ");
                    id = new Scanner(System.in).nextInt();
                    System.out.println("Ingrese el origen: ");
                    origen = new Scanner(System.in).nextLine();
                    System.out.println("Ingrese el destino: ");
                    destino = new Scanner(System.in).nextLine();
                    System.out.println("Ingrese el peso: ");
                    peso = new Scanner(System.in).nextFloat();

                    paqueteria.insertarInicio(new Paquete(id, origen, destino, peso));

                    System.out.println("\f\f\f");

                    break;

                case "2":
                    paqueteria.eliminarInicio();
                    System.out.println("\f\f\f");
                    break;

                case "3":
                    paqueteria.ordenarOrigen();
                    System.out.println("\f\f\f");
                    break;

                case "4":
                    paqueteria.ordenarPeso();
                    System.out.println("\f\f\f");
                    break;

                case "5":
                    paqueteria.mostrar();
                    System.out.println("\f\f");
                    break;

                case "6":
                    paqueteria.guardar();
                    System.out.println("\f\f");
                    break;

                case "7":
                    paqueteria.recuperar();
                    System.out.println("\f\f");
                    break;

                default:
                    System.out.println("La opcion seleccionada es invalida");
                    System.out.println("\f\f");
                    break;
                    
            }
        } while (!opcion.equals("0"));

    }

}
