package org.inria.restlet.mta.database.api;

import org.inria.restlet.mta.internals.MultiThreading.Requin;
import org.inria.restlet.mta.internals.MultiThreading.Zone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Ocean {

    public static final int N = 4;

    public static Zone zone[][] = new Zone[N][N];

    Collection<Zone> zones_ = new ArrayList<Zone>();

    private static Requin[] requins = new Requin[2];
    private List<Requin> requinList = new ArrayList<Requin>();


    public Ocean() {
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                zone[i][j] = new Zone(i,j);
                zones_.add(zone[i][j]);
            }
        }
    }

    public Collection<Zone> getZones() {
        return this.zones_;
    }

    public int getSardines() {
        int nbSardines = 0;
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                nbSardines += zone[i][j].getNbSardine();
            }
        }

        return nbSardines;
    }

    public void creerRequin(){

        requins[0] = new Requin(this.zone[3][3]);
        requins[0].start();

        requinList.add(requins[0]);

        requins[1] = new Requin(this.zone[1][2]);
        requins[1].start();

        requinList.add(requins[1]);
    }

    public Requin createRequin(){
        int x = new Random().nextInt(N);
        int y = new Random().nextInt(N);

         //requin = null;
        //if (zone[x][y].occuper() != null) {
        Requin requin = new Requin(zone[x][y]);
        //}
        requinList.add(requin);

        return requin;
    }

    public int getRequins() {
        return requinList.size();
    }

    public Requin getRequin(int idRequin) {
        return requins[idRequin];
    }

    public void creerPilote(){


    }

    /**
     * G (x,y) = > (x,y-1)
     * D (x,y) => (x,y+1)
     * H (x,y) = (x-1,y)
     * B (x,y) => (x+1,y)
     */
    public static Zone getZoneLeft(int x, int y){

        int posY;

        if (y ==0){
            posY = N -1;
        }else {
            posY = y-1;
        }

        return zone[x][posY];

    }
    public static Zone getZoneRigth(int x, int y){

        int posY;

        if (y == N-1){
            posY = 0;
        }else {
            posY = y+1;
        }

        return zone[x][posY];
    }
    public static Zone getZoneUp(int x, int y){
        int posX;

        if (x ==0){
            posX = N -1;
        }else {
            posX = x-1;
        }

        return zone[posX][y];

    }
    public static Zone getZoneDown(int x, int y){

        int posX;

        if (x == N-1){
            posX = 0;
        }else {
            posX = x+1;
        }

        return zone[posX][y];
    }

    public static void main(String[] args) {

        Ocean ocean = new Ocean();
        ocean.creerRequin();
    }
}
