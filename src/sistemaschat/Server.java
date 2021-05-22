/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaschat;

import chat.modelo.DetalleMensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Server implements Runnable {

    private String nick;
    private String ip;
    private String mensaje;
    private DetalleMensaje recibirDetalleMensaje;
    private int puerto;

    public Server() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(9999);

            while (true) {
                Socket miSocket = servidor.accept();

                ObjectInputStream recibirPaquete = new ObjectInputStream(miSocket.getInputStream());
                recibirDetalleMensaje = (DetalleMensaje) recibirPaquete.readObject();

                nick = recibirDetalleMensaje.getNick();
                ip = recibirDetalleMensaje.getIp();
                mensaje = recibirDetalleMensaje.getMensaje();
                puerto = recibirDetalleMensaje.getPuerto();

                Socket enviarMensaje = new Socket("192.168.0.101", puerto);

                ObjectOutputStream enviarPaquete = new ObjectOutputStream(enviarMensaje.getOutputStream());

                enviarPaquete.writeObject(recibirDetalleMensaje);

                enviarPaquete.close();
                enviarMensaje.close();

                //miSocket.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
