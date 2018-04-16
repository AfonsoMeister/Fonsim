package layouts.guilherme.activities2;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import layouts.guilherme.activities2.R;


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
        registerForContextMenu(lv);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        AddStudent.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.add(Menu.NONE, 0, 0, "Ligar para o aluno");
            menu.add(Menu.NONE, 0, 0, "Mandar SMS para o aluno");
            menu.add(Menu.NONE, 0, 0, "Ver Localização no mapa");
            menu.add(Menu.NONE, 0, 0, "Acessar site do aluno");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String[] menuItems = {"Edit", "Delete"};
        String menuItemName = menuItems[menuItemIndex];
        String listItemName = alunos.get( info.position);
        return true;
    }

}
