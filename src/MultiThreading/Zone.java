package MultiThreading;

import java.util.List;

public class Zone {

    static final int NB_POISSON_PILOTE = 10;
    static final int NB_SARDINE = 25;

    private List<String> liste;

    private int nb_poi_pil;
    private int nb_sardines;
    private Requin requinPresent;
    public int x;
    public int y;

    public Zone(int x, int y) {
        this.x = x;
        this.y = y;
        this.nb_poi_pil = NB_POISSON_PILOTE;
        this.nb_sardines = NB_SARDINE;
    }

    public synchronized void mangerPoisson() {

        if (this.nb_sardines <= 10){
            this.nb_sardines = 0;
        }else {
            this.nb_sardines -=10;
        }

        System.out.println("Le nombre de sardine dans la zone ("+x+","+y+") est = " +nb_sardines);
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
        System.out.println("Le requin "+ Thread.currentThread().getName() + " entre en zone ("+x+","+y+")");
    }

    public synchronized void sortir(){

        this.requinPresent = null;
        notifyAll();

        System.out.println("Le requin sort "+ Thread.currentThread().getName() + " sort en zone ("+x+","+y+")");
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
