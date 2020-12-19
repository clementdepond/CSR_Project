package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Requin extends Thread{

    private int NB_CYCLE = 10;
    private int NB_PILOTES;
    private Zone zoneActuelle;
    private Zone zoneDestination;

    public Requin(Zone zone) {
        this.NB_PILOTES = 5;
        this.zoneActuelle = zone;
    }

    public void sortir() {
        this.zoneActuelle.sortir();
        this.zoneActuelle = null;
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



    }

    public void entrer(){
        this.zoneDestination.entrer(this);
        this.zoneActuelle = zoneDestination;
        this.zoneDestination = null;
    }

    public void manger() {
        this.zoneActuelle.mangerPoisson();
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){e.printStackTrace();}
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
