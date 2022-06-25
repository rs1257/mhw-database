package zinogre.pascal.mhwpc.Palico;

import android.database.Cursor;

public class Palico {
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

    public static Palico fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Palico m = new Palico();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        return m;
    }
}

