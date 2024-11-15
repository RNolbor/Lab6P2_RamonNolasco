/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p2_ramonnolasco;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author ramon
 */
public class Lab6P2_RamonNolasco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        
        boolean menu = true;    
        do{
            System.out.println("1-Tablas de Verdad");
            System.out.println("2-Triangulo con patron");
            System.out.println("3-Intercambio de filas y columnas");
            System.out.println("4-Salir");
        
            System.out.println("Ingrese opcion: ");
            int opcion = scanner.nextInt();
            while (opcion < 1 || opcion > 4){
                System.out.println("Ingrese una opcion valida!");
                opcion = scanner.nextInt();
            }
            
            switch (opcion){
                
                case 1 -> {
                    
                    TablasDeVerdad(scanner);
               
                }
                
                case 2 -> {
                    
                    Triangulo(scanner);
                    // "se deforma de los bordes cuando el tamaño es alto"
                    
                }
                
                case 3 -> {
                    
                    
                    
                }
                
                case 4 -> menu = false;
            }
        
        
        }while(menu == true);                    
    }
    
    
    // METODOS PARA LAS TABLAS DE VERDAD
    
    
    public static void TablasDeVerdad(Scanner scanner) {
        Random random = new Random();

        System.out.print("Ingrese el numero de filas para la tabla de verdad: ");
        int filas = scanner.nextInt();

        
        boolean[][] proposiciones = new boolean[filas][2];
        for (int i = 0; i < filas; i++) {
            proposiciones[i][0] = random.nextBoolean(); 
            proposiciones[i][1] = random.nextBoolean(); 
        }

        
        System.out.println("Matriz inicial (P   Q):");
        imprimirMatriz(proposiciones);

        
        System.out.print("Ingrese la operacion logica (pvq para OR, p^q para AND): ");
        String operacion = scanner.next();

        
        boolean[][] resultado = realizarOperacion(proposiciones, operacion);

        
        if (resultado != null) {
            System.out.println("Matriz resultado:");
            imprimirMatriz(resultado);
        } else {
            System.out.println("Operacion invalida.");
        }

       
    }

    public static void imprimirMatriz(boolean[][] matriz) {
        for (boolean[] fila : matriz) {
            for (boolean valor : fila) {
                System.out.print((valor ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }

    public static boolean[][] realizarOperacion(boolean[][] proposiciones, String operacion) {
        int filas = proposiciones.length;
        boolean[][] resultado = new boolean[filas][3];

        for (int i = 0; i < filas; i++) {
            resultado[i][0] = proposiciones[i][0]; 
            resultado[i][1] = proposiciones[i][1]; 

            
            switch (operacion) {
                case "pvq": 
                    resultado[i][2] = resultado[i][0] || resultado[i][1];
                    break;
                case "p^q": 
                    resultado[i][2] = resultado[i][0] && resultado[i][1];
                    break;
                default:
                    return null;
            }
        }
        return resultado;
    }

    
    // METODOS PARA EL TRIANGULO
    
    
    public static void Triangulo (Scanner scanner){
        
        System.out.println("Ingrese el tamaño del triangulo: ");
        int tamaño = scanner.nextInt();
        
        int[][] triangulo = crearTriangulo(tamaño);
        
        imprimirTriangulo(triangulo, tamaño);
    }
    
    public static int[][] crearTriangulo(int tamaño){
      
        int[][] matrizTA = new int [tamaño][tamaño];
        
        for (int i = 0 ; i < tamaño ; i++){
            matrizTA[i][0] = 1;
            matrizTA[i][i] =1;
        }
        
        for (int i = 2; i < tamaño ; i++){
            
            for (int j= 1 ; j < i; j ++){
                 matrizTA[i][j] = matrizTA[i - 1][j - 1] + matrizTA[i - 1][j];
            }    
        } 
        return matrizTA;
    }
    
    public static void imprimirTriangulo(int[][] matriz, int n) {
        for (int i = 0; i < n; i++) {
            // Espaciado inicial para centrar el triángulo
            for (int k = 0; k < n - i - 1; k++) {
                System.out.print("  ");
            }
            // Imprimir valores de la fila
            for (int j = 0; j <= i; j++) {
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    
    // METODOS PARA EL INTERCAMBIO DE FILAS
    
    
    public static void FilasColumnas (Scanner scanner){
        
        
        
        
    }
    
}
