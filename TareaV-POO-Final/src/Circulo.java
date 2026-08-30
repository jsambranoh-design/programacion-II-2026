public  class Circulo extends Figura {
    //Tener un atributo privado radio.
    private double radio;
    //Utilizar super(...) en su constructor.
    public Circulo(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }
    //Sobrescribir calcularArea().
    @Override
    public  double calcularArea(){
        return Math.PI * Math.pow(radio,2);
    }



}
