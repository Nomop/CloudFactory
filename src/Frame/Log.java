/*
 * Created by JFormDesigner on Thu Jun 01 20:06:31 CST 2023
 */

package Frame;

//import Text.Test03;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import static control.fileControl.loadJsonArrayFromFile;

/**
 * @author zhoufengming
 */
public class Log extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JFormattedTextField formattedTextField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private Log() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("Frame.Log");
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        formattedTextField1 = new JFormattedTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label2 ----
            label2.setText("\u4e91\u5de5\u5382\u5236\u9020");

            //---- label3 ----
            label3.setText(bundle.getString("Log.label3.text"));

            //---- label4 ----
            label4.setText(bundle.getString("Log.label4.text"));

            //---- button1 ----登陆
            button1.setText(bundle.getString("Log.button1.text"));
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accountCheck();
                }
            });

            //---- button2 ----注册
            button2.setText(bundle.getString("Log.button2.text"));
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new Register().setVisible(true);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(button1)
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                                    .addGap(27, 27, 27)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(formattedTextField1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                            .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                            .addComponent(button2, GroupLayout.Alignment.TRAILING))
                                    .addContainerGap(59, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(48, 48, 48)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(button1)
                                            .addComponent(button2))
                                    .addContainerGap(74, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void accountCheck() {
        String Account = formattedTextField1.getText();
        char[] passwordChars = passwordField1.getPassword();
        String password = new String(passwordChars);

        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");

        boolean hasSame = false;//判断是否是正确账号
        boolean isDealer=false;//判断是否是经销商
        boolean isSuper=false;//判断是系统管理员
        //系统管理员
        if (Account.equals("321") && password.equals("123")) {
            isSuper=true;
        }


        //处理账号密码
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

            if (Account.equals(jsonObject1.get("account")) && password.equals(jsonObject1.get("password"))) {
                hasSame = true;
            }
            if(jsonObject1.get("RegisWay").equals("经销商")){
                isDealer=true;
            }
        }


        //进行判断
        if (isDealer){
            JOptionPane.showMessageDialog(null, "经销商无法登陆", "提示", JOptionPane.INFORMATION_MESSAGE);
            formattedTextField1.setText(""); // 清空输入框
            passwordField1.setText("");
        }else {
            if (hasSame) {
                dispose();
                new PersonalCloudFactory(Account).setVisible(true);
            } else {
                if(isSuper){
                    dispose();
                    new Menu().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "账号或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
                    formattedTextField1.setText(""); // 清空输入框
                    passwordField1.setText("");
                }
            }
        }



    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 私有静态成员变量，用于保存单例实例
    private static Log instance;
    // 公共静态方法，用于获取单例实例
    public static Log getInstance() {
        if (instance == null) {
            synchronized (Log.class) {
                if (instance == null) {
                    instance = new Log();
                }
            }
        }
        return instance;
    }
}
