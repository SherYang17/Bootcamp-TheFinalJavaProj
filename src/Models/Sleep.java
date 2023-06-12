package Models;
import java.util.Date;

public class Sleep {
    private Date sleep;
    private Date awake;


    public Sleep(Date sleep, Date awake) {
        this.sleep = sleep;
        this.awake = awake;
    }

    public Sleep() {
        this.sleep = null;
        this.awake = null;
    }


    public Date getSleep() {
        return sleep;
    }

    public void setsleep(Date sleep) {
        this.sleep = sleep;
    }

    public Date getawake() {
        return awake;
    }

    public void setawake(Date awake) {
        this.awake = awake;
    }

    public boolean hasValidSleepAndAwake() {
        return sleep != null && awake != null && awake.after(sleep);
    }

    public double getTotalSleepHours() {
        if (hasValidSleepAndAwake()) {
            long sleepDurationInMillis = getawake().getTime() - getSleep().getTime();
            return sleepDurationInMillis / (1000.0 * 60.0 * 60.0);
        } else {
            return 0;
        }
    }
}