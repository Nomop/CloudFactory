/*
 * Created by JFormDesigner on Sun Jun 11 09:05:32 CST 2023
 */

package Frame;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import unit.ProductItem;
import unit.TypeItem;

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
public class AddProduct extends JFrame {
    public AddProduct() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel2 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        textField3 = new JTextField();
        label3 = new JLabel();
        textField4 = new JTextField();
        label4 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel2 ========
        {

            //---- label2 ----
            label2.setText("\u4ea7\u54c1\u540d\u79f0");

            //---- button2 ----
            button2.setText("\u786e\u5b9a");

            //---- label3 ----
            label3.setText("\u4ea7\u54c1\u7c7b\u522b");

            //---- label4 ----
            label4.setText("\u4ea7\u54c1\u89c4\u683c");

            //---- label5 ----
            label5.setText("\u4ea7\u54c1\u63cf\u8ff0");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(button2))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(45, Short.MAX_VALUE))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(button2)
                        .addContainerGap(60, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(21, 21, 21))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProductItem();
            }
        });
    }


    //生成新建信息
    private void createProductItem() {
        //读入新建信息
        String filePath="src\\data\\product.json";
        ProductItem productItem=new ProductItem();

        String inputAccount=textField2.getText();
        productItem.setName(textField2.getText());
        productItem.setType(textField3.getText());
        productItem.setMeasure(textField4.getText());
        productItem.setDescribe(textField5.getText());

        //加载原来的json文件到JSON数组里
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);

        //写入JSON文件
        JSONObject jsonObject = new JSONObject();
        boolean hasSame=false;//判断是否有相同产品名称
        boolean typeSame=findSame(textField3.getText());//判断产品类别是否存在

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
                JOptionPane.showMessageDialog(null, "该产品名称已经存在了\n请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
                textField2.setText("");// 清空输入框
            }else{
                jsonObject.put("name",productItem.getName());
                jsonObject.put("type",productItem.getType());
                jsonObject.put("measure",productItem.getMeasure());
                jsonObject.put("describe",productItem.getDescribe());
                jsonObject.put("No","PNO"+uniqueId);

                jsonArray.put(jsonObject);

                writeJsonToFile(jsonArray,filePath);

                JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "该产品类别不存在\n请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
            textField3.setText("");// 清空输入框
        }


    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel2;
    private JLabel label2;
    private JTextField textField2;
    private JButton button2;
    private JTextField textField3;
    private JLabel label3;
    private JTextField textField4;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
