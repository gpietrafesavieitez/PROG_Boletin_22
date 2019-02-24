/**
 * Gabriel P.
 * CPR Daniel Castelao
 * <gpietrafesavieitez@danielcastelao.org>
 */

package boletin_22_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Buzon {
    static ArrayList<Correo> listaCorreos = new ArrayList<>();
    
    static int numeroDeCorreos(){
        return listaCorreos.size();
    }
    
    static void añadir(Correo c){
        listaCorreos.add(c);
    }
    
    static int porLeer(){
        int c = 0;
        for(Correo obx : listaCorreos){
            if(obx.isflagSinLeer()){
                c++;
            }
        }
        return c;
    }
    
    static String mostrarPrimerNoLeido(){
        for(Correo obx : listaCorreos){
            if(obx.isflagSinLeer()){
                obx.flagSinLeer(false);
                return "=> '" + obx.toString() + "'";
            }
        }
        return "[ info ] No hay mensajes nuevos.";
    }
    
    static String mostrar(int k){
        listaCorreos.get(k).flagSinLeer(false); // Hacemos constar de que se ha leido
        return listaCorreos.get(k).toString(); // Devolvemos el contenido del correo
    }
    
    static void eliminar(int k){
        listaCorreos.remove(k);
    }
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String key = null;
        do{
            try{
                System.out.print("\n[ BUZÓN DE CORREOS ]: " + numeroDeCorreos() + " correo(s) en total.\n\t1: Añadir\n\t2: Vistazo\n\t3: Mostrar\n\t4: Eliminar\n\t5: Salir (" + porLeer() + " mensaje(s) sin leer)\n\t?: ");
                key = leer.nextLine();
                switch(key.toLowerCase()){
                    case "1":
                    case "añadir":
                        System.out.print("\n[ AÑADIR ]\n\t- Redacte el correo: ");
                        añadir(new Correo(leer.nextLine(),true));
                        break;
                    case "2":
                    case "vistazo":
                        System.out.println("\n[ VISTAZO ]\n\t" + mostrarPrimerNoLeido());
                        break;
                    case "3":
                        System.out.print("\n[ MOSTRAR ]\n\t- Introduzca la posición del correo a mostrar: ");
                        System.out.println("\n\t=> '" + mostrar(Integer.parseInt(leer.nextLine()) - 1) + "'");
                        break;
                    case "4":
                    case "eliminar":
                        System.out.print("\n[ ELIMINAR ]\n\t- Introduzca la posición del correo a eliminar: ");
                        eliminar(Integer.parseInt(leer.nextLine() ) - 1);
                        break;
                    case "5":
                    case "salir":
                        System.exit(0);
                    default:
                        System.out.println("\n\t[ error ] Porfavor, seleccione una opción válida.");
                }
            }catch(NullPointerException e1){
                System.out.println("\n\t[ error ] El valor no puede ser nulo.");
            }catch(NumberFormatException e2){
                System.out.println("\n\t[ error ] El formato introducido no es correcto.");
            }catch(IndexOutOfBoundsException e3){
                System.out.println("\n\t[ error ] No existe esa posición.");
            }catch(Exception e){
                System.out.println("\n\t[ error ] Ha ocurrido un error inesperado.");
            }
        }while(!key.equals("5") || !key.equalsIgnoreCase("salir"));
    }
}