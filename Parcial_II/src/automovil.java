public class automovil extends vehiculo{

    public  automovil( String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }
        @Override
        public double calcularCosto(){
            double costoMonetario = gethorasUtilizadas() * 10;

            if (gethorasUtilizadas() > 5) {
                costoMonetario = costoMonetario *0.90;
            }
            return costoMonetario;
        }
    @Override
    public String Tipo() {
        return "Automovil";
    }
    }
