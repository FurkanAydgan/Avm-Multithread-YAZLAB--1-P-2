
package avm_multithread;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Basla {

    JFrame frame;
    JPanel menu = new JPanel();
    JLabel kisi_sayisi = new JLabel("0.kattaki kişi sayisi : " + 0);
    JLabel kisi_sayisi1 = new JLabel("1.kattaki kişi sayisi : " + 0);
    JLabel kisi_sayisi2 = new JLabel("2.kattaki kişi sayisi : " + 0);
    JLabel kisi_sayisi3 = new JLabel("3.kattaki kişi sayisi : " + 0);
    JLabel kisi_sayisi4 = new JLabel("4.kattaki kişi sayisi : " + 0);
    JLabel kuyruk_sayisi = new JLabel("0.kattaki kuyruk sayisi : " + 0);
    JLabel kuyruk_sayisi1 = new JLabel("1.kattaki kuyruk sayisi : " + 0);
    JLabel kuyruk_sayisi2 = new JLabel("2.kattaki kuyruk sayisi : " + 0);
    JLabel kuyruk_sayisi3 = new JLabel("3.kattaki kuyruk sayisi : " + 0);
    JLabel kuyruk_sayisi4 = new JLabel("4.kattaki kuyruk sayisi : " + 0);
    JLabel cikis_kuyruk = new JLabel("Cikis yapan kisiler : " + 0);
    JLabel durum = new JLabel("Asansor 1 durum : " + false);
    JLabel durum2 = new JLabel("Asansor 2 durum : " + false);
    JLabel durum3 = new JLabel("Asansor 3 durum : " + false);
    JLabel durum4 = new JLabel("Asansor 4 durum : " + false);
    JLabel durum5 = new JLabel("Asansor 5 durum : " + false);
    JLabel floor = new JLabel("Bulunduğu kat : " + 0);
    JLabel floor1 = new JLabel("Bulunduğu kat : " + 0);
    JLabel floor2 = new JLabel("Bulunduğu kat : " + 0);
    JLabel floor3 = new JLabel("Bulunduğu kat : " + 0);
    JLabel floor4 = new JLabel("Bulunduğu kat : " + 0);
    JLabel dest = new JLabel("Hedef Kat : " + 0);
    JLabel dest1 = new JLabel("Hedef Kat : " + 0);
    JLabel dest2 = new JLabel("Hedef Kat : " + 0);
    JLabel dest3 = new JLabel("Hedef Kat : " + 0);
    JLabel dest4 = new JLabel("Hedef Kat : " + 0);
    JLabel yon = new JLabel("Yön : ");
    JLabel yon1 = new JLabel("Yön : ");
    JLabel yon2 = new JLabel("Yön : ");
    JLabel yon3 = new JLabel("Yön : ");
    JLabel yon4 = new JLabel("Yön : ");
    JLabel kapasite = new JLabel("Max. kapasite : " + 10);
    JLabel kapasite1 = new JLabel("Max. kapasite : " + 10);
    JLabel kapasite2 = new JLabel("Max. kapasite : " + 10);
    JLabel kapasite3 = new JLabel("Max. kapasite : " + 10);
    JLabel kapasite4 = new JLabel("Max. kapasite : " + 10);
    JLabel icerde = new JLabel("Asansördeki insan : " + 0);
    JLabel icerde1 = new JLabel("Asansördeki insan : " + 0);
    JLabel icerde2 = new JLabel("Asansördeki insan : " + 0);
    JLabel icerde3 = new JLabel("Asansördeki insan : " + 0);
    JLabel icerde4 = new JLabel("Asansördeki insan : " + 0);
    JLabel ic_kuyruk = new JLabel("Kuyruk : ");
    JLabel ic_kuyruk1 = new JLabel("Kuyruk : ");
    JLabel ic_kuyruk2 = new JLabel("Kuyruk : ");
    JLabel ic_kuyruk3 = new JLabel("Kuyruk : ");
    JLabel ic_kuyruk4 = new JLabel("Kuyruk : ");
    JLabel mode = new JLabel("mod : " + "idle");
    JLabel mode1 = new JLabel("mod : " + "idle");
    JLabel mode2 = new JLabel("mod : " + "idle");
    JLabel mode3 = new JLabel("mod : " + "idle");
    JLabel mode4 = new JLabel("mod : " + "idle");
    JLabel katbilgi = new JLabel("0.Kat : ");
    JLabel katbilgi1 = new JLabel("1.Kat : ");
    JLabel katbilgi2 = new JLabel("2.Kat : ");
    JLabel katbilgi3 = new JLabel("3.Kat : ");
    JLabel katbilgi4 = new JLabel("4.Kat : ");
    static Kat_Yonetici kat_yonetici;
    static Ciz canvas;
    static Asansor_Thread[] asansorler;

    public synchronized void araYuz() {
        int bosluk = 25;
        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(650, 1000);
        frame.setTitle("Asansor Uygulaması");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        menu.setLayout(null);
        menu.setSize(650, 1000);
        menu.setBackground(java.awt.Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        kisi_sayisi.setBounds(10, 10, 170, 25);
        menu.add(kisi_sayisi);
        kuyruk_sayisi.setBounds(200, 10, 170, 25);
        menu.add(kuyruk_sayisi);
        bosluk += 10;

        kisi_sayisi1.setBounds(10, 35, 150, 25);
        menu.add(kisi_sayisi1);
        kuyruk_sayisi1.setBounds(200, 35, 170, 25);
        menu.add(kuyruk_sayisi1);
        bosluk += 25;

        kisi_sayisi2.setBounds(10, 60, 150, 25);
        menu.add(kisi_sayisi2);
        kuyruk_sayisi2.setBounds(200, 60, 170, 25);
        menu.add(kuyruk_sayisi2);
        bosluk += 25;

        kisi_sayisi3.setBounds(10, 85, 150, 25);
        menu.add(kisi_sayisi3);
        kuyruk_sayisi3.setBounds(200, 85, 170, 25);
        menu.add(kuyruk_sayisi3);
        bosluk += 25;

        kisi_sayisi4.setBounds(10, 110, 150, 25);
        menu.add(kisi_sayisi4);
        kuyruk_sayisi4.setBounds(200, 110, 170, 25);
        menu.add(kuyruk_sayisi4);
        bosluk += 40;

        cikis_kuyruk.setBounds(10, 150, 150, 25);
        menu.add(cikis_kuyruk);
        frame.getContentPane().add(menu);
        bosluk += 60;

        durum.setBounds(10, bosluk, 150, 25);
        menu.add(durum);

        durum2.setBounds(250, bosluk, 150, 25);
        menu.add(durum2);
        bosluk += 25;

        mode.setBounds(10, bosluk, 150, 25);
        menu.add(mode);

        mode1.setBounds(250, bosluk, 150, 25);
        menu.add(mode1);
        bosluk += 25;

        floor.setBounds(10, bosluk, 150, 25);
        menu.add(floor);
        floor1.setBounds(250, bosluk, 150, 25);
        menu.add(floor1);
        bosluk += 25;

        dest.setBounds(10, bosluk, 150, 25);
        menu.add(dest);
        dest1.setBounds(250, bosluk, 150, 25);
        menu.add(dest1);
        bosluk += 25;

        yon.setBounds(10, bosluk, 150, 25);
        menu.add(yon);
        yon1.setBounds(250, bosluk, 150, 25);
        menu.add(yon1);
        bosluk += 25;

        kapasite.setBounds(10, bosluk, 150, 25);
        menu.add(kapasite);
        kapasite1.setBounds(250, bosluk, 150, 25);
        menu.add(kapasite1);
        bosluk += 25;

        icerde.setBounds(10, bosluk, 150, 25);
        menu.add(icerde);
        icerde1.setBounds(250, bosluk, 150, 25);
        menu.add(icerde1);
        bosluk += 25;

        ic_kuyruk.setBounds(10, bosluk, 150, 25);
        menu.add(ic_kuyruk);

        ic_kuyruk1.setBounds(250, bosluk, 150, 25);
        menu.add(ic_kuyruk1);
        bosluk += 50;

        durum3.setBounds(10, bosluk, 150, 25);
        menu.add(durum3);

        durum4.setBounds(250, bosluk, 150, 25);
        menu.add(durum4);
        durum5.setBounds(450, bosluk, 150, 25);
        menu.add(durum5);
        bosluk += 25;

        mode2.setBounds(10, bosluk, 150, 25);
        menu.add(mode2);

        mode3.setBounds(250, bosluk, 150, 25);
        menu.add(mode3);

        mode4.setBounds(450, bosluk, 150, 25);
        menu.add(mode4);
        bosluk += 25;

        floor2.setBounds(10, bosluk, 150, 25);
        menu.add(floor2);
        floor3.setBounds(250, bosluk, 150, 25);
        menu.add(floor3);
        floor4.setBounds(450, bosluk, 150, 25);
        menu.add(floor4);
        bosluk += 25;

        dest2.setBounds(10, bosluk, 150, 25);
        menu.add(dest2);
        dest3.setBounds(250, bosluk, 150, 25);
        menu.add(dest3);
        dest4.setBounds(450, bosluk, 150, 25);
        menu.add(dest4);
        bosluk += 25;

        yon2.setBounds(10, bosluk, 150, 25);
        menu.add(yon2);
        yon3.setBounds(250, bosluk, 150, 25);
        menu.add(yon3);
        yon4.setBounds(450, bosluk, 150, 25);
        menu.add(yon4);
        bosluk += 25;

        kapasite2.setBounds(10, bosluk, 150, 25);
        menu.add(kapasite2);
        kapasite3.setBounds(250, bosluk, 150, 25);
        menu.add(kapasite3);
        kapasite4.setBounds(450, bosluk, 150, 25);
        menu.add(kapasite4);
        bosluk += 25;

        icerde2.setBounds(10, bosluk, 150, 25);
        menu.add(icerde2);
        icerde3.setBounds(250, bosluk, 150, 25);
        menu.add(icerde3);
        icerde4.setBounds(450, bosluk, 150, 25);
        menu.add(icerde4);
        bosluk += 25;

        ic_kuyruk2.setBounds(10, bosluk, 150, 25);
        menu.add(ic_kuyruk2);

        ic_kuyruk3.setBounds(250, bosluk, 150, 25);
        menu.add(ic_kuyruk3);

        ic_kuyruk4.setBounds(450, bosluk, 150, 25);
        menu.add(ic_kuyruk4);
        bosluk += 100;

        katbilgi.setBounds(10, bosluk, 500, 25);
        menu.add(katbilgi);
        bosluk += 40;

        katbilgi1.setBounds(10, bosluk, 500, 25);
        menu.add(katbilgi1);
        bosluk += 40;

        katbilgi2.setBounds(10, bosluk, 500, 25);
        menu.add(katbilgi2);
        bosluk += 40;

        katbilgi3.setBounds(10, bosluk, 500, 25);
        menu.add(katbilgi3);
        bosluk += 40;

        katbilgi4.setBounds(10, bosluk, 500, 25);
        menu.add(katbilgi4);
        bosluk += 40;

        canvas = new Ciz();
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
    }

    class Ciz extends JPanel {

        @Override
        public synchronized void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }

    public synchronized void Guncelle() {

        kisi_sayisi.setText("0.kattaki kişi sayisi : " + kat_yonetici.getKat_bilgi()[0].getKatta_bulunan_kisi());
        kisi_sayisi1.setText("1.kattaki kişi sayisi : " + kat_yonetici.getKat_bilgi()[1].getKatta_bulunan_kisi());
        kisi_sayisi2.setText("2.kattaki kişi sayisi : " + kat_yonetici.getKat_bilgi()[2].getKatta_bulunan_kisi());
        kisi_sayisi3.setText("3.kattaki kişi sayisi : " + kat_yonetici.getKat_bilgi()[3].getKatta_bulunan_kisi());
        kisi_sayisi4.setText("4.kattaki kişi sayisi : " + kat_yonetici.getKat_bilgi()[4].getKatta_bulunan_kisi());

        kuyruk_sayisi.setText("0.kattaki kuyruk sayisi : " + kat_yonetici.getKat_bilgi()[0].getKuyruk_sayisi());
        kuyruk_sayisi1.setText("1.kattaki kuyruk sayisi : " + kat_yonetici.getKat_bilgi()[1].getKuyruk_sayisi());
        kuyruk_sayisi2.setText("2.kattaki kuyruk sayisi : " + kat_yonetici.getKat_bilgi()[2].getKuyruk_sayisi());
        kuyruk_sayisi3.setText("3.kattaki kuyruk sayisi : " + kat_yonetici.getKat_bilgi()[3].getKuyruk_sayisi());
        kuyruk_sayisi4.setText("4.kattaki kuyruk sayisi : " + kat_yonetici.getKat_bilgi()[4].getKuyruk_sayisi());
        
        cikis_kuyruk.setText("Cikis yapan kisiler : " + kat_yonetici.getCikis_yapan());
        
        durum.setText("Asansor 1 durum : " + asansorler[0].isAsansor_durum());
        durum2.setText("Asansor 2 durum : " + asansorler[1].isAsansor_durum());
        durum3.setText("Asansor 3 durum : " + asansorler[2].isAsansor_durum());
        durum4.setText("Asansor 4 durum : " + asansorler[3].isAsansor_durum());
        durum5.setText("Asansor 5 durum : " + asansorler[4].isAsansor_durum());
        
        floor.setText("Bulunduğu kat : " + asansorler[0].getBulundugu_kat());
        floor1.setText("Bulunduğu kat : " + asansorler[1].getBulundugu_kat());
        floor2.setText("Bulunduğu kat : " + asansorler[2].getBulundugu_kat());
        floor3.setText("Bulunduğu kat : " + asansorler[3].getBulundugu_kat());
        floor4.setText("Bulunduğu kat : " + asansorler[4].getBulundugu_kat());

        dest.setText("Hedef Kat : " + asansorler[0].getHedef_kat());
        dest1.setText("Hedef Kat : " + asansorler[1].getHedef_kat());
        dest2.setText("Hedef Kat : " + asansorler[2].getHedef_kat());
        dest3.setText("Hedef Kat : " + asansorler[3].getHedef_kat());
        dest4.setText("Hedef Kat : " + asansorler[4].getHedef_kat());

        yon.setText("Yön : " + asansorler[0].getYon());
        yon1.setText("Yön : " + asansorler[1].getYon());
        yon2.setText("Yön : " + asansorler[2].getYon());
        yon3.setText("Yön : " + asansorler[3].getYon());
        yon4.setText("Yön : " + asansorler[4].getYon());

        icerde.setText("Asansördeki insan : " + asansorler[0].getYolcu_sayisi());
        icerde1.setText("Asansördeki insan : " + asansorler[1].getYolcu_sayisi());
        icerde2.setText("Asansördeki insan : " + asansorler[2].getYolcu_sayisi());
        icerde3.setText("Asansördeki insan : " + asansorler[3].getYolcu_sayisi());
        icerde4.setText("Asansördeki insan : " + asansorler[4].getYolcu_sayisi());

        mode.setText("mod : " + asansorler[0].getAsansor_mod());
        mode1.setText("mod : " + asansorler[1].getAsansor_mod());
        mode2.setText("mod : " + asansorler[2].getAsansor_mod());
        mode3.setText("mod : " + asansorler[3].getAsansor_mod());
        mode4.setText("mod : " + asansorler[4].getAsansor_mod());

        ic_kuyruk.setText("Kuyruk : " + asansorler[0]);
        ic_kuyruk1.setText("Kuyruk : " + asansorler[1]);
        ic_kuyruk2.setText("Kuyruk : " + asansorler[2]);
        ic_kuyruk3.setText("Kuyruk : " + asansorler[3]);
        ic_kuyruk4.setText("Kuyruk : " + asansorler[4]);

        katbilgi.setText("0.Kat : " + kat_yonetici.getKat_bilgi()[0].toString());
        katbilgi1.setText("1.Kat : " + kat_yonetici.getKat_bilgi()[1].toString());
        katbilgi2.setText("2.Kat : " + kat_yonetici.getKat_bilgi()[2].toString());
        katbilgi3.setText("3.Kat : " + kat_yonetici.getKat_bilgi()[3].toString());
        katbilgi4.setText("4.Kat : " + kat_yonetici.getKat_bilgi()[4].toString());

        canvas.repaint();
    }

    public static void main(String[] args) {
        Basla run = new Basla();
        ArrayList<Asansor_kuyruk>[] kat_bilgi = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            kat_bilgi[i] = new ArrayList<Asansor_kuyruk>();
        }
        Zaman zaman = new Zaman();
        kat_yonetici = new Kat_Yonetici(zaman);
        Thread[] threads = new Thread[5];
        asansorler = new Asansor_Thread[5];

        for (int i = 0; i < 5; i++) {
            Asansor_Thread asansor = new Asansor_Thread(i, kat_yonetici, zaman);
            threads[i] = new Thread(asansor);
            asansorler[i] = asansor;
        }
        kat_yonetici.asansor_al(asansorler);
        Thread th3 = new Thread(new Kontrol_Thread(zaman, kat_yonetici, threads, asansorler));
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                asansorler[i].setAsansor_mod("Working");
                asansorler[i].setKontrol_asansor(true);
            } else {
                asansorler[i].setAsansor_mod("idle");
                asansorler[i].setKontrol_asansor(false);
            }
            threads[i].start();
        }

        Thread th1 = new Thread(new Giris_Thread(zaman, kat_yonetici, kat_bilgi));
        th1.start();
        Thread th2 = new Thread(new Cikis_Thread(zaman, kat_yonetici, kat_bilgi));
        th2.start();

        th3.start();
        run.araYuz();

        while (true) {
          
       
            run.Guncelle();
            try {

                TimeUnit.MILLISECONDS.sleep(1);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            zaman.zamanArttir();

        }

    }
}
