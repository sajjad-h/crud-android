package com.example.mycrudapp;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class OnClickListenerCreateStudent implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Context context = view.getRootView().getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = layoutInflater.inflate(R.layout.student_input_form, null, false);

        final EditText editTextStudentFirstName = (EditText) formElementsView.findViewById(R.id.editTextStudentFirstName);
        final EditText editTextStudentEmail = (EditText) formElementsView.findViewById(R.id.editTextStudentEmail);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Create Student")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                        String studentFirstName = editTextStudentFirstName.getText().toString();
                        String studentEmail = editTextStudentEmail.getText().toString();

                        ObjectStudent objectStudent = new ObjectStudent();
                        objectStudent.setFirstName(studentFirstName);
                        objectStudent.setEmail(studentEmail);

                        boolean createSuccessful = new TableControllerStudent(context).create(objectStudent);

                        if (createSuccessful) {
                            Toast.makeText(context, "Student information was saved!", Toast.LENGTH_SHORT).show();
                            new MainActivity().countRecords();
                        } else {
                            Toast.makeText(context, "Unable to save student information!", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .show();

    }
}
