import java.util.Date;

public class RacePerformance {

    private Date time;
    private Date fastestLap;

    public RacePerformance(Date time, Date fastestLap) {
        this.time = time;
        this.fastestLap = fastestLap;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(Date fastestLap) {
        this.fastestLap = fastestLap;
    }

    @Override
    public String toString() {
        return "RacePerformance{" +
                "time=" + time +
                ", fastestLap=" + fastestLap +
                '}';
    }
}
