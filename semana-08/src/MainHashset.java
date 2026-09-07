import java.util.HashSet;
public class MainHashset {
    public static void main(String[] args){
        HashSet<String> correos = new HashSet<>();

        correos.add("dalvareze@miumg.edu.gt");
        correos.add("jvaldez@miumg.edu.gt");
        correos.add("dalvareze@miumg.edu.gt");

        for(String correo: correos){
            System.out.println(correo);
        }
    }
}
