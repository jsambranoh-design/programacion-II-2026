public class Main {
    public static void main (String[] args) {
//Crear al menos un objeto de cada figura.
        Circulo circulo = new Circulo("Circulo", 12);
        Rectangulo rectangulo = new Rectangulo("Rectangulo", 20, 10);
        Triangulo triangulo = new Triangulo("Triangulo", 10, 12.5);
//Guardar los objetos en un arreglo de tipo Figura[].
        Figura[] figurasGeometricas = {circulo, rectangulo, triangulo};

//Recorrer el arreglo mediante un ciclo for-each.
//Mostrar el nombre de cada figura.
        for (Figura figura : figurasGeometricas) {

            System.out.println("\nFigura: " + figura.getNombre());
            System.out.printf("Area: %.2f%n" , figura.calcularArea());

        }
    }
}
