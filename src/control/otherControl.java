package control;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import static control.fileControl.loadJsonArrayFromFile;

public class otherControl {

    //判断产品类别是否存在
    public static boolean findSame(String inputType){
        boolean result=false;

        String filePath="src\\data\\type.json";
        //加载type的json文件到JSON数组里
        JSONArray jsonArray = loadJsonArrayFromFile(filePath);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            if(inputType.equals(jsonObject1.get("type"))){
                result=true;
            }
        }
        return result;
    }
}
