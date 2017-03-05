package ho.jackie.febreezehack;

/**
 * Created by JH on 3/4/17.
 */

public class Location {
    Bounds geometry;
    String formatted_address;

    public Bounds getGeometry() {
        return geometry;
    }

    public String getFormatted_address() {
        return formatted_address;
    }
}
