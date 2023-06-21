package unit;

import java.io.Serializable;

public class ManagerItem implements Serializable {
    private String account;
    private String password;
    private String name;
    private String phone;
    private String ResgisWay;
    private String facName;
    private String facIntro;
    private String state;

    public ManagerItem(){}

    public ManagerItem(String Account){
        this.account=Account;
        this.facName="";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacIntro() {
        return facIntro;
    }

    public void setFacIntro(String facIntro) {
        this.facIntro = facIntro;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResgisWay() {
        return ResgisWay;
    }

    public void setResgisWay(String resgisWay) {
        this.ResgisWay = resgisWay;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState(){return  this.state;}

    @Override
    public String toString() {
        return "\",\"account\":\"" + this.account + "\",\"password\":\"" + this.password + "\",\"name\":\"" + this.name + "\",\"phone\":\"" + this.phone + "\",\"registerWay\":\"" + this.ResgisWay + "\",\"facName\":\"" + this.facName + "\",\"facIntro\":\"" + this.facIntro + "\",\"state\":\"" + this.state+ "\"/";
    }
}

