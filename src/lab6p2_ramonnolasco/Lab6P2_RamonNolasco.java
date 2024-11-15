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
                    
                    ejecutarTablasDeVerdad(scanner);
               
                }
                
                case 2 -> {
                    
                    
                    
                }
                
                case 3 -> {
                    
                    
                    
                }
                
                case 4 -> menu = false;
            }
        
        
        }while(menu == true);                    
    }
    
    
    public static void ejecutarTablasDeVerdad(Scanner scanner) {
        Random random = new Random();

        System.out.print("Ingrese el numero de filas para la tabla de verdad: ");
        int filas = scanner.nextInt();

        
        boolean[][] proposiciones = new boolean[filas][2];
        for (int i = 0; i < filas; i++) {
            proposiciones[i][0] = random.nextBoolean(); 
            proposiciones[i][1] = random.nextBoolean(); 
        }

        
        System.out.println("Matriz inicial (P y Q):");
        imprimirMatriz(proposiciones);

        
        System.out.print("Ingrese la operacion logica (pvq para OR, p^q para AND): ");
        String operacion = scanner.next();

        
        boolean[][] resultado = realizarOperacion(proposiciones, operacion);

        
        if (resultado != null) {
            System.out.println("Matriz resultado:");
            imprimirMatriz(resultado);
        } else {
            System.out.println("Operación invalida.");
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

    
    
    
}
