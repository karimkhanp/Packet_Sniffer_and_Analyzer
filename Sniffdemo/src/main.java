/* Program: Console TCP/IP packet sniffer, using jpcap
 * Author: Plaguez
 * Date: 01.01.2008
 */

import java.net.*;
import java.io.*;
import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.*;

	class Main {

	   	/* variables */
	   	JpcapCaptor captor;
	   	NetworkInterface[] list;
	   	String str,info;
	   	int x, choice;

	    	public static void main(String args[]) {
	      	   new Main();
	    	}

	    	public Main() {

		     /* first fetch available interfaces to listen on */
		        list = JpcapCaptor.getDeviceList();
			System.out.println("Available interfaces: ");

			for(x=0; x<list.length; x++) {
			     System.out.println(x+" -> "+list[x].description);
			}
		            System.out.println("-------------------------\n");
		            choice = Integer.parseInt(getInput("Choose interface (0,1..): "));
			    System.out.println("Listening on interface -> "+list[choice].description);
			    System.out.println("-------------------------\n");



		  /*Setup device listener */
		  try {
		         captor=JpcapCaptor.openDevice(list[choice], 65535, false, 20);
			 /* listen for TCP/IP only */
			 captor.setFilter("ip and tcp", true);
		      }
		         catch(IOException ioe) { ioe.printStackTrace(); }


		  /* start listening for packets */
		  while (true) {

	                Packet info = captor.getPacket();
		           if(info != null)
		           System.out.print(getPacketText(info));
	             }
	    	}


        /* get user input */
        public static String getInput(String q) {
	      String input = "";
	      System.out.print(q);
	      BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
	           try {
	               input = bufferedreader.readLine();
	             }
	               catch(IOException ioexception) { }
	        return input;
            }


     /* return packet data in true text */
     String getPacketText(Packet pack){
           int i=0,j=0;
           byte[] bytes=new byte[pack.header.length + pack.data.length];

      		System.arraycopy(pack.header, 0, bytes, 0, pack.header.length);
      		System.arraycopy(pack.data, 0, bytes, pack.header.length, pack.data.length);
      		StringBuffer buffer = new StringBuffer();

      		for(i=0; i<bytes.length;) {
      			for(j=0;j<8 && i<bytes.length;j++,i++) {
      				String d = Integer.toHexString((int)(bytes [i] &0xff));
      				buffer.append((d.length() == 1 ? "0" + d:d ) + " ");

      	        if(bytes[i]<32 || bytes[i]>126)
      	        	bytes[i] = 46;
      	           }
           }
      	     return new String(bytes,i - j, j);
      	 }
} /* end class */

