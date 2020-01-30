package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.helloworld.adapters.StudentAdapter;
import com.example.helloworld.models.Student;

import java.util.ArrayList;
import java.util.Calendar;

public class ListViewActivity extends AppCompatActivity {

    ListView lvName;
    ArrayList<String> nameList;
    ArrayAdapter adapter;
    EditText edtName;
    Button btnAddName;
    Button btnEditName;
    int selectedNameId;

    // Custom listView
    ListView lvStudent;
    ArrayList<Student> studentList;
    StudentAdapter studentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initVar();
        main();
    }

    private void initVar() {
        lvName = findViewById(R.id.listViewName);
        edtName = findViewById(R.id.editTextName);
        btnAddName = findViewById(R.id.buttonAddName);
        btnEditName = findViewById(R.id.buttonEditName);

        selectedNameId = 0;

        nameList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nameList.add("Name " + i);
        }

        // Custom Adapter
        lvStudent = findViewById(R.id.listViewStudent);
        studentList = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student("Student " + i, i + 20);
            studentList.add(student);
        }
    }

    private void main() {
        initListView();

        lvName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = nameList.get(position);
                edtName.setText(selectedName);
                selectedNameId = position;
            }
        });

        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showConfirmDeleteDialog(position);
                return false;
            }
        });

        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });

        btnEditName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName();
            }
        });
    }

    private void initListView() {
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList);
        lvName.setAdapter(adapter);

        studentAdapter = new StudentAdapter(this, R.layout.student_item, studentList);
        lvStudent.setAdapter(studentAdapter);
    }

    private void addName() {
        String newName = edtName.getText().toString();
        nameList.add(0, newName);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Added: " + newName, Toast.LENGTH_SHORT).show();
        edtName.setText("");
    }

    private void editName() {
        String newName = edtName.getText().toString();
        nameList.set(selectedNameId, newName);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Updated: " + newName, Toast.LENGTH_SHORT).show();
        edtName.setText("");
        selectedNameId = 0;
    }

    private void showConfirmDeleteDialog(final int position) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Confirm delete");
        alertDialog.setIcon(R.mipmap.ic_launcher_round);
        alertDialog.setMessage("Do you want to delete this item?");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ListViewActivity.this, "Deleted: " + nameList.get(position), Toast.LENGTH_SHORT).show();
                nameList.remove(position);
                adapter.notifyDataSetChanged();
                edtName.setText("");
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }
}
