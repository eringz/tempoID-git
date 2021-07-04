
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author E-rinGZ
 */
public class studentUpdate extends javax.swing.JFrame {

    /**
     * Creates new form studentUpdate
     */
    Connection myConnection = null;
    Statement myStatement = null;
    ResultSet myResult = null;
    public studentUpdate() {
        initComponents();
        
       
    }
      public void connect(){
        try{
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/temporaryid", "root", "");
            myStatement = myConnection.createStatement();
            myResult = myStatement.executeQuery("Select * From student");
        }catch (SQLException e){
            e.printStackTrace();
        }
           
          
    }
  public studentUpdate(String colegio, String person) {
        initComponents();
        connect();
        studentno.setText(colegio);
        idnumba.setText(person);
        idnumba.setVisible(false);
        cdmid.setVisible(false);
        String me = studentno.getText();  
        course.setBackground(new Color(0,0,0,0));
        last.setBackground(new Color(0,0,0,0));
        first.setBackground(new Color(0,0,0,0));
        mid.setBackground(new Color(0,0,0,0));
        kontak.setBackground(new Color(0,0,0,0));
        emailadd.setBackground(new Color(0,0,0,0));
        gl.setBackground(new Color(0,0,0,0));
        gf.setBackground(new Color(0,0,0,0));
        gm.setBackground(new Color(0,0,0,0));
        gc.setBackground(new Color(0,0,0,0));
        edit1.setBackground(new Color(0,0,0,0));
        edit2.setBackground(new Color(0,0,0,0));
        address.setBackground(new Color(0,0,0,0));
        last.setEditable(false);
        first.setEditable(false);
        mid.setEditable(false);
        kontak.setEditable(false);
        emailadd.setEditable(false);
        gl.setEditable(false);
        gf.setEditable(false);
        gm.setEditable(false);
        gc.setEditable(false);
        address.setEditable(false);      
        try{
            String sql = "select * from student where studentnumber='"+me+"'";
            Statement add = myConnection.createStatement();
            ResultSet rs = add.executeQuery(sql);
               if (rs.next()){
            String cdm = rs.getString(1);
            String lastname = rs.getString(4);
            String firstname = rs.getString(5);
            String middlename = rs.getString(6);
            String initial = middlename.substring(0,1);
            String fullname = firstname+" "+initial+". "+lastname;          
            String kurso = rs.getString(8);
            System.out.print(kurso);
            String idnumero = rs.getString(1);
            String gdl = rs.getString(9);
            String gdf = rs.getString(10);
            String gdm = rs.getString(11);
            String guardianini = gdm.substring(0,1);
            String gwardiya = gdf+" "+guardianini+" "+gdl;
            String gcontact = rs.getString(12);
            String cellphone = rs.getString(7);
            String eadd = rs.getString(13);
            String tirahan = rs.getString(14);
            String petsa = rs.getDate(2).toString();
            String oras = rs.getTime(15).toString();
            last.setText(lastname);
            first.setText(firstname);
            mid.setText(middlename);
            kontak.setText(cellphone);
            //course.setText(kurso);           
            emailadd.setText(eadd);
            address.setText(tirahan);
            gc.setText(gcontact);
            gl.setText(gdl);
            gf.setText(gdf);
            gm.setText(gdm);
            cdmid.setText(cdm);
            date.setText(petsa);
            time.setText(oras);
            date.setVisible(false);
            time.setVisible(false);
            if(kurso.contains("BSCPE-1A")==true){
                course.setSelectedIndex(0);
            }else if (kurso.contains("BSCPE-1B")==true){
                course.setSelectedIndex(1);
            }else if (kurso.contains("BSCPE-2A")== true){
                course.setSelectedIndex(2);
            }else if(kurso.contains("BSCPE-2B")==true){
                course.setSelectedIndex(3);
            }else if(kurso.contains("BSCPE-2C")==true){
                course.setSelectedIndex(4);
            }else if(kurso.contains("BSCPE-2D")== true){
                course.setSelectedIndex(5);
            }else{
                course.setSelectedIndex(-1);
            }
             Blob pic = rs.getBlob(16);          
            int blobLength = (int) pic.length();
             byte[] blobAsBytes = pic.getBytes(1, blobLength);
             BufferedImage bufferedImage = null;
             try {
                 bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
             } catch (IOException ex) {
                 Logger.getLogger(idOutput.class.getName()).log(Level.SEVERE, null, ex);
             }
            ImageIcon lit = new ImageIcon(bufferedImage);
             Image img = lit.getImage();
            Image newImg = img.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            photo.setIcon(image);
      }
        }catch (SQLException e){
                  e.printStackTrace();
            }
        
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        edit2 = new javax.swing.JButton();
        jlabel = new javax.swing.JLabel();
        studentno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        edit1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();
        jl1 = new javax.swing.JLabel();
        jl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idnumba = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        gc = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        last = new javax.swing.JTextField();
        gm = new javax.swing.JTextField();
        gf = new javax.swing.JTextField();
        gl = new javax.swing.JTextField();
        emailadd = new javax.swing.JTextField();
        kontak = new javax.swing.JTextField();
        mid = new javax.swing.JTextField();
        first = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        course = new javax.swing.JComboBox<>();
        cdmid = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 51, 51), new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/editAsset 1.png"))); // NOI18N
        photo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 210, 190));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/1x/1x/close50pxAsset 4.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 70, 50));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 760, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 760, 30));

        edit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/1x/1x/pen30Asset 2.png"))); // NOI18N
        edit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edit2MouseExited(evt);
            }
        });
        edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit2ActionPerformed(evt);
            }
        });
        jPanel1.add(edit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 60, 50));

        jlabel.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jlabel.setText("ADDRESS");
        jPanel1.add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 100, 40));

        studentno.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        studentno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentno.setText("STUDENT NO");
        jPanel1.add(studentno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 210, 30));

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel6.setText("CONTACT NO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 150, 20));

        save.setBackground(new java.awt.Color(61, 83, 244));
        save.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(235, 255, 238));
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 810, 180, 40));

        edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/1x/1x/pen30Asset 2.png"))); // NOI18N
        edit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edit1MouseExited(evt);
            }
        });
        edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit1ActionPerformed(evt);
            }
        });
        jPanel1.add(edit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 60, 50));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("STUDENT UPDATE");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 600, 70));

        jl2.setBackground(new java.awt.Color(3, 9, 52));
        jl2.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jl2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jl2.setText("EMAIL ADD");
        jPanel1.add(jl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 130, 30));

        jl1.setBackground(new java.awt.Color(3, 9, 52));
        jl1.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jl1.setText("CONTACT");
        jPanel1.add(jl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 130, 30));

        jl.setBackground(new java.awt.Color(3, 9, 52));
        jl.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jl.setText("FULL NAME");
        jPanel1.add(jl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 130, 30));

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        jLabel9.setText("GUARDIAN NAME");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 170, 20));

        idnumba.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        idnumba.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idnumba.setText("ID NUMBER");
        jPanel1.add(idnumba, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 220, 30));

        address.setColumns(20);
        address.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 700, 120));

        gc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gc.setText("contact");
        gc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcActionPerformed(evt);
            }
        });
        jPanel1.add(gc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 250, 50));

        jSeparator4.setBackground(new java.awt.Color(8, 50, 3));
        jSeparator4.setForeground(new java.awt.Color(8, 50, 3));
        jSeparator4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(8, 50, 3))); // NOI18N
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 720, 160));

        last.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        last.setText("lastname");
        last.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });
        jPanel1.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 160, 50));

        gm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gm.setText("mid");
        gm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmActionPerformed(evt);
            }
        });
        jPanel1.add(gm, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 110, 50));

        gf.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gf.setText("first name");
        gf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gfActionPerformed(evt);
            }
        });
        jPanel1.add(gf, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 160, 50));

        gl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gl.setText("lastname");
        gl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glActionPerformed(evt);
            }
        });
        jPanel1.add(gl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 150, 50));

        emailadd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emailadd.setText("email");
        emailadd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        emailadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailaddActionPerformed(evt);
            }
        });
        jPanel1.add(emailadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 300, 50));

        kontak.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kontak.setText("contact");
        kontak.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        kontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontakActionPerformed(evt);
            }
        });
        jPanel1.add(kontak, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 150, 50));

        mid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mid.setText("middlename");
        mid.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        mid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midActionPerformed(evt);
            }
        });
        jPanel1.add(mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 110, 50));

        first.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        first.setText("firstname");
        first.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });
        jPanel1.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 190, 50));

        jSeparator7.setBackground(new java.awt.Color(8, 50, 3));
        jSeparator7.setForeground(new java.awt.Color(8, 50, 3));
        jSeparator7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(8, 50, 3))); // NOI18N
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 270, 70));

        jSeparator5.setBackground(new java.awt.Color(8, 50, 3));
        jSeparator5.setForeground(new java.awt.Color(8, 50, 3));
        jSeparator5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(8, 50, 3))); // NOI18N
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 440, 70));

        jSeparator2.setBackground(new java.awt.Color(17, 78, 9));
        jSeparator2.setForeground(new java.awt.Color(17, 78, 9));
        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(8, 50, 3))); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 500, 70));

        jSeparator3.setBackground(new java.awt.Color(8, 50, 3));
        jSeparator3.setForeground(new java.awt.Color(8, 50, 3));
        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(8, 50, 3))); // NOI18N
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 490, 70));

        course.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCPE-1A", "BSCPE-1B", "BSCPE-2A", "BSCPE-2B", "BSCPE-2C", "BSCPE-2D" }));
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 40));

        cdmid.setText("jLabel1");
        jPanel1.add(cdmid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        date.setText("date");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 820, -1, -1));

        time.setText("time");
        jPanel1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 840, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/green1kAsset 1.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 880));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 880));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit1ActionPerformed
       
        last.setEditable(true);
        first.setEditable(true);
        mid.setEditable(true);
        kontak.setEditable(true);
        emailadd.setEditable(true); 
        last.setBackground(Color.WHITE);
        first.setBackground(Color.WHITE);
        mid.setBackground(Color.WHITE);
        kontak.setBackground(Color.WHITE);
        emailadd.setBackground(Color.WHITE);
        
    }//GEN-LAST:event_edit1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String info = studentno.getText();
               String person = idnumba.getText();
               this.dispose();
               new idOutput(info, person).show(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstActionPerformed

    private void midActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_midActionPerformed

    private void kontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakActionPerformed

    private void emailaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailaddActionPerformed

    private void glActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_glActionPerformed

    private void edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit2ActionPerformed
 
        gl.setEditable(true);
        gf.setEditable(true);
        gm.setEditable(true);
        gc.setEditable(true);
        address.setEditable(true); 
        address.setBackground(Color.WHITE);
         gl.setBackground(Color.WHITE);
        gf.setBackground(Color.WHITE);
        gm.setBackground(Color.WHITE);
        gc.setBackground(Color.WHITE);
    }//GEN-LAST:event_edit2ActionPerformed

    private void gfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gfActionPerformed

    private void gmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gmActionPerformed

    private void gcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gcActionPerformed

    private void edit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit1MouseEntered
         edit1.setBackground(Color.GRAY);
    }//GEN-LAST:event_edit1MouseEntered

    private void edit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit1MouseExited
        edit1.setBackground(new Color(0,0,0,0));
    }//GEN-LAST:event_edit1MouseExited

    private void edit2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit2MouseEntered
         edit2.setBackground(Color.GRAY);
    }//GEN-LAST:event_edit2MouseEntered

    private void edit2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit2MouseExited
        edit2.setBackground(new Color(0,0,0,0));
    }//GEN-LAST:event_edit2MouseExited

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        connect();
        String cdm = cdmid.getText();
        String stu = studentno.getText();
        String apelido = last.getText().toUpperCase();
        String pangalan = first.getText().toUpperCase();
        String gitna = mid.getText().toUpperCase();
        String cellphone = kontak.getText();
        String emailaddress = emailadd.getText();
        String guardianlast = gl.getText().toUpperCase();
        String guardianfirst = gf.getText().toUpperCase();
        String guardianmid = gm.getText().toUpperCase();
        String guardiancontact = gc.getText();
        String tirahan = address.getText().toUpperCase();
        String kurso = course.getSelectedItem().toString();
        Date petsa = new Date();
            java.sql.Date dql =new java.sql.Date(petsa.getTime());
            Date oras = new Date();
            java.sql.Time tql = new java.sql.Time(oras.getTime());
            
        try{
        String me = "update  student SET idnumber=?, date=?, studentnumber=?, lastname=?, firstname=?, middlename=?"
                + ", contact=?,course=?, guardianlast=?, guardianfirst=?, guardianmiddle=?,guardiancontact=?"
                + ",email=?,address=?,time=?  WHERE idnumber='"+cdm+"'";
                PreparedStatement add = myConnection.prepareStatement(me);
                add.setString(1, cdm);
                add.setDate(2,dql);
                add.setString(3,stu);
                add.setString(4,apelido);
                add.setString(5,pangalan);
                add.setString(6,gitna);
                add.setString(7,cellphone);
                add.setString(8, kurso);
                add.setString(9,guardianlast);
                add.setString(10, guardianfirst);
                add.setString(11, guardianmid);
                add.setString(12,guardiancontact);
                add.setString(13, emailaddress);
                add.setString(14, tirahan);
                add.setTime(15, tql);               
                add.executeUpdate();
                JOptionPane.showMessageDialog(null,     " "+cdmid.getText()+" is now Updated!!!");
                this.dispose();
                String info = studentno.getText();
               String person = idnumba.getText();
               new idOutput(info, person).show(); 
                /* try {
                    FileInputStream fis = new FileInputStream(pic);
                    try {
                        add.setBinaryStream(16, fis,fis.available());
                    } catch (IOException ex) {
                        Logger.getLogger(studentUpdate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(studentUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }  */         
       /* String me = "select student SET id='"+cdm+"'"
                    + ",studentnumber='"+stu+"'"+",lastname='"+apelido+"'"+",firstname='"+pangalan+"'"+",middlename='"+gitna+"'"+",contact='"+cellphone+"'"+",guardianlast='"+guardianlast+"'"+",guardianfirst='"+guardianfirst+"'"+",guardianmiddle='"+guardianmid+"'"
                + ",guardiancontact='"+guardiancontact+"'"+",email='"+emailaddress+"'"+",address='"+tirahan+"'"+" WHERE id='"+cdm+"'";
                PreparedStatement add = myConnection.prepareStatement(me);
                add.executeQuery();*/
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JLabel cdmid;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JLabel date;
    private javax.swing.JButton edit1;
    private javax.swing.JButton edit2;
    private javax.swing.JTextField emailadd;
    private javax.swing.JTextField first;
    private javax.swing.JTextField gc;
    private javax.swing.JTextField gf;
    private javax.swing.JTextField gl;
    private javax.swing.JTextField gm;
    public static javax.swing.JLabel idnumba;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel jl;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl2;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField kontak;
    private javax.swing.JTextField last;
    private javax.swing.JTextField mid;
    private javax.swing.JLabel photo;
    private javax.swing.JButton save;
    private javax.swing.JLabel studentno;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
