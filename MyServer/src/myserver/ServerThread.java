/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Andre Kelvin
 */
public class ServerThread extends Thread {

    private BufferedReader input;
    private BufferedWriter output;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private ServerSocket serSock;
    private Socket sock;
    public TextArea textArea;
    public TextField text;

    @Override
    public void run() {
        try {
            serSock = new ServerSocket(444);
            sock = serSock.accept();

            //input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            //output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
            dataIn = new DataInputStream(sock.getInputStream());
            dataOut = new DataOutputStream(sock.getOutputStream());

//                String line;
//                while ((line = input.readLine()) != null) {
//                    textArea.appendText("Client says: " + line+"\n");
//                }
            
            while (sock.isConnected()) {
                textArea.appendText("Client says: " + dataIn.readUTF() + "\n");
            }
        } catch (Exception e) {
        }
    }

    public void writeOutput() throws IOException {
        dataOut.writeUTF(text.getText());
        //output.newLine();
        textArea.appendText("You: " + text.getText() + "\n");
        dataOut.flush();
        text.clear();
    }
}
