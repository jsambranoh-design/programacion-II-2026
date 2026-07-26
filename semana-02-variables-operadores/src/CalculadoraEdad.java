import  java.util.Scanner;
public class CalculadoraEdad {
    public static void  main (String[] args){
        Scanner entrada = new Scanner(System.in);
        // uso evitado de println para tener los datos ingresados en una misma linea
        System.out.print("Nombre completo del estudiante: ");
        String nombreCompleto = entrada.nextLine();

        System.out.print("Carne: ");
        String carne = entrada.nextLine();

        System.out.print("Año de nacimiento: ");
        int yearBirth = entrada.nextInt();

        System.out.print("Año actual: ");
        int actualYear = entrada.nextInt();

        int edadAproximada = actualYear - yearBirth;
        int edadMeses = edadAproximada * 12;

        boolean mayorEdad = edadAproximada >=18;
//Salida de datos
        System.out.println("-----------------Resultados-------------------");
        System.out.println("Nombre; " + nombreCompleto+".");
        System.out.println("Carnet; " + carne+".");
        System.out.println("Edad aproximada; " + edadAproximada + " años.");
        System.out.println("Edad aproximada en meses: " + edadMeses + " meses.");
        System.out.println("Es mayor de edad? "+ mayorEdad);

    }
}
