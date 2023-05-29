package com.example.rollapp.model;

public class wiedzmin_statystyki_postaci {

    private int id;
    private int bieg;
    private int id_karta;
    private int powazanie;
    private int poziom_zdrowia;
    private int punkty_przytomnosci;
    private int punkty_wytrwalosci;
    private int skok;
    private int slawa;
    private int udzwig;
    private int wprawa;
    private int zdrowienie;
    private String piesc;
    private String kop;

    private int koniec;
    public wiedzmin_statystyki_postaci(){
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getId_karta() {return id_karta;}
    public void setId_karta(int id_karta) {this.id_karta = id_karta;}

    public int getPowazanie() {return powazanie;}
    public void setPowazanie(int powazanie) {this.powazanie = powazanie;}
    public int getSlawa(){return slawa;}
    public void setSlawa(int slawa) {this.slawa = slawa;}
    public int getWprawa() {return wprawa;};
    public void setWprawa(int wprawa) {this.wprawa = wprawa;}
    public int getPunkty_przytomnosci(){return punkty_przytomnosci;}
    public void setPunkty_przytomnosci(int punkty_przytomnosci) {this.punkty_przytomnosci = punkty_przytomnosci;}
    public int getBieg(){return bieg;}
    public void setBieg(int bieg) {this.bieg = bieg;}
    public int getSkok(){return skok;};
    public void setSkok(int skok) {this.skok = skok;}
    public int getPoziom_zdrowia(){return poziom_zdrowia;}
    public void setPoziom_zdrowia(int poziom_zdrowia) {this.poziom_zdrowia = poziom_zdrowia;}
    public int getPunkty_wytrwalosci(){return punkty_wytrwalosci;}
    public void setPunkty_wytrwalosci(int punkty_wytrwalosci) {this.punkty_wytrwalosci = punkty_wytrwalosci;}
    public int getUdzwig() {return udzwig;}
    public void setUdzwig(int udzwig) {this.udzwig = udzwig;}
    public int getZdrowienie(){return zdrowienie;}
    public void setZdrowienie(int zdrowienie) {this.zdrowienie = zdrowienie;}
    public String getPiesc() {return piesc;}
    public void setPiesc(String piesc) {this.piesc = piesc;}
    public String getKop(){return kop;}
    public void setKop(String kop) {this.kop = kop;}

    @Override
    public String toString(){
        return "wiedzmin_statystyki_postaci{" +
                "id=" + id +
                ", powazanie'" + powazanie + '\'' +
                ",  slawa'" +  slawa + '\'' +
                ",  wprawa'" +  wprawa + '\'' +
                ",  punkty_przytomnosci'" +  punkty_przytomnosci + '\'' +
                ",  bieg'" +  bieg + '\'' +
                ",  skok'" +  skok + '\'' +
                ", poziom_zdrowia'" + poziom_zdrowia + '\'' +
                ",  punkty_wytrwalosci'" +  punkty_wytrwalosci + '\'' +
                ",  udzwig'" +  udzwig + '\'' +
                ", zdrowienie'" + zdrowienie + '\'' +
                ",  piesc'" +  piesc + '\'' +
                ", kop'" + kop + '\'' +
                '}';



    }

}
