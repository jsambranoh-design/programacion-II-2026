import java.util.Scanner;
class Condicionesciclos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Estudiante; Juan Otoniel Sambrano Hernandez.\nCarne: 9941-25-14918.\nSemana 3 - Condiciones y cliclos.\n");
        int opcion;
        do {
            System.out.print("\n========= DESAFÍOS LÓGICOS =========\n1. Generar una secuencia \n2. Realizar un conteo regresivo \n3. Analizar números \n4. Dibujar una pirámide\n5. Validar palabra secreta\n6. Salir ");
            System.out.print("\nSeleccione una opcion; ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1://Opción 1 — Generar una secuencia
                    System.out.print("Numero Inicial: ");
                    int numInicial = entrada.nextInt();

                    System.out.print("Numero Final: ");
                    int numFinal = entrada.nextInt();

                    System.out.print("Incremento: ");
                    int incremento = entrada.nextInt();

                    if (incremento <= 0 || numFinal <= numInicial) {
                        System.out.print("El numero ingresado no es valido, asegurese de seguir las siguentes instrucciones:\nEl incremento debe ser mayor que cero.\nEl número final debe ser mayor que el inicial.");
                    } else {
                        for (int i = numInicial; i <= numFinal; i += incremento) {
                            System.out.print(i + " ");
                        }
                    }
                    break;
                case 2://Opción 2 — Conteo regresivo
                    System.out.print("Ingrese el numero inicial: ");
                    int numIncial = entrada.nextInt();
                    while (numIncial < 10 || numIncial > 50) {
                        System.out.print("Ingrese un valor entre 10 y 50.\nIngrese el numero inicial: ");
                        numIncial = entrada.nextInt();
                    }

                    while (numIncial >= 0) {
                        System.out.print(numIncial + " ");
                        numIncial--;
                    }
                    System.out.print("\n¡Despegue!");
                    break;
                case 3://Opción 3 — Analizar números
                    int newnum;
                    int suma = 0;
                    int positivo = 0;
                    int negativo = 0;
                    int numignorado = 0;
                    do {
                        System.out.print("Ingrese un Numero: ");
                        newnum = entrada.nextInt();
                        if (newnum == 0) {
                            break;
                        }
                        if (newnum < 0) {
                            negativo++;
                        } else {
                            if (newnum > 0) {
                                positivo++;
                            }
                        }
                        if (newnum % 5 != 0) {
                            suma = suma + newnum;
                        } else {
                            numignorado++;
                            System.out.print("el numero " + newnum + " fue ignorado\n");
                            continue;

                        }
                    }
                    while (newnum != 0);
                    System.out.print("Positivos: " + positivo);
                    System.out.print("\nNegativos: " + negativo);
                    System.out.print("\nSuma Valida: " + suma);
                    System.out.print("\nNumero ignorado: " + numignorado);
                    break;
                case 4://Opción 4 — Dibujar una pirámide
                    System.out.print("Ingrese la altura: ");
                    int altura = entrada.nextInt();

                    for (int i = 1; i <= altura; i++) {
                        for (int s = 1; s <= altura - i; s++) {
                            System.out.print(" ");
                        }
                        for (int s = 1; s <= i; s++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    //Opción 5 — Validar palabra secreta
                    entrada.nextLine();
                    String secret;
                    do {
                        System.out.print("Ingrese la palabra secreta: ");
                        secret = entrada.nextLine();
                        secret = secret.trim();
                        if (secret.equalsIgnoreCase("Guatemala")) {
                            System.out.print("Palabra correcta.");
                        } else {
                            System.out.print("Palabra Incorrecta. Intente nuevamente.\n");
                        }
                    }
                    while (!secret.equalsIgnoreCase("Guatemala"));
                    break;
                case 6:
                    System.out.print("Programa finalizado correctamente.");
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida.");


            }
        }while (opcion !=6) ;
    }
}
