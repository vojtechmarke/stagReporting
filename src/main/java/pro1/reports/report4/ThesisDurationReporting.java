package pro1.reports.report4;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ThesisList;
import pro1.reports.report4.reportDataModel.YearDurationStats;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ThesisDurationReporting {

    public static List<YearDurationStats> GetReport(DataSource dataSource, String katedra, String[] years) {
        List<YearDurationStats> report = new ArrayList<>();
        Gson gson = new Gson();

        for (String year : years) {
            String json = dataSource.getKvalifikacniPrace(year, katedra);
            ThesisList thesisList = gson.fromJson(json, ThesisList.class);

            if (thesisList == null || thesisList.items == null) {
                report.add(new YearDurationStats(year, 0));
                continue;
            }

            long totalDays = 0;
            int count = 0;

            for (var thesis : thesisList.items) {
                if (thesis.zadani != null && thesis.zadani.isValid() &&
                        thesis.odevzdani != null && thesis.odevzdani.isValid()) {

                    long days = ChronoUnit.DAYS.between(
                            thesis.zadani.toLocalDate(),
                            thesis.odevzdani.toLocalDate()
                    );
                    totalDays += days;
                    count++;
                }
            }

            int average = (count > 0) ? Math.round((float) totalDays / count) : 0;
            report.add(new YearDurationStats(year, average));
        }

        return report;
    }
}