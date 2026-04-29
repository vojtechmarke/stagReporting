package pro1.reports.report5.reportDataModel;

import java.util.List;

public class DepartmentExamsStats {
    public long realizedExamsCount;
    public List<String> reservedRoms;

    public DepartmentExamsStats(long realizedExamsCount, List<String> reservedRoms) {
        this.realizedExamsCount = realizedExamsCount;
        this.reservedRoms = reservedRoms;
    }
}