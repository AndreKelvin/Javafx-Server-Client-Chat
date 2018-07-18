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
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
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
public class MyServerController implements Initializable {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField text;
    @FXML
    private Label label;
    private ServerSocket serSock;
    private Socket sock;
    private BufferedReader input;
    private BufferedWriter output;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private ServerThread s;

    @FXML
    private void handleButtonAction(ActionEvent event) {
//        ServerThread s = new ServerThread();
//        s.start();
    }

    @FXML
    private void sendAction() {
        try {
            s.writeOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //starts the server
        s = new ServerThread();
        //Reference TextArea and TextField of Controller Class to Server Thread Class
        //So that the same effect will happen to both componet here 
        s.textArea = textArea;
        s.text = text;
        s.start();
        label.setText("Sever Started");
    }

    //    public class ServerThread extends Thread {
    //
    //        @Override
    //        public void run() {
    //            try {
    //                serSock = new ServerSocket(444);
    //                sock = serSock.accept();
    //
    //                //input = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    //                //output = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    //                dataIn=new DataInputStream(sock.getInputStream());
    //                dataOut=new DataOutputStream(sock.getOutputStream());
    //
    //               String line;
    //                while ((line = input.readLine()) != null) {
    //                    textArea.appendText("Client says: " + line+"\n");
    //                }
    //                while(sock.isConnected()){
    //                    System.out.println("ok");
    //                    textArea.appendText("Client says: " +dataIn.readUTF()+"\n");
    //                }
    //            } catch (Exception e) {
    //                e.printStackTrace();
    //            }
    //        }
    //    }
}
