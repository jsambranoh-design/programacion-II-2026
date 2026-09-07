import java.util.ArrayList;
public class MainArrayList {
    public static void main (String[] args){
        ArrayList<String> estudiantes = new ArrayList<>();

        estudiantes.add("Ana");
        estudiantes.add("Benito");
        estudiantes.add("Daniel");

        for(String estudianate : estudiantes){
            System.out.println(estudianate);
        }

        estudiantes.add("Juan");
        estudiantes.add("David");
        estudiantes.clear();

        System.out.println("Total estudiantes: " + estudiantes.size());
    }
}
