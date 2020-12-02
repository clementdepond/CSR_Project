public class Ocean {

    public Zone zone[][] = new Zone[4][4];

    public Ocean(int NB_ZONE) {
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 4; j++) {
                this.zone[i][j] = new Zone(i,j);
            }
        }
    }

    
}
