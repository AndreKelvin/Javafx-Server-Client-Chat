/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Andre Kelvin
 */
public class ClientThread extends Thread {

    private Socket sock;
    private BufferedReader input;
    private BufferedWriter output;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    public TextArea textArea;
    public TextField textField;

    @Override
    public void run() {
        try {
            sock = new Socket("localhost", 444);
//                output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
//                input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            dataOut = new DataOutputStream(sock.getOutputStream());
            dataIn = new DataInputStream(sock.getInputStream());

//                String line;
//                while ((line = input.readLine()) != null) {
//                    textArea.appendText("Server says: " + line+"\n");
//                }

            while (sock.isConnected()) {
                textArea.appendText("Server says: " + dataIn.readUTF() + "\n");
            }
        } catch (Exception e) {
        }
    }

    public void writeOutput() throws IOException {
        dataOut.writeUTF(textField.getText());
        //output.newLine();
        textArea.appendText("You: " + textField.getText() + "\n");
        dataOut.flush();
        textField.clear();
    }

}
