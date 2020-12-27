
package avm_multithread;


public class Zaman {
    private static int zaman;
    public Zaman()
    {
        this.zaman=0;
    }
    public synchronized void zamanArttir()
    {
        this.zaman++;
    }

    public synchronized int getZaman() {
        return zaman;
    }
    
}
