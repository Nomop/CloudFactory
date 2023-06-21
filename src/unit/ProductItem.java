package unit;

public class ProductItem {
    private String No;
    private String name;
    private String type;
    private String measure;
    private String describe;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public String getMeasure() {
        return measure;
    }

    public String getNo() {
        return No;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setNo(String no) {
        No = no;
    }

    @Override
    public String toString() {
        return "\",\"No\":\"" + this.No+"\",\"name\":\"" + this.name+"\",\"type\":\"" + this.type+"\",\"measure\":\"" + this.measure+"\",\"describe\":\"" + this.describe;
    }
}

