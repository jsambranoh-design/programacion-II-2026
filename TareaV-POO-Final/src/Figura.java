public abstract class Figura {
    //Un atributo privado nombre.
    private String nombre;

    //Constructor para inicializar el nombre.
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    //Método público para consultar el nombre. getter .
    public String getNombre() {
        return nombre;
    }

    //Un método concreto para mostrar la información de la figura. Pendiente!!!!!!!!!
    public void mostrarInfo() {

    }

    //El método abstracto calcularArea(), que deberá devolver un valor de tipo double.
    public abstract double calcularArea();




//La clase Figura no podrá instanciarse directamente.
}