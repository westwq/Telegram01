package sg.edu.np.twq2.exam01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        Intent i = getIntent();
        int start = i.getIntExtra("chatId",0);

        ArrayList<Integer> data = new ArrayList<>();
        for(int j = start; j < 20; j++)
        {
            data.add(j);
        }

        RecyclerView rv = findViewById(R.id.rv2);
        MsgAdapter adapter = new MsgAdapter(this, data);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
    }
}




















