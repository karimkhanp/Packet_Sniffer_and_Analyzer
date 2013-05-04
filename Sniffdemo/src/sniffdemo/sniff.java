package sniffdemo;

import java.io.*;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import jpcap.*;
import jpcap.packet.Packet;
import jpcap.packet.*;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.JpcapCaptor;
import javax.swing.Action;
import javax.swing.JTextArea;
import jpcap.PacketReceiver;
import sniffdemo.packet;

/**
 *
 * @author Abdul karim
 */
public class sniff extends javax.swing.JFrame {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    JpcapCaptor capture;
    int i;
    String str, info;
    NetworkInterface[] list = JpcapCaptor.getDeviceList();
    int choice;

    /** Creates new form sniff */
    public sniff() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        textArea1 = new java.awt.TextArea();
        jTextField16 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 102));
        setFont(new java.awt.Font("Andalus", 1, 12));

        jLabel1.setBackground(new java.awt.Color(196, 209, 49));
        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("packet Sniffer and analyzeR");

        jRadioButton1.setText("TCP Packet");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ELProperty.create("${selection.selected}"), jRadioButton1, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        jRadioButton2.setText("UDP Packet");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ELProperty.create("${selection.selected}"), jRadioButton2, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        jRadioButton3.setText("ICMP packet");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ELProperty.create("${selection.selected}"), jRadioButton3, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        jButton1.setText("Capture Packets");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Source IP : ");

        jLabel3.setText("Destination IP  :");

        jLabel4.setText("Source Port :");

        jLabel5.setText("Destination Port :");

        jLabel6.setText("Protocol Type :");

        jLabel7.setText("Version  :");

        jLabel8.setText("Data Length  :");

        jLabel9.setText("Delay Flag  : ");

        jLabel10.setText("Dont fragment Flag  :");

        jLabel11.setText("Identification :");

        jLabel12.setText("Header length  :");

        jLabel13.setText("Urgent Bit");

        jLabel14.setText("Sequence Number : ");

        jLabel15.setText("Ack Value");

        jLabel16.setText("Ack Number  : ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel17.setText("Data    :");

        jLabel18.setText("Thank You");

        jRadioButton4.setText("ARP Packet");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ELProperty.create("${selection.selected}"), jRadioButton4, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        jRadioButton5.setText("RARP Packet");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ELProperty.create("${selection.selected}"), jRadioButton5, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        jLabel19.setFont(new java.awt.Font("Stencil", 1, 24));
        jLabel19.setForeground(new java.awt.Color(255, 0, 153));
        jLabel19.setText("Full Arcieve");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField3)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel15))
                                        .addGap(83, 83, 83)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton3))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton4)
                                        .addGap(259, 259, 259)
                                        .addComponent(jLabel17)
                                        .addGap(34, 34, 34)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jRadioButton2))))
                        .addGap(385, 385, 385))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jRadioButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel17)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel18)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton2.isSelected() == true) {
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
              System.out.println("Address   :" + list[choice].addresses);
              System.out.println("" + list[choice].mac_address);
            System.out.println("Interface Description     :" + list[choice].description + " Interface    Name :" + list[choice].name);
          
            System.out.println("");

            JpcapCaptor capture = null;
            try {
                capture = JpcapCaptor.openDevice(list[choice], 65000, true, 1000);


  //              True if ywe want to open the interface in promiscuous mode, and otherwise false.
//In promiscuous mode, we can capture packets every packet from the wire, i.e., even if its source or destination MAC address is not same as the MAC address of the interface you are opening.
//In non-promiscuous mode, we can only capture packets send and received by your host.
            } catch (IOException ex) {
                Logger.getLogger(sniff.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (i = 0; i < 500; i++) {
                Packet pack = capture.getPacket();
                String ss = capture.getPacket().toString();
                JpcapCaptor captute = null;
                byte[] s = pack.data;

                if (pack instanceof UDPPacket) {
                    UDPPacket udpPacket = (UDPPacket) pack;

                    //String data=udpPacket.data;
                    byte[] data2 = udpPacket.data;
                    String dat = new String(data2);
                    System.out.println("Udp Packet :" + dat);
                    System.out.println("Source IP " + udpPacket.src_ip);
                    System.out.println("Destination IP : " + udpPacket.dst_ip);
                    System.out.println("Source port  :" + udpPacket.dst_port);
                    System.out.println("Version " + udpPacket.version);
                    System.out.println("Header length" + udpPacket.header.length);
                    System.out.println("");
                    System.out.println("");

                    jTextField16.setText(dat);
                    //   System.out.println("UDP packet wid tostrnig  :" + isoData2);
                    jTextField1.setText(udpPacket.src_ip.toString());

                    System.out.println("Source Port :" + udpPacket.src_port);
                    Integer aaa = new Integer(udpPacket.src_port);
                    String sp = aaa.toString();

                    jTextField4.setText(sp);
                    // jTextField5.se
                    textArea1.append("UDP packet  :" + "\n" + "Payload  :" + dat + "\n" + "Source IP  :" + udpPacket.src_ip + "\n" + "Destiantion IP :"+
                            udpPacket.dst_ip + "\n" + "Source Port  :" + udpPacket.src_port + "\n" + "Destination Port :" + udpPacket.dst_port + "\n"
                            + "Hop Limit  : " + udpPacket.hop_limit + "\n" +"Protocol  :" +  udpPacket.protocol + "\n" +"Version  :" + udpPacket.version
                           + "Data Length  :" + udpPacket.data.length + "\n" + "\n");
                    System.out.println("Destination IP :" + udpPacket.dst_ip.toString());
                    jTextField2.setText(udpPacket.dst_ip.toString());
                    System.out.println("Destination Port " + udpPacket.dst_port);
                    Integer bbb = new Integer(udpPacket.dst_port);
                    String sss = bbb.toString(bbb);

                    jTextField3.setText(sss);
                    System.out.println("Protocol : " + udpPacket.protocol);
                    Short s2 = new Short(udpPacket.protocol);
                    String strp = new String(s2.toString());


                    jTextField6.setText(strp.toString());
                    System.out.println("Version :" + udpPacket.version);
                    Byte byt1 = new Byte(udpPacket.version);
                    jTextField8.setText(byt1.toString());

                    System.out.println("Header length" + udpPacket.header.length);
                    Integer int1 = new Integer(udpPacket.header.length);
                    String str2 = new String(int1.toString());
                    jTextField9.setText(str2);

                    System.out.println("Data length : " + udpPacket.data.length);
                    Integer int2 = new Integer(udpPacket.header.length);
                    String str3 = new String(int1.toString());
                    jTextField5.setText(str2);

                    System.out.println("Delay flag :  " + udpPacket.d_flag);
                    Boolean bol1 = new Boolean(udpPacket.d_flag);
                    String str4 = new String(bol1.toString());
                    jTextField11.setText(str4);

                    Short srt=udpPacket.hop_limit;
                    String abc=srt.toString();
                    jTextField10.setText(abc);
                    jLabel11.setText("Hop Limit :");

                    System.out.println("Dont fragement flag" + udpPacket.dont_frag);
                    Boolean bol2 = new Boolean(udpPacket.d_flag);
                    String str5 = new String(bol1.toString());
                    jTextField7.setText(str4);

                    System.out.println("Identification : " + udpPacket.ident);
                    Integer int3 = new Integer(udpPacket.header.length);
                    String str6 = new String(int1.toString());
                    jTextField11.setText(str2);

                    System.out.println("Dont Frag : " + udpPacket.d_flag);
                    Boolean ba=udpPacket.d_flag;
                    String sa=ba.toString();
                    jLabel13.setText("Dont frag :");
                    jTextField12.setText(sa);

                    System.out.println("rsv toc  :" + udpPacket.caplen);
                    Integer ints=new Integer(udpPacket.caplen);
                    String o=new String(ints.toString());

                    jTextField13.setText(o);
                    jLabel14.setText("Capture lenth  :");

                    System.out.println("hop count :" + udpPacket.hop_limit);
                    Short st1 = new Short(udpPacket.hop_limit);
                    String str9 = new String(st1.toString());
                    jLabel15.setText("hop count  : ");
                    jTextField14.setText(str9);

                    System.out.println("" + udpPacket.more_frag);
                    Boolean bl4 = new Boolean(udpPacket.more_frag);
                    String str10 = new String(bl4.toString());
                    jTextField15.setText(str10);
                    jLabel16.setText("More frag value :");

                    textArea1.append("");

                }
            }

        }
        if (jRadioButton1.isSelected() == true) {
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
            JpcapCaptor capture = null;
            try {
                capture = JpcapCaptor.openDevice(list[choice], 65000, true, 1000);
            } catch (IOException ex) {
                Logger.getLogger(sniff.class.getName()).log(Level.SEVERE, null, ex);
            }
            // JpcapWriter writer=JpcapWriter.openDumpFile(capture,"demo");
            //  JpcapWriter writer = JpcapWriter.openDumpFile(capture, "demo");
            for (i = 0; i < 20; i++) {

                //   capture=JpcapCaptor.openDevice(list[choice], 65535, true, 20);
                //  JpcapWriter writer=JpcapWriter.openDumpFile(capture,"demo");

                Packet pack = capture.getPacket();

                if (pack instanceof TCPPacket) {
                    TCPPacket tcpPacket = (TCPPacket) pack;
                    byte[] data1 = tcpPacket.data;
                    String isoData1 = new String(data1);
                    jTextField16.setText(isoData1);
                    System.out.println("Tcp Packet :" + isoData1);
                    System.out.println("Source IP : " + tcpPacket.src_ip);
                    //  jTextField1.setAction((Action) (tcpPacket.src_ip));
                    jTextField1.setText(tcpPacket.src_ip.toString());

                    System.out.println("Source Port :" + tcpPacket.src_port);
                    Integer aaa = new Integer(tcpPacket.src_port);
                    String s = aaa.toString();

                    jTextField4.setText(s);
                    // jTextField5.se

                    System.out.println("Destination IP :" + tcpPacket.dst_ip.toString());
                    jTextField2.setText(tcpPacket.dst_ip.toString());
                    System.out.println("Destination Port " + tcpPacket.dst_port);
                    Integer bbb = new Integer(tcpPacket.dst_port);
                    String ss = bbb.toString(bbb);

                    jTextField3.setText(ss);
                    System.out.println("Protocol : " + tcpPacket.protocol);
                    Short s2 = new Short(tcpPacket.protocol);
                    String strp = new String(s2.toString());
                    jTextField8.setText(strp);


                    jTextField6.setText(strp.toString());
                    System.out.println("Version :" + tcpPacket.version);
                    Byte byt1 = new Byte(tcpPacket.version);
                    jTextField8.setText(byt1.toString());

                    System.out.println("Header length" + tcpPacket.header.length);
                    Integer int1 = new Integer(tcpPacket.header.length);
                    String str2 = new String(int1.toString());
                    jTextField9.setText(str2);

                    System.out.println("HOP limit : " + tcpPacket.hop_limit);
                    Short sss = new Short(tcpPacket.hop_limit);
                    String strpq = new String(s2.toString());
                    jLabel8.setText("hop limit : ");
                    jTextField5.setText(strpq);

                    System.out.println("Delay flag :  " + tcpPacket.d_flag);
                    Boolean bol1 = new Boolean(tcpPacket.d_flag);
                    String str4 = new String(bol1.toString());
                    jTextField11.setText(str4);

                    System.out.println("Dont fragement flag" + tcpPacket.dont_frag);
                    Boolean bol2 = new Boolean(tcpPacket.d_flag);
                    String str5 = new String(bol1.toString());
                    jTextField7.setText(str4);

                    System.out.println("Identification : " + tcpPacket.ident);
                    Integer int3 = new Integer(tcpPacket.header.length);
                    String str6 = new String(int1.toString());
                    jTextField10.setText(str2);

                    System.out.println("Urgent bit" + tcpPacket.urg);
                    Boolean bol3 = new Boolean(tcpPacket.urg);
                    String str7 = new String(bol3.toString());
                    jTextField12.setText(str7);

                    System.out.println("Sequene number  : " + tcpPacket.sequence);
                    Long ln1 = new Long(tcpPacket.sequence);
                    String str8 = new String(ln1.toString());
                    jTextField13.setText(str8);

                    System.out.println("ACK  : " + tcpPacket.ack);
                    Boolean bol4 = new Boolean(tcpPacket.ack);
                    String str9 = new String(bol4.toString());
                    jTextField14.setText(str9);

                    System.out.println("ACK number" + tcpPacket.ack_num);
                    Long ln2 = new Long(tcpPacket.sequence);
                    String str10 = new String(ln2.toString());
                    jTextField15.setText(str8);


                    textArea1.append( "Data captured :" + isoData1 +"Source IP : " + tcpPacket.src_ip + "\n" + "Destination IP :" + tcpPacket.dst_ip + "\n" + "Source port" + tcpPacket.src_port
                            + "\n" + "Destination port  :" + tcpPacket.dst_port + "\n" + "Version   :" + tcpPacket.version + "Protocol value   :" + tcpPacket.protocol
                            + "\n" + "Header Length   :" + tcpPacket.header.length + "\n" + "Ack Number :" + tcpPacket.ack_num + "\n" + "Sequence Number  :" + tcpPacket.sequence + "\n" + "Urgent bit set  :" + tcpPacket.urg + "\n"
                            + "------------------------------" + "\n" + "New Packet" + "\n" + "\n");

                }

    }//GEN-LAST:event_jButton1ActionPerformed

        }



      
        if (jRadioButton3.isSelected() == true) {


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
            JpcapCaptor capture = null;
            try {
                capture = JpcapCaptor.openDevice(list[choice], 65000, true, 1000);
            } catch (IOException ex) {
                Logger.getLogger(sniff.class.getName()).log(Level.SEVERE, null, ex);
            }
            // JpcapWriter writer=JpcapWriter.openDumpFile(capture,"demo");
            //  JpcapWriter writer = JpcapWriter.openDumpFile(capture, "demo");
            for (i = 0; i < 500; i++) {

                //   capture=JpcapCaptor.openDevice(list[choice], 65535, true, 20);
                //  JpcapWriter writer=JpcapWriter.openDumpFile(capture,"demo");

                Packet pack = capture.getPacket();

                if (pack instanceof ICMPPacket) {
                    ICMPPacket icmpPacket = (ICMPPacket) pack;

                    //String data=udpPacket.data;
                    byte[] data2 = icmpPacket.data;
                    String dat = new String(data2);
                    //  System.out.println("UDP Packet :" + dat);
                    System.out.println("Source IP : " + icmpPacket.src_ip);
                    //  jTextField1.setAction((Action) (tcpPacket.src_ip));
                    jTextField1.setText(icmpPacket.src_ip.toString());


                    // jTextField5.se

                    System.out.println("Destination IP :" + icmpPacket.dst_ip.toString());
                    jTextField2.setText(icmpPacket.dst_ip.toString());

                    System.out.println("Protocol : " + icmpPacket.protocol);
                    Short s2 = new Short(icmpPacket.protocol);
                    String strp = new String(s2.toString());

                    jTextField6.setText(strp.toString());
                    System.out.println("Version :" + icmpPacket.version);
                    Byte byt1 = new Byte(icmpPacket.version);
                    jTextField8.setText(byt1.toString());

                    System.out.println("ICMP Echo :" + icmpPacket.ICMP_ECHO);
                    Short st1 = new Short(icmpPacket.ICMP_ECHO);
                    jLabel8.setText("ICMP echo");
                    String is1 = st1.toString();
                    jTextField5.setText(is1);

                    System.out.println("ICMP Echo reply :" + icmpPacket.ICMP_ECHOREPLY);
                    Short st2 = new Short(icmpPacket.ICMP_ECHOREPLY);
                    jLabel12.setText("ICMP echo reply");
                    String is2 = st1.toString();
                    jTextField9.setText(is2);


                    System.out.println("ICMP redirect :" + icmpPacket.ICMP_REDIRECT);
                    Short st3 = new Short(icmpPacket.ICMP_REDIRECT);  //Shorter rout to host
                    jLabel10.setText("ICMP redirect");
                    String is3 = st1.toString();
                    jTextField7.setText(is3);

                    System.out.println("ICMP redirect host :" + icmpPacket.ICMP_REDIRECT_HOST);
                    Short st4 = new Short(icmpPacket.ICMP_REDIRECT_HOST);
                    jLabel9.setText("ICMP Redirect host");//Shorter rout to host
                    String is4 = st1.toString();
                    jTextField11.setText(is4);

                    System.out.println("ICMP Redirect Net :" + icmpPacket.ICMP_REDIRECT_NET);
                    Short st5 = new Short(icmpPacket.ICMP_REDIRECT_NET);
                    jLabel13.setText("ICMP Redirect net");  //shorter rout to network
                    String is5 = st1.toString();
                    jTextField12.setText(is5);

                    System.out.println("ICMP Sourcequenc" + icmpPacket.ICMP_SOURCEQUENCH);
                    Short st6 = new Short(icmpPacket.ICMP_SOURCEQUENCH);
                    jLabel15.setText("ICMP Sourcequence");
                    String is6 = st1.toString();
                    jTextField14.setText(is6);

                    System.out.println("ICMP Router solicitatiom :" + icmpPacket.ICMP_ROUTERSOLICIT);
                    Short st7 = new Short(icmpPacket.ICMP_ROUTERSOLICIT);
                    jLabel6.setText("ICMP Router licit"); //router solisitation
                    String is7 = st1.toString();
                    jTextField15.setText(is7);

                    System.out.println("Unreach host :" + icmpPacket.ICMP_UNREACH_PORT);
                    Short st8 = new Short(icmpPacket.ICMP_UNREACH_PORT);
                    jLabel11.setText("Unreach Host :");

                    jTextField10.setText(st8.toString());

                    textArea1.append("New ICMP Package :" + "\n" + "Source IP  :" + icmpPacket.src_ip + "\n" + "Echo reply  :" + icmpPacket.ICMP_ECHOREPLY + "\n" +"ICMP redirect" + icmpPacket.ICMP_REDIRECT
                             + "\n" + " Verion  :" + icmpPacket.version + "\n" + "Potocol  :" + icmpPacket.protocol + "\n" + "Priority   :" + icmpPacket.priority
                             + "\n" + " Source quench   :" + icmpPacket.ICMP_SOURCEQUENCH + "\n" + "Unreach host   :" + icmpPacket.ICMP_UNREACH_PORT + "\n" + "Hop limit  :" + icmpPacket.hop_limit + "\n" + "\n");

                }
            }
            }
            if (jRadioButton4.isSelected() == true) {

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
                //    JpcapCaptor capture = null;
                try {
                    capture = JpcapCaptor.openDevice(list[choice], 65000, true, 1000);
                } catch (IOException ex) {
                    Logger.getLogger(sniff.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (i = 0; i < 100; i++) {
                    Packet pack = capture.getPacket();
                    String ss = capture.getPacket().toString();
                    JpcapCaptor captute = null;
                    byte[] s = pack.data;

                    if (pack instanceof ARPPacket) {
                        ARPPacket arpPacket = (ARPPacket) pack;



                        System.out.println("ARP data :" + arpPacket.data);
                        byte[] by1 = arpPacket.data;
                        String as1 = new String(by1.toString());
                        jTextField16.setText(as1);

                        System.out.println("ARP Reqest :" + arpPacket.ARP_REQUEST);
                        Short srt1 = arpPacket.ARP_REQUEST;
                        String as2 = new String(srt1.toString());
                        jLabel2.setText("ARP request");
                        jTextField1.setText(as2);

                        System.out.println("ARP reply  :" + arpPacket.ARP_REPLY);
                        Short srt2 = arpPacket.ARP_REPLY;
                        String st3 = new String(srt2.toString());
                        jLabel3.setText("ARP Reply   :");
                        jTextField2.setText(st3);

                        System.out.println("PROTOTYPE IP :" + arpPacket.PROTOTYPE_IP);
                        Short srt4 = arpPacket.PROTOTYPE_IP;
                        String st4 = new String(srt4.toString());
                        jLabel4.setText("ARP Prototype - IP   :");
                        jTextField4.setText(st4);

                        System.out.println("Hardware type  :" + arpPacket.hardtype);
                        Short srt5 = arpPacket.hardtype;
                        String st5 = new String(srt5.toString());
                        jLabel5.setText("Hardware Type   :" );
                        jTextField3.setText(st5);

                        System.out.println("Prototype  :" + arpPacket.prototype);
                        Short srt6 = arpPacket.prototype;
                        String st6 = new String(srt6.toString());
                        jLabel6.setText("Protocol Type  :" );
                        jTextField8.setText(st6);

                        System.out.println("Datalink  :" + arpPacket.datalink);
                        DatalinkPacket srt7 = arpPacket.datalink;
                        String st7 = new String(srt7.toString());
                        jLabel7.setText("ARP Reply   :");
                   //     jTextField8.setText(st7);

                        System.out.println("Hardware length :" + arpPacket.hlen);
                        Short srt8 = arpPacket.hlen;
                        String st8 = new String(srt8.toString());
                        jLabel8.setText("Hardware length   :");
                        jTextField5.setText(st8);

                        System.out.println("Sender hardware address :" + arpPacket.sender_hardaddr);
                        byte[] by3 = arpPacket.sender_hardaddr;
                       
                        String st9 = new String(by3.toString());
                        jLabel12.setText("Sender Hardware address   :");
                        jTextField9.setText(st9);

                        System.out.println("Protocol adress length :" + arpPacket.plen);
                        Short srt10 = arpPacket.plen;
                        String st10 = new String(srt10.toString());
                        jLabel10.setText("Protocol Address length   :" );
                        jTextField7.setText(st10);

                        System.out.println("ARP operation  :" + arpPacket.operation);
                        Short srt11 = arpPacket.operation;
                        String st11 = new String(srt11.toString());
                        jLabel11.setText("ARP Operation  :" );
                        jTextField10.setText(st11);

                        System.out.println("Peer address request :" + arpPacket.INV_REQUEST);
                        Short srt13 = arpPacket.INV_REQUEST;
                        String st13 = new String(srt13.toString());
                        jLabel9.setText("Peer address reply   :");
                        jTextField11.setText(st13);

                        System.out.println("Peer Address reply" + arpPacket.INV_REPLY); // Identify peer address
                        Short srt12 = arpPacket.INV_REPLY;
                        String st12 = new String(srt12.toString());
                        jLabel3.setText("Peer Address reply  :");
                        jTextField12.setText(st12);

                        // System.out.println("" + arpPacket.sender_protoaddr);
                        System.out.println("Sender protocol address :" + arpPacket.sender_hardaddr);
                        byte[] by4 = arpPacket.sender_hardaddr;
                        String st44 = new String(by4.toString());
                        jLabel15.setText("Sender protocol address   :" );
                        jTextField14.setText(st44);

                        System.out.println("target hardware address :" + arpPacket.target_hardaddr);
                        byte[] by5 = arpPacket.target_hardaddr;
                        for(byte b:arpPacket.target_hardaddr){
                            System.out.print("\n"+Integer.toHexString(b & 0xff)+"\n");
                        }
                        String st55 = new String(by5.toString());
                        jLabel14.setText("target Hardware address   :" );
                        jTextField13.setText(st55);

                        System.out.println("Target Protocol address :" + arpPacket.target_protoaddr);
                        byte[] by6 = arpPacket.target_protoaddr;
                        String st66 = new String(by6.toString());
                        jLabel12.setText("Target Protocol address   :" );
                        jTextField9.setText(st9);

                        textArea1.append("New RARP Packet :" + "\n" + "ARP Request  :" + arpPacket.ARP_REQUEST + "\n" + "ARP reply" + arpPacket.ARP_REPLY
                                + "\n" + "\n" + "ARP prototype   :" + arpPacket.PROTOTYPE_IP + "\n" + "Hardware type  :" + arpPacket.hardtype
                                + "\n" + "SEnder HArdware Address :" + arpPacket.sender_hardaddr.toString() + "\n" + "Sender Protocol  :" + arpPacket.sender_protoaddr + "\n" +
                                "Target H/W address  :" + arpPacket.target_hardaddr + "\n" + "Target Prototype :" + arpPacket.target_protoaddr
                                + "\n" + "ARP Datalink  :" +arpPacket.datalink + "\n" +"prototype  :" + arpPacket.prototype + "\n" + "\n") ;
                        
                    }
                }
                }
///RARP

            if (jRadioButton5.isSelected() == true) {

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
                //    JpcapCaptor capture = null;
                try {
                    capture = JpcapCaptor.openDevice(list[choice], 65000, true, 1000);
                } catch (IOException ex) {
                    Logger.getLogger(sniff.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (i = 0; i < 5; i++) {
                    Packet pack = capture.getPacket();
                    String ss = capture.getPacket().toString();
                    JpcapCaptor captute = null;
                    byte[] s = pack.data;

                    if (pack instanceof ARPPacket) {
                        ARPPacket rarpPacket = (ARPPacket) pack;



                        System.out.println("RARP data :" + rarpPacket.data);
                        byte[] by1 = rarpPacket.data;
                        String as1 = new String(by1.toString());
                        jTextField16.setText(as1);

                        System.out.println("RARP Reqest :" + rarpPacket.RARP_REQUEST);
                        Short srt1 = rarpPacket.RARP_REQUEST;
                        String as2 = new String(srt1.toString());
                        jLabel2.setText("RARP request");
                        jTextField1.setText(as2);

                        System.out.println("RARP reply  :" + rarpPacket.RARP_REPLY);
                        Short srt2 = rarpPacket.RARP_REPLY;
                        String st3 = new String(srt2.toString());
                        jLabel3.setText("RARP Reply   :" + rarpPacket.RARP_REPLY);
                        jTextField2.setText(st3);

                        System.out.println("PROTOTYPE IP :" + rarpPacket.PROTOTYPE_IP);
                        Short srt4 = rarpPacket.PROTOTYPE_IP;
                        String st4 = new String(srt4.toString());
                        jLabel4.setText("RARP Prototype - IP   :" + rarpPacket.PROTOTYPE_IP);
                        jTextField4.setText(st4);

                        System.out.println("Hardware type  :" + rarpPacket.hardtype);
                        Short srt5 = rarpPacket.hardtype;
                        String st5 = new String(srt5.toString());
                        jLabel5.setText("Hardware Type   :" + rarpPacket.hardtype);
                        jTextField3.setText(st5);

                        System.out.println("Prototype  :" + rarpPacket.prototype);
                        Short srt6 = rarpPacket.prototype;
                        String st6 = new String(srt6.toString());
                        jLabel6.setText("Protocol Type  :" + rarpPacket.prototype);
                        jTextField8.setText(st6);

                        System.out.println("Datalink  :" + rarpPacket.datalink);
                        DatalinkPacket srt7 = rarpPacket.datalink;
                        String st7 = new String(srt7.toString());
                        jLabel7.setText("RARP Reply   :" + rarpPacket.datalink);
                        jTextField8.setText(st7);

                        System.out.println("Hardware length :" + rarpPacket.hlen);
                        Short srt8 = rarpPacket.hlen;
                        String st8 = new String(srt8.toString());
                        jLabel8.setText("Hardware length   :" + rarpPacket.hlen);
                        jTextField5.setText(st8);

                        System.out.println("Sender hardware address :" + rarpPacket.sender_hardaddr);
                        byte[] by3 = rarpPacket.sender_hardaddr;
                        String st9 = new String(by3.toString());
                        jLabel12.setText("Sender Hardware address   :" + rarpPacket.sender_hardaddr);
                        jTextField9.setText(st9);

                        System.out.println("Protocol adress length :" + rarpPacket.plen);
                        Short srt10 = rarpPacket.plen;
                        String st10 = new String(srt10.toString());
                        jLabel10.setText("Protocol Address length   :" + rarpPacket.plen);
                        jTextField7.setText(st10);

                        System.out.println("RARP operation  :" + rarpPacket.operation);
                        Short srt11 = rarpPacket.operation;
                        String st11 = new String(srt11.toString());
                        jLabel11.setText("RARP Operation  :" + rarpPacket.plen);
                        jTextField10.setText(st11);

                        System.out.println("Peer address request :" + rarpPacket.INV_REQUEST);
                        Short srt13 = rarpPacket.INV_REQUEST;
                        String st13 = new String(srt13.toString());
                        jLabel9.setText("Peer address reply   :" + rarpPacket.RARP_REQUEST);
                        jTextField11.setText(st13);

                        System.out.println("Peer Address reply" + rarpPacket.INV_REPLY); // Identify peer address
                        Short srt12 = rarpPacket.INV_REPLY;
                        String st12 = new String(srt12.toString());
                        jLabel3.setText("Peer Address reply  :" + rarpPacket.INV_REPLY);
                        jTextField12.setText(st12);

                        // System.out.println("" + arpPacket.sender_protoaddr);
                        System.out.println("Sender protocol address :" + rarpPacket.sender_hardaddr);
                        byte[] by4 = rarpPacket.sender_hardaddr;
                        String st44 = new String(by4.toString());
                        jLabel15.setText("Sender protocol address   :" + rarpPacket.sender_protoaddr);
                        jTextField14.setText(st44);

                        System.out.println("target hardware address :" + rarpPacket.target_hardaddr);
                        byte[] by5 = rarpPacket.target_hardaddr;
                        String st55 = new String(by5.toString());
                        jLabel14.setText("target Hardware address   :" + rarpPacket.target_hardaddr);
                        jTextField13.setText(st55);

                        System.out.println("Target Protocol address :" + rarpPacket.target_protoaddr);
                        byte[] by6 = rarpPacket.target_protoaddr;
                        String st66 = new String(by6.toString());
                        jLabel12.setText("Target Protocol address   :" + rarpPacket.target_protoaddr);
                        jTextField9.setText(st9);

                        textArea1.append("New RARP Packet :" + "\n" + "ARP Request  :" + rarpPacket.ARP_REQUEST + "\n" + "ARP reply" + rarpPacket.ARP_REPLY
                                + "\n" + "ARP data  :" + rarpPacket.data + "\n" + "ARP prototype   :" + rarpPacket.PROTOTYPE_IP + "\n" + "Hardware type  :" + rarpPacket.hardtype
                                + "\n" + "SEnder HArdware Address :" + rarpPacket.sender_hardaddr + "\n" + "Sender Protocol  :" + rarpPacket.sender_protoaddr + "\n" +
                                "Target H/W address  :" + rarpPacket.target_hardaddr + "\n" + "Target Prototype :" + rarpPacket.target_protoaddr
                                + "\n" + "ARP Datalink  :" +rarpPacket.datalink + "\n" +"prototype  :" + rarpPacket.prototype) ;
                    }
                }
            }
        }
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new sniff().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.awt.TextArea textArea1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
