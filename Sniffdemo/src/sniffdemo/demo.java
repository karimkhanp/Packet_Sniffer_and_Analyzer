/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sniffdemo;

import java.io.*;
import java.io.InputStreamReader;
import jpcap.packet.*;
import jpcap.NetworkInterface;
import jpcap.JpcapCaptor;

/**0
 *
 *
 * @author karimkhan
 */
public class demo {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JpcapCaptor capture;
    int i;
    String str, info;
    NetworkInterface[] list = JpcapCaptor.getDeviceList();
    int choice,selection;
    Packet packet;
  //  TCPPacket tcppacl = (TCPPacket) packet;

    public static void main(String a[]) throws IOException {
        new demo();
    }

    public demo() throws IOException {

        System.out.println("Available Interface");

        System.out.println(list.length);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].description);
        }
        System.out.println("************************");
        System.out.println("Chooses yout choice 0,1");
        System.out.println("");

        str = br.readLine();
        //str="0";
        choice = Integer.parseInt(str);

        byte[] mac = list[choice].mac_address;
        System.out.println("");
        //System.out.println("Addresses     :" + list[choice].addresses);
        System.out.println("Addresses in hexadecimal  :");
        for (byte b : list[i].mac_address) {
            System.out.print(Integer.toHexString(b & 0xff) + ":");
        }
        System.out.println("");
        System.out.println("************************");


       
        System.out.println("Select Option  :");
        System.out.println("1 for ICMP");
        System.out.println("2 for  UDP");
        System.out.println("3 for TCP");
        System.out.println("4 for IGMP");
       
        String s=br.readLine();
        int selection=Integer.parseInt(s);



        for (i = 0; i < 5000; i++) {

            int i1=0;
             capture = JpcapCaptor.openDevice(list[choice], 500, true, 200);
            Packet prot2 = capture.getPacket();
            //  byte[] v=prot2.data
            byte[] d = prot2.data;

            byte[] h = prot2.header;
           for(byte b : d  ){
               System.out.println(Integer.toString(16).toUpperCase());
           }
//           String p=new String(d);
                System.out.println("");
                System.out.println("String form data:" + d);
                System.out.println("");
                System.out.println("String form header:" + h);
                System.out.println("");
            String ss=prot2.toString();
                
            if(prot2==null)
                    continue;
           // String prot2 = prot.data.toString();
//            if (prot1.contains("protocol(1)"))
//            {
//                i1 = prot1.indexOf("protocol(1)");
//            }
//            else if (prot1.contains("protocol(2)"))
//            {
//                i1 = prot1.indexOf("protocol(2)");
//            }
//            else if (prot1.contains("protocol(6)"))
//            {
//                i1 = prot1.indexOf("protocol(6)");
//            }
//
//            else if(prot1.contains("protocol(17)"))
//            {
//                i1 = prot1.indexOf("protocol(17)");
//            }
//             else if(prot1.contains("ARP"))
//            {
//               continue;
//            }
//            int i2 = prot1.indexOf("priority(0)");
//            System.out.println(i1+"  "+i2);
//            String prot2 = prot1.substring(i1, i2).trim();
//            System.out.println("STRING   : " + prot2);
            if(ss.contains("protocol(2)") && selection==4)
            {
                System.out.println("Received packet IGMP :" + prot2.data);
            }

            if(ss.contains("protocol(1)") && selection==1)
            {
                System.out.println("Received packet ICMP :" + capture.getPacket());
            }

            if(ss.contains("protocol(6)") && selection==3)
            {
                System.out.println("Received packet TCP :" + capture.getPacket());
            }

            if(ss.contains("protocol(17)") && selection==2)
            {
                System.out.println("Received packet UDP :" + prot2.data);
            }
            
            //System.out.println("packet header   :" + capture.getPacket().header.toString());
            //System.out.println("");


        }
// for (byte b : capture.getPacket().header)
//                System.out.print(Integer.toHexString(b&0xff).toString() + ":");
//            System.out.println("");
//
//
    
//        for (byte b : capture.getPacket().data) {
//            System.out.println(  ":");
        }
//          //  System.out.println("header :" + capture.getPacket().datalink);






    }



