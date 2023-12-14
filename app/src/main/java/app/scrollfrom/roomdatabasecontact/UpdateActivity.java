package app.scrollfrom.roomdatabasecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
private EditText etname,etno;
private Button btnUpdate;
private Users users;

private UserDatabase userDatabase;
private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

         userDatabase=UserDatabase.getINSTANCE(this);
         userDao=userDatabase.getDao();


        etname = findViewById(R.id.etname);
        etno = findViewById(R.id.etno);
        btnUpdate = findViewById(R.id.btnUpdate);
       users= (Users) getIntent().getSerializableExtra("model");
       etname.setText(users.getName());
       etno.setText(users.getNumber());
       btnUpdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Users usersModel=new Users(users.getId(),etname.getText().toString(),etno.getText().toString());
               userDao.update(usersModel);
               finish();
           }
       });

    }
}