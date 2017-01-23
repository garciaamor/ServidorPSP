
package servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class Servidor {

    
    public static void main(String[] args) {
        
        int num1, num2, total = 0;
        int result = 0;
        char signo = 0;
       try{
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket=new ServerSocket();
            
            System.out.println("Realizando el bind");

            InetSocketAddress addr=new InetSocketAddress("localhost",5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");
            
            
            
            Socket newSocket= serverSocket.accept();

            System.out.println("Conexion recibida");

            InputStream is=newSocket.getInputStream();
            OutputStream os=newSocket.getOutputStream();

            /*byte[]mensaje=new byte[25];        
            is.read(mensaje);*/
            
            num1=is.read();
            num2=is.read();
            
            result = is.read();
        if (result == 1) {

            signo = '+';
            total = (num1 + num2);


        }
        if (result == 2) {

            signo = '-';
            total = (num1 - num2);
        }
        if (result == 3) {


            signo = 'x';
            total = (num1 * num2);
        }
        if (result == 4) {


            signo = '/';
            total = (num1 / num2);
        }

            System.out.println(num1);
            System.out.println(num2);
            

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
            }
    }
}
