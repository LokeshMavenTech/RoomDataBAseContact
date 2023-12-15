package app.scrollfrom.roomdatabasecontact.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Users implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
   // @ColumnInfo(name = Full_Name )
    private String name;
    //@ColumnInfo(name = Contact_Number)
    private String number;

    public Users(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
