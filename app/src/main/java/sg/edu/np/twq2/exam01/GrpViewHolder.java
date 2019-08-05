package sg.edu.np.twq2.exam01;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class GrpViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView msg;
    TextView time;
    View v;

    public GrpViewHolder(View v)
    {
        super(v);
        this.v = v;
        title = v.findViewById(R.id.textView);
        msg = v.findViewById(R.id.textView2);
        time = v.findViewById(R.id.textView3);
    }
}










