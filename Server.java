import java.net.*;
import java.io.*;

public class Server {
	

	static int port = 2345; 	
								
	public static void main(String[] args)    {
		
       try {
    	 
    	   ServerSocket sock = new ServerSocket(port);
    	   
  
    	   System.out.println("Ожидание подключений...");
    	   Socket client = sock.accept();
    	   System.out.println("Подключился клиент");
           
    
    	   InputStream sin = client.getInputStream();
    	   OutputStream sout = client.getOutputStream();

    	 
    	   DataInputStream in = new DataInputStream(sin);
    	   DataOutputStream out = new DataOutputStream(sout);
    	   
 
    	   while(true) {
    		 
    		   String line = in.readUTF();
    		   System.out.println("Получена строка: " + line);
    		   
    		 
    		   try {
    			   int x = Integer.valueOf(line);
    			   int y = x * x;
    			
    			   out.writeUTF(Integer.toString(y));
    		   } catch (NumberFormatException ex) {
    			   System.out.println("Получена строка: ");
    			   out.writeUTF("Ожидалось целое число");   
    		   }
    		   out.flush(); 
    	   }
      } catch(IOException ex) {
    	
    	  System.out.println("Ошибка ввода/вывода");
    	  ex.printStackTrace();
	  }
   }
}
