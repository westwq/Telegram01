package sg.edu.np.twq2.exam01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            c.setTitle("Title " +i);
            c.setLastMsg("" + i);
            c.setTime(""+i + ":00");
            data.add(c);
        }

        //adding records from db
        DBHelper db = new DBHelper(this);
        ArrayList<ChatGrp> records = db.getAllChatGroups();
        for(ChatGrp cg: records)
        {
            data.add(cg);
        }

        GrpAdapter adapter = new GrpAdapter(this, data);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);


        //regex
        Pattern p = Pattern.compile("expression");
        Matcher m = p.matcher("user input");
        boolean results = m.matches();

        
    }
}
















