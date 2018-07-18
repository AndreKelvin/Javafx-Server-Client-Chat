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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Andre Kelvin
 */
public class MyClientController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Label label;
    private Socket sock;
    private BufferedReader input;
    private BufferedWriter output;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private ClientThread c;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @FXML
    private void sendAction() {
        try {
            c.writeOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //start the server connection
        c = new ClientThread();
        //Reference TextArea and TextField of Controller Class to Client Thread Class
        //So that the same effect will happen to both componet here 
        c.textArea = textArea;
        c.textField = textField;
        c.start();
        label.setText("Connected to server");
    }

    //    private class ClientThread extends Thread {
    //
    //        @Override
    //        public void run() {
    //            try {
    //                InetAddress ip = InetAddress.getLocalHost();
    //
    //                sock = new Socket(ip, 444);
    //                output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    //                input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    //                dataOut=new DataOutputStream(sock.getOutputStream());
    //                dataIn=new DataInputStream(sock.getInputStream());
    //
    //                String line;
    //                while ((line = input.readLine()) != null) {
    //                    textArea.appendText("Server says: " + line+"\n");
    //                }
    //                while(sock.isConnected()){
    //                    System.out.println("ok");
    //                    textArea.appendText("Server says: " +dataIn.readUTF()+"\n");
    //                }
    //            } catch (Exception e) {
    //                e.printStackTrace();
    //            }
    //        }
    //    }
}
