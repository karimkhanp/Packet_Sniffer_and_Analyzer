
import java.net.*;
import java.io.*;
public class Uclient
{
	public static void main(String arg[])
  	{
        		try
        		{
			DatagramSocket socket=new DatagramSocket();
			byte[] sendbuf = new byte[256];
 			byte[] receivebuf = new byte[256];
			InetAddress address = InetAddress.getByName("192.168.60.86");
     			String message="Hello Datagram server";
   			sendbuf=message.getBytes();
                                        DatagramPacket packet = new DatagramPacket(sendbuf, sendbuf.length,
     			address, 4445);
socket.send(packet);
      			packet = new DatagramPacket(receivebuf, receivebuf.length);
        			socket.receive(packet);
			String s=new String(packet.getData());
      			String ss= s.substring(0,packet.getLength());
  			System.out.println(ss);
 		}

		catch(Exception e)
		{}


	}


}

