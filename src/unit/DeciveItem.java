package unit;

public class DeciveItem {
    private String name;
    private String No;
    private String type;
    private String measure;
    private String state;
    private String describe;
    private String leasedState;
    private String fac;

    public String getMeasure() {
        return measure;
    }

    public String getDescribe() {
        return describe;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getNo() {
        return No;
    }

    public String getFac() {
        return fac;
    }

    public String getLeasedState() {
        return leasedState;
    }

    public String getState() {
        return state;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLeasedState(String leasedState) {
        this.leasedState = leasedState;
    }

    @Override
    public String toString() {
        return "DeciveItem{" +
                "name='" + name + '\'' +
                ", No='" + No + '\'' +
                ", type='" + type + '\'' +
                ", measure='" + measure + '\'' +
                ", state='" + state + '\'' +
                ", describe='" + describe + '\'' +
                ", leasedState='" + leasedState + '\'' +
                ", fac='" + fac + '\'' +
                '}';
    }
}
