/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sniffdemo;

import java.net.*;
import java.io.*;

public class userver {

    public static void main(String arg[]) {
        byte[] receivebuf = new byte[256];
        try {
            while (true) {
                DatagramSocket ds = new DatagramSocket(8888); //Server binded with port number
                System.out.println("serveradd=>" + ds.getLocalSocketAddress());
                while (true) {

                    DatagramPacket packet = new DatagramPacket(receivebuf,
                            receivebuf.length);
                    ds.receive(packet);
                    myt tr = new myt(packet, ds);
                    tr.start();
                }
            }
        } catch (Exception e) {
        }
    }
}

class myt extends Thread {

    DatagramPacket packet;
    DatagramSocket ds;
    byte[] sendbuf = new byte[256];

    myt(DatagramPacket p, DatagramSocket d) {
        this.packet = p;
        this.ds = d;
    }

    public void run() {
        try {


            String received = new String(packet.getData());
            String ss = received.substring(0, packet.getLength());
            InetAddress address = packet.getAddress();
            System.out.println("Client address :" + packet.getAddress() + "port :" + packet.getPort() );
            int port = packet.getPort();
            ss="Hi client";
            sendbuf = ss.getBytes();
            packet = new DatagramPacket(sendbuf, sendbuf.length,
                    address, port);
            ds.send(packet);
        } catch (Exception e) {
        }
    }
}

