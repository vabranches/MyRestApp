package br.com.teravalt.myrestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.teravalt.myrestapp.adapter.AndroidAdapter;
import br.com.teravalt.myrestapp.api.APIUtils;
import br.com.teravalt.myrestapp.api.AndroidAPI;
import br.com.teravalt.myrestapp.model.Android;
import br.com.teravalt.myrestapp.model.ResponseAndroid;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAndroids;
    private AndroidAdapter androidAdapter;
    private AndroidAPI androidAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvAndroids = (RecyclerView) findViewById(R.id.rvAndroids);

        androidAdapter = new AndroidAdapter(new ArrayList<Android>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androidAdapter);
        rvAndroids.setHasFixedSize(true);
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        //rvAndroids.addItemDecoration(itemDecoration);

        carregarDados();


    }



    private void carregarDados(){

        androidAPI = APIUtils.getAndroidAPIVersion();

        androidAPI.getVersoes().enqueue(new Callback<ResponseAndroid>() {
            @Override
            public void onResponse(Call<ResponseAndroid> call, Response<ResponseAndroid> response) {
                if(response.isSuccessful()){
                androidAdapter.update(response.body().getAndroids());
                }
            }

            @Override
            public void onFailure(Call<ResponseAndroid> call, Throwable t) {

            }
        });
    }
}
