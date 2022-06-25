package zinogre.pascal.mhwpc.Weapon;

import android.database.Cursor;

public class Weapon {
    private int uid;
    private String name;

    private void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    private void setUid(int uid){
        this.uid = uid;
    }

    public int getUid(){
        return uid;
    }

    public static Weapon fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Weapon w = new Weapon();
        w.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        w.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        return w;
    }
}
