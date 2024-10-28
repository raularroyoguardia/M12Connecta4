/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connecta4;

import java.util.*;

/**
 *
 * @author raularroyo
 */
public class Connecta4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclat = new Scanner(System.in);

        missatgeBenvinguda();

        //Crear i inicialitzar les variables
        int files = demanarFiles();
        int columnes = demanarColumnes();


        //Creació del taulell
        Tablero tablero = new Tablero(files, columnes);
        
        //Mostrar taulell
        tablero.mostrarTablero();
        
        Jugador JugadorX = new Jugador('X');
        Jugador JugadorO = new Jugador('O');
        Jugador JugadorActual = JugadorX;
        
        boolean empezado = true;
        
        while(empezado) {
            System.out.println("Turno del jugador " + JugadorActual.getSimbol());
            int columna;
            
            do{
                System.out.print("Introduce una columna (1-"+columnes+"): ");
                columna = teclat.nextInt() - 1;
            }while(!tablero.posicioValida(columna));
            
            tablero.colocar(columna, JugadorActual.getSimbol());
            tablero.mostrarTablero();
            
            if(tablero.comprovarGuanyador(JugadorActual.getSimbol())) {
                System.out.println("El jugador " + JugadorActual.getSimbol() + " ha ganado.");
                empezado = false;
            }else if(tablero.tableroOcupado()){
                System.out.println("EMPATE");
                empezado = false;
            }else {
                JugadorActual = (JugadorActual == JugadorX) ? JugadorO : JugadorX;
            }
        }
        
    }

    /**
     * Muestra el título
     */
    public static void missatgeBenvinguda() {
        System.out.println("==========");
        System.out.println("CONNECTA 4");
        System.out.println("==========\n");
    }

    /**
     * Verificar que el valor introducido el valido
     * @return filas del tablero
     */
    public static int demanarFiles() {
        Scanner scanner = new Scanner(System.in);
        int files = 0;
        boolean valid = false;
        
        do{
            try{
                System.out.print("Introdueix el número de files: ");
                files = scanner.nextInt();
                if(files < 1) {
                    System.out.println("El número de files ha de ser major a 0.");
                }else {
                    valid = true;
                }
            }catch(InputMismatchException e) {
                System.out.println("Error: Si us plau, introdueix un número enter.");
                scanner.next();
            }
            
        }while(!valid);
        return files;
    }

    /**
     * Verificar que el valor introducido el válido
     * @return columnas del tablero
     */
    public static int demanarColumnes() {
        Scanner scanner = new Scanner(System.in);
        int columnes = 0;
        boolean valid = false;
        
        do{
            try{
                System.out.print("Introdueix el numero de columnes: ");
                columnes = scanner.nextInt();
                if(columnes < 1) {
                    System.out.println("El número de columnes ha de ser major a 0.");
                }else {
                    valid = true;
                }
            }catch(InputMismatchException e) {
                System.out.println("Error: Si us plau, introdueix un número enter.");
                scanner.next();
            }
        }while(!valid);
        return columnes;
    }

}
