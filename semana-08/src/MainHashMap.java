import java.util.HashMap;
public class MainHashMap {
    public static void main (String[] args){
        HashMap<String, Double> preciosMascota = new HashMap<>();

        preciosMascota.put("PET-001", 150.00);
        preciosMascota.put("PET-002", 150.00);
        preciosMascota.put("PET-003", 150.00);

        String coidgoMascota = "PET-001";
         if ( preciosMascota.containsKey(coidgoMascota)){
             System.out.println(preciosMascota.get(coidgoMascota));
         } else {
             System.out.println("Mascota No encontrada");
         }
        
    }
}
