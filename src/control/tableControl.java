package control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

import static control.fileControl.loadJsonArrayFromFile;
import static control.fileControl.writeJsonToFile;

public class tableControl {

    //渲染多选框
    public static JTable addCheckBox(JTable table){
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

    //删除多选框选中数据,多选框对应文件全部数据,打钩恰好对应第几个
    public static void delete(JTable table,String filePath){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);

        int column = 0; // 指定列
        //遍历第一列每一行多选框
        for(int row = 0;row<table.getRowCount() ;row++){
            Boolean isSelected = (Boolean) table.getValueAt(row, column);
            if(isSelected){
                jsonArray= removeKeyData(jsonArray,row);
            }
        }
        //写入新的数据
        writeJsonToFile(jsonArray,filePath);

        JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    //删除对应文件的对应索引数据
    public static void deleteIndex(int n,String filePath){
        //加载JSON文件
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);

        jsonArray= removeKeyData(jsonArray,n);
        //写入新的数据
        writeJsonToFile(jsonArray,filePath);
    }

    // 从 JSONArray 中删除多选框选中的数据并返回更新后的 JSONArray
    public static JSONArray removeKeyData(JSONArray jsonArray, int dataToRemove) {
        JSONArray updatedArray = new JSONArray();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject dataObj = jsonArray.getJSONObject(i);
            if (i!=dataToRemove) {
                // 将要保留的数据添加到更新后的 JSONArray 中
                updatedArray.put(dataObj);
            }
        }
        return updatedArray;
    }






}
