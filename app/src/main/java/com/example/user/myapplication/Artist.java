package com.example.user.myapplication;

public class Artist {

    String EN;
    String Loc;
    String Min;
    String Or;
    String cat;
    String dT;
    String email;
    String li;
    String mes;
    String ph;
    String res;

    public Artist(){

    }

    public Artist(String EN, String loc, String min, String or, String cat, String dT, String email, String li, String mes, String ph, String res) {
        this.EN = EN;
        Loc = loc;
        Min = min;
        Or = or;
        this.cat = cat;
        this.dT = dT;
        this.email = email;
        this.li = li;
        this.mes = mes;
        this.ph = ph;
        this.res = res;
    }

    public String getEN() {
        return EN;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getMin() {
        return Min;
    }

    public void setMin(String min) {
        Min = min;
    }

    public String getOr() {
        return Or;
    }

    public void setOr(String or) {
        Or = or;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getdT() {
        return dT;
    }

    public void setdT(String dT) {
        this.dT = dT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLi() {
        return li;
    }

    public void setLi(String li) {
        this.li = li;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
