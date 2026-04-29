package pro1;

public interface DataSource {
    String getRozvrhByKatedra(String rok, String katedra);
    String getPredmetyByUcitel(String rok, int ucitIdno, String katedra);
    String getLiteraturaPredmetu(String zkratka, String katedra);
    String getTerminyZkousek(String semestr, String zkratka, String katedra);
    String getTerminyZkousek2(String katedra);
    String getKvalifikacniPrace(String rokObhajoby, String katedra);
}