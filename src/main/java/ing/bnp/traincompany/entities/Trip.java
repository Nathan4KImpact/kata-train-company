package ing.bnp.traincompany.entities;

import java.math.BigDecimal;

public class Trip {
    private Customer customer;
    private Character stationStart;
    private Character stationEnd;
    private int startedJourneyAt;
    private BigDecimal costInCents;
    private int zoneFrom;
    private int zoneTo;

    public Trip(Character stationStart, Character stationEnd, int startedJourneyAt, BigDecimal costInCents, int zoneFrom, int zoneTo) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.startedJourneyAt = startedJourneyAt;
        this.costInCents = costInCents;
        this.zoneFrom = zoneFrom;
        this.zoneTo = zoneTo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Character getStationStart() {
        return stationStart;
    }

    public void setStationStart(Character stationStart) {
        this.stationStart = stationStart;
    }

    public Character getStationEnd() {
        return stationEnd;
    }

    public void setStationEnd(Character stationEnd) {
        this.stationEnd = stationEnd;
    }

    public int getStartedJourneyAt() {
        return startedJourneyAt;
    }

    public void setStartedJourneyAt(int startedJourneyAt) {
        this.startedJourneyAt = startedJourneyAt;
    }

    public BigDecimal getCostInCents() {
        return costInCents;
    }

    public void setCostInCents(BigDecimal costInCents) {
        this.costInCents = costInCents;
    }

    public int getZoneFrom() {
        return zoneFrom;
    }

    public void setZoneFrom(int zoneFrom) {
        this.zoneFrom = zoneFrom;
    }

    public int getZoneTo() {
        return zoneTo;
    }

    public void setZoneTo(int zoneTo) {
        this.zoneTo = zoneTo;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "stationStart=" + stationStart +
                ", stationEnd=" + stationEnd +
                ", startedJourneyAt=" + startedJourneyAt +
                ", costInCents=" + costInCents +
                ", zoneFrom=" + zoneFrom +
                ", zoneTo=" + zoneTo +
                '}';
    }
}
