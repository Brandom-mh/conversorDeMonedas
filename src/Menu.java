import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    public void header() {
        System.out.println("=============================\n"
                + "|    Conversor de monetas   |\n"
                + "=============================");
    }

    public void menu() {
        System.out.println("\n#################################");
        System.out.println("\n1) Dolar ==> Peso Argentino\n"
                + "2) Peso Argentino ==> Dolar\n"
                + "3) Dolar ==> Real Brasileno\n"
                + "4) Real Brasileno ==> Dolar\n"
                + "5) Dolar ==> Peso Colombiano\n"
                + "6) Peso colombiano ==> Dolar\n"
                + "7) Salir\n");
        System.out.println("\n#################################");

    }

    public int opc() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean valido = false;

        while (!valido) {
            try {
                opc = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                valido = true; // Salir del bucle si no hay excepción
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                sc.nextLine(); // Limpiar el buffer
            }
        }

        return opc;
    }
    

    public void conversion(String origen, String destino) {
        Scanner sc = new Scanner(System.in);
        Consultas consulta;
        float cantidad = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("\nIngrese la cantidad\n");
                cantidad = sc.nextFloat();
                sc.nextLine(); // Limpiar el buffer
                valido = true; // Salir del bucle si no hay excepción
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce una cantidad válida.");
                sc.nextLine(); // Limpiar el buffer
            }
        }

        consulta = new Consultas(origen, destino, cantidad);
        System.out.println("\nLa conversión de " + cantidad + " es:");
        consulta.consulta();
        menu();
    }
    public void seleccion() {

        int opc = 0;
        
        
        System.out.println("Ingrese una opcion =)\n");

        while (opc != 7) {
            opc = opc();
            switch (opc) {
                case 1:
                    System.out.println("\n1) Dolar ==> Peso Argentino");
                    conversion("USD", "ARS");
        
                    break;

                case 2:
                    System.out.println("\n2) Peso Argentino ==> Dolar");
                    conversion("ARS", "USD");
                    
                    break;

                case 3:
                    System.out.println("\n3) Dolar ==> Real Brasileno");
                    conversion("USD", "BRL");
                    
                    break;

                case 4:
                    System.out.println("\n4) Real Brasileno ==> Dolar");
                    conversion("BRL", "USD");
                    
                    break;

                case 5:
                    System.out.println("\n5) Dolar ==> Peso Colombiano");
                    conversion("USD", "COP");
                    
                    break;

                case 6:
                    System.out.println("\n6) Peso colombiano ==> Dolar");
                    conversion("COP", "USD");
                    
                    break;

                case 7:
                    System.out.println("\nGracias por utilizar el conversor adios...");
                    break;

                default:
                    System.out.println("\nOpcion invalida");
                    break;
            }
        }
    }

    public void ejecucion() {
        System.out.println("\nBinvenido al conversor de Moneda =)");
        header();
        menu();
        seleccion();
    }
}
