package sg.edu.np.twq2.exam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        ArrayList<ChatGrp> data = new ArrayList<>();
        for(int i=0; i<10; i++)
        {
            ChatGrp c = new ChatGrp();
            c.setTitle("" +i);
            c.setLastMsg("" + i);
            c.setTime(""+i);
            data.add(c);
        }
        GrpAdapter adapter = new GrpAdapter(this, data);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }
}
















