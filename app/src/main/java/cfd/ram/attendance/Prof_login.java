package cfd.ram.attendance;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.*;

public class Prof_login extends AppCompatActivity {

    private List<course> mCourseList= new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Course_Adapter mCourse_adapter;
    private DatabaseReference mDatabaseReference;
    private FloatingActionButton mFloatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_login);

        mFloatingActionButton= (FloatingActionButton) findViewById(R.id.fab);

        mRecyclerView =  findViewById(R.id.course_view);

        mCourse_adapter = new Course_Adapter(mCourseList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mCourse_adapter);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Institute").child("Professor").child("Professor2320");

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Prof_login.this,AddCourseDetails.class);
                startActivity(intent);
            }
        });


        /*
        course c=new course("CSN 101","Introduction to Computer Science");

        mCourseList.add(c);
        Toast.makeText(getApplicationContext(),mCourseList.get(0).course_name,Toast.LENGTH_SHORT).show();
        mCourse_adapter.notifyDataSetChanged();

        course d=new course("PHN 006","StatisticaL Mechanincs");
        mCourseList.add(d);
        Toast.makeText(getApplicationContext(),mCourseList.get(1).course_name,Toast.LENGTH_SHORT).show();
        mCourse_adapter.notifyDataSetChanged();

        mDatabaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                course c=dataSnapshot.getValue(course.class);
                mCourseList.add(c);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCourseList.clear();

                for (DataSnapshot postSnapShot:dataSnapshot.getChildren()){

                    String course_name=(String)  postSnapShot.child("Course_Name").getValue();
                    String course_code=(String) postSnapShot.child("Course_Code").getValue();
                    course c=new course(course_code,course_name);
                    mCourseList.add(c);

                }
                mCourse_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(),"Cancelled",Toast.LENGTH_LONG);
            }
        });



    }




}
