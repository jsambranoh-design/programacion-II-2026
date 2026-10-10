import java.util.Scanner;

public class controlParqueo{
    static Scanner entrada = new Scanner(System.in);
    public static void main ( String[] args){
        int cantidadVehiculos = datosInciales();
        registro (cantidadVehiculos);
    }
    public static int datosInciales() {
        System.out.println("Ingrese la cantidad de vehiculos: ");
        int cantidadVehiculos = entrada.nextInt();

        while (cantidadVehiculos<=0){
            System.out.println("Cantidad ingresada no valida, \n ingrese una cantidad mayor a 0: ");
            cantidadVehiculos= entrada.nextInt();
        }
        entrada.nextLine();
        return cantidadVehiculos;
    }
    public static String obtenerNombreVehiculo( int tipoVehiculo){
        switch (tipoVehiculo){
            case 1:
                return "Motocicleta";
            case 2:
                return "Automovil";
            default:
                return "Pick up o Camioneta";
        }
    }
    public static double obtenerTarifa( int tipoVehiculo){
        switch (tipoVehiculo){
            case 1:
                return 5.00;
            case 2:
                return 8.00;
            default:
                return 12.00;
        }
    }
    public static double calcularDescuento(double subtotal, double horas){
        if (horas>8){
            return subtotal*0.15;
        }
        return 0;
    }
    public static double calcularPago(double horas, double tarifa){
        return horas * tarifa;
    }
    public static double calcularPago(double horas, double tarifa, double recargo){
        return horas * tarifa + recargo;
    }
    public static void mostrarComprobante( String placa, String nombreVehiculo, double horas, double tarifa, double subtotal, double descuento, double recargo, double total){
        System.out.println("------------Comprobante------------\n" +
                "Placa:"+ placa +"\n" + "Tipo: " + nombreVehiculo +"\n" +
                "Horas estacionado: " + horas + "\n" );
        System.out.printf("Tarifa por hora: Q%.2f%n", tarifa);
        System.out.printf("Subtotal: Q%.2f%n", subtotal);
        System.out.printf("Descuento: Q%.2f%n", descuento);
        System.out.printf("Recargo por ticket perdido: Q%.2f%n", recargo);
        System.out.printf("Total: Q%.2f%n", total);
        System.out.println("\n--------------------------------");
    }
    public static void registro(int cantidadVehiculo){
        int cantidadMotocicletas = 0;
        int cantidadAutomoviles =0;
        int cantidadPickups = 0;
        int ticketsPerdidos = 0;
        double  totalRecaudado = 0;
        double pagoMasAlto = 0;
        String placaPagoMasAlto = "";

        for (int i = 1; i <=cantidadVehiculo; i++){
            System.out.println("Datos del Vehiculo "+ i);
            System.out.print("Numero de placa: ");
            String placa = entrada.nextLine();
            int tipoVehiculo;
            do {
                System.out.println("\nSeleccione el tipo de vehiculo:");
                System.out.println("1. Motocicleta");
                System.out.println("2. Automovil");
                System.out.println("3. Pickup o camioneta");
                System.out.print("Opcion: ");

                tipoVehiculo = entrada.nextInt();
                if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                    System.out.println("Opcion invalida.");
                }
            } while (tipoVehiculo < 1 || tipoVehiculo > 3);
            double horas;
            do {
                System.out.print("Cantidad de horas estacionadas: ");
                horas = entrada.nextDouble();

                if (horas <= 0) {
                    System.out.println("Las horas tiene que ser mayores que cero.");
                }
            } while (horas <= 0);
            entrada.nextLine();

            String ticket;
            do {
                System.out.print("Ticket perdido (S/N): ");
                ticket = entrada.nextLine().toUpperCase();
                if (!ticket.equals("S") && !ticket.equals("N")) {
                    System.out.println("Respuesta invalida. Ingrese S o N.");
                }

            } while (!ticket.equals("S") && !ticket.equals("N"));

            double tarifa = obtenerTarifa(tipoVehiculo);
            String nombreVehiculo = obtenerNombreVehiculo(tipoVehiculo);
            double subtotal = calcularPago(horas, tarifa);
            double descuento = calcularDescuento(subtotal, horas);
            double recargo = 0;

            if (ticket.equals("S")) {
                recargo = 50.00;
            }
            double total;
            if (ticket.equals("S")) {
                total = subtotal - descuento + recargo;
            } else {
                total = calcularPago(horas, tarifa) - descuento;
            }

            mostrarComprobante(placa, nombreVehiculo, horas, tarifa, subtotal, descuento, recargo, total
            );

            if (tipoVehiculo == 1) {
                cantidadMotocicletas++;
            } else if (tipoVehiculo == 2) {
                cantidadAutomoviles++;
            } else if (tipoVehiculo == 3) {
                cantidadPickups++;
            }

            if (ticket.equals("S")) {
                ticketsPerdidos++;
            }
            totalRecaudado += total;

            if (total > pagoMasAlto) {
                pagoMasAlto = total;
                placaPagoMasAlto = placa;
            }
        }

        System.out.println("\n------------- Resumen de la jornada ----------------");
        System.out.println("Cantidad de motocicletas: " + cantidadMotocicletas);
        System.out.println("Cantidad de automoviles: " + cantidadAutomoviles);
        System.out.println("Cantidad de pickups o camionetas: " + cantidadPickups);
        System.out.println("Cantidad de tickets perdidos: " + ticketsPerdidos);
        System.out.printf("Total de dinero recaudado: Q%.2f%n", totalRecaudado);
        System.out.printf("Pago mas alto: Q%.2f%n", pagoMasAlto);
        System.out.println("Placa del pago mas alto: " + placaPagoMasAlto);
        System.out.println("-----------------------------------------------------");
    }

}