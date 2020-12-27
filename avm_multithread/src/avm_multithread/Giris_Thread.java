
package avm_multithread;

import java.util.ArrayList;
import java.util.Random;


public class Giris_Thread implements Runnable {

    Zaman time;
    ArrayList<Asansor_kuyruk>[] kat_bilgi;
    Kat_Yonetici kat_yonetici;
    int giris_yolcu = 0;
    int b = 0;
    Random rnd;

    public Giris_Thread(Zaman time, Kat_Yonetici kat_yonetici, ArrayList<Asansor_kuyruk>[] kat_bilgi) {
        this.kat_bilgi = kat_bilgi;
        rnd = new Random();
        this.time = time;
        this.kat_yonetici = kat_yonetici;

    }

    @Override
    public void run() {

        while (true) {

            try {
                Asansor_kuyruk a = new Asansor_kuyruk();
                giris_yolcu = rnd.nextInt(10) + 1;
                a.setYolcu_sayisi(giris_yolcu);
                a.setUlasilacak_kat(rnd.nextInt(4) + 1);
                kat_bilgi[0].add(a);
                kat_yonetici.getKat_bilgi()[0].setKuyruk(kat_bilgi[0]);
                kat_yonetici.getKat_bilgi()[0].setKatta_bulunan_kisi(giris_yolcu);
                kat_yonetici.istek_kontrol(0);

                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

}
