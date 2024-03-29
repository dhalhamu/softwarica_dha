package com.example.softwarica_dha.AddStudent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.softwarica_dha.HomeActivity;
import com.example.softwarica_dha.Model.Student;
import com.example.softwarica_dha.R;

import java.util.ArrayList;
import java.util.List;

public class AddStudentFrag extends Fragment {

    public static List<Student> studentsList = new ArrayList<Student>();
    //List<Students> studentsList;
    private EditText etStudentName, etStudentAge,etStudentAddress;
    private RadioGroup Gender;
    private RadioButton rbtnMale,rbtnFemale,rbtnOther;
    private Button Register;
    private int Image, age;
    private String name, address, gender;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_add_student,container,false);
        etStudentName=view.findViewById(R.id.studentName);
        etStudentAge=view.findViewById(R.id.studentAge);
        etStudentAddress = view.findViewById(R.id.studentAddress);
        Gender = view.findViewById(R.id.selectGender);
        rbtnMale = view.findViewById(R.id.rdoMale);
        rbtnFemale = view.findViewById(R.id.rdoFemale);
        rbtnOther = view.findViewById(R.id.rdoOthers);
        Register = view.findViewById(R.id.btnRegistration);

        final int[] image = {R.drawable.boy, R.drawable.girl, R.drawable.other};
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etStudentName.getText().toString();
                address = etStudentAddress.getText().toString();
                age = Integer.parseInt(etStudentAge.getText().toString());

                int selectGender = Gender.getCheckedRadioButtonId();
                RadioButton radioButton = view.findViewById(selectGender);
                gender = radioButton.getText().toString();
                if(gender.equals("Male")){
                    Image = image[0];
                }
                else if (gender.equals("Female")){
                    Image = image[1];
                }
                else
                {
                    Image = image[2];
                }

                Student students = new Student(name, address, gender, age, Image);
                studentsList = HomeActivity.studentsList;
                studentsList.add(students);
                Toast.makeText(getActivity(),"Student Registered Successfully",Toast.LENGTH_LONG).show();
                etStudentName.getText().clear();
                etStudentAddress.getText().clear();
                etStudentAge.getText().clear();
                Gender.clearCheck();
            }
        });
        return view;
    }
}

