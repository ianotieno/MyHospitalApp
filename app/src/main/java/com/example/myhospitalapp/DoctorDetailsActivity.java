package com.example.myhospitalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1={
            {"Doctor Name: Paul Otieno","Hospital Address: Nairobi","Exp: 5yrs","Mobile No:071414414","400"},
            {"Doctor Name: Mary Otieno","Hospital Address: Mombasa","Exp: 3yrs","Mobile No:071111111","700"},
            {"Doctor Name: John Otieno","Hospital Address: Kisumu","Exp: 6yrs","Mobile No:0732424242","100"},
            {"Doctor Name: Peter Otieno","Hospital Address: Eldoret","Exp: 10yrs","Mobile No:0722442420","150"},
            {"Doctor Name: Ian Otieno","Hospital Address: Kitale","Exp: 15yrs","Mobile No:0714142323","200"},
    };
    private String[][] doctor_details2={
    {"Doctor Name: Paul Otieno","Hospital Address: Nairobi","Exp: 5yrs","Mobile No:071414414","400"},
    {"Doctor Name: Mary Otieno","Hospital Address: Mombasa","Exp: 3yrs","Mobile No:071111111","700"},
    {"Doctor Name: John Otieno","Hospital Address: Kisumu","Exp: 6yrs","Mobile No:0732424242","100"},
    {"Doctor Name: Peter Otieno","Hospital Address: Eldoret","Exp: 10yrs","Mobile No:0722442420","150"},
    {"Doctor Name: Ian Otieno","Hospital Address: Kitale","Exp: 15yrs","Mobile No:0714142323","200"},
};
    private String[][] doctor_details3={
            {"Doctor Name: Paul Otieno","Hospital Address: Nairobi","Exp: 5yrs","Mobile No:071414414","400"},
            {"Doctor Name: Mary Otieno","Hospital Address: Mombasa","Exp: 3yrs","Mobile No:071111111","700"},
            {"Doctor Name: John Otieno","Hospital Address: Kisumu","Exp: 6yrs","Mobile No:0732424242","100"},
            {"Doctor Name: Peter Otieno","Hospital Address: Eldoret","Exp: 10yrs","Mobile No:0722442420","150"},
            {"Doctor Name: Ian Otieno","Hospital Address: Kitale","Exp: 15yrs","Mobile No:0714142323","200"},
    };
    private String[][] doctor_details4={
            {"Doctor Name: Paul Otieno","Hospital Address: Nairobi","Exp: 5yrs","Mobile No:071414414","400"},
            {"Doctor Name: Mary Otieno","Hospital Address: Mombasa","Exp: 3yrs","Mobile No:071111111","700"},
            {"Doctor Name: John Otieno","Hospital Address: Kisumu","Exp: 6yrs","Mobile No:0732424242","100"},
            {"Doctor Name: Peter Otieno","Hospital Address: Eldoret","Exp: 10yrs","Mobile No:0722442420","150"},
            {"Doctor Name: Ian Otieno","Hospital Address: Kitale","Exp: 15yrs","Mobile No:0714142323","200"},
    };
    private String[][] doctor_details5={
            {"Doctor Name: Paul Otieno","Hospital Address: Nairobi","Exp: 5yrs","Mobile No:071414414","400"},
            {"Doctor Name: Mary Otieno","Hospital Address: Mombasa","Exp: 3yrs","Mobile No:071111111","700"},
            {"Doctor Name: John Otieno","Hospital Address: Kisumu","Exp: 6yrs","Mobile No:0732424242","100"},
            {"Doctor Name: Peter Otieno","Hospital Address: Eldoret","Exp: 10yrs","Mobile No:0722442420","150"},
            {"Doctor Name: Ian Otieno","Hospital Address: Kitale","Exp: 15yrs","Mobile No:0714142323","200"},
    };

    TextView tv;
 Button btn;
 String[][ ] doctor_details={};
 HashMap <String,String>item;
 ArrayList list;
 SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
       tv= findViewById(R.id.textViewDDTitle);
       btn = findViewById(R.id.buttonDDBack);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Pysicians")==0)
            doctor_details=doctor_details1;
        else

        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
            if (title.compareTo("Dentist")==0)
        doctor_details=doctor_details3;
        if(title.compareTo("surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0;i<doctor_details.length; i++){
         item = new HashMap<String,String>();
         item.put("line1",doctor_details[i][0]);
         item.put("line2",doctor_details[i][1]);
         item.put("line3",doctor_details[i][2]);
         item.put("line4",doctor_details[i][3]);
         item.put("line5", "Cons Fees :" +doctor_details[i][4]+"/=");
         list.add(item);

        }
       sa = new SimpleAdapter(this,list,
               R.layout.multi_lines,
               new String[]{"line1","line2","line3","line4","line5"},
               new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
               );
        ListView lst= findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


    }
}