import java.time.*;
import java.time.temporal.*;

class WorkingDays {
    public static long count(final LocalDate start, final LocalDate end) {

        LocalDate firstMonday = start.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        LocalDate lastFriday = end.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));

        long days = firstMonday.until(lastFriday, ChronoUnit.DAYS) + 1;

        return (days + 2) * 5 / 7;
    }
}
