import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
public class CasoC {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        ArrayList<String> mascotas = new ArrayList<>();
        HashMap<String, Double> mascotaCodigo = new HashMap<>();
        mascotaCodigo.put("MC001", 123.987);
        mascotaCodigo.put("MC002", 124.987);
        mascotaCodigo.put("MC003", 125.987);

        System.out.println("Ingrese el codigo del paciente: ");
        String codigoMascotaIngreso = entrada.nextLine();

        if (mascotaCodigo.containsKey(codigoMascotaIngreso)){
            System.out.println("Codigo" + mascotaCodigo.get(codigoMascotaIngreso));
        }else{
            System.out.println("codigo no encontrado");
        }

    }
}
