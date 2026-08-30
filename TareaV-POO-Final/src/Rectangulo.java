//Heredar de Figura.
//Tener los atributos privados base y altura.
public class Rectangulo extends Figura {

    private double base;
    private double altura;
//Utilizar super(...) en su constructor.

    public Rectangulo(String nombre,double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }
    //Sobrescribir calcularArea().
    @Override
    public double calcularArea() {
        return base * altura;
    }
}