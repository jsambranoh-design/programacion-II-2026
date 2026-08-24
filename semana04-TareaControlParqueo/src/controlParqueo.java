import java.util.Scanner;
//Desarrolla en Java un programa de consola que calcule el pago de varios vehículos que utilizan un parqueo.
//El programa deberá procesar la cantidad de vehículos indicada por el usuario y, al finalizar, mostrar un resumen general de la jornada.
//Tarifas
//Tipo de vehículo	Tarifa por hora
//Motocicleta	Q5.00
//Automóvil	Q8.00
//Pickup o camioneta	Q12.00
//Si el vehículo permanece más de 8 horas, se aplica un descuento del 15 % sobre el pago del tiempo estacionado.
//Si el conductor perdió el ticket, se agregan Q50.00 después de calcular cualquier descuento.
//Requerimientos obligatorios
//2. Registro de vehículos
//Para cada vehículo solicita
//Número de placa.
//Tipo de vehículo:
//1: motocicleta.
//2: automóvil.
//3: pickup o camioneta.
//Cantidad de horas estacionadas.
//Indicar si perdió el ticket: S o N.
//Debes validar que:
//El tipo de vehículo esté entre 1 y 3.
//Las horas sean mayores que cero.
//La respuesta del ticket sea únicamente S o N.
//3. Cálculos
//Para cada vehículo determina:
//Tarifa por hora.
//Subtotal por el tiempo estacionado.
//Descuento, cuando corresponda.
//Recargo por ticket perdido.
//Total que debe pagar.
//4. Resultado individual
//Muestra un comprobante como el siguiente:
//========== COMPROBANTE ========== Placa: P123ABC Tipo: Automóvil Horas estacionado: 10 Tarifa por hora: Q8.00 Subtotal: Q80.00 Descuento: Q12.00 Recargo por ticket perdido: Q50.00 TOTAL: Q118.00 =================================
//5. Resumen de la jornada
//Al terminar de procesar todos los vehículos, muestra:
//Cantidad de motocicletas.
//Cantidad de automóviles.
//Cantidad de pickups o camionetas.
//Cantidad de tickets perdidos.
//Total de dinero recaudado.
//Vehículo que realizó el pago más alto y su placa.
//Uso obligatorio de métodos
//El programa debe estar modularizado. No se permite desarrollar toda la solución dentro de main.

//Temas que debe demostrar la solución
//Variables y tipos de datos.
//Operadores aritméticos, relacionales y lógicos.
//Entrada de datos con Scanner.
//Condiciones con if, else o switch.
//Ciclo for para procesar los vehículos.
//Ciclo while o do while para las validaciones.
//Métodos void.
//Métodos con return.
//Parámetros y argumentos.
//Métodos static.
//Sobrecarga de métodos.
//Acumuladores y contadores.
//Reto opcional — Control exacto del tiempo +2 puntos adicionales
//Modifica el programa para solicitar la hora y los minutos de entrada y salida.
//Ejemplo
//Hora de entrada: 22 Minuto de entrada: 30 Hora de salida: 2 Minuto de salida: 10
//El sistema deberá:
//Validar horas entre 0 y 23.
//Validar minutos entre 0 y 59.
//Calcular correctamente el tiempo aunque el vehículo salga al día siguiente.
//Cobrar como una hora completa cualquier fracción de hora.
//Mostrar el tiempo exacto y las horas cobradas.
//Integrar esta funcionalidad con el resto del sistema.
//Para el ejemplo anterior:
//Tiempo estacionado: 3 horas y 40 minutos Horas cobradas: 4
//No se aceptará como reto una solución con valores fijos o que solamente funcione para el ejemplo proporcionado
public class controlParqueo {
    static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args){
        int cantidadI=datos_iniciales();
        System.out.print("Cantidad ingresada; " + cantidadI);
        System.out.print("Los "+ cantidadI+ "vehiclos a ingresar son del mismo tipo?");

    }
    //DATOS INICIALES-------------------------------
    public static int datos_iniciales(){
        System.out.print("Ingresee la cantidad de vehiculos; ");
        int cantidadVehiculos = entrada.nextInt();

        while (cantidadVehiculos<=0){
            System.out.print("Cantidad de vehiculos incorrecta\n Ingresar la cantidad de vehiculos nuevamente");
            cantidadVehiculos=entrada.nextInt();
        }
        return cantidadVehiculos;
    }

    //REGISTRO VEHICULOS---------------------------------
    public static String registro(){
        for (int i =1; i<=datos_iniciales();i++){
            System.out.print("\nDatos del vehiculo # "+ i );
            System.out.print("\nNumero de Placa: ");
            String placa = entrada.nextLine();

            System.out.print("\nSeleccione el tipo de vehiculo\n1: motocicleta.\n" + "//2: automóvil.\n" +  "//3: pickup o camioneta.: ");
            int vehiculotype = entrada.nextInt();
            switch (vehiculotype) {
                case 1:
                    System.out.print("Tipo de vehiculo: " + vehiculotype);
                    break;

                case 2:
                    System.out.print("Tipo de vehiculo: " + vehiculotype);
                    break;

                case 3:
                    System.out.print("Tipo de vehiculo: " + vehiculotype);
                    break;

                default:
                    System.out.print("\n Opcion invalidad, ingrese nuevamente el tipo de vehiculo ");
            }
            System.out.print("Cantidad de horas estacionadas: ");
            int parkTime = entrada.nextInt();
            System.out.print("Ticket perdido(S/N): ");
            String ticket= entrada.nextLine();
            if ( ticket equalS){
            }
        }
    }
//Para cada vehículo solicita
//Número de placa.
//Tipo de vehículo:
//1: motocicleta.
//2: automóvil.
//3: pickup o camioneta.
//Cantidad de horas estacionadas.
//Indicar si perdió el ticket: S o N.
//Debes validar que:
//El tipo de vehículo esté entre 1 y 3.
//Las horas sean mayores que cero.
//La respuesta del ticket sea únicamente S o N.

}
//Como mínimo, debe incluir:
//public static double obtenerTarifa(int tipoVehiculo)
//public static String obtenerNombreVehiculo(int tipoVehiculo)
//public static double calcularDescuento(double subtotal, int horas)
//public static void mostrarComprobante(...)
//También debe incluir una sobrecarga real de calcularPago:
//public static double calcularPago(int horas, double tarifa)
//Calcula el pago cuando no se perdió el ticket
//public static double calcularPago(int horas, double tarifa, double recargo)
//Calcula el pago cuando existe un recargo por ticket perdido.
//Los métodos deben tener el mismo nombre, pero distinta lista de parámetros. Cambiar solamente el tipo de retorno no es sobrecarga.