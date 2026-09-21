public class motocicleta extends vehiculo{

    public  motocicleta( String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }
    @Override
    public double calcularCosto(){
        double costoMonetario = gethorasUtilizadas() * 6;

        if (gethorasUtilizadas() > 5) {
            costoMonetario = costoMonetario *0.90;
        }
        return costoMonetario;
    }
    @Override
    public String Tipo() {
        return "Motocicleta";
    }
}
