package cl.jav.sismos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PresenterView{
    private Presenter presenter;
    private SismosAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this,new Repositorio());
        adapter = new SismosAdapter(new ArrayList<>());
        recyclerView = findViewById(R.id.recyclerviewsismo);
        recyclerView.setLayoutManager(new LinearLayoutManager(getParent()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showInfo(List<SismosLista> listasismos) {
        adapter.update(listasismos);

    }
}