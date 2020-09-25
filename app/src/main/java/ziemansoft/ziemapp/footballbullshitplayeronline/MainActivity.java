package ziemansoft.ziemapp.footballbullshitplayeronline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ziemansoft.ziemapp.footballbullshitplayeronline.adapter.ActorsListAdapter;
import ziemansoft.ziemapp.footballbullshitplayeronline.data.ApiFactory;
import ziemansoft.ziemapp.footballbullshitplayeronline.data.ApiFactoryService;
import ziemansoft.ziemapp.footballbullshitplayeronline.pojo.PersonalResult;
import ziemansoft.ziemapp.footballbullshitplayeronline.pojo.ResponseResult;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ActorsListAdapter adapter;
    private List<PersonalResult> actors;
    private final String API_KEY = "cce0d189833afd248f4eaf6cac887086";
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ActorsListAdapter();
        actors = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setActors(actors);
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiFactoryService apiFactoryService = apiFactory.getServise();
        apiFactoryService.getActor(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseResult>() {
                    @Override
                    public void accept(ResponseResult responseResult) throws Exception {
                        if(responseResult != null){
                            adapter.setActors(responseResult.getResults());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}