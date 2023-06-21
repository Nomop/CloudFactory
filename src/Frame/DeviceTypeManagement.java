/*
 * Created by JFormDesigner on Sun Jun 04 11:08:47 CST 2023
 */

package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author zhoufengming
 */
public class DeviceTypeManagement extends JFrame {
    public DeviceTypeManagement() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        table1 = new JTable();
        button6 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- button1 ----
                button1.setText("\u7c7b\u522b\u540d\u79f0\u67e5\u8be2");

                //---- button2 ----
                button2.setText("\u91cd\u7f6e");

                //---- button5 ----
                button5.setText("\u4fee\u6539");

                //---- button4 ----
                button4.setText("\u5220\u9664");

                //---- button3 ----
                button3.setText("\u65b0\u5efa");

                //---- button6 ----
                button6.setText("\u8fd4\u56de");
                button6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        new Menu().setVisible(true);

                    }
                });

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(table1, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(button2))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(471, 471, 471)
                                        .addComponent(button6))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(button3)
                                        .addGap(18, 18, 18)
                                        .addComponent(button4)
                                        .addGap(218, 218, 218)
                                        .addComponent(button5))))
                            .addContainerGap(46, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(47, 47, 47)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(button3)
                                .addComponent(button4)
                                .addComponent(button5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(table1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(button6)
                            .addContainerGap(83, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JButton button3;
    private JTable table1;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
