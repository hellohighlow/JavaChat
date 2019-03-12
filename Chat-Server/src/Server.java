import java.net.*;
import java.util.*;

public class Server implements IServer, Runnable{

   private ArrayList<IClient> serverSideClients;
   private boolean running;
   private GUI gui;
   private ServerSocket listener;
   private int ID;

   public IClient[] getClients() {
      return (IClient[])serverSideClients.toArray();
   }
   public void broadcast(String data) {
      for(int i = 0; i < serverSideClients.size(); i++)
         serverSideClients.get(i).send(data);
   }
   public void remove(IClient c) {
      ServerSideClient serverSideClient = (ServerSideClient)c;
      serverSideClients.remove(c);
      broadcast("REMOVE "+serverSideClient.getHandle());
   }
   public void run() {
      try{
         while(running){
            gui.append("Accepting Clients");

            Socket clientSocket = listener.accept();
            ServerSideClient NewClient = new ServerSideClient(nextID(), this, clientSocket, gui);
            serverSideClients.add(NewClient);
            broadcast("ADD " + NewClient.getHandle());
            Thread client = new Thread(NewClient);
            client.start();
            gui.append("Client " + NewClient.getHandle() + " Connected");
         }
      }catch(Exception e ){System.out.println("ERR: " + e.getStackTrace());}
   }
   public void stop() {running = false;}
   public Server(GUI gui, int port){
      try {
         this.gui = gui;
         ID = 1;
         running = true;
         serverSideClients = new ArrayList<IClient>();
         listener = new ServerSocket(port);
      }catch(Exception e){System.out.println("ERR: " + e.getStackTrace());}

   }
   public int nextID(){
      ID = ID+1;
      return ID-1;
   }
}
