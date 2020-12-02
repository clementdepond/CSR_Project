public class Zone {
    static final int NB_POISSON_PILOTE = 10;
    static final int NB_SARDINE = 25;

    private int nb_poi_pil;
    private int nb_poi;

    public Zone(int i, int j) {
        this.nb_poi_pil = NB_POISSON_PILOTE;
        this.nb_poi = NB_SARDINE;
    }

    public void mangerPoisson() {
        nb_poi = 0;
    }
}
