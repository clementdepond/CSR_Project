package MultiThreading;

import java.util.List;

public class Zone {

    static final int NB_POISSON_PILOTE = 10;
    static final int NB_SARDINE = 25;

    private List<String> liste;

    private int nb_poi_pil;
    private int nb_sardines;
    private Requin requinPresent;
    private int x;
    private int y;

    public Zone(int x, int y) {
        this.x = x;
        this.y = y;
        this.nb_poi_pil = NB_POISSON_PILOTE;
        this.nb_sardines = NB_SARDINE;
    }

    public synchronized void mangerPoisson() {

        if (this.nb_sardines <= 2){
            this.nb_sardines = 0;
        }else {
            this.nb_sardines -=2;
        }
    }


    public synchronized void entrer(Requin requin){

        while (this.requinPresent != null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.requinPresent = requin;
    }

    public synchronized void sortir(){

        this.requinPresent = null;
        notifyAll();
    }

    public Requin occuper(){

        return this.requinPresent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
