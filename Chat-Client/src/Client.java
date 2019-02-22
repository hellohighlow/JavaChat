import java.util.*;
import java.io.*;
import java.net.*;

public class Client implements IClient, Runnable {
   private ArrayList<INetworkListener> listeners; //List of INetworkListeners
   private Socket socket; //Socket to connect to
   private BufferedReader in; //Server to client input stream
   private PrintWriter out; //Client to server input stream
   private boolean running;
   private GUI gui;

   public Client(String IP, int port, GUI gui) throws UnknownHostException, IOException{
      this.gui = gui;
      listeners = new ArrayList<INetworkListener>();
      socket = new Socket(IP, port);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      running = true;
   }
   public void run(){
      try {
         while (running) {
            process(in.readLine());
            if(gui.pressed)
               send(gui.isPushed());
         }
      }catch(Exception e){System.out.println("Caught error: " + e);}
   }
   public void send(String message){
      for(INetworkListener i : listeners)
         i.send(message, this);
   }
   public void process(String str){
      for(INetworkListener i : listeners)
         i.process(str, this);
   }
   public void addNetworkListener(INetworkListener listener){
      listeners.add(listener);
   }
   public void stop(){
      running = false;
   }
   public void append(String str){
      String[] strings = str.split(" ");
      if(strings[0].equals("LIST"))
         gui.addUser(strings[1]);
      else
         gui.print(str);
   }
}
