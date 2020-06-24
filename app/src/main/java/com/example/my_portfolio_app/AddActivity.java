package com.example.my_portfolio_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_portfolio_app.Models.Courses;
import com.example.my_portfolio_app.Models.Education;
import com.example.my_portfolio_app.Models.Portfolio;


public class AddActivity extends AppCompatActivity {
    public static final String PARAM_PORTFOLIO = "param-portfolio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        // Can be called to test the app functionality
        // initSampleData();
    }



    public void submitData(View view) {
        EditText etName = findViewById(R.id.et_name);
        EditText etPosition = findViewById(R.id.et_title);
        EditText etEducationTitle = findViewById(R.id.et_education_university);
        EditText etEducationDegree = findViewById(R.id.et_education_degree);
        EditText etEducationYear = findViewById(R.id.et_education_year);
        EditText etCourseTitle = findViewById(R.id.et_course_organisation);
        EditText etCourseDegree = findViewById(R.id.et_course_title);
        EditText etCourseYear = findViewById(R.id.et_course_year);
        EditText etGithub = findViewById(R.id.et_github);

        Education education = new Education(etEducationTitle.getText().toString(), etEducationDegree.getText().toString(),
                etEducationYear.getText().toString());

        Courses course = new Courses(etCourseTitle.getText().toString(), etCourseDegree.getText().toString(),
                etCourseYear.getText().toString());

        Portfolio portfolio = new Portfolio(etName.getText().toString(), etPosition.getText().toString(),
                education, course, etGithub.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(PARAM_PORTFOLIO, portfolio);
        setResult(RESULT_OK, intent);
        finish();
    }
}