package zinogre.pascal.mhwpc.Life;

import android.database.Cursor;

public class Life {
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

    public static Life fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Life m = new Life();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        return m;
    }
}

