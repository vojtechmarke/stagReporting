package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Thesis {
    @SerializedName("datumZadani")
    public Date zadani;

    @SerializedName("datumOdevzdani")
    public Date odevzdani;
}