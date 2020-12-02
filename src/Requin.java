public class Requin {
    private int NB_CYCLE;
    private int NB_PILOTES;
    private Zone depart;
    private Zone arrivee;

    public Requin(Zone dep, Zone arr) {
        this.NB_CYCLE = 10;
        this.NB_PILOTES = 5;
        this.depart = dep;
        this.arrivee = arr;
    }

    private void seDeplacer() {
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){e.printStackTrace();}
    }

    public void manger() {
       this.arrivee.mangerPoisson();
    }

    public void run() {
        seDeplacer();
        manger();
    }
}
