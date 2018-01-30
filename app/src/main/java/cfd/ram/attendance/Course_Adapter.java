package cfd.ram.attendance;

import java.util.*;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by Aary on 29-01-2018.
 */

public class Course_Adapter extends RecyclerView.Adapter<Course_Adapter.MyViewHolder> {
    private List<course> mCourseList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView course_code , course_name;

        public MyViewHolder(View view){
            super(view);
            course_code = (TextView) view.findViewById(R.id.course_code);
            course_name= (TextView) view.findViewById(R.id.course_name);

        }

    }

    public Course_Adapter(List<course> mCourseList){
        this.mCourseList = mCourseList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_list_view, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        course c=mCourseList.get(position);
        holder.course_name.setText(course.getcourse_name());
        holder.course_code.setText(course.getcourse_code());

    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }
}
