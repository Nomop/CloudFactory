/*
 * Created by JFormDesigner on Sun Jun 04 11:17:19 CST 2023
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
import static control.tableControl.addCheckBox;

/**
 * @author zhoufengming
 */
public class LeasedEquipment extends JFrame {
    public LeasedEquipment() {
        initComponents();
    }

    public LeasedEquipment(ManagerItem ManagerItem) {
        managerItem=ManagerItem;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(createTable());
        }

        //======== panel1 ========
        {

            //---- button1 ----
            button1.setText("\u8fd4\u56de");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addContainerGap(23, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(475, Short.MAX_VALUE)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentDevice(table1,"src\\data\\device.json");
                dispose();
            }
        });
    }

    //得到无归属工厂并且未被租用的新数组
    private JSONArray updateJsonarray(JSONArray jsonArray){
        JSONArray updateJsonArray =new JSONArray();

        for (int i=0;i<jsonArray.length();i++){
            JSONObject object =jsonArray.getJSONObject(i);
            if(object.get("fac").equals("") && object.get("leasedState").equals("未被租用")){
                updateJsonArray.put(object);
            }
        }
        return updateJsonArray;
    }

    //添加设备，即修改选定的设备状态和所属工厂
    private void rentDevice(JTable table,String filePath){
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

                        //修改属性
                        object1.put("fac",managerItem.getFacName());
                        object1.put("leasedState","已被租用");
                        //写入修改后的数据
                        writeJsonToFile(jsonArray1,filePath);
                        break;
                    }
                }
            }
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

            if(jsonObject.get("fac").equals("") && jsonObject.get("leasedState").equals("未被租用")) {
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


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private ManagerItem managerItem;
}
