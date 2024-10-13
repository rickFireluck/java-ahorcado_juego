import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "libro";
        int numeroIntentos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for(int i=0; i<letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_';
        }

        while(intentos < numeroIntentos && !palabraAdivinada){
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() +" letras)");
            System.out.println("\nTe quedan "+(10 - intentos)+" intentos");
            System.out.println("Ingresa letra o palabra:\n");
            String palabra = scanner.nextLine().toLowerCase();
            System.out.println();

            if(palabraSecreta.equals(palabra)){
                palabraAdivinada = true;
                intentos++;
                break;
            }

            try{
                char letra = Character.toLowerCase(palabra.charAt(0));
                for(int i=0; i<palabraSecreta.length(); i++){
                    if (palabraSecreta.charAt(i) == letra){
                        letrasAdivinadas[i] = letra;
                        intentos--;
                    }
                }
            } catch(Exception e){
                System.out.println("Letra no válida\n");
            }

            intentos++;

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println(String.valueOf(letrasAdivinadas));
                intentos++;
            }
        }

        scanner.close();
        if (palabraAdivinada && intentos != 1){
            System.out.println("\nGanaste el juego en " + intentos + " intentos");
        } else if (palabraAdivinada && intentos == 1){
            System.out.println("\nGanaste el juego en 1 intento");
        }else {
            System.out.println("\nPerdiste el juego, la palabra a adivinar era: " + palabraSecreta);
        }
    }
}
