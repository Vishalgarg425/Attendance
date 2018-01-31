package cfd.ram.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.IOException;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;


public class AddCourseDetails extends AppCompatActivity {
    private Button mDone_Button;
    private EditText mcourse_code;
    private EditText mcourse_name;
    private DatabaseReference mDatabase;
    private String mProf;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.add_course_details);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mcourse_name=(EditText) findViewById(R.id.course_name_input);
        mcourse_code=(EditText) findViewById(R.id.course_code_input);

        Random rn=new Random();
        final int i=rn.nextInt(10000)+1;

       mDone_Button=(Button)findViewById(R.id.done_bu);
       mDone_Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String course_name = mcourse_name.getText().toString().trim();
               String course_code = mcourse_code.getText().toString().trim();
               HashMap<String, String > mDataMap= new HashMap<String, String>();
               mDataMap.put("Course_Code",course_code  );
               mProf="Professor"+ 2320;
               mDataMap.put("Course_Name",  course_name);
               mDataMap.put("Course_Code",course_code);
               mDatabase.child("Institute").child("Professor").child(mProf).child(course_code).setValue(mDataMap);

               finish();
           }
       });

    }
}
