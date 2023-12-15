package app.scrollfrom.roomdatabasecontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
//import app.scrollfrom.roomdatabasecontact.Room.Users;

import app.scrollfrom.roomdatabasecontact.Room.Users;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    private List<Users> usersList;

    private AdapeterListener adapeterListener;
    public UserAdapter(Context context,AdapeterListener listener) {
        this.context = context;
        usersList=new ArrayList<>();
        this.adapeterListener=listener;
    }
     public void addUser(Users users){
        usersList.add(users);
        notifyDataSetChanged();
     }
     public void removeUser(int position){
        usersList.remove(position);
        notifyDataSetChanged();
     }
     public void clearData(){
        usersList.clear();
        notifyDataSetChanged();
     }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         Users users=usersList.get(position);
         holder.name01.setText(users.getName());
         holder.contactNo01.setText(users.getNumber());


         holder.update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 adapeterListener.onUpdate(users);
             }
         });
         holder.delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 adapeterListener.onDelete(users.getId(),position);
             }
         });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name01,contactNo01;
        private ImageView update,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name01=itemView.findViewById(R.id.name01);
            contactNo01=itemView.findViewById(R.id.contactNo01);
            update=itemView.findViewById(R.id.update);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
