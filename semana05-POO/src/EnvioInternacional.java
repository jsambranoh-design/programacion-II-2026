// Clase EnvioInternaciona
public class EnvioInternacional extends Envio {
//  atributos ==========
    private String paisDestino;
// datos especificos ==========
    public void datosEspecificos() {
// País de destino====================
        do {
            System.out.println("País de destino: ");
            paisDestino = entrada.nextLine().trim();
            if (paisDestino.isEmpty()) {System.out.println("El país no puede estar vacío.");
            }
        } while (paisDestino.isEmpty());
    }
//constructores ====================
    public EnvioInternacional() {}
    public EnvioInternacional(String codigoEnvio, String nombreDestinatario, double peso, String paisDestino) {
        super(codigoEnvio, nombreDestinatario, peso);
        this.paisDestino = paisDestino;
    }
    // getter y setter ==========
    public String getPaisDestino() {
        return paisDestino;
    }
    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

// override ====================
    @Override
    public double costoFinal() {
        double costoBase = costoBase();
        return costoBase + 75 + (costoBase * 0.12);
    }
}