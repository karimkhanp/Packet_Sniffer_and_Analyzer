package javaapplication1;

import java.net.*;
import java.io.*;

public class Alice
{
     	public static void main(String arg[]) throws IOException
	{
         		BufferedReader br=null;
         		Socket s=null;
         		PrintWriter pw=null;
         		BufferedReader br1=null;
		try
		{
			s=new Socket("192.168.60.78",8888);
			br =new BufferedReader(new InputStreamReader(System.in));
		           pw=new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		           br1=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg= "he";
                        pw.print(msg);
			while (true)
			{
				//msg=br.readLine();
				pw.println(msg);
				pw.flush();
				String str=br1.readLine();
				System.out.println(" echo : "+str);
				if(str.equalsIgnoreCase(" server stop"))
    					break;
			}
		}
		catch(Exception e)
		{
		}
		br.close();
		s.close();
		pw.close();
		br1.close();
	}
}
