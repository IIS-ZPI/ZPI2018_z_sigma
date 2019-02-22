import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PeriodOftime {

    private String endDate, startDate;

    public String getEndDate() {
        return endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void oneWeek(Calendar calendar){

        startDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        endDate = dateFormat.format(calendar.getTime());
    }

    public void twoWeek(Calendar calendar){

        startDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, -14);
        endDate = dateFormat.format(calendar.getTime());
    }

    public void oneMonth(Calendar calendar){

        startDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH, -1);
        endDate = dateFormat.format(calendar.getTime());
    }

    public void quarter(Calendar calendar){

        startDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH, -3);
        endDate = dateFormat.format(calendar.getTime());
    }

    public void halfYear(Calendar calendar){

        startDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH, -6);
        endDate = dateFormat.format(calendar.getTime());
    }

    public void Year(Calendar calendar){

        startDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH, -12);
        endDate = dateFormat.format(calendar.getTime());
    }





}

