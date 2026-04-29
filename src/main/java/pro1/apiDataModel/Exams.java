package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Exams {
    @SerializedName("misto")
    public String misto;

    @SerializedName("pocetPrihlasenych")
    public int pocetPrihlasenych;

    @SerializedName("predmetZkratka")
    public String zkratka;
}