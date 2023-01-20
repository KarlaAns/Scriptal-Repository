
package ec.edu.espe.studentsystem.view;

import static ec.edu.espe.studentsystem.controller.ClassroomController.findTeacher;
import ec.edu.espe.studentsystem.controller.Theme;
import java.awt.EventQueue;
import javax.swing.UIManager;
import org.bson.Document;

/**
 *
 * @author Alejandro Andrade, Scriptal, DCCO_ESPE
 */
public class FrmTeacher extends javax.swing.JFrame {

    private final int teacherId;
    private final Document teacher;
    /**
     * Creates new form FrmTeacher
     * @param teacherId
     */
    public FrmTeacher(int teacherId) {
        initComponents();
        this.teacherId=teacherId;
        this.teacher = findTeacher(teacherId);
        if(teacher!=null){
            String[] teacherName;
            teacherName = teacher.getString("name").split(" ");
            lbTeacherName.setText(teacherName[0]);
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

        pnlTeacher = new javax.swing.JPanel();
        lbTeacherName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        brnClassrooms = new javax.swing.JButton();
        btnStudents = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnStudentSystem = new javax.swing.JMenu();
        mniHome = new javax.swing.JMenuItem();
        mniAbout = new javax.swing.JMenuItem();
        mniLogOut = new javax.swing.JMenuItem();
        mnManage = new javax.swing.JMenu();
        menuView = new javax.swing.JMenu();
        cbmiDarkMode = new javax.swing.JCheckBoxMenuItem();
        menuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTeacher.setPreferredSize(new java.awt.Dimension(1000, 562));

        lbTeacherName.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        lbTeacherName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTeacherName.setText("...");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome");

        brnClassrooms.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        brnClassrooms.setText("Classrooms");
        brnClassrooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnClassroomsActionPerformed(evt);
            }
        });

        btnStudents.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnStudents.setText("Students");
        btnStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTeacherLayout = new javax.swing.GroupLayout(pnlTeacher);
        pnlTeacher.setLayout(pnlTeacherLayout);
        pnlTeacherLayout.setHorizontalGroup(
            pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366))
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(lbTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(brnClassrooms)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStudents)
                .addGap(261, 261, 261))
        );
        pnlTeacherLayout.setVerticalGroup(
            pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brnClassrooms)
                    .addComponent(btnStudents))
                .addGap(100, 100, 100))
        );

        mnStudentSystem.setText("StudentSystem");

        mniHome.setText("Home");
        mniHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHomeActionPerformed(evt);
            }
        });
        mnStudentSystem.add(mniHome);

        mniAbout.setText("About");
        mniAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAboutActionPerformed(evt);
            }
        });
        mnStudentSystem.add(mniAbout);

        mniLogOut.setText("Log Out");
        mnStudentSystem.add(mniLogOut);

        jMenuBar1.add(mnStudentSystem);

        mnManage.setText("Manage");
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
        jMenuBar1.add(menuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void brnClassroomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnClassroomsActionPerformed
        // TODO add your handling code here:
        FrmClassroomManagement classrooms = new FrmClassroomManagement(teacher);
        classrooms.setVisible(true);
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            classrooms.setStatusCbmiDarkMode(false);
        }else{
            classrooms.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_brnClassroomsActionPerformed

    private void btnStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentsActionPerformed
        // TODO add your handling code here:
        FrmStudentManagement students = new FrmStudentManagement(teacherId);
        students.setVisible(true);
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            students.setStatusCbmiDarkMode(false);
        }else{
            students.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnStudentsActionPerformed

    private void mniHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHomeActionPerformed
        FrmMain main = new FrmMain();
        main.setVisible(true);
        System.out.println(UIManager.getLookAndFeel().getName());
        if("FlatLaf Light".equals(UIManager.getLookAndFeel().getName())){
            main.setStatusCbmiDarkMode(false);
        }else{
            main.setStatusCbmiDarkMode(true);
        }
        this.dispose();
    }//GEN-LAST:event_mniHomeActionPerformed

    private void mniAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAboutActionPerformed

        FrmAboutUs mniAbout = new FrmAboutUs();
        mniAbout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mniAboutActionPerformed

    private void cbmiDarkModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmiDarkModeActionPerformed
        if (cbmiDarkMode.isSelected())
        {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Theme.setDarkTheme();
                }
            });
        } else
        {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Theme.setFlatLightLafTheme();
                }
            });
        }
    }//GEN-LAST:event_cbmiDarkModeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Theme.setFlatLightLafTheme();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTeacher(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnClassrooms;
    private javax.swing.JButton btnStudents;
    private javax.swing.JCheckBoxMenuItem cbmiDarkMode;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbTeacherName;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenu mnManage;
    private javax.swing.JMenu mnStudentSystem;
    private javax.swing.JMenuItem mniAbout;
    private javax.swing.JMenuItem mniHome;
    private javax.swing.JMenuItem mniLogOut;
    private javax.swing.JPanel pnlTeacher;
    // End of variables declaration//GEN-END:variables

    public boolean getStatusCbmiDarkMode() {
        return cbmiDarkMode.isSelected();
    }

    public void setStatusCbmiDarkMode(boolean isSelected) {
        this.cbmiDarkMode.setSelected(isSelected);
    }
}
