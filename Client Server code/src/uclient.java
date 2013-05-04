/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.*;
import java.io.*;
public class uclient
{
	public static void main(String arg[])
  	{
        		try
        		{
                        while(true){
			DatagramSocket socket=new DatagramSocket();
			byte[] sendbuf = new byte[256];
 			byte[] receivebuf = new byte[256];
                        //run this code in ishan's PC t, aderess below PC is server's change accoring to
			InetAddress address = InetAddress.getByName("192.168.60.78");
     			String message="Hello Datagram server";
   			sendbuf=message.getBytes();
                        DatagramPacket packet = new DatagramPacket(sendbuf, sendbuf.length,address, 8888);
                        socket.send(packet);
      			packet = new DatagramPacket(receivebuf, receivebuf.length);
        			socket.receive(packet);
			String s=new String(packet.getData());
      			String ss= s.substring(0,packet.getLength());
  			System.out.println(ss);
 		}
                        }
		catch(Exception e)
		{}
	}


}
