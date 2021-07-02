
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class idOutput extends javax.swing.JFrame {

 Connection myConnection = null;
 Statement myStatement = null;
 ResultSet myResult = null;
 /*String harap;
 String likod;*/
    /**
     * Creates new form idOutput
     */

    public idOutput() {
     
         initComponents();
         //String akin = idOutput(idnumber.getText());
         //output(cdm.getText()); 
        // System.out.println(akin);
        //String rad = studentn.getText();
       
    }

   public  idOutput(String colegio, String person ){
       initComponents();
       
       backPanel.hide();
       studentn.setText(colegio);
       idnumbe.setText(person);
       idnumbe.hide();
       edit.setBackground(new Color(0,0,0,0));
       System.out.println("idnumbe"+ idnumbe.getText());
       System.out.println(studentn.getText());   
       connect(); 
        String rad = studentn.getText();   
       System.out.println(rad);
         try {    
         String ako = "select * from student where studentnumber='"+rad+"'";
         Statement add = myConnection.createStatement();
             ResultSet rs = add.executeQuery(ako);
         if (rs.next()){
            String lastname = rs.getString(4);
            String firstname = rs.getString(5);
            String middlename = rs.getString(6);
            String initial = middlename.substring(0,1);
            String fullname = firstname+" "+initial+". "+lastname;
            String studentno = rs.getString(3);
            String kurso = rs.getString(8);
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
            name.setText(fullname);
            studentn.setText(studentno);
            course.setText(kurso);    
            guardian.setText(gwardiya);
            guardiancontact.setText(gcontact);
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
                   try {
            //ByteArrayOutputStream out = QRCode.from(rs.getString(1)).to(ImageType.JPG).stream();
            String impormasyon  = "ID NUMBER:  "+idnumero+"\n"+ "CONTACT NO:  "+cellphone+"\n"+"EMAIL ADDRESS:  "+eadd+"\n"+"ADDRESS:  "+tirahan;
            System.out.print(impormasyon);
            //ByteArrayOutputStream out = QRCode.from(rs.getString(1)).to(ImageType.JPG).stream();     
            ByteArrayOutputStream out = QRCode.from(impormasyon).to(ImageType.JPG).stream();  
            //File f  =  new File("C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\qrcode\\create.jpg");
            File f  =  new File("imahe.create.jpg");
            FileOutputStream fos = new FileOutputStream(f);         
            fos.write(out.toByteArray());
            fos.flush();
            
            //ImageIcon kaido = new ImageIcon("C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\qrcode\\create.jpg");
            ImageIcon kaido = new ImageIcon("imahe.create.jpg");
            Image imahe = kaido.getImage();
            Image newImahe = imahe.getScaledInstance(idnumber.getWidth(), idnumber.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon luffy = new ImageIcon(newImahe);
            idnumber.setIcon(luffy);       
        }catch (Exception e){
            e.printStackTrace();
        }        
         }     
     } catch (SQLException ex) {
         Logger.getLogger(idOutput.class.getName()).log(Level.SEVERE, null, ex);
     }  
   }   
    
      public static BufferedImage screenshoter(Component component){
          BufferedImage asta = new BufferedImage(component.getWidth(),component.getHeight(), BufferedImage.TYPE_INT_RGB);
          component.paint(asta.getGraphics());
          return asta;
      }
      public static void saveme(Component component, String pila) throws Exception{
          BufferedImage yuno = screenshoter(component);
          ImageIO.write(yuno, "png", new File(pila));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        idnumber = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        guardiancontact = new javax.swing.JLabel();
        guardian = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        frontPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        studentn = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        side = new javax.swing.JComboBox<>();
        edit = new javax.swing.JButton();
        home = new javax.swing.JButton();
        save = new javax.swing.JButton();
        idnumbe = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(248, 255, 249));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idnumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idnumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 4, true));
        jPanel3.add(idnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 260, 190));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(251, 251, 251));
        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 250, 255));
        jLabel6.setText("IN CASE OF EMERGENCY, PLEASE NOTIFY");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 330, 40));

        guardiancontact.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        guardiancontact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardiancontact.setText("CONTACT");
        jPanel3.add(guardiancontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 330, 30));

        guardian.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        guardian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guardian.setText("GUARDIAN NAME");
        jPanel3.add(guardian, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 330, 30));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(251, 251, 251));
        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 250, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SIGNATURE OF STUDENT");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 330, 40));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/1x/1x/likodAsset 2.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 330, 120));

        backPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 560));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/alright.png"))); // NOI18N
        backPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        getContentPane().add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 410, 580));

        frontPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(248, 255, 249));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 28, 9));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Colegio De Montalban");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 370, 70));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 28, 9));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Kasiglahan Village, San Jose Rodriguez Rizal");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 350, 20));

        course.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        course.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        course.setText("COURSE");
        jPanel4.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 370, 50));

        photo.setBackground(new java.awt.Color(255, 255, 255));
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel4.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 190, 180));

        studentn.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        studentn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentn.setText("STUDENT NUMBER");
        jPanel4.add(studentn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 200, 40));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/1x/1x/cdm logoAsset 1.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 150));

        name.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");
        jPanel4.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 370, 60));

        frontPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 560));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/alright.png"))); // NOI18N
        frontPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, -1));

        getContentPane().add(frontPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 580));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side.setBackground(new java.awt.Color(246, 252, 238));
        side.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        side.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FRONT", "BACK" }));
        side.setAlignmentX(100.0F);
        side.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sideActionPerformed(evt);
            }
        });
        jPanel2.add(side, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 240, 40));

        edit.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/1x/1x/pen30Asset 2.png"))); // NOI18N
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 80, 40));

        home.setBackground(new java.awt.Color(96, 146, 22));
        home.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        home.setForeground(new java.awt.Color(244, 246, 251));
        home.setText("HOME");
        home.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel2.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 410, 40));

        save.setBackground(new java.awt.Color(61, 83, 244));
        save.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(240, 245, 255));
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel2.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 720, 230, 50));

        idnumbe.setText("jLabel10");
        jPanel2.add(idnumbe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 730, 100, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/green1kAsset 1.png"))); // NOI18N
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(67, 73, 2), 3, true));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 800));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        int answer;
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to retreat?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if(answer == 0){
        String person = idnumbe.getText();    
        this.dispose();
        new frontPage(person).show();
        }else{
            JOptionPane.showMessageDialog(null,"Mananatili ka Dito");
            }
    }//GEN-LAST:event_homeActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String rambo = studentn.getText();
        
        
        try {
            saveme(frontPanel, "C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\tempo\\"+rambo+" front.png");
            saveme(backPanel, "C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\tempo\\"+rambo+" back.png");
            JOptionPane.showMessageDialog(null, "nasave na ang file!!!");
            String person = idnumbe.getText();    
            this.dispose();
            new frontPage(person).show();
            
            } catch (Exception ex) {
                Logger.getLogger(idOutput.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Subukan muli!!!");
            }

            
    }//GEN-LAST:event_saveActionPerformed

    private void sideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sideActionPerformed
       int tingnan = side.getSelectedIndex();
        //String likod = side.getSelectedItem(2).toString();
        System.out.println(tingnan);
        if(tingnan == 1 ){
            frontPanel.hide();
            backPanel.show();
            
        }else{
            backPanel.hide();
            frontPanel.show();
        }
    }//GEN-LAST:event_sideActionPerformed

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
            java.util.logging.Logger.getLogger(idOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(idOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(idOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(idOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new idOutput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel course;
    private javax.swing.JButton edit;
    private javax.swing.JPanel frontPanel;
    private javax.swing.JLabel guardian;
    private javax.swing.JLabel guardiancontact;
    private javax.swing.JButton home;
    public static javax.swing.JLabel idnumbe;
    public static javax.swing.JLabel idnumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel name;
    private javax.swing.JLabel photo;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> side;
    public static javax.swing.JLabel studentn;
    // End of variables declaration//GEN-END:variables
}
