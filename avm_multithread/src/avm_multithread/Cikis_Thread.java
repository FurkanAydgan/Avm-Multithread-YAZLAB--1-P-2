
package avm_multithread;

import java.util.ArrayList;
import java.util.Random;

public class Cikis_Thread implements Runnable {

    Zaman time;
    Kat_Yonetici kat_yonetici;
    ArrayList<Asansor_kuyruk>[] kat_bilgi;
    Random rnd;
    int a = 0, b = 0;

    public Cikis_Thread(Zaman time, Kat_Yonetici kat_yonetici, ArrayList<Asansor_kuyruk>[] kat_bilgi) {
        rnd = new Random();
        this.kat_bilgi = kat_bilgi;
        this.time = time;
        this.kat_yonetici = kat_yonetici;

    }

    @Override
    public void run() {
        while (true) {
            try {
                do {
                    Asansor_kuyruk kuyruk = new Asansor_kuyruk();
                    int c = 0;
                    a = 1 + rnd.nextInt(4);
                    if (kat_yonetici.getKat_bilgi()[a].getSanal_katta_bulunan() != 0) {

                        c = kat_yonetici.getKat_bilgi()[a].getSanal_katta_bulunan();
                        if (c > 0) {
                            if (c >= 5) {
                                c = 5;
                            }
                            b = rnd.nextInt(c) + 1;
                            kuyruk.setUlasilacak_kat(0);
                            kuyruk.setYolcu_sayisi(b);
                            kat_bilgi[a].add(kuyruk);
                        }

                        break;
                    }

                } while (true);

                kat_yonetici.getKat_bilgi()[a].setKuyruk(kat_bilgi[a]);
                kat_yonetici.getKat_bilgi()[a].sanal_sil(b);
                kat_yonetici.istek_kontrol(a);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
