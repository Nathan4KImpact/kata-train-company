package ing.bnp.traincompany.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyTaps {
    private transient LocalDate  date;
    private List<Tap> taps;

    public DailyTaps(){
        date = LocalDate.now();
        taps = new ArrayList<>();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Tap> getTaps() {
        return taps;
    }

    @Override
    public String toString() {
        return "DailyTaps{" +
                "date=" + date +
                ", taps=" + taps +
                '}';
    }
}
