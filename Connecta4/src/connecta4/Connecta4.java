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

        missatgeBenvinguda();

        //Crear i inicialitzar les variables
        int files = demanarFiles();
        int columnes = demanarColumnes();


        //Creació del taulell
        char[][] taulell = crearTaulell(files, columnes);
        
        //Mostrar taulell
        mostrarTaulell(taulell);

    }

    public static void missatgeBenvinguda() {
        System.out.println("==========");
        System.out.println("CONNECTA 4");
        System.out.println("==========\n");
    }

    public static int demanarFiles() {
        Scanner scanner = new Scanner(System.in);
        int files;
        do {
            System.out.print("Introdueix el número de files: ");
            files = scanner.nextInt();
        } while (files < 1);
        return files;
    }

    public static int demanarColumnes() {
        Scanner scanner = new Scanner(System.in);
        int columnes;
        do {
            System.out.print("Introdueix el número de columnes: ");
            columnes = scanner.nextInt();
        } while (columnes < 1);
        return columnes;
    }

    public static char[][] crearTaulell(int filas, int columnas) {
        char[][] taulell = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                taulell[i][j] = ' ';
            }
        }
        return taulell;
    }

    public static void mostrarTaulell(char[][] taulell) {
        System.out.println();
        
        //Imprimir les files amb separadors
        for (int i = 0; i < taulell.length; i++) {
            System.out.print("" + (taulell.length - i) + " | ");
            for (int j = 0; j < taulell[i].length; j++) {
                System.out.print(taulell[i][j] + " | ");
            }
            System.out.println();

            //Línia separadora
            System.out.print(" ");
            for (int j = 0; j < taulell[i].length; j++) {
                System.out.print("----");
            }
            System.out.println("-");
        }

        //Numeració de les columnes
        System.out.print("   ");
        for (int j = 1; j <= taulell[0].length; j++) {
            System.out.print(" " + j + "  ");
        }
        System.out.println();

    }

}
