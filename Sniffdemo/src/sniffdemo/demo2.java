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

/**
 *
 * @author karimkhan
 */
public class demo2 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JpcapCaptor capture;
    int i;
    String str, info;
    NetworkInterface[] list = JpcapCaptor.getDeviceList();
    int choice,selection;
    Packet packet;
  //  TCPPacket tcppacl = (TCPPacket) packet;

    public static void main(String a[]) throws IOException {
        new demo2();
    }

    public demo2() throws IOException {

        System.out.println("Available Interface");

        System.out.println(list.length);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].description);
        }
        System.out.println("************************");
        System.out.println("Chooses yout choice 0,1");
        System.out.println("");

        str = "0";
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

        for (i = 0; i < 100; i++) {
            int i1=0;
             capture = JpcapCaptor.openDevice(list[choice], 60000, true, 200);
            Packet prot = capture.getPacket()
                    ;

            byte[] data2=prot.data;
            byte[] head=prot.header;
            if(data2==null)
                    continue;
            String prot1 = prot.toString();
            System.out.println("Data   :" + data2);
            if(prot1.contains("ARP"))
            {
                System.out.println("data  :" + data2);
            }
            if(prot1.contains("protocol(1)"))
            {
                if(selection==1)
                    System.out.println("Received Packet : " + data2);
                    System.out.println("Received Packet : " + head);
                //i1 = prot1.indexOf("protocol(1)");
            }
            if (prot1.contains("protocol(2)"))
            {
                if(selection==4)
                    System.out.println("Received Packet : " + data2);
                    System.out.println("Received Packet : " + head);

             ///   i1 = prot1.indexOf("protocol(2)");
            }

            else if(prot1.contains("protocol(17)"))
            {
                if(selection==2)
                    System.out.println("Received Packet : " + capture.getPacket());
            }
            

            else if (prot1.contains("protocol(6)"))
            {
                if(selection==3)
                    if(prot instanceof TCPPacket)
                    {
                       Packet pack = capture.getPacket();
             if (pack instanceof TCPPacket) {
                TCPPacket tcpPacket = (TCPPacket) pack;
                byte[] data = tcpPacket.data;
                String isoData = new String(data); //, "ISO-8859-1"
                System.out.println(isoData);
                    }
            }

             
            int i2 = prot1.indexOf("priority(0)");
            System.out.println(i1+"  "+i2);
            String prot2 = prot1.substring(i1, i2).trim();
         //   System.out.println("STRING   : " + prot2);
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
    }








