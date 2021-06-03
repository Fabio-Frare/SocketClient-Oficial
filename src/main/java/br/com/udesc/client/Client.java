package br.com.udesc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author fabio
 */
public class Client {

    public static void main(String[] args) throws IOException {
        
        
        while (true) {
            Socket s = new Socket("localhost", 80);

            // Enviando dados Cliente >> Servidor
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("is it a work");
            pr.flush();

            // Recebendo dados Servidor >> Cliente
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("server: " + str);
        }
//        
//        s.close();
    }

}
