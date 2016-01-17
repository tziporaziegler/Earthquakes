package earthquakes.ziegler.zieglerearthquakes;

public class Properties {
    private String place;
    private String mag;

    public String getPlace() {
        return place;
    }

    public String getMag() {
        return mag;
    }

    public String toString(){
        return place + " " + mag;
    }
}
