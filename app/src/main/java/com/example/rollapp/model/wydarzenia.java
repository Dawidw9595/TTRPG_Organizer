package com.example.rollapp.model;

public class wydarzenia {

    private int id;
    private String lata_10;
    private String lata_20;
    private String lata_30;
    private String lata_40;
    private String lata_50;
    private String lata_60;
    private String lata_70;
    private String lata_80;
    private String lata_90;
    private String lata_100;
    private int id_karty;
    private int koniec;



    public wydarzenia(){}

    public String getLata_10() {return lata_10;}
    public void setLata_10(String lata_10){
        this.lata_10 = lata_10;
    }

    public String getLata_20() {return lata_20;}
    public void setLata_20(String lata_20){
        this.lata_20 = lata_20;
    }

    public String getLata_30() {return lata_30;}
    public void setLata_30(String lata_30){
        this.lata_30 = lata_30;
    }

    public String getLata_40() {return lata_40;}
    public void setLata_40(String lata_40){
        this.lata_40 = lata_40;
    }

    public String getLata_50() {return lata_50;}
    public void setLata_50(String lata_50){
        this.lata_50 = lata_50;
    }

    public String getLata_60() {return lata_60;}
    public void setLata_60(String lata_60){
        this.lata_60 = lata_60;
    }

    public String getLata_70() {return lata_70;}
    public void setLata_70(String lata_70){
        this.lata_70 = lata_70;
    }

    public String getLata_80() {return lata_80;}
    public void setLata_80(String lata_80){
        this.lata_80 = lata_80;
    }

    public String getLata_90() {return lata_90;}
    public void setLata_90(String lata_90){
        this.lata_90 = lata_90;
    }

    public String getLata_100() {return lata_100;}
    public void setLata_100(String lata_100){
        this.lata_100 = lata_100;
    }

    public int getId_karty(){return id_karty;}
    public void setId_karty(int id_karty){this.id_karty = id_karty;}


    @Override
    public String toString(){
        return  "wydarzenia{" +
                "id" + id +
                ", lata_10" + lata_10 +'\'' +
                ", lata_20" + lata_20 + '\'' +
                ", lata_30" + lata_30 +'\'' +
                ", lata_40" + lata_40 + '\'' +
                ", lata_50" + lata_50 + '\'' +
                ", lata_60" + lata_60 + '\'' +
                ", lata_70" + lata_70 + '\'' +
                ", lata_80" + lata_80 + '\'' +
                ", lata_90" + lata_90 +'\'' +
                ", lata_100" + lata_100 + '\'' +
                ", koniec" + koniec +
                '}';
    }


}
