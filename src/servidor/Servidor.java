
package servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class Servidor extends Thread{

    //Hacer en casa
     int num1, num2, total = 0;
        int result = 0;
        char signo = 0;
        static int puerto=5555;
        public static int CONT=0;
        
    public void run(){
        CONT++;
        while (CONT<3){
        
        try{
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket=new ServerSocket();
            
            
            System.out.println("Realizando el bind");

            InetSocketAddress addr=new InetSocketAddress("localhost",puerto);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");
            
                        
            Socket newSocket= serverSocket.accept();
            puerto++;
            new Servidor().start();
            
            System.out.println("Conexion recibida");

            InputStream is=newSocket.getInputStream();
            OutputStream os=newSocket.getOutputStream();
            
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
            
            

            System.out.println("La operacion a realizar es: "+num1+signo+num2);      
            System.out.println("RESULTADO "+total);
            System.out.println("CONTADOR "+CONT);
            os.write(total);
            os.flush();
            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
            }
    }
        
    }
    public static void main(String[] args) {
        
       new Servidor().start();
        
       
    }
}
