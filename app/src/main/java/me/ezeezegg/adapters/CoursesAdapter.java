package me.ezeezegg.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.ezeezegg.cardviewrecyclerviewexample.R;
import me.ezeezegg.models.Course;

/**
 * Created by egarcia on 3/22/15.
 */
public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    private ArrayList<Course> courses;
    private int itemLayout;

    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{

        public ImageView image;
        public TextView name;
        public TextView description;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"OnItemClick :D", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public CoursesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate( itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CoursesAdapter.ViewHolder viewHolder, int position) {

        Course course = courses.get(position);
        viewHolder.name.setText(course.getName());
        viewHolder.description.setText(course.getDescription());

        switch (course.getId()){
            case 1:

                viewHolder.image.setImageResource(R.drawable.disenio);
                break;

            case 2:

                viewHolder.image.setImageResource(R.drawable.android);
                break;

            case 3:
                viewHolder.image.setImageResource(R.drawable.swift);
                break;

            case 4:
                viewHolder.image.setImageResource(R.drawable.backend);
                break;

            case 5:
                viewHolder.image.setImageResource(R.drawable.servidores);
                break;
        }
        viewHolder.itemView.setTag(course);

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
