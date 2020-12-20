package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Requin extends Thread{

    private int NB_CYCLE = 10;
    private int NB_PILOTES;
    private Zone zoneActuelle;
    public Zone zoneDestination;
    public static final int P = 5;

    int nb_pilotes_attaches = 0;
    boolean dispo = false;
    boolean mouvement = false;

    public Requin(Zone zone) {
        this.NB_PILOTES = 5;
        this.zoneActuelle = zone;
    }

    public void sortir() {
        this.zoneActuelle.sortir();

    }

    public void choisirDestination(){


        int x = zoneActuelle.getX();
        int y = zoneActuelle.getY();

        Zone zoneLeft = Ocean.getZoneLeft(x,y);
        Zone zoneRigth = Ocean.getZoneRigth(x,y);
        Zone zoneUp = Ocean.getZoneUp(x,y);
        Zone zoneDown = Ocean.getZoneDown(x,y);

        List<Zone> listeDestionations = new ArrayList<>();
        listeDestionations.add(zoneLeft);
        listeDestionations.add(zoneRigth);
        listeDestionations.add(zoneUp);
        listeDestionations.add(zoneDown);

        int choix = new Random().nextInt(4);

        this.zoneDestination = listeDestionations.get(choix);
        this.mouvement = true;
        this.zoneActuelle = null;
    }

    public synchronized void entrer(){
        this.zoneDestination.entrer(this);
        this.zoneActuelle = zoneDestination;
        this.zoneDestination = null;
        this.mouvement = false;

        notifyAll();
    }


    public void manger() {
        this.dispo = true;
        this.zoneActuelle.mangerPoisson();
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){e.printStackTrace();}
        this.dispo = false;
    }

    public synchronized void attacher() {
        while (nb_pilotes_attaches > P || !dispo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nb_pilotes_attaches++;
    }


    public synchronized void detacher() {
        nb_pilotes_attaches--;
    }

    public void run() {

        for (int i=0; i< NB_CYCLE; i++) {
            sortir();
            choisirDestination();
            entrer();
            manger();
        }
    }
}
