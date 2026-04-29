package pro1.reports.report3;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report3.reportDataModel.DayStats;

import java.util.ArrayList;
import java.util.List;

public class DepartmentWeekdaysReporting {


    public static List<DayStats> GetReport(DataSource dataSource, String rok, String katedra, String[] days) {
        var actionsJson = dataSource.getRozvrhByKatedra(rok, katedra);
        var actionsList = new Gson().fromJson(actionsJson, ActionsList.class);

        List<DayStats> report = new ArrayList<>();

        if (actionsList == null || actionsList.items == null) {
            return report;
        }

        for (String day : days) {
            long count = actionsList.items.stream()
                    .filter(a -> day.equals(a.dayOfWeek))
                    .count();
            report.add(new DayStats(day, count));
        }

        return report;
    }
}