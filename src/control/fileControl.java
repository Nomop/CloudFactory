package control;

import net.sf.json.JSONArray;

import java.io.*;

public class fileControl {

    //写入json文件
    public static void writeJsonToFile(JSONArray jsonArray,String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //加载json文件,
    public static JSONArray loadJsonArrayFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonStr = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStr.append(line);
            }
            return JSONArray.fromObject(jsonStr.toString());
        } catch (IOException e) {
            return new JSONArray();
        }
    }
}
