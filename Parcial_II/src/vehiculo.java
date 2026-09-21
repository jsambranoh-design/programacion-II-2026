public abstract class vehiculo  {

    private String placa;
    private String propietario;
    private String horaIngreso;
    private int horasUtilizadas;

    public vehiculo( String placav, String propietariovehiculo, String horaIngresov, int horasUtilizadasv) {
        this.placa= placav;
        this.propietario = propietariovehiculo;
        this.horaIngreso = horaIngresov;
        this.horasUtilizadas = horasUtilizadasv;
    }

    public String getplaca(){return placa;}
    public String getpropietario(){return propietario;}
    public String gethoraIngreso(){return horaIngreso;}
    public int gethorasUtilizadas(){return horasUtilizadas;}

    public abstract double calcularCosto();

    public void mostrarInformación() {
        System.out.println("Placa; " + placa + "\n" +
                "Nombre del Propietario; " + propietario + "\n" +
                "Hora de ingreso; " + horaIngreso + "\n" +
                "Cantidad de horas utilizadas; " + horasUtilizadas);
    }
    public abstract String Tipo();
    }




