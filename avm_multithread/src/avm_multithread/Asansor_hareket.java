
package avm_multithread;


public class Asansor_hareket {
    private int varacagi_kat;
    private int varis_suresi;
    public Asansor_hareket()
    {
        int varacagi_kat=0;
        int varis_suresi=0;
    }
    public Asansor_hareket(int varacagi_kat,int varis_suresi)
    {
        this.varacagi_kat=varacagi_kat;
        this.varis_suresi=varis_suresi;
    }

    public int getVaracagi_kat() {
        return varacagi_kat;
    }

    public int getVaris_suresi() {
        return varis_suresi;
    }
    
}
