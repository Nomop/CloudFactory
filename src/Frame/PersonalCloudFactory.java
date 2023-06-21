/*
 * Created by JFormDesigner on Sun Jun 04 11:14:54 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import unit.ManagerItem;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.fileControl.loadJsonArrayFromFile;
import static control.fileControl.writeJsonToFile;
import static control.tableControl.*;

/**
 * @author zhoufengming
 */
public class PersonalCloudFactory extends JFrame {
    public PersonalCloudFactory() {
        managerItem=new ManagerItem("321");
        loadManager();
        initComponents();
    }

    public PersonalCloudFactory(String account) {
        managerItem=new ManagerItem(account);
        loadManager();
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        formattedTextField1 = new JFormattedTextField();
        button1 = new JButton();
        button2 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        button7 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button8 = new JButton();
        button6 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            System.out.println(managerItem.getAccount());

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

            //---- button7 ----
            button7.setText("text");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(createTable());
            }

            //---- button8 ----
            button8.setText("\u8bbe\u5907\u72b6\u6001");

            //---- button6 ----
            button6.setText("\u79df\u7528\u8bbe\u5907");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(button4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button5))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(button2)))))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(0, 530, Short.MAX_VALUE)
                                .addComponent(button8))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(button3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button6)))
                        .addGap(35, 35, 35))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(formattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addComponent(button8, GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(button3, GroupLayout.Alignment.TRAILING)
                                .addComponent(button6, GroupLayout.Alignment.TRAILING))
                            .addComponent(button5)
                            .addComponent(button4))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(96, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
        );
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
                new AddOneDevice(managerItem).setVisible(true);
                scrollPane1.setViewportView(createTable());
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOne(table1,"src\\data\\device.json");
                scrollPane1.setViewportView(createTable());
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                revisedata(table1,"src\\data\\device.json");
                scrollPane1.setViewportView(createTable());
            }
        });

        //租用设备
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LeasedEquipment(managerItem).setVisible(true);
                scrollPane1.setViewportView(createTable());

            }
        });

        //设备状态开关
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeState(table1,"src\\data\\device.json");
                scrollPane1.setViewportView(createTable());
            }
        });
    }

    //得到有个只有属于自己工厂对的新数组
    private JSONArray updateJsonarray(JSONArray jsonArray){
        JSONArray updateJsonArray =new JSONArray();

        for (int i=0;i<jsonArray.length();i++){
            JSONObject object =jsonArray.getJSONObject(i);
            if(object.get("fac").equals(managerItem.getFacName())){
                updateJsonArray.put(object);
            }
        }
        return updateJsonArray;
    }

    //修改选中的数据
    private void revisedata(JTable table,String filePath){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);
        int column = 0; // 指定列
        int num=0;//判断多选框是否为空
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){
                //删掉选中的数据
                deleteOne(table,filePath);
                //生成新的数据
                new AddOneDevice(managerItem).setVisible(true);
            }else{
                num++;
            }
        }

        if(num==table.getRowCount()){
            JOptionPane.showMessageDialog(null, "请选中要修改的用户", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    //只删除新数组的打钩的对象，用索引删除文件对应对象
    private void deleteOne(JTable table,String filePath){
        //加载多选框对应数组
        JSONArray jsonArray =updateJsonarray(loadJsonArrayFromFile(filePath));
        //加载文件对应数组
        JSONArray jsonArray1 = loadJsonArrayFromFile(filePath);
        int column = 0; // 指定列
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){
                //找到这个
                JSONObject object =jsonArray.getJSONObject(row);

                for (int i=0;i<jsonArray1.length();i++) {
                    JSONObject object1 =jsonArray1.getJSONObject(i);
                    if(object1.get("name").equals(object.get("name"))){
                        if(object1.get("leasedState").equals("工厂设备")){
                            deleteIndex(i,filePath);
                            break;
                        }else{
                            object1.put("leasedState","未被租用");
                            object1.put("fac","");
                            writeJsonToFile(jsonArray1,filePath);
                            break;
                        }

                    }
                }
            }
        }
    }

    //改变设备状态
    private void changeState(JTable table,String filePath){
        int num=0;//判断多选框是否为空
        //加载多选框对应数组
        JSONArray jsonArray =updateJsonarray(loadJsonArrayFromFile(filePath));
        //加载文件对应数组
        JSONArray jsonArray1 = loadJsonArrayFromFile(filePath);
        int column = 0; // 指定列
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){
                //找到这个
                JSONObject object =jsonArray.getJSONObject(row);

                for (int i=0;i<jsonArray1.length();i++) {
                    JSONObject object1 =jsonArray1.getJSONObject(i);
                    if(object1.get("name").equals(object.get("name"))){
                        System.out.println(i);

                        //修改状态
                        String key =object1.getString("state");
                        if(key.equals("关机")){
                            object1.put("state","开机");
                        }else{
                            object1.put("state","关机");
                        }

                        //写入删除后的数据
                        writeJsonToFile(jsonArray1,filePath);
                        break;
                    }
                }
            }else {
                num++;
            }
        }
        if(num==table.getRowCount()){
            JOptionPane.showMessageDialog(null, "请选中要开关机的用户", "提示", JOptionPane.INFORMATION_MESSAGE);
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
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\device.json");
        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn(" ");
        tableModel.addColumn("ID");
        tableModel.addColumn("设备名称");
        tableModel.addColumn("设备编码");
        tableModel.addColumn("设备类别");
        tableModel.addColumn("设备规格");
        tableModel.addColumn("类别状态");
        tableModel.addColumn("类别描述");
        tableModel.addColumn("租用状态");
        tableModel.addColumn("所属工厂");


        //遍历JSON数组找到对应用户，构造数据模型
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            if(jsonObject.get("fac").equals(managerItem.getFacName())) {
                String ID = Integer.toString(i + 1);
                String column1Value = jsonObject.getString("name");
                String column2Value = jsonObject.getString("No");
                String column3Value = jsonObject.getString("type");
                String column4Value = jsonObject.getString("measure");
                String column5Value = jsonObject.getString("state");
                String column6Value = jsonObject.getString("describe");
                String column7Value = jsonObject.getString("leasedState");
                String column8Value = jsonObject.getString("fac");
                tableModel.addRow(new Object[]{false, ID, column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value});
            }
        }

        return tableModel;
    }

    //重新生成表格数据
    private DefaultTableModel createOneModel(){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\device.json");

        //目标用户名字
        String inputAccount = formattedTextField1.getText();

        // 创建表格模型
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn(" ");
        tableModel.addColumn("ID");
        tableModel.addColumn("设备名称");
        tableModel.addColumn("设备编码");
        tableModel.addColumn("设备类别");
        tableModel.addColumn("设备规格");
        tableModel.addColumn("类别状态");
        tableModel.addColumn("类别描述");
        tableModel.addColumn("租用状态");
        tableModel.addColumn("所属工厂");


        //遍历JSON数组找到对应用户，构造数据模型
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject.get("name"))){
                if(jsonObject.get("fac").equals(managerItem.getFacName())) {
                    String ID = Integer.toString(i + 1);
                    String column1Value = jsonObject.getString("name");
                    String column2Value = jsonObject.getString("No");
                    String column3Value = jsonObject.getString("type");
                    String column4Value = jsonObject.getString("measure");
                    String column5Value = jsonObject.getString("state");
                    String column6Value = jsonObject.getString("describe");
                    String column7Value = jsonObject.getString("leasedState");
                    String column8Value = jsonObject.getString("fac");
                    tableModel.addRow(new Object[]{false, ID, column1Value, column2Value, column3Value, column4Value, column5Value, column6Value, column7Value, column8Value});
                }
            }
        }

        return tableModel;
    }

    //加载个人用户资料
    private void loadManager(){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile("src\\data\\manager.json");

        //寻找目标用户的信息
        for (int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(jsonObject.get("account").equals(managerItem.getAccount())){
                managerItem.setFacName(jsonObject.getString("facName"));
            }
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JFormattedTextField formattedTextField1;
    private JButton button1;
    private JButton button2;
    private JButton button5;
    private JButton button4;
    private JButton button3;
    private JButton button7;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button8;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private ManagerItem managerItem;
}
