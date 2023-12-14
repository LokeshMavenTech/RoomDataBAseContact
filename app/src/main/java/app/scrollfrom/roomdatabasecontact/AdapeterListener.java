package app.scrollfrom.roomdatabasecontact;

public interface AdapeterListener {
    void onUpdate( Users users);
    void onDelete(int id,int pos);
}
