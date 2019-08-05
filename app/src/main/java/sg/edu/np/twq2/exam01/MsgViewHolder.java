package sg.edu.np.twq2.exam01;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MsgViewHolder extends RecyclerView.ViewHolder {
    TextView text;

    public MsgViewHolder(View v)
    {
        super(v);
        text = v.findViewById(R.id.textView4);
    }
}
