/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexioncliente.servidor;
import java.net.*;
import java.io.*;
/**
 *
 * @author monte
 */
public class Conector {
    //variables del socket
    Socket cliente;
    //Parametros del servidor
    int puerto=8080;
    String ip="192.168.1.76";
    BufferedReader entrada,teclado;
    PrintStream salida;
    public void iniciar(){
        try{
            //Creacion del socket con parametros del servidor
            cliente=new Socket(ip,puerto);
            //Creacion de la ntrada
            entrada=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            //Creacion de la lectura del teclado
            teclado=new BufferedReader(new InputStreamReader(System.in));
            //Lectura del Teclado
            String txt=teclado.readLine();
            //Creacion de la salida
            salida=new PrintStream(cliente.getOutputStream());
            //Impresion de la salida
            salida.println(txt);
            //Lectura de la salida del servidor
            String mensaje=entrada.readLine();
            //Impresion de la lecturta
            System.out.println(mensaje);
            //Cerrar entradas,salidas y socket
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();            
        }catch(Exception e){
            System.out.println("Algo salio mal :c");
        }
    }
}
