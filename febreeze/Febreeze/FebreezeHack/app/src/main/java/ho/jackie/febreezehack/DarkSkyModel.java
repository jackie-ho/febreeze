package ho.jackie.febreezehack;

/**
 * Created by JH on 3/4/17.
 */

public class DarkSkyModel {
    String timezone;
    Weather currently;
    int offset;

    public int getOffset() {
        return offset;
    }

    public String getTimezone() {
        return timezone;
    }

    public Weather getCurrently() {
        return currently;
    }
}
