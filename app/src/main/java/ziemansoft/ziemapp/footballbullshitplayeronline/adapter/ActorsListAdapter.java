package ziemansoft.ziemapp.footballbullshitplayeronline.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ziemansoft.ziemapp.footballbullshitplayeronline.R;
import ziemansoft.ziemapp.footballbullshitplayeronline.pojo.PersonalResult;

public class ActorsListAdapter extends RecyclerView.Adapter<ActorsListAdapter.ItemViewHolder> {
    private List<PersonalResult> actors;

    public ActorsListAdapter(){
        actors = new ArrayList<>();
    }

    public void setActors(List<PersonalResult> actors) {
        this.actors = actors;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_page, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        PersonalResult result = actors.get(position);
        holder.textViewNameValue.setText(result.getName());
        holder.textViewPopularityValue.setText(Double.toString(result.getPopularity()));
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewNameValue;
        private TextView textViewPopularityValue;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameValue = itemView.findViewById(R.id.textViewNameValue);
            textViewPopularityValue = itemView.findViewById(R.id.textViewPopularityValue);
        }
    }
}
