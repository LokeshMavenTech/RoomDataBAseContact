package app.scrollfrom.roomdatabasecontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import app.scrollfrom.roomdatabasecontact.Room.UserDao;
import app.scrollfrom.roomdatabasecontact.Room.UserDatabase;
import app.scrollfrom.roomdatabasecontact.Room.Users;

public class MainActivity extends AppCompatActivity implements AdapeterListener{
    EditText etname, etno;
    Button btnInsert;
    RecyclerView myrecycler;

    private UserDatabase userDatabase;
    private UserDao userDao;
    private UserAdapter userAdapter;
@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDatabase = UserDatabase.getINSTANCE(this);
        userDao = userDatabase.getDao();


        etname = findViewById(R.id.etname);
        etno = findViewById(R.id.etno);
        btnInsert = findViewById(R.id.btnInsert);
        myrecycler = findViewById(R.id.userReycler);

        userAdapter = new UserAdapter(this,this);
        myrecycler.setAdapter(userAdapter);
        myrecycler.setLayoutManager(new LinearLayoutManager(this));

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                String number = etno.getText().toString();

                Users users = new Users(0, name, number);
                userAdapter.addUser(users);
                userDao.insert(users);
                etname.setText("");
                etno.setText("");
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void fetchData(){
    userAdapter.clearData();
        List<Users> usersList=userDao.getAllUsers();
        for(int i=0;i<usersList.size();i++){
            Users users=usersList.get(i);
            userAdapter.addUser(users);
        }
        
        
    }

    @Override
    public void onUpdate(Users users) {
        Intent intent = new Intent(this, UpdateActivity.class);
        intent.putExtra("model",users);
        startActivity(intent);
    }




    @Override
    public void onDelete(int id, int pos) {
          userDao.delete(id);
          userAdapter.removeUser(pos);
    }
    protected void onResume(){
        super.onResume();
        fetchData();

    }
}