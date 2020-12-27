package avm_multithread;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

public class Asansor_Thread implements Runnable {

    Zaman time;
    private int asansor_id;
    private int yolcu_sayisi;
    private boolean asansor_durum;
    private String asansor_mod;
    private int bulundugu_kat;
    private int indirdigi_yolcu_sayi;
    private int max_kapasite;
    private int toplam_aldigi_yolcu;
    private ArrayList<Asansor_hareket> hareket;
    private Kat_Yonetici kontrol;
    private ArrayList<Asansor_kuyruk> inside;
    private String yon = "Yukarı";
    private int hedef_kat = 0;
    private boolean kontrol_asansor;

    public int getHedef_kat() {
        return hedef_kat;
    }

    public ArrayList<Asansor_kuyruk> getInside() {
        return inside;
    }

    public void setHedef_kat(int hedef_kat) {
        this.hedef_kat = hedef_kat;
    }

    public String getYon() {
        return yon;
    }

    public void setYon(String yon) {
        this.yon = yon;
    }

    public void setAsansor_durum(boolean asansor_durum) {
        this.asansor_durum = asansor_durum;
    }

    public synchronized boolean isKontrol_asansor() {
        return kontrol_asansor;
    }

    public synchronized void setKontrol_asansor(boolean kontrol_asansor) {
        this.kontrol_asansor = kontrol_asansor;
    }

    public Asansor_Thread() {

    }

    public Asansor_Thread(int ID, Kat_Yonetici kontrol, Zaman time) {
        this.asansor_id = ID;
        this.kontrol = kontrol;
        this.max_kapasite = 10;
        this.asansor_durum = false;
        this.bulundugu_kat = 0;
        this.indirdigi_yolcu_sayi = 0;
        this.toplam_aldigi_yolcu = 0;
        this.yolcu_sayisi = 0;
        this.hareket = new ArrayList<>();
        this.time = time;

        inside = new ArrayList<>();
    }

    public int getBulundugu_kat() {
        return bulundugu_kat;
    }

    public int getYolcu_sayisi() {
        return yolcu_sayisi;
    }

    public int getAsansor_id() {
        return asansor_id;
    }

    public boolean isAsansor_durum() {
        return asansor_durum;
    }

    public int getIndirdigi_yolcu_sayi() {
        return indirdigi_yolcu_sayi;
    }

    public synchronized void setIndirdigi_yolcu_sayi(int indirdigi_yolcu_sayi) {
        this.indirdigi_yolcu_sayi += indirdigi_yolcu_sayi;
    }

    public int getMax_kapasite() {
        return max_kapasite;
    }

    public int getToplam_aldigi_yolcu() {
        return toplam_aldigi_yolcu;
    }

    public synchronized void setToplam_aldigi_yolcu(int toplam_aldigi_yolcu) {
        this.toplam_aldigi_yolcu += toplam_aldigi_yolcu;
    }

    public ArrayList<Asansor_hareket> getHareket() {
        return hareket;
    }

    public Kat_Yonetici getKontrol() {
        return kontrol;
    }

    public void hareket(Asansor_hareket hareket) {
        if (hareket != null) {
            this.hareket.add(hareket);
        }
    }

    public String getAsansor_mod() {
        return asansor_mod;
    }

    public void setAsansor_mod(String asansor_mod) {
        this.asansor_mod = asansor_mod;
    }

    public void hareket(List<Asansor_hareket> events) {
        this.hareket.addAll(events);
    }

    @Override
    public synchronized String toString() {
        String name = "";

        for (int i = 0; i < this.inside.size(); i++) {
            if (!this.inside.isEmpty()) {
                try {

                    name += "(" + this.getInside().get(i).getYolcu_sayisi() + "," + this.getInside().get(i).getUlasilacak_kat() + ")";
                } catch (IndexOutOfBoundsException e) {
                    name = "";
                } catch (NullPointerException ex) {
                    name = "";
                }
            }

        }

        return name;
    }

    public synchronized Asansor_hareket yolcu_yukle(ArrayList<Asansor_kuyruk> kuyruk) {

        ArrayList<Asansor_kuyruk> temp = new ArrayList<>();
        ArrayList<Asansor_hareket> hareket = new ArrayList<>();
        int alinan_yolcu = 0;

        int kucuk = kuyruk.get(0).getUlasilacak_kat();

        int tut = 0;

        int tut2 = kuyruk.size();
        for (int j = 0; j < tut2; j++) {
            for (int i = 0; i < kuyruk.size(); i++) {
                if (kucuk > kuyruk.get(i).getUlasilacak_kat()) {
                    kucuk = kuyruk.get(i).getUlasilacak_kat();
                    tut = i;
                }
            }
            temp.add(kuyruk.get(tut));
            kuyruk.remove(tut);
            tut = 0;
        }

        for (int i = this.bulundugu_kat; i < 5; i++) {
            for (int k = 0; k < temp.size(); k++) {
                if (temp.get(k).getUlasilacak_kat() == i) {
                    hareket.add(new Asansor_hareket(i, this.time.getZaman() + (int) (abs(i - this.bulundugu_kat) * 200)));
                    alinan_yolcu += temp.get(k).getYolcu_sayisi();

                    this.yon = "Yukari";
                }
            }

        }
        if (hareket.isEmpty()) {

            for (int i = this.bulundugu_kat - 1; i >= 0; i--) {
                for (int k = 0; k < temp.size(); k++) {
                    if (temp.get(k).getUlasilacak_kat() == i) {
                        hareket.add(new Asansor_hareket(i, this.time.getZaman() + (int) (abs(i - this.bulundugu_kat) * 200)));
                        alinan_yolcu += temp.get(k).getYolcu_sayisi();

                        this.yon = "Asagi";
                    }
                }
            }
        }
        this.hareket(hareket);
        this.asansor_durum = true;
        this.yolcu_sayisi += alinan_yolcu;
        this.inside.addAll(temp);

        return hareket.get(0);
    }

    public synchronized ArrayList<Asansor_kuyruk> yolcu_yukle2(int kat, int asansorID, int kapasite) {
        int i = 0;
        int kapa = 0;
        int temp = 0;
        this.getKontrol().getKat_bilgi()[0].setYaklasan_asansor(-1);
        int size = this.getKontrol().getKat_bilgi()[kat].getKuyruk().size();
        Asansor_kuyruk deneme;
        ArrayList<Asansor_kuyruk> iceridekiler = new ArrayList<>();
        if (!this.getKontrol().getKat_bilgi()[kat].getKuyruk().isEmpty()) {
            do {

                if (i == size) {
                    break;
                }

                kapa += this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0).getYolcu_sayisi();
                if (kapa <= kapasite) {

                    try {
                        temp += this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0).getYolcu_sayisi();
                        iceridekiler.add(this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0));
                        this.getKontrol().getKat_bilgi()[kat].yolcu_sil(this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0).getYolcu_sayisi());
                        this.getKontrol().getKat_bilgi()[kat].getKuyruk().remove(0);

                    } catch (IndexOutOfBoundsException | NullPointerException e) {

                    }

                } else {
                    if (temp < 10) {
                        deneme = new Asansor_kuyruk();
                        temp = 10 - temp;
                        deneme.setUlasilacak_kat(this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0).getUlasilacak_kat());
                        deneme.setYolcu_sayisi(temp);
                        this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0).setYolcu_sayisi(this.getKontrol().getKat_bilgi()[kat].getKuyruk().get(0).getYolcu_sayisi() - temp);
                        this.getKontrol().getKat_bilgi()[kat].yolcu_sil(temp);
                        iceridekiler.add(deneme);

                    }

                }
                i++;

            } while (kapa <= kapasite);
            return iceridekiler;
        } else {
            return iceridekiler;
        }

    }

    public synchronized void yolcu_indir(int kat) {
        int i = 0;
        this.hareket.remove(0);
        this.yolcu_sayisi -= this.inside.get(i).getYolcu_sayisi();
        if (this.inside.get(i).getUlasilacak_kat() == 0) {
            this.kontrol.setCikis_yapan(this.inside.get(i).getYolcu_sayisi());
        } else {
            this.kontrol.getKat_bilgi()[this.inside.get(i).getUlasilacak_kat()].setKatta_bulunan_kisi(this.inside.get(i).getYolcu_sayisi());
            this.kontrol.getKat_bilgi()[this.inside.get(i).getUlasilacak_kat()].setSanal_katta_bulunan(this.inside.get(i).getYolcu_sayisi());
        }

        this.inside.remove(i);

    }

    @Override
    public void run() {

        while (true) {
            if (this.isKontrol_asansor() == false) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if (this.isKontrol_asansor() == true) {

                this.asansor_durum = true;
                if (this.yolcu_sayisi == 0 && this.getHareket().isEmpty()) {
                    Asansor_hareket a = this.getKontrol().istek_Varmi(asansor_id, this.bulundugu_kat, this.asansor_id);
                    if (a != null) {
                        hedef_kat = a.getVaracagi_kat();
                        this.hareket(a);
                        if (a.getVaracagi_kat() == this.bulundugu_kat) {
                            System.out.println(String.format("%d. Asansor %d.katta kapılarını açıyor", this.asansor_id, a.getVaracagi_kat()));
                            System.out.println("\n");
                        } else {
                            System.out.println(String.format("%d. Asansor %d.kata almak için gidiyor", this.asansor_id, a.getVaracagi_kat()));
                            System.out.println("\n");
                        }
                    }

                } else if (!this.getHareket().isEmpty()) {
                    ArrayList<Asansor_kuyruk> temp = new ArrayList<>();
                    Asansor_hareket hareket = this.getHareket().get(0);
                    hedef_kat = hareket.getVaracagi_kat();
                    if (hareket.getVaris_suresi() <= this.time.getZaman()) {
                        this.bulundugu_kat = this.hareket.get(0).getVaracagi_kat();
                        if (this.yolcu_sayisi == 0) {
                            this.getHareket().remove(0);
                            inside.addAll(this.yolcu_yukle2(hareket.getVaracagi_kat(), this.asansor_id, this.max_kapasite));
                            if (!inside.isEmpty()) {
                                Asansor_hareket firstEvent = this.yolcu_yukle(inside);
                            } else {
                                this.getKontrol().getKat_bilgi()[hareket.getVaracagi_kat()].setYolcu_istek(false);
                            }
                        } else {
                            this.yolcu_indir(hareket.getVaracagi_kat());
                            if (this.asansor_id != 0 && this.yolcu_sayisi == 0) {

                                this.setKontrol_asansor(false);
                            }

                        }
                    }

                }

            }

        }
    }

}
