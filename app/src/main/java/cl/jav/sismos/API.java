package cl.jav.sismos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("general/public/sismos")
    Call<List<SismosLista>> getSismos();

}
