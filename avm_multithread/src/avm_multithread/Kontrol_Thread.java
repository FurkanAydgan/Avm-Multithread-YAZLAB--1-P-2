
package avm_multithread;


public class Kontrol_Thread implements Runnable {

    Kat_Yonetici kat_yonetici;
    Zaman time;
    int zaman = 0;
    int h;
    int sum = 0, kuyruk = 0;
    Thread[] asansor;
    int temp = 0, sayac = 0, sayi = 0, sayi2 = 0, sayi3 = 0, kontrol = 0, deneme, sayac3 = 0, kontrol2 = 0;
    Asansor_Thread[] asansorler;
    int[] kat;

    public Kontrol_Thread(Zaman time, Kat_Yonetici kat_yonetici, Thread[] asansor, Asansor_Thread[] asansorler) {
        this.kat_yonetici = kat_yonetici;
        this.time = time;
        this.asansor = asansor;
        this.asansorler = asansorler;
        kat = new int[5];
    }

    public synchronized void Asansor_kontrol() {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < this.kat_yonetici.getKat_bilgi()[i].getKuyruk().size(); j++) {

                try {
                    this.sum += this.kat_yonetici.getKat_bilgi()[i].getKuyruk().get(j).getYolcu_sayisi();
                    this.kuyruk += this.kat_yonetici.getKat_bilgi()[i].getKuyruk().get(j).getYolcu_sayisi();
                } catch (IndexOutOfBoundsException e) {
                } catch (NullPointerException ex) {
                }

            }

            kat_yonetici.getKat_bilgi()[i].setKuyruk_sayisi(this.kuyruk);
            this.kuyruk = 0;

        }

        deneme = this.sum;
        temp = sum / 20;
        if (sum >= 80) {
            temp = 4;

        }
        this.sum = 0;
        if (temp - sayi3 > 0) {
            while (sayi2 < temp) {

                while (true) {
                    if (asansorler[sayi % 5].isKontrol_asansor() == false && asansorler[sayi % 5].isAsansor_durum() == false) {
                        sayac++;
                        asansorler[sayi % 5].setKontrol_asansor(true);
                        asansorler[sayi % 5].setAsansor_mod("working");
                        asansorler[sayi % 5].setAsansor_durum(true);
                        sayi3 = temp;
                        break;
                    }
                    sayi++;
                }
                sayi2++;
                sayi = 0;
            }
        } else {

            int degs = sayi3;
            int tut = temp;
            if (tut - degs < 0) {
                while (tut < degs) {
                    while (true) {

                        if (asansorler[sayi % 5].isKontrol_asansor() == false && asansorler[sayi % 5].isAsansor_durum() == true) {
                            sayac++;
                            asansorler[sayi % 5].setKontrol_asansor(false);
                            asansorler[sayi % 5].setAsansor_mod("idle");
                            asansorler[sayi % 5].setAsansor_durum(false);
                            sayi3 = temp;
                            break;
                        }

                        sayi++;
                    }
                    sayi = 0;
                    degs--;
                }
                sayi2 = temp;
            } else {
                for (int i = 4; i >= 1; i--) {
                    if (asansorler[i].isKontrol_asansor() == false && asansorler[i].isAsansor_durum() == true) {
                        for (int m = 0; m < 5; m++) {

                            for (int j = 0; j < this.kat_yonetici.getKat_bilgi()[m].getKuyruk().size(); j++) {
                                this.sum += this.kat_yonetici.getKat_bilgi()[m].getKuyruk().get(j).getYolcu_sayisi();
                                this.kuyruk += this.kat_yonetici.getKat_bilgi()[m].getKuyruk().get(j).getYolcu_sayisi();
                            }

                            kat_yonetici.getKat_bilgi()[i].setKuyruk_sayisi(this.kuyruk);
                            this.kuyruk = 0;

                        }
                        temp = this.sum / 20;
                        if (this.sum >= 80) {
                            temp = 4;
                        }

                        if (this.sum >= 20) {
                            if (temp - sayi3 >= 0) {
                                asansorler[i].setKontrol_asansor(true);
                                asansorler[i].setAsansor_mod("Working");
                                kontrol = 1;
                            }
                        }
                        if (kontrol != 1) {
                            if (temp - sayi3 < 0) {

                                asansorler[i].setAsansor_durum(false);
                                asansorler[i].setAsansor_mod("idle");
                                if (temp == 0) {
                                    sayi2 = 0;
                                }
                                if (temp == 1) {
                                    sayi2 = 1;
                                }
                                if (temp == 2) {
                                    sayi2 = 2;
                                }
                                if (temp == 3) {
                                    sayi2 = 3;
                                }
                                if (temp == 4) {
                                    sayi2 = 4;
                                }
                                sayi3 = temp;
                            }
                        }
                        kontrol = 0;
                    }
                }
            }

        }

        sayac = 0;
        sayi = 0;

    }

    @Override
    public void run() {
        while (true) {

            try {

                Asansor_kontrol();

                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

}
