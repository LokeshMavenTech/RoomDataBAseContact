package app.scrollfrom.roomdatabasecontact;

import app.scrollfrom.roomdatabasecontact.Room.Users;

public interface AdapeterListener {
    void onUpdate( Users users);
    void onDelete(int id,int pos);
}
