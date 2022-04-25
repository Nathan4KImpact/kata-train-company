package ing.bnp.traincompany.entities;

import java.util.Date;

public class Tap {
    private int unixTimestamp;
    private int customerId;
    private transient Date tripDate;
    private Character station;

    public int getUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(int unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Character getStation() {
        return station;
    }

    public void setStation(Character station) {
        this.station = station;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    @Override
    public String toString() {
        return "Tap{" +
                "unixTimestamp=" + unixTimestamp +
                ", customerId=" + customerId +
                ", tripDate=" + tripDate +
                ", station=" + station +
                '}';
    }
}
