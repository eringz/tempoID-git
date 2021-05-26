
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

   public  idOutput(String colegio ){
       initComponents();
       studentn.setText(colegio);
       System.out.println(studentn.getText());   
       connect(); 
        String rad = studentn.getText();   
       System.out.println(rad);
         try {    
         String ako = "select * from data where studentnumber='"+rad+"'";
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
            name.setText(fullname);
            studentn.setText(studentno);
            course.setText(kurso);       
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
            ByteArrayOutputStream out = QRCode.from(rs.getString(1)).to(ImageType.JPG).stream();
            File f  =  new File("C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\qrcode\\create.jpg");
            FileOutputStream fos = new FileOutputStream(f);         
            fos.write(out.toByteArray());
            fos.flush();
            ImageIcon kaido = new ImageIcon("C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\qrcode\\create.jpg");
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
            myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/studentdata", "student", "admin");
            myStatement = myConnection.createStatement();
            myResult = myStatement.executeQuery("Select * From student.data");
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
        jPanel2 = new javax.swing.JPanel();
        print = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        front = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        studentn = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        namepanel = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        course = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        idnumber = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 590));

        print.setText("SAVE");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, 130, 30));

        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 130, 30));

        front.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        studentn.setText("s");
        jPanel3.add(studentn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 110, 40));

        front.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 110, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photo.setBackground(new java.awt.Color(255, 255, 255));
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("photo");
        jPanel4.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, 110));

        front.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 110, 140));

        namepanel.setBackground(new java.awt.Color(255, 255, 255));
        namepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("jLabel2");
        namepanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 370, 60));

        front.add(namepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 340, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        course.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        course.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        course.setText("jLabel3");
        jPanel5.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 370, 50));

        front.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 120, 50));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idnumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(idnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 210, 190));

        front.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 190, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imahe/alright.png"))); // NOI18N
        front.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        getContentPane().add(front, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        int answer;
        answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to retreat?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        if(answer == 0){
        this.dispose();
        new studentList().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Mananatili ka Dito");
            }
    }//GEN-LAST:event_cancelActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        String rambo = studentn.getText();
     try {
         saveme(front, "C:\\Users\\E-rinGZ\\OneDrive\\Desktop\\tempo\\"+rambo+"front.png");
     } catch (Exception ex) {
         Logger.getLogger(idOutput.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        JOptionPane.showMessageDialog(null, "nasave na ang file!!!");
    }//GEN-LAST:event_printActionPerformed

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
    private javax.swing.JButton cancel;
    private javax.swing.JLabel course;
    private javax.swing.JPanel front;
    public static javax.swing.JLabel idnumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel name;
    private javax.swing.JPanel namepanel;
    private javax.swing.JLabel photo;
    private javax.swing.JButton print;
    public static javax.swing.JLabel studentn;
    // End of variables declaration//GEN-END:variables
}
