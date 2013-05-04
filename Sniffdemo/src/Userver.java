import java.net.*;
import java.io.*;
public class Userver
{
 	public static void main(String arg[])
	{
 		try{
		        	DatagramSocket socket= new DatagramSocket(4445);
             byte[] sendbuf = new byte[256];
     			byte[] receivebuf = new byte[256];
			DatagramPacket packet = new DatagramPacket(receivebuf,
                                       	receivebuf.length);
  			socket.receive(packet);
String received = new String(packet.getData());
 			String ss= received.substring(0,packet.getLength());
   			System.out.println(ss);
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
 String dString = "Hello User from "+address;
  			sendbuf = dString.getBytes();
packet = new DatagramPacket(sendbuf, sendbuf.length, address, port);     socket.send(packet);
       		 }
        		catch(Exception e)
       		 {}
 }
}
