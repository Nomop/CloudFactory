/*
 * Created by JFormDesigner on Sat Jun 10 17:24:29 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import unit.TypeItem;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static control.fileControl.loadJsonArrayFromFile;
import static control.fileControl.writeJsonToFile;

/**
 * @author zhoufengming
 */
public class AddType extends JFrame {
    public AddType() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("\u7c7b\u522b\u540d\u79f0");

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createTypeItem();
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(button1)
                        .addContainerGap(161, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(button1)
                        .addGap(76, 76, 76))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    //生成新建信息
    private void createTypeItem() {
        //读入新建信息
        String filePath="src\\data\\type.json";
        TypeItem typeItem=new TypeItem();
        String inputAccount=textField1.getText();
        typeItem.setType(textField1.getText());

        //加载原来的json文件到JSON数组里
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);

        //写入JSON文件
        JSONObject jsonObject = new JSONObject();
        boolean hasSame=false;//判断是否有相同类型名称

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if(inputAccount.equals(jsonObject1.get("type"))){
                hasSame=true;
            }
        }

        if(hasSame){
            JOptionPane.showMessageDialog(null, "该类型名称已经存在了\n请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
            textField1.setText("");// 清空输入框
        }else{
            jsonObject.put("type",typeItem.getType());

            jsonArray.put(jsonObject);

            writeJsonToFile(jsonArray,filePath);

            JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
