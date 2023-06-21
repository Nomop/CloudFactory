/*
 * Created by JFormDesigner on Fri Jun 09 16:29:34 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import unit.ManagerItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static control.fileControl.loadJsonArrayFromFile;

/**
 * @author zhoufengming
 */
public class Revise extends JFrame {
    public Revise() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        formattedTextField2 = new JFormattedTextField();
        formattedTextField3 = new JFormattedTextField();
        formattedTextField4 = new JFormattedTextField();
        formattedTextField5 = new JFormattedTextField();
        formattedTextField6 = new JFormattedTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("\u767b\u9646\u8d26\u53f7");

                //---- label2 ----
                label2.setText("\u767b\u9646\u5bc6\u7801");

                //---- label3 ----
                label3.setText("\u771f\u5b9e\u59d3\u540d");

                //---- label4 ----
                label4.setText("\u8054\u7cfb\u65b9\u5f0f");

                //---- radioButton1 ----
                radioButton1.setText("\u4e91\u5de5\u5382");

                //---- radioButton2 ----
                radioButton2.setText("\u7ecf\u9500\u5546");

                //---- label5 ----
                label5.setText("\u6ce8\u518c\u65b9\u5f0f");

                //---- label6 ----
                label6.setText("\u5de5\u5382\u540d\u79f0");

                //---- label7 ----
                label7.setText("\u5de5\u5382\u7b80\u5386");

                //---- button1 ----
                button1.setText("\u786e\u5b9a");
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        createManagerItem();
                    }
                });

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(label5, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button1, GroupLayout.Alignment.LEADING)
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                            .addGap(40, 40, 40)
                                            .addComponent(radioButton2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(formattedTextField1))
                                    .addComponent(formattedTextField2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formattedTextField3, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formattedTextField4, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(formattedTextField6, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(59, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(formattedTextField2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(formattedTextField3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(formattedTextField4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label5)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioButton2)
                                    .addComponent(radioButton1)))
                            .addGap(24, 24, 24)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(formattedTextField5, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addGap(39, 39, 39)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(formattedTextField6, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addComponent(button1)
                            .addGap(31, 31, 31))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 483, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dialogPane, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 509, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void createManagerItem() {
        //读入注册信息
        ManagerItem managerItem = new ManagerItem();
        String inputAccount = formattedTextField1.getText();
        managerItem.setAccount(formattedTextField1.getText());
        managerItem.setPassword(formattedTextField2.getText());
        managerItem.setName(formattedTextField3.getText());
        managerItem.setPhone(formattedTextField4.getText());
        managerItem.setFacIntro(formattedTextField6.getText());
        managerItem.setFacName(formattedTextField5.getText());
        boolean isSelected1 = radioButton1.isSelected();
        boolean isSelected2 = radioButton2.isSelected();
        String selectedOption = "";
        if (isSelected1) {
            selectedOption = "云工厂";
        } else if (isSelected2) {
            selectedOption = "经销商";
        }
        managerItem.setResgisWay(selectedOption);

        //加载原来的json文件到JSON数组里
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");

        //写入JSON文件
        JSONObject jsonObject = new JSONObject();
        boolean hasSame=false;//判断是否有相同账号

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject1.get("account"))){
                hasSame=true;
            }
        }

        if (hasSame) {
            JOptionPane.showMessageDialog(null, "该账号已经被注册了\n请重新输入账号", "提示", JOptionPane.INFORMATION_MESSAGE);
            formattedTextField1.setText(""); // 清空输入框
        }else{

            jsonObject.put("account", managerItem.getAccount());
            jsonObject.put("password", managerItem.getPassword());
            jsonObject.put("name", managerItem.getName());
            jsonObject.put("phone", managerItem.getPhone());
            jsonObject.put("RegisWay", managerItem.getResgisWay());
            jsonObject.put("facIntro", managerItem.getFacIntro());
            jsonObject.put("facName", managerItem.getFacName());
            jsonObject.put("state","关停");

            jsonArray.put(jsonObject);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\data\\manager.json"))) {
                writer.write(jsonArray.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JFormattedTextField formattedTextField5;
    private JFormattedTextField formattedTextField6;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
