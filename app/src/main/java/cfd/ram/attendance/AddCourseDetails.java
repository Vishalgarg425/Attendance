package cfd.ram.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class AddCourseDetails extends AppCompatActivity {
    private Button mDone_Button;
    private EditText mcourse_code;
    private EditText mcourse_name;
    private DatabaseReference mDatabase;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.add_course_details);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Professor");
        mcourse_name=(EditText) findViewById(R.id.course_name_input);
        mcourse_code=(EditText) findViewById(R.id.course_code_input);

       mDone_Button=(Button)findViewById(R.id.done_bu);
       mDone_Button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String course_name = mcourse_name.getText().toString().trim();
               String course_code = mcourse_code.getText().toString().trim();

               finish();
           }
       });

    }
}
