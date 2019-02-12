/**
 * Gabriel P.
 * CPR Daniel Castelao
 * <gpietrafesavieitez@danielcastelao.org>
 */

package boletin_22_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Buzon {
    static ArrayList<Correo> listaCorreos = new ArrayList<>();
    
    static int porLeer(){
        int c = 0;
        for(Correo obx : listaCorreos){
            if(obx.isflagSinLeer()){
                c++;
            }
        }
        return c;
    }
    
    static void añadir(Correo c){
        listaCorreos.add(c);
    }
    
    static String vistazo(){
        String devolver = "\t[ INFO ] No hay mensajes nuevos.";
        for(Correo obx : listaCorreos){
            if(obx.isflagSinLeer()){
                obx.flagSinLeer(false);
                devolver = obx.toString();
                break;
            }
        }
        return devolver;
    }
    
    static String mostrar(int k){ // FALTA SETEAR A FALSE CUANDO SE MUESTRA EL CORREO
        if(k < 0){
            return "\t[ ERROR ] Valor no puede ser negativo.";
        }else if(k > listaCorreos.size()){
            return "\t[ AVISO ] No existe ningún correo en esa posición.";
        }else{
            return listaCorreos.get(k).toString();
        }
    }
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int input;
        String key = null;
        listaCorreos.add(new Correo("Define a clase Buzon para xestionar unbuzon de correo",true));
        listaCorreos.add(new Correo("Para representar o buzon de correo úsase un array de correos",true));
        listaCorreos.add(new Correo("Define a clase Correo cos métodos que creas convenientes",true));
        do{
            try{
                System.out.print("\n[ BUZÓN DE CORREOS ]\n\t1: Añadir\n\t2: Vistazo\n\t3: Mostrar\n\t4: Eliminar\n\t5: Salir (" + porLeer() + " mensaje(s) sin leer)\n\t$: ");
                key = leer.nextLine();
                switch(key.toLowerCase()){
                    case "1":
                    case "añadir":
                        System.out.print("\n[ AÑADIR ]\n\t- Redacte el contenido: ");
                        key = leer.nextLine();
                        añadir(new Correo(key,true));
                        break;
                    case "2":
                    case "vistazo":
                        System.out.println("\n[ VISTAZO ]\n" + vistazo());
                        break;
                    case "3":
                        System.out.print("\n[ MOSTRAR ]\n\t- Introduzca la posición: ");
                        System.out.println(mostrar(Integer.parseInt(leer.nextLine())));
                        break;
                    case "4":
                    case "eliminar":
                        System.out.println("\n[ ELIMINAR ]");
                        break;
                    case "5":
                    case "salir":
                        System.exit(0);
                    default:
                        System.out.println("\n\t[ ERROR ] Porfavor, seleccione una opción válida.");
                }
            }catch(NullPointerException e1){
                System.out.println("\n\t[ ERROR ] El valor no puede ser nulo.");
            }catch(NumberFormatException e2){
                System.out.println("\n\t[ ERROR ] El formato introducido no es correcto.");
            }catch(Exception e){
                System.out.println("\n\t[ ERROR ] Ha ocurrido un error inesperado." + e.toString());
            }
        }while(!key.equals("4") || !key.equalsIgnoreCase("salir"));
    }
}