package sg.edu.np.twq2.exam01;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class GrpAdapter extends RecyclerView.Adapter<GrpViewHolder> {
    private ArrayList<ChatGrp> data;
    private Context c;

    public GrpAdapter(Context c, ArrayList<ChatGrp> data)
    {
        this.c = c;
        this.data = data;
    }

    @NonNull
    @Override
    public GrpViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(c)
                .inflate(R.layout.layout_chatgroup, viewGroup, false);

        return new GrpViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull GrpViewHolder grpViewHolder, final int i) {
        ChatGrp cg = data.get(i);

        grpViewHolder.title.setText(cg.getTitle());
        grpViewHolder.msg.setText(cg.getLastMsg());
        grpViewHolder.time.setText(cg.getTime());

        grpViewHolder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(c, MsgActivity.class);
                it.putExtra("chatId", i);
                c.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}















