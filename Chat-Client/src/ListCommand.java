import java.util.ArrayList;

public class ListCommand extends NetworkListenerAdapter {

   private final String COMMAND = "LIST";
   private ArrayList<String> users;

   public void process(String message, IClient client) {
      users = new ArrayList<String>();
      //message should be LIST 7 Highlow3 Bee5 Hazel
      if(isCommand(message, COMMAND)){
         String[] str = message.split(" ", 3);
         int start = Integer.parseInt(str[1]);
         users.add(str[2].substring(0,start));
         String s;
         String[] tmp;
         while(str[2].length() > 0){
            s = str[2].substring(start);
            tmp = s.split(" ", 2);
            if(tmp[0].equals("")){
               break;
            }
            start = Integer.parseInt(tmp[0]);
            users.add(tmp[1].substring(0,start));
            str[2] = tmp[1].substring(start);
         }
         for(String s1 : users)
            client.append("LIST "+s1);
      }
   }
   public void send(String message, IClient client) {
      if(isCommand(message,COMMAND)){
         ((Client) client).out.println(message);
      }
   }
}
