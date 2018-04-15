package layouts.guilherme.activities1;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    public static List<String> alunos = new ArrayList<String>();
    public static ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.listStudents);
        this.arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, alunos);

        lv.setAdapter(arrayAdapter);
        lv.setTextFilterEnabled(true);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        AddStudent.class);
                startActivity(myIntent);
            }
        });



    }
}
