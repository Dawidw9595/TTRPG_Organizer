package com.example.rollapp.model;

public class wiedzmin_zdolnosci_rozum {

    private int id;


    private int id_karta;

    private int czujnosc;

    private int dedukcja;

    private int interesy;

    private int j_krasnoludzki;

    private int j_starsza_mowa;

    private int j_wspolny;

    private int miastowy;

    private int nauczanie;

    private int obycie;

    private int strategia;

    private int sztuka_przetrwania;

    private int wiedz_o_potworach;

    private int wyksztalcenie;


    private int koniec;

    public wiedzmin_zdolnosci_rozum() {
    }

    public int getKoniec() {
        return koniec;
    }

    public void setKoniec(int koniec) {
        this.koniec = koniec;
    }

    public int getId_karta() {
        return id_karta;
    }

    public void setId_karta(int id_karta) {
        this.id_karta = id_karta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCzujnosc() {
        return czujnosc;
    }

    public void setCzujnosc(int czujnosc) {
        this.czujnosc = czujnosc;
    }

    public int getDedukcja() {
        return dedukcja;
    }

    public void setDedukcja(int dedukcja) {
        this.dedukcja = dedukcja;
    }

    public int getInteresy() {
        return interesy;
    }

    public void setInteresy(int interesy) {
        this.interesy = interesy;
    }

    public int getJ_krasnoludzki() {
        return j_krasnoludzki;
    }

    public void setJ_krasnoludzki(int j_krasnoludzki) {
        this.j_krasnoludzki = j_krasnoludzki;
    }

    public int getJ_starsza_mowa() {
        return j_starsza_mowa;
    }

    public void setJ_starsza_mowa(int j_starsza_mowa) {
        this.j_starsza_mowa = j_starsza_mowa;
    }

    public int getJ_wspolny() {
        return j_wspolny;
    }

    public void setJ_wspolny(int j_wspolny) {
        this.j_wspolny = j_wspolny;
    }

    public int getMiastowy() {
        return miastowy;
    }

    public void setMiastowy(int miastowy) {
        this.miastowy = miastowy;
    }

    public int getNauczanie() {
        return nauczanie;
    }

    public void setNauczanie(int nauczanie) {
        this.nauczanie = nauczanie;
    }

    public int getObycie() {
        return obycie;
    }

    public void setObycie(int obycie) {
        this.obycie = obycie;
    }

    public int getStrategia() {
        return strategia;
    }

    public void setStrategia(int strategia) {
        this.strategia = strategia;
    }

    public int getSztuka_przetrwania() {
        return sztuka_przetrwania;
    }

    public void setSztuka_przetrwania(int sztuka_przetrwania) {
        this.sztuka_przetrwania = sztuka_przetrwania;
    }

    public int getWiedz_o_potworach() {
        return wiedz_o_potworach;
    }

    public void setWiedz_o_potworach(int wiedz_o_potworach) {
        this.wiedz_o_potworach = wiedz_o_potworach;
    }

    public int getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(int wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    @Override
    public String toString() {
        return "wiedzmin_zdolnosci_rozum{" +
                "id=" + id +
                ", id_karta=" + id_karta +
                ", czujnosc=" + czujnosc +
                ", dedukcja=" + dedukcja +
                ", interesy=" + interesy +
                ", j_krasnoludzki=" + j_krasnoludzki +
                ", j_starsza_mowa=" + j_starsza_mowa +
                ", j_wspolny=" + j_wspolny +
                ", miastowy=" + miastowy +
                ", nauczanie=" + nauczanie +
                ", obycie=" + obycie +
                ", strategia=" + strategia +
                ", sztuka_przetrwania=" + sztuka_przetrwania +
                ", wiedz_o_potworach=" + wiedz_o_potworach +
                ", wyksztalcenie=" + wyksztalcenie +
                ", koniec=" + koniec +
                '}';
    }
}
