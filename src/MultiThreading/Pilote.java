package MultiThreading;

public class Pilote extends Thread {
    private int NB_CYCLE = 3;
    private Zone zoneCourante;
    private Zone zoneDestination;
    private Requin requin;


    public Pilote(Zone zone){

        zoneCourante = zone;

    }

    public void attacherRequin() {
/*
        while (zoneCourante.occuper() == null) { // tant que y'a pas de Requin
           *//* try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
        }*/
        requin = zoneCourante.occuper();
        if (requin !=null)
         this.requin.attacher();
    }

    public void deplacer() {
        if (requin !=null) {
            this.zoneDestination = requin.zoneDestination;
            this.zoneCourante = this.zoneDestination;
            this.zoneDestination = null;
        }
    }

    public void detacherRequin() {
       /* while (requin.mouvement = true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        if (requin !=null) {
            this.requin.detacher();
        }

    }

    public void run() {
        System.out.println("Le poisson pilote "+Thread.currentThread().getName()+" est dans la zone "+"("+zoneCourante.x+","+zoneCourante.y+")");
        for (int i=0; i< NB_CYCLE; i++) {
            attacherRequin();
            deplacer();
            detacherRequin();
        }
    }
}
