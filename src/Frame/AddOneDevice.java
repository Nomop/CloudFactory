/*
 * Created by JFormDesigner on Tue Jun 13 13:50:41 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import unit.DeciveItem;
import unit.ManagerItem;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import static control.fileControl.loadJsonArrayFromFile;
import static control.fileControl.writeJsonToFile;
import static control.otherControl.findSame;

/**
 * @author zhoufengming
 */
public class AddOneDevice extends JFrame {
    public AddOneDevice() {
        initComponents();
    }

    public AddOneDevice(ManagerItem ManagerItem) {
        managerItem=ManagerItem;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        textField4 = new JTextField();
        label4 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();
        label7 = new JLabel();
        textField7 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel2 ========
        {

            //---- label2 ----
            label2.setText("\u8bbe\u5907\u540d\u79f0");

            //---- button2 ----
            button2.setText("\u786e\u5b9a");

            //---- label4 ----
            label4.setText("\u8bbe\u5907\u7c7b\u522b");

            //---- label5 ----
            label5.setText("\u8bbe\u5907\u89c4\u683c");

            //---- label7 ----
            label7.setText("\u8bbe\u5907\u63cf\u8ff0");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(155, Short.MAX_VALUE)
                        .addComponent(button2)
                        .addGap(153, 153, 153))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addComponent(button2)
                        .addContainerGap(31, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(132, 132, 132))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDeviceItem();
            }
        });
    }

    //生成新建信息
    private void createDeviceItem() {
        //读入新建信息
        String filePath="src\\data\\device.json";
        DeciveItem deciveItem =new DeciveItem();

        String inputAccount=textField2.getText();

        deciveItem.setName(textField2.getText());
        deciveItem.setType(textField4.getText());
        deciveItem.setMeasure(textField5.getText());
        deciveItem.setState("关机");
        deciveItem.setDescribe(textField7.getText());
        deciveItem.setFac(managerItem.getFacName());
        deciveItem.setLeasedState("工厂设备");

        //加载原来的json文件到JSON数组里
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);
        //JSONArray jsonArray =updateJsonarray(loadJsonArrayFromFile("src\\data\\device.json"));

        //写入JSON文件
        JSONObject jsonObject = new JSONObject();
        boolean hasSame=false;//判断是否有相同产品名称
        boolean typeSame=findSame(textField4.getText());//判断产品类别是否存在

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject1.get("name"))){
                hasSame=true;
            }
        }

        //生成产品编号
        long timestamp = Instant.now().toEpochMilli();
        String uniqueId = String.valueOf(timestamp);

        if(typeSame){
            if(hasSame){
                JOptionPane.showMessageDialog(null, "该设备名称已经存在了\n请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
                textField2.setText("");// 清空输入框
            }else{

                jsonObject.put("type",deciveItem.getType());
                jsonObject.put("measure",deciveItem.getMeasure());
                jsonObject.put("describe",deciveItem.getDescribe());
                jsonObject.put("state",deciveItem.getState());
                jsonObject.put("leasedState",deciveItem.getLeasedState());
                jsonObject.put("fac",deciveItem.getFac());
                jsonObject.put("No","PNO"+uniqueId);
                jsonObject.put("name",deciveItem.getName());

                jsonArray.put(jsonObject);

                writeJsonToFile(jsonArray,filePath);

                JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "该设备类别不存在\n请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
            textField4.setText("");// 清空输入框
        }


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JLabel label2;
    private JTextField textField2;
    private JButton button2;
    private JTextField textField4;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label5;
    private JLabel label7;
    private JTextField textField7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private ManagerItem managerItem;
}
