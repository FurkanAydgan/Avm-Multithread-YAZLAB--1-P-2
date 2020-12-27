
package avm_multithread;

import static java.lang.Math.abs;



public class Kat_Yonetici {

    Zaman time;
    int istek_kontrol;
    private Kat_Bilgi[] kat_bilgi;
    private int cikis_yapan = 0;
    Asansor_Thread[] asansorler;
    Asansor_kuyruk deneme;
    public Kat_Yonetici(Zaman time) {
        this.time = time;
        kat_bilgi = new Kat_Bilgi[5];
        for (int i = 0; i < 5; i++) {
            kat_bilgi[i] = new Kat_Bilgi();
        }
    }

    public void asansor_al(Asansor_Thread[] asansorler) {
        this.asansorler = asansorler;
    }

    public int getCikis_yapan() {
        return cikis_yapan;
    }

    public void setCikis_yapan(int cikis_yapan) {
        this.cikis_yapan += cikis_yapan;
    }

    public Kat_Bilgi[] getKat_bilgi() {
        return kat_bilgi;
    }

    public synchronized void istek_kontrol(int istek_kontrol) {
        this.istek_kontrol = istek_kontrol;
        Kat_Bilgi kt = kat_bilgi[this.istek_kontrol];
        kt.setYolcu_istek(true);
    }

    public synchronized Asansor_hareket istek_Varmi(int id, int asansor_durum, int asansor_id) {
        if (asansor_durum == 0 || asansor_durum == 1) {
            Kat_Bilgi kat = kat_bilgi[asansor_durum];
            if (kat.isYolcu_istek()) {
                return new Asansor_hareket(asansor_durum, this.time.getZaman());
            } else {
                for (int i = 0; i < 5; i++) {
                    Kat_Bilgi kt = kat_bilgi[i];
                    if (kt.isYolcu_istek()) {
                        if (asansor_durum == i) {
                            kt.setYaklasan_asansor(id);
                            return new Asansor_hareket(i, this.time.getZaman());
                        } else {
                            kt.setYaklasan_asansor(id);
                            if (asansor_durum > i) {
                                asansorler[asansor_id].setYon("Asagi");
                            } else {
                                asansorler[asansor_id].setYon("Yukarı");
                            }
                            return new Asansor_hareket(i, this.time.getZaman() + (int) (abs(i - asansor_durum) * 200));
                        }

                    }
                }
            }

        } else {
            Kat_Bilgi kat = kat_bilgi[asansor_durum];
            if (kat.isYolcu_istek()) {
                return new Asansor_hareket(asansor_durum, this.time.getZaman());
            } else {
                for (int i = 4; i >= 0; i--) {
                    Kat_Bilgi kt = kat_bilgi[i];
                    if (kt.isYolcu_istek()) {

                        if (asansor_durum == i) {
                            kt.setYaklasan_asansor(id);
                            return new Asansor_hareket(i, this.time.getZaman());
                        } else {
                            kt.setYaklasan_asansor(id);
                            if (asansor_durum > i) {
                                asansorler[asansor_id].setYon("Asagi");
                            } else {
                                asansorler[asansor_id].setYon("Yukarı");
                            }
                            return new Asansor_hareket(i, this.time.getZaman() + (int) (abs(i - asansor_durum) * 200));
                        }

                    }
                }
            }
        }
        return null;
    }

   

}
