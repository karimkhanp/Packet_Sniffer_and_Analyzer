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
public class arp {

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

    public arp() throws IOException {

        System.out.println("Available Interface");
        System.out.println("arp");
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



       

      //  String s=br.readLine();


      //  int selection=Integer.parseInt(s);

        for (i = 0; i < 100; i++) {
            int i1=0;
             capture = JpcapCaptor.openDevice(list[choice], 60000, true, 200);
            Packet prot = capture.getPacket();
            String str=prot.data.toString();
//            byte[] data2=prot.data;
//            byte[] head=prot.header;
//            if(data2==null)
//                    continue;
//            String prot1 = prot.toString();
//            System.out.println("Data   :" + data2);
          if(prot instanceof ARPPacket)
          {
              ARPPacket arpr=(ARPPacket)prot;

              System.out.println("" + arpr.ARP_REPLY);
          }
        }
    }
}