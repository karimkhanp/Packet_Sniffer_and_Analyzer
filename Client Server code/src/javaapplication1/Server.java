package javaapplication1;

import java.net.*;
import java.io.*;

public class Server
{
	public static void main(String arg[])
     	{
         		try
         		{
            	 	ServerSocket ss=new ServerSocket(8888);
             		while(true)
             		{
        				Socket s=ss.accept();
        				System.out.println("server :"+ ss.getLocalPort() );
        				System.out.println("client :"+ s.getPort());

        				myt tr=new myt(s);
        				tr.start();
             		}
         		}
         		catch(Exception e)
         		{
             		System.out.println(e);
         		}
     	}
}

class myt extends Thread
{
    	Socket s;
    	myt(Socket s)
    	{
       		this.s=s;
    	}

    	public void run()
    	{
       	 	try
        		{
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        			String str;

                 		while(!(str=br.readLine()).equalsIgnoreCase("end"))
          			{
        				pw.println(str);
        				pw.flush();
          			}
        			System.out.println(" client is stop with poet no =>"+s.getPort() );

        			pw.println(" server stop");
        			pw.close();
        			br.close();
        			s.close();
        		}
        		catch(Exception e)
        		{
                		System.out.println("error");
        		}
    	}
}
