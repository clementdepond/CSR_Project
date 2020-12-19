package MultiThreading;

public class Ocean {

    public static final int N = 4;

    public static Zone zone[][] = new Zone[N][N];

    public Ocean(int NB_ZONE) {
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                zone[i][j] = new Zone(i,j);
            }
        }
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
}
