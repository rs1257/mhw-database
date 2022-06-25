package zinogre.pascal.mhwpc.Charms;

import android.database.Cursor;

public class Charm {
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

    public static Charm fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Charm m = new Charm();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        return m;
    }
}

