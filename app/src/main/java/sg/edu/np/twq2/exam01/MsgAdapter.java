package sg.edu.np.twq2.exam01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {
    Context c;
    ArrayList<Integer> data;

    public MsgAdapter(Context c, ArrayList<Integer> data)
    {
        this.c = c;
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position)%3;
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c)
                .inflate(R.layout.layout_msgleft, viewGroup, false);

        if(i == 0)
        {
            v = LayoutInflater.from(c)
                    .inflate(R.layout.layout_msgright, viewGroup, false);
        }
        return new MsgViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder msgViewHolder, int i) {
        int num = data.get(i);

        msgViewHolder.text.setText("" + num);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}











