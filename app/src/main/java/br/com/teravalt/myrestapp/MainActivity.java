package br.com.teravalt.myrestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.teravalt.myrestapp.adapter.AndroidAdapter;
import br.com.teravalt.myrestapp.api.AndroidAPI;
import br.com.teravalt.myrestapp.model.Android;

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
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvAndroids.addItemDecoration(itemDecoration);


    }
}
