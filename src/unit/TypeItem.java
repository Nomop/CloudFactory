package unit;

import java.io.Serializable;

public class TypeItem implements Serializable {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\",\"type\":\"" + this.type+ "\"/";
    }
}
