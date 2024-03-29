package ec.edu.espe.studentsystem.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.studentsystem.controller.MongoConection;
import ec.edu.espe.studentsystem.controller.ThemeController;
import ec.edu.espe.studentsystem.model.Student;
import java.awt.EventQueue;
import javax.swing.UIManager;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class FrmStudent extends javax.swing.JFrame {

    private int id = 0;
    private String password = "";

    /**
     * Creates new form FrmStudent
     * @param id
     * @param password
     */
    public FrmStudent(int id, String password) {
        this.id = id;
        this.password = password;
        initComponents();
        lblStudent.setText(getStudentName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        btnActivity = new javax.swing.JButton();
        btnEnrollment = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnStudentSystem = new javax.swing.JMenu();
        mniAbout = new javax.swing.JMenuItem();
        mniLogOut = new javax.swing.JMenuItem();
        mnManage = new javax.swing.JMenu();
        mnActivity = new javax.swing.JMenuItem();
        mnEnrollment = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        cbmiDarkMode = new javax.swing.JCheckBoxMenuItem();
        menuHelp = new javax.swing.JMenu();
        mnMail = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");

        lblStudent.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStudent.setPreferredSize(new java.awt.Dimension(0, 50));

        btnActivity.setText("Activity");
        btnActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivityActionPerformed(evt);
            }
        });

        btnEnrollment.setText("Enrollment");
        btnEnrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollmentActionPerformed(evt);
            }
        });

        mnStudentSystem.setText("StudentSystem");

        mniAbout.setText("About");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        mnStudentSystem.add(mniAbout);

        mniLogOut.setText("Log Out");
        mniLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogOutActionPerformed(evt);
            }
        });
        mnStudentSystem.add(mniLogOut);

        jMenuBar1.add(mnStudentSystem);

        mnManage.setText("Manage");

        mnActivity.setText("Activity");
        mnActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnActivityActionPerformed(evt);
            }
        });
        mnManage.add(mnActivity);

        mnEnrollment.setText("Enrollment");
        mnEnrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEnrollmentActionPerformed(evt);
            }
        });
        mnManage.add(mnEnrollment);

        jMenuBar1.add(mnManage);

        menuView.setText("View");

        cbmiDarkMode.setText("Dark Mode");
        cbmiDarkMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmiDarkModeActionPerformed(evt);
            }
        });
        menuView.add(cbmiDarkMode);

        jMenuBar1.add(menuView);

        menuHelp.setText("Help");
        menuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHelpActionPerformed(evt);
            }
        });

        mnMail.setText("Mail");
        mnMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMailActionPerformed(evt);
            }
        });
        menuHelp.add(mnMail);

        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(btnActivity)
                        .addGap(147, 147, 147)
                        .addComponent(btnEnrollment)
                        .addGap(0, 336, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivity)
                    .addComponent(btnEnrollment))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbmiDarkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmiDarkModeActionPerformed
        if (cbmiDarkMode.isSelected())
        {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ThemeController.setDarkTheme();
                }
            });
        } else
        {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ThemeController.setFlatLightLafTheme();
                }
            });
        }
    }//GEN-LAST:event_cbmiDarkModeActionPerformed

    private void btnActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivityActionPerformed
        openFrmActivities();
    }//GEN-LAST:event_btnActivityActionPerformed

    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed
        FrmAboutUs aboutUs = new FrmAboutUs();
        aboutUs.setVisible(true);
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            aboutUs.setStatusCbmiDarkMode(false);
        }else{
            aboutUs.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_mniAboutActionPerformed

    private void mnActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnActivityActionPerformed
        openFrmActivities();
    }//GEN-LAST:event_mnActivityActionPerformed

    private void openFrmActivities() {
        FrmStudentsActivities frmActivities = new FrmStudentsActivities(id);
        frmActivities.setVisible(true);
        if ("FlatLaf Light".equals(UIManager.getLookAndFeel().getName()))
        {
            frmActivities.setStatusCbmiDarkMode(false);
        } else
        {
            frmActivities.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }

    private void mnEnrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEnrollmentActionPerformed
        openFrmEnrollment();
    }//GEN-LAST:event_mnEnrollmentActionPerformed

    private void btnEnrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollmentActionPerformed
        openFrmEnrollment();
    }//GEN-LAST:event_btnEnrollmentActionPerformed

    private void menuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHelpActionPerformed
        FrmHelp newHelp = new FrmHelp();
        newHelp.setVisible(true);
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            newHelp.setStatusCbmiDarkMode(false);
        }else{
            newHelp.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_menuHelpActionPerformed

    private void mniLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogOutActionPerformed
        FrmMain main = new FrmMain();
        main.setVisible(true);
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            main.setStatusCbmiDarkMode(false);
        }else{
            main.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_mniLogOutActionPerformed

    private void mnMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMailActionPerformed
        FrmHelp newHelp = new FrmHelp();
        newHelp.setVisible(true);
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            newHelp.setStatusCbmiDarkMode(false);
        }else{
            newHelp.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_mnMailActionPerformed

    private void openFrmEnrollment() {
        FrmEnrollment frmEnrollment = new FrmEnrollment(id);
        frmEnrollment.setVisible(true);
        if ("FlatLaf Light".equals(UIManager.getLookAndFeel().getName()))
        {
            frmEnrollment.setStatusCbmiDarkMode(false);
        } else
        {
            frmEnrollment.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        ThemeController.setFlatLightLafTheme();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmStudent(0, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivity;
    private javax.swing.JButton btnEnrollment;
    private javax.swing.JCheckBoxMenuItem cbmiDarkMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenuItem mnActivity;
    private javax.swing.JMenuItem mnEnrollment;
    private javax.swing.JMenuItem mnMail;
    private javax.swing.JMenu mnManage;
    private javax.swing.JMenu mnStudentSystem;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniLogOut;
    // End of variables declaration//GEN-END:variables

    public boolean getStatusCbmiDarkMode() {
        return cbmiDarkMode.isSelected();
    }

    public void setStatusCbmiDarkMode(boolean isSelected) {
        this.cbmiDarkMode.setSelected(isSelected);
    }
    
    private String getStudentName() {
        String collection = "students";
        String studentName = "";
        Gson gson = new Gson();

        MongoCollection<Document> studentsCollection = MongoConection.getConnection(collection);
        Bson bsonFilter = Filters.eq("id", id);
        Document doc = studentsCollection.find(Filters.and(bsonFilter)).first();
        String studentDoc = doc.toJson();
        TypeToken<Student> type = new TypeToken<Student>() {};
        Student student = gson.fromJson(studentDoc, type.getType());
        studentName = student.getName();

        return studentName;
    
    }
}
