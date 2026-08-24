// Clase EnvioNacional
public class EnvioNacional extends Envio {
// atributos ====================
    private String depDestino;
    private double distanciaKm;

// datos especificos ====================
    public void datosEspecificos() {
// Departamento de destino ====================
        do {
            System.out.println("Departamento de destino: ");
            depDestino = entrada.nextLine().trim();
            if (depDestino.equals("")) {System.out.println("El departamento no puede estar vacio.");
            }
        } while (depDestino.equals(""));
    // Distancia ====================
        do {
            System.out.println("Distancia del envio en kilometros: ");
            if (entrada.hasNextDouble()) {distanciaKm = entrada.nextDouble();
                if (distanciaKm <= 0) {System.out.println("La distancia debe ser mayor que cero.");
                }
            } else {
                System.out.println("Ingrese una distancia valida.");
                entrada.nextLine();
                distanciaKm = 0;
            }
        } while (distanciaKm <= 0);
      entrada.nextLine();
    }

// constructores ====================
    public EnvioNacional() {}
    public EnvioNacional(String codigoEnvio, String nombreDestinatario, double peso, String depDestino, double distanciaKm) {
        super(codigoEnvio, nombreDestinatario, peso);
        this.depDestino = depDestino;
        this.distanciaKm = distanciaKm;
    }

// getter y setters ====================
    public double getDistanciaKm() {
        return distanciaKm;
    }
    public String getDepDestino() {
        return depDestino;
    }
    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }
    public void setDepDestino(String depDestino) {
        this.depDestino = depDestino;
    }

// override ====================
    @Override
    public double costoFinal() {
        return costoBase() + (distanciaKm * 0.50);
    }
}