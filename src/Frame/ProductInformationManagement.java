/*
 * Created by JFormDesigner on Sun Jun 04 11:06:15 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import static control.fileControl.loadJsonArrayFromFile;
import static control.fileControl.writeJsonToFile;
import static control.tableControl.*;

/**
 * @author zhoufengming
 */
public class ProductInformationManagement extends JFrame {
    public ProductInformationManagement() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        panel2 = new JPanel();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {

            //======== panel2 ========
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

                //---- button7 ----
                button7.setText("text");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(createTable());
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addComponent(button3)
                                        .addGap(30, 30, 30)
                                        .addComponent(button4)
                                        .addGap(241, 241, 241)
                                        .addComponent(button5))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(button2)))
                                .addComponent(button6))
                            .addGap(21, 21, 21))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(38, 38, 38)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button3)
                                .addComponent(button4)
                                .addComponent(button5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button6)
                            .addContainerGap(15, Short.MAX_VALUE))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(42, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
            );
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
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

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane1.setViewportView(createTable());
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProduct().setVisible(true);
                scrollPane1.setViewportView(createTable());
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(table1,"src\\data\\product.json");
                scrollPane1.setViewportView(createTable());
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revisedata(table1);
                scrollPane1.setViewportView(createTable());
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);

            }
        });


    }

    //修改选中的数据
    private void revisedata(JTable table){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\product.json");
        int column = 0; // 指定列
        int num=0;//判断多选框是否为空
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){
                //删掉选中的数据
                jsonArray= removeKeyData(jsonArray,row);
                //写入删除后的数据
                writeJsonToFile(jsonArray,"src\\data\\product.json");
                //生成新的数据
                new AddProduct().setVisible(true);
            }else{
                num++;
            }
        }

        if(num==table.getRowCount()){
            JOptionPane.showMessageDialog(null, "请选中要修改的用户", "提示", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    //构造表格
    private  JTable createTable(){
        DefaultTableModel tableModel = createModel();
        table1.setModel(tableModel);
        table1= addCheckBox(table1);
        return table1;
    }

    //重新生成表格数据
    private DefaultTableModel createModel(){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\product.json");
        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn(" ");
        tableModel.addColumn("ID");
        tableModel.addColumn("产品编号");
        tableModel.addColumn("产品名称");
        tableModel.addColumn("产品类别");
        tableModel.addColumn("产品规格");
        tableModel.addColumn("产品描述");


        //遍历JSON数组找到对应用户，构造数据模型
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ID =Integer.toString(i+1);
            String column1Value = jsonObject.getString("No");
            String column2Value = jsonObject.getString("name");
            String column3Value = jsonObject.getString("type");
            String column4Value = jsonObject.getString("measure");
            String column5Value = jsonObject.getString("describe");
            tableModel.addRow(new Object[]{false,ID,column1Value,column2Value,column3Value,column4Value,column5Value});

        }

        return tableModel;
    }

    //重新生成表格数据
    private DefaultTableModel createOneModel(){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\product.json");

        //目标用户名字
        String inputAccount = formattedTextField1.getText();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn(" ");
        tableModel.addColumn("ID");
        tableModel.addColumn("产品编号");
        tableModel.addColumn("产品名称");
        tableModel.addColumn("产品类别");
        tableModel.addColumn("产品规格");
        tableModel.addColumn("产品描述");


        //遍历JSON数组找到对应用户，构造数据模型
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject.get("name"))){
                String ID =Integer.toString(i+1);
                String column1Value = jsonObject.getString("No");
                String column2Value = jsonObject.getString("name");
                String column3Value = jsonObject.getString("type");
                String column4Value = jsonObject.getString("measure");
                String column5Value = jsonObject.getString("describe");
                tableModel.addRow(new Object[]{false,ID,column1Value,column2Value,column3Value,column4Value,column5Value});
            }
        }

        return tableModel;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JPanel panel2;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JButton button3;
    private JButton button6;
    private JButton button7;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
