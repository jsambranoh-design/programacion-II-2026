import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
//============Menu extermo==================
        do {
            System.out.print(
                    "\n========= SISTEMA DE ENVIOS =========\n" +
                            "1. Registrar envio nacional\n" +
                            "2. Registrar envio internacional\n" +
                            "3. Salir\n"
            );
// VALIDACIÓN DE LA OPCIÓN=========================================
            do {
                System.out.print("\nSeleccione una opcion: ");
                if (entrada.hasNextInt()) {
                    opcion = entrada.nextInt();

                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Seleccionar una opcion valida.");
                    }
                } else {
                    System.out.println("Debe ingresar un numero valido.");
                    entrada.nextLine();
                    opcion = 0;}
            } while (opcion < 1 || opcion > 3);
            entrada.nextLine();
// menu interno =======================vv=
            switch (opcion) {
                case 1:
                    Envio envio = new EnvioNacional();
                    envio.datosIniciales();
                    ((EnvioNacional) envio).datosEspecificos();
                    envio.mostrarResumen(true);
                    break;
                case 2:
                    Envio envioInternacional = new EnvioInternacional();
                    envioInternacional.datosIniciales();
                    ((EnvioInternacional) envioInternacional)
                            .datosEspecificos();

                    envioInternacional.mostrarResumen(true);
                    break;
                case 3:
                    System.out.println("\nPrograma finalizado.");
                    break;}
        } while (opcion != 3);
        entrada.close();
    }
}