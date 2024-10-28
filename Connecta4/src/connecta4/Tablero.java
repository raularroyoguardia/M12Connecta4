/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecta4;

/**
 *
 * @author raularroyo
 */
public class Tablero {

    private char[][] tablero;

    /**
     * Constructor para el tablero
     * @param files
     * @param columnes 
     */
    public Tablero(int files, int columnes) {
        tablero = new char[files][columnes];
        crearTablero();

    }

    /**
     * Creación del tablero
     */
    private void crearTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    
    /**
     * Mostrar el tablero
     */
    public void mostrarTablero() {
        System.out.println();

        //Imprimir les files amb separadors
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("" + (tablero.length - i) + " | ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();

            //Línia separadora
            System.out.print(" ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("----");
            }
            System.out.println("-");
        }

        //Numeració de les columnes
        System.out.print("   ");
        for (int j = 1; j <= tablero[0].length; j++) {
            System.out.print(" " + j + "  ");
        }
        System.out.println();

    }

    /**
     * Comprovar la posición introducida sea vàlida
     * @param posicio
     * @return true si la posición es correcta, sino fale
     */
    public boolean posicioValida(int posicio) {
        if (posicio < 0 || posicio >= tablero[0].length) {
            System.out.println("Posición invàlida.");
            return false;
        }

        return true;
    }

    /**
     * Coloca la ficha del jugador 
     * @param columna
     * @param jugador 
     */
    public void colocar(int columna, char jugador) {
        for (int i = tablero.length - 1; i >= 0; i--) {
            if (tablero[i][columna] == ' ') {
                tablero[i][columna] = jugador;
                break;
            }
        }
    }

    /**
     * Comprueba si hay 4 fichas del mismo jugador juntas horizontalmente
     * @param jugador
     * @return 
     */
    private boolean comprovarHoritzontal(char jugador) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j <= tablero[0].length - 4; j++) {
                if (tablero[i][j] == jugador && tablero[i][j + 1] == jugador && tablero[i][j + 2] == jugador && tablero[i][j + 3] == jugador) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Comprueba si hay 4 fichas del mismo jugador juntas verticalmente
     * @param jugador
     * @return 
     */
    private boolean comprovarVertical(char jugador) {
        for (int i = 0; i <= tablero.length - 4; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j] == jugador && tablero[i + 2][j] == jugador && tablero[i + 3][j] == jugador) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Comprueba si hay 4 fichas del mismo jugador juntas en diagonal
     * @param jugador
     * @return 
     */
    private boolean comprovarDiagonal(char jugador) {
        for (int i = 3; i < tablero.length; i++) {
            for (int j = 0; j <= tablero[0].length - 4; j++) {
                if (tablero[i][j] == jugador && tablero[i - 1][j + 1] == jugador && tablero[i - 2][j + 2] == jugador && tablero[i - 3][j + 3] == jugador) {
                    return true;
                }
            }
        }
        for (int i = 0; i <= tablero.length - 4; i++) {
            for (int j = 0; j <= tablero[0].length - 4; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j + 1] == jugador && tablero[i + 2][j + 2] == jugador && tablero[i + 3][j + 3] == jugador) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Comprueba si algun método para comprovar 4 fichas seguidas en diagonal, horizontal o vertical devuelve true
     * @param jugador
     * @return 
     */
    public boolean comprovarGuanyador(char jugador) {
        return comprovarHoritzontal(jugador) || comprovarVertical(jugador) || comprovarDiagonal(jugador);
    }

    
    /**
     * Comprueba si todo el tablero ha sido rellenado
     * @return true si esta todo el tablero rellenado, sino false
     */
    public boolean tableroOcupado() {
        for (int i = 0; i < tablero[0].length; i++) {
            if (tablero[0][i] == ' ') {
                return false;
            }
        }
        return true;
    }

}
