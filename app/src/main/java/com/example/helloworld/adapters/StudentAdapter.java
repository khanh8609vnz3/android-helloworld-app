package com.example.helloworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.models.Student;

import org.w3c.dom.Text;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> studentList;

    public StudentAdapter(Context context, int layout, List<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }

    private class ViewHolder {
        TextView txtName, txtAge;
    }

    @Override
    public int getCount() {
        // Number of element return from list
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){



            layout = R.layout.student_item;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.txtName= (TextView) convertView.findViewById(R.id.textViewName);
            viewHolder.txtAge = (TextView) convertView.findViewById(R.id.textViewAge);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Student student = studentList.get(position);

        viewHolder.txtName.setText(student.getName());
        viewHolder.txtAge.setText(student.getAge()+"");

        return convertView;
    }
}
