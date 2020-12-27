
package avm_multithread;

import java.util.ArrayList;


public class Kat_Bilgi {

    private int yaklasan_asansor;
    private ArrayList<Asansor_kuyruk> kuyruk;
    private int katta_bulunan_kisi;
    private int sanal_katta_bulunan;
    private boolean yolcu_istek;
    private int kuyruk_sayisi;

    public int getKuyruk_sayisi() {
        return kuyruk_sayisi;
    }

    public void setKuyruk_sayisi(int kuyruk_sayisi) {
        this.kuyruk_sayisi = kuyruk_sayisi;
    }

    public Kat_Bilgi() {
        sanal_katta_bulunan = 0;
        katta_bulunan_kisi = 0;
        yaklasan_asansor = -1;
        kuyruk = new ArrayList<>();
    }

    public int getSanal_katta_bulunan() {
        return sanal_katta_bulunan;
    }

    public synchronized void setSanal_katta_bulunan(int sanal_katta_bulunan) {
        this.sanal_katta_bulunan += sanal_katta_bulunan;
    }

    public synchronized void sanal_sil(int temp) {
        this.sanal_katta_bulunan -= temp;
    }

    public int getKatta_bulunan_kisi() {
        return katta_bulunan_kisi;
    }

    public synchronized void setKatta_bulunan_kisi(int katta_bulunan_kisi) {
        this.katta_bulunan_kisi += katta_bulunan_kisi;
    }

    public int getYaklasan_asansor() {
        return yaklasan_asansor;
    }

    public void setYaklasan_asansor(int yaklasan_asansor) {
        this.yaklasan_asansor = yaklasan_asansor;
    }

    public ArrayList<Asansor_kuyruk> getKuyruk() {
        return kuyruk;
    }

    public void setKuyruk(ArrayList<Asansor_kuyruk> kuyruk) {
        this.kuyruk = kuyruk;
    }

    public synchronized void yolcu_sil(int yolcu_sayisi) {
        this.katta_bulunan_kisi -= yolcu_sayisi;
    }

    public boolean isYolcu_istek() {
        return yolcu_istek;
    }

    public void setYolcu_istek(boolean yolcu_istek2) {
        this.yolcu_istek = yolcu_istek2;
    }

    @Override
    public String toString() {
        String name = "";

        for (int i = 0; i < kuyruk.size(); i++) {
            if (!this.getKuyruk().isEmpty()) {
                try {
                    name += "(" + this.getKuyruk().get(i).getYolcu_sayisi() + "," + this.getKuyruk().get(i).getUlasilacak_kat() + ")";
                } catch (IndexOutOfBoundsException e) {
                    name = "";
                }
               catch (NullPointerException ex) {               
                }
            }
        }

        return name;
    }

}
