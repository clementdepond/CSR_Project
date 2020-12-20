package MultiThreading;

public class Ocean {

    public static final int N = 4;

    public static Zone zone[][] = new Zone[N][N];

    private static Requin[] requins = new Requin[2];
   // private static Pilote[] requins = new Requin[2];


    public Ocean() {
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                zone[i][j] = new Zone(i,j);
            }
        }
    }

    public void creerRequin(){

        requins[0] = new Requin(zone[3][3]);
        requins[0].start();

        requins[1] = new Requin(zone[1][2]);
        requins[1].start();
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
