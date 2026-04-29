package pro1.reports.report5;

import com.google.gson.Gson;
import pro1.DataSource;
import pro1.apiDataModel.ExamsList;
import pro1.reports.report5.reportDataModel.DepartmentExamsStats;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentExamsStatsReporting {

    public static DepartmentExamsStats GetReport(DataSource dataSource, String katedra) {

        String json = dataSource.getTerminyZkousek2(katedra);


        ExamsList examslist = new Gson().fromJson(json, ExamsList.class);


        if (examslist == null || examslist.items == null) {
            return new DepartmentExamsStats(0, new ArrayList<>());
        }


        long count = examslist.items.stream()
                .filter(e -> e.pocetPrihlasenych > 0)
                .count();


        List<String> rooms = examslist.items.stream()
                .map(e -> e.misto)
                .filter(misto -> misto != null && !misto.isEmpty())
                .distinct()
                .sorted()
                .collect(Collectors.toList());


        return new DepartmentExamsStats(count, rooms);
    }
}