package cl.jav.sismos;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {
    private PresenterRepositorio presenterRepositorio;

    public void setPresenterRepositorio(PresenterRepositorio presenterRepositorio) {
        this.presenterRepositorio = presenterRepositorio;
    }

    private static final String TAG="Repositorio";

    public void loadInfo() {
        RetrofitClient.getRetrofitInstance().getSismos().enqueue(new Callback<List<SismosLista>>() {
            @Override
            public void onResponse(Call<List<SismosLista>> call, Response<List<SismosLista>> response) {
                Log.d(TAG, "onResponse: "+ response.body());
                List<SismosLista> listasismos = new ArrayList<>();
                for(int i=0;i<response.body().size(); i++) {
                    listasismos.add(response.body().get(i));
                    presenterRepositorio.showInfo(listasismos);
                }

            }

            @Override
            public void onFailure(Call<List<SismosLista>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.toString());

            }
        });
    }

}
