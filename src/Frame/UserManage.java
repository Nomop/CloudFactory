/*
 * Created by JFormDesigner on Sun Jun 04 10:25:51 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import static control.fileControl.loadJsonArrayFromFile;
import static control.fileControl.writeJsonToFile;
import static control.tableControl.*;

/**
 * @author zhoufengming
 */
public class UserManage extends JFrame {
    public UserManage() {
        setTitle("用户管理");
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
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

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(createTable());
                }

                //---- button1 ----查询
                button1.setText("\u7528\u6237\u59d3\u540d\u67e5\u8be2");
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel =createOneModel();
                        table1.setModel(tableModel);
                        table1= addCheckBox(table1);

                        // 将表格添加到滚动面板
                        scrollPane1.setViewportView(table1);
                    }
                });

                //---- button2 ----重置
                button2.setText("\u91cd\u7f6e");
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel = createModel();
                        table1.setModel(tableModel);
                        table1= addCheckBox(table1);

                        // 将表格添加到滚动面板
                        scrollPane1.setViewportView(table1);
                    }
                });

                //---- button4 ----删除
                button4.setText("\u5220\u9664");
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        delete(table1,"src\\data\\manager.json");
                        scrollPane1.setViewportView(createTable());
                    }
                });

                //---- button5 ----修改
                button5.setText("\u4fee\u6539");
                button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        revisedata(table1);
                        scrollPane1.setViewportView(createTable());

                    }
                });

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
                            .addGap(39, 39, 39)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button2)
                                    .addGap(232, 232, 232))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(button4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button5)
                                    .addGap(36, 36, 36)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(599, Short.MAX_VALUE)
                            .addComponent(button6)
                            .addGap(34, 34, 34))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(68, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(45, 45, 45)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button4)
                                .addComponent(button5))
                            .addGap(47, 47, 47)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addComponent(button6)
                            .addGap(31, 31, 31))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    //构造表格
    private  JTable createTable(){
        DefaultTableModel tableModel = createModel();
        table1.setModel(tableModel);
        table1= addCheckBox(table1);
        return table1;
    }



    //修改选中的数据
    private void revisedata(JTable table){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");
        int column = 0; // 指定列
        int num=0;//判断多选框是否为空
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){
                //删掉选中的数据
                jsonArray= removeKeyData(jsonArray,row);
                //写入删除后的数据
                writeJsonToFile(jsonArray,"src\\data\\manager.json");
                //生成新的数据
                new Revise().setVisible(true);
            }else{
                num++;
            }
        }

        if(num==table.getRowCount()){
            JOptionPane.showMessageDialog(null, "请选中要修改的用户", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //重新生成表格数据
    private DefaultTableModel createModel(){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");
        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn(" ");
        tableModel.addColumn("ID");
        tableModel.addColumn("登陆账号");
        tableModel.addColumn("姓名");
        tableModel.addColumn("联系方式");
        tableModel.addColumn("角色名称");

        //遍历JSON数组找到对应用户，构造数据模型
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ID =Integer.toString(i+1);
            String column1Value = jsonObject.getString("account");
            String column2Value = jsonObject.getString("name");
            String column3Value = jsonObject.getString("phone");
            String column4Value = jsonObject.getString("RegisWay");
            tableModel.addRow(new Object[]{false,ID,column1Value, column2Value,column3Value,column4Value});
        }

        return tableModel;
    }

    //重新生成目标数据的数据模型
    private DefaultTableModel createOneModel() {
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");

        //目标用户名字
        String inputAccount = formattedTextField1.getText();
        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn(" ");
        tableModel.addColumn("ID");
        tableModel.addColumn("登陆账号");
        tableModel.addColumn("姓名");
        tableModel.addColumn("联系方式");
        tableModel.addColumn("角色名称");

        //在表格模型中添加数据
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject.get("name"))){
                String ID =Integer.toString(i+1);
                String column1Value = jsonObject.getString("account");
                String column2Value = jsonObject.getString("name");
                String column3Value = jsonObject.getString("phone");
                String column4Value = jsonObject.getString("RegisWay");
                tableModel.addRow(new Object[]{false,ID,column1Value, column2Value,column3Value,column4Value});
            }

        }
        return tableModel;
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
