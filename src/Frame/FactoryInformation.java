/*
 * Created by JFormDesigner on Sun Jun 04 10:58:25 CST 2023
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

/**
 * @author zhoufengming
 */
public class FactoryInformation extends JFrame {
    public FactoryInformation() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();

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
                button1.setText("\u5de5\u5382\u540d\u79f0\u67e5\u8be2");
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

                //---- button3 ----
                button3.setText("\u5207\u6362");
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        revisedata(table1);
                        scrollPane1.setViewportView(createTable());
                    }
                });

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(createTable());
                }

                //---- button2 ----
                button2.setText("\u8fd4\u56de");
                button2.addActionListener(new ActionListener() {
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
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(46, Short.MAX_VALUE)
                            .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                            .addGap(176, 176, 176)
                            .addComponent(button3)
                            .addGap(38, 38, 38))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(559, 559, 559)
                                    .addComponent(button2))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(14, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(button1)
                                    .addComponent(button3)))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(30, 30, 30))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.SOUTH);
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


    //渲染多选框
    private JTable addCheckBox(JTable table){
        // 创建多选框渲染器
        TableCellRenderer checkBoxRenderer = new TableCellRenderer() {
            private final JCheckBox checkBox = new JCheckBox();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                checkBox.setSelected((Boolean) value);
                return checkBox;
            }
        };

        // 设置第一列的渲染器为多选框渲染器,第一列每一行打一个多选框
        table.getColumnModel().getColumn(0).setCellRenderer(checkBoxRenderer);

        // 创建多选框编辑器
        DefaultCellEditor checkBoxEditor = new DefaultCellEditor(new JCheckBox());

        // 设置第一列的编辑器为多选框编辑器
        table.getColumnModel().getColumn(0).setCellEditor(checkBoxEditor);

        return table;
    }

    //修改选中数据的工厂状态
    private void revisedata(JTable table){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");
        int column = 0; // 指定列
        int num=0;//判断多选框是否为空
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){

                //修改选中的数据
                String str ="关停";
                JSONObject jsonObject1 = jsonArray.getJSONObject(row);
                if(str.equals(jsonObject1.get("state"))){
                    jsonObject1.put("state","正常");
                }else{
                    jsonObject1.put("state","关停");
                }

                //在原来插入修改并且写入
                jsonArray.put(row,jsonObject1);
                writeJsonToFile(jsonArray,"src\\data\\manager.json");
//                writeJsonToFile(jsonArray);

            }else{
                num++;
            }
        }

        if(num==table.getRowCount()){
            JOptionPane.showMessageDialog(null, "请选中要切换的工厂", "提示", JOptionPane.INFORMATION_MESSAGE);
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
        tableModel.addColumn("工厂名称");
        tableModel.addColumn("工厂简介");
        tableModel.addColumn("负责人");
        tableModel.addColumn("联系方式");
        tableModel.addColumn("登陆账号");
        tableModel.addColumn("工厂状态");

        //遍历JSON数组找到对应用户，构造数据模型
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ID =Integer.toString(i+1);
            String column1Value = jsonObject.getString("facName");
            String column2Value = jsonObject.getString("facIntro");
            String column3Value = jsonObject.getString("name");
            String column4Value = jsonObject.getString("phone");
            String column5Value = jsonObject.getString("account");
            String column6Value = jsonObject.getString("state");
            tableModel.addRow(new Object[]{false,ID,column1Value, column2Value,column3Value,column4Value,column5Value,column6Value});
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
        tableModel.addColumn("工厂名称");
        tableModel.addColumn("工厂简介");
        tableModel.addColumn("负责人");
        tableModel.addColumn("联系方式");
        tableModel.addColumn("登陆账号");
        tableModel.addColumn("工厂状态");

        //在表格模型中添加数据
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject.get("facName"))){
                String ID =Integer.toString(i+1);
                String column1Value = jsonObject.getString("facName");
                String column2Value = jsonObject.getString("facIntro");
                String column3Value = jsonObject.getString("name");
                String column4Value = jsonObject.getString("phone");
                String column5Value = jsonObject.getString("account");
                String column6Value = jsonObject.getString("state");
                tableModel.addRow(new Object[]{false,ID,column1Value, column2Value,column3Value,column4Value,column5Value,column6Value});
            }

        }
        return tableModel;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
