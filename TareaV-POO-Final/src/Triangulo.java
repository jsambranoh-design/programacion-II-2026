//Heredar de Figura.
public class Triangulo extends Figura{

    //Tener los atributos privados base y altura.
   private double base;
   private double altura;
    //Utilizar super(...) en su constructor.
    public Triangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }
    //Sobrescribir calcularArea().
    @Override
    public double calcularArea() {
        return (base*altura)/2;
    }
}
