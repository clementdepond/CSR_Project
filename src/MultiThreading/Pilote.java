package MultiThreading;

public class Pilote extends Thread {
    private int NB_CYCLE = 8;
    private Zone zoneCourante;
    private Zone zoneDestination;
    private Requin requin;

    public void attacherRequin() {
        while (requin.dispo = false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.requin.attacher();
    }

    public void deplacer() {
        this.zoneDestination = requin.zoneDestination;
        this.zoneCourante = this.zoneDestination;
        this.zoneDestination = null;
    }

    public void detacherRequin() {
        while (requin.mouvement = true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.requin.detacher();
    }

    public void run() {
        for (int i=0; i< NB_CYCLE; i++) {
            attacherRequin();
            deplacer();
            detacherRequin();
        }
    }
}
