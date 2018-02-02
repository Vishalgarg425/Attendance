package cfd.ram.attendance;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;
import android.support.v4.app.FragmentActivity;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;


public class AddCourseDetails extends AppCompatActivity {
    private Button mDone_Button;
    private EditText mcourse_code;
    private EditText mcourse_name;
    private DatabaseReference mDatabase;
    private String mProf;
    private int hour,minutes;


    TextView start_1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.add_course_details);

         start_1=(TextView) findViewById(R.id.start_1);
        TextView start_2=(TextView) findViewById(R.id.start_2);
        TextView start_3=(TextView) findViewById(R.id.start_3);
        TextView start_4=(TextView) findViewById(R.id.start_4);
        TextView start_5=(TextView) findViewById(R.id.start_5);
        TextView start_6=(TextView) findViewById(R.id.start_6);
        final Button set_time=(Button)findViewById(R.id.set_time);
        final TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);


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


       start_1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentManager fragmentManager=getSupportFragmentManager();
               FragmentTransaction transaction=fragmentManager.beginTransaction();
               transaction.commit();
               Clock c=new Clock();

               transaction.replace(R.id.frm,c);



           }
       });
        /*
        Clock d=new Clock();

        hour=d.getHr();
        Log.i("The value in last",Integer.toString(hour));
        start_1.setText(Integer.toString(hour));
*/


    }

    public void setValues(int hr,int min){
        start_1.setText(Integer.toString(hr));

    }
}
