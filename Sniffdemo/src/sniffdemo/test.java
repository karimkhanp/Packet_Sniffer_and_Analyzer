/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sniffdemo;

import java.io.*;
import java.io.InputStreamReader;
import java.net.InetAddress;
import jpcap.*;
import jpcap.packet.Packet;
import jpcap.packet.*;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.JpcapCaptor;
import jpcap.PacketReceiver;
import sniffdemo.packet;

public class test {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JpcapCaptor capture;
    int i;
    String str, info;
    NetworkInterface[] list = JpcapCaptor.getDeviceList();
    int choice;

    public static void main(String a[]) throws IOException {
        new test();
    }

    public test() throws IOException {
        System.out.println("Available Interface");
        System.out.println(list.length);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].description);
        }
        System.out.println("************************");
        System.out.println("Chooses yout choice 0,1,2");
        System.out.println("");

        str = "0";
        choice = Integer.parseInt(str);
        System.out.println("Interface Description     :" + list[choice].description + " Interface    Name :" + list[choice].name);
        System.out.println("");
        capture = JpcapCaptor.openDevice(list[choice], 6500, true, 800);
        for (i = 0; i < 2000; i++) {
            Packet pack = capture.getPacket();

            byte[] s = pack.data;
            if (pack instanceof UDPPacket) {
                UDPPacket udpPacket = (UDPPacket) pack;

                //String data=udpPacket.data;
                byte[] data2 = udpPacket.data;
                String dat = new String(data2);
                System.out.println("Udp Packet :" + dat);
                System.out.println("Source IP " + udpPacket.src_ip);
                System.out.println("Destination IP "+udpPacket.dst_ip);
                System.out.println("Source port" + udpPacket.dst_port);
                System.out.println("Version " + udpPacket.version);
                System.out.println("Header length" + udpPacket.header.length);
                System.out.println("");
                System.out.println("");
                //   System.out.println("UDP packet wid tostrnig  :" + isoData2);


            }
        }
    }
}
