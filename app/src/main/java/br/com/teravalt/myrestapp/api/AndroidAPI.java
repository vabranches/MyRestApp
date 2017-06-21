package br.com.teravalt.myrestapp.api;

import br.com.teravalt.myrestapp.model.ResponseAndroid;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidAPI {
    @GET("/v2/58af1fb21000001e1cc94547")
    Call<ResponseAndroid> getVersoes();


}
