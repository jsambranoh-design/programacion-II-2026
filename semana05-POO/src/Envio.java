import java.util.Scanner;
public class Envio {
    static Scanner entrada = new Scanner(System.in);
// Atributos encapsulados ============================
    private String codigoEnvio;
    private String nombreDestinatario;
    private double peso;
// Constructor vacio ================================
    public Envio() {
    }
// Constructor con parametros ======================
    public Envio(String codigoEnvio, String nombreDestinatario, double peso) {
        this.codigoEnvio = codigoEnvio;
        this.nombreDestinatario = nombreDestinatario;
        this.peso = peso;
    }
// Ingreso de datos ==============================
    public void datosIniciales() {
        do {
            System.out.println("Codigo de envio: ");
            codigoEnvio = entrada.nextLine().trim();
            if (codigoEnvio.equals("")) {
                System.out.println("El codigo no puede estar vacio.");
            }
        } while (codigoEnvio.equals(""));

// Nombre del destinatario=============================
        do {
            System.out.println("Nombre del destinatario: ");
            nombreDestinatario = entrada.nextLine().trim();
            if (nombreDestinatario.equals("")) {
                System.out.println("El nombre no puede estar vacio.");
            }
        } while (nombreDestinatario.equals(""));
// Peso=============================
        do {
            System.out.println("Peso en kilogramos: ");
            if (entrada.hasNextDouble()) {
                peso = entrada.nextDouble();
                if (peso <= 0) {
                    System.out.println("El peso debe ser mayor que cero.");
                }
            } else {
                System.out.println("Ingrese un numero valido.");
                entrada.nextLine();
                peso = 0;
            }
        } while (peso <= 0);
        entrada.nextLine();
    }
// Getters y setter =============================
    public String getCodigoEnvio() {
        return codigoEnvio;
    }
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }
    public double getPeso() {
        return peso;
    }
// Mostrar informacion=============================
    public void mostrarInfo() {
        System.out.println("Codigo de envio: " + codigoEnvio);
        System.out.println("Nombre del destinatario: " + nombreDestinatario);
        System.out.println("Peso en kilogramos: " + peso);
    }
// costo base=============================
    public double costoBase() {
        return peso * 10;
    }
//costo final =============================
    public double costoFinal() {
        return costoBase();
    }

// Resumen simple=======================================
    public void mostrarResumen() {
        System.out.println("===== RESUMEN DEL ENVIO ====="
        );
        mostrarInfo();
        System.out.printf("Costo final: Q%.2f%n",  costoFinal());
    }
// Resumen con desglose========================================
    public void mostrarResumen(boolean desglose) {
        if (desglose) {
            System.out.println("===== RESUMEN COMPLETO =====");
            mostrarInfo();
            System.out.printf("Costo base: Q%.2f%n", costoBase());
            System.out.printf("Cargos adicionales: Q%.2f%n", costoFinal() - costoBase());
            System.out.printf("Costo final: Q%.2f%n", costoFinal());
        } else {
            mostrarResumen();
        }
    }
}