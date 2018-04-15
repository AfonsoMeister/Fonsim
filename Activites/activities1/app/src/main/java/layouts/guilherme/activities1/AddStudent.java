package layouts.guilherme.activities1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudent extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstudent);

        Button bt  = (Button) findViewById(R.id.salvar);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit_text   = (EditText)findViewById(R.id.te_aluno);

                MainActivity.alunos.add(edit_text.getText().toString());

                MainActivity.arrayAdapter.notifyDataSetChanged();

                Intent myIntent = new Intent(AddStudent.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
