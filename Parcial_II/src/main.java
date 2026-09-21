import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<vehiculo> vehiculosRegistro = new ArrayList<>();
        HashSet<String> placas = new HashSet<>();
        HashMap<String, Double> totalRecaudado = new HashMap<>();
        int opcion;

        do {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Mostrar todos los vehiculos registrados");
            System.out.println("3. Buscar un vehiculo por placa");
            System.out.println("4. Mostrar el vehiculo que genero el mayor costo");
            System.out.println("5. Mostrar el total general recaudado");
            System.out.println("6. Mostrar el total recaudado por tipo de vehiculo");
            System.out.println("7. Salir");

            while (true) {
                try {
                    System.out.print("\nSeleccione una opcion: ");
                    String textoOpcion = entrada.nextLine();
                    opcion = Integer.parseInt(textoOpcion);

                    if (opcion >= 1 && opcion <= 7) {
                        break;
                    } System.out.println("Seleccione una opcion del 1 al 7.");}
                catch (NumberFormatException e) {
                    System.out.println("Debe ingresar un numero valido.");
                }
            }
            switch (opcion) {
                case 1:
                    System.out.println("\n======= Registrar vehiculo=======");
                    System.out.print("Ingrese placa: ");
                    String placa = entrada.nextLine().trim();

                    if (placa.isEmpty()) {
                        System.out.println("La placa no puede estar vacia.");
                        break;
                    }

                    if (placas.contains(placa)) {
                        System.out.println("La placa ya esta registrada.");
                        break;
                    }
                    System.out.print("Ingrese propietario: ");
                    String propietario = entrada.nextLine().trim();
                    if (propietario.isEmpty()) {
                        System.out.println("El propietario no puede estar vacio.");
                        break;
                    }

                    String horaIngreso;
                    try {
                        System.out.print("Ingrese hora de ingreso: ");
                        horaIngreso = entrada.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error al ingresar la hora.");
                        break;
                    }

                    int horasUtilizadas;
                    try {
                        System.out.print("Ingrese horas utilizadas: ");
                        String horasusadas = entrada.nextLine();
                        horasUtilizadas = Integer.parseInt(horasusadas);

                        if (horasUtilizadas <= 0) {
                            System.out.println("Las horas utilizadas deben ser mayores que cero.");
                            break;}
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un numero acorde a las horas usadas.");
                        break;
                    }
                    int tipo;
                    while (true) {
                        try {
                            System.out.println("\nTipo de vehiculo.");
                            System.out.println("1. Automovil");
                            System.out.println("2. Motocicleta");
                            System.out.print("Seleccione el numero de tipo de vehiculo: ");
                            String textoTipo = entrada.nextLine();
                            tipo = Integer.parseInt(textoTipo);

                            if (tipo == 1 || tipo == 2) {
                                break;
                            }
                            System.out.println("Debe seleccionar entre 1 o 2.");
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un numero.");
                        }
                    }
                    vehiculo nuevoVehiculo;
                    if (tipo == 1) {
                        nuevoVehiculo = new automovil(placa, propietario, horaIngreso, horasUtilizadas);
                    } else {
                        nuevoVehiculo = new motocicleta(placa, propietario, horaIngreso, horasUtilizadas);
                    }
                    vehiculosRegistro.add(nuevoVehiculo);
                    placas.add(placa);
                    System.out.println("\nVehiculo registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\n==== Vehiculos Registrados =====");

                    if (vehiculosRegistro.isEmpty()) {
                        System.out.println("No hay vehiculos registrados.");
                    } else {
                        for (vehiculo vehiculoenRegistro : vehiculosRegistro) {
                            vehiculoenRegistro.mostrarInformación();
                            System.out.println("Tipo de vehiculo: " + vehiculoenRegistro.getClass().getSimpleName());
                            System.out.printf("Costo: Q%.2f%n", vehiculoenRegistro.calcularCosto());
                        }
                    }break;

                case 3:
                    System.out.println("\n==== Buscar Vehiculo por numero de placa ====");
                    System.out.print("Ingrese la placa: ");
                    String placaBuscar = entrada.nextLine().trim();
                    boolean encontrado = false;

                    for (vehiculo vehiculoregistrado : vehiculosRegistro) {
                        if (vehiculoregistrado.getplaca().equalsIgnoreCase(placaBuscar)) {
                            vehiculoregistrado.mostrarInformación();
                            System.out.println("Tipo de vehiculo: " + vehiculoregistrado.Tipo());
                            System.out.printf("Costo: Q%.2f%n", vehiculoregistrado.calcularCosto());
                            encontrado = true;
                            break;}
                    }
                    if (!encontrado) {
                        System.out.println("No se encontro un vehiculo con esa placa.");
                    }break;

                case 4:
                    System.out.println("\n==== Vehiculo generando mayor monto ====");

                    if (vehiculosRegistro.isEmpty()) {
                        System.out.println("No hay vehiculos registrados.");
                    } else {
                        vehiculo mayor = vehiculosRegistro.get(0);

                        for (vehiculo vehiculoRegistrado : vehiculosRegistro) {
                            if (vehiculoRegistrado.calcularCosto() > mayor.calcularCosto()) {
                                mayor = vehiculoRegistrado;
                            }
                        }
                        System.out.println("El vehiculo que genero el mayor monto:");
                        mayor.mostrarInformación();
                        System.out.println("Tipo de vehiculo: " + mayor.Tipo());
                        System.out.printf("Monto: Q%.2f%n", mayor.calcularCosto());
                    }
                    break;

                case 5:
                    System.out.println("\n==== Total Generado ====");
                    double totalGeneral = 0;

                    for (vehiculo vehiculoRegistrado : vehiculosRegistro) {
                        totalGeneral += vehiculoRegistrado.calcularCosto();
                    }
                    System.out.printf("Total generado : Q%.2f%n", totalGeneral);
                    break;

                case 6:
                    System.out.println("\n==== Total generado por cada vehiculo ====");
                    totalRecaudado.clear();

                    for (vehiculo vehiculoRegistrado : vehiculosRegistro) {
                        String tipoVehiculo = vehiculoRegistrado.Tipo();
                        double costo = vehiculoRegistrado.calcularCosto();

                        if (totalRecaudado.containsKey(tipoVehiculo)) {
                            totalRecaudado.put(tipoVehiculo, totalRecaudado.get(tipoVehiculo) + costo);
                        } else {
                            totalRecaudado.put(tipoVehiculo, costo);
                        }
                    }
                    if (totalRecaudado.isEmpty()) {
                        System.out.println("No hay vehiculos registrados.");
                    } else {
                        for (String tipoVehiculo : totalRecaudado.keySet()) {
                            System.out.printf("%s: Q%.2f%n", tipoVehiculo, totalRecaudado.get(tipoVehiculo)
                            );
                        }
                    }break;

                case 7:
                    System.out.println("\nGracias por su tiempo.");
                    break;
            }} while (opcion != 7);
    }
}