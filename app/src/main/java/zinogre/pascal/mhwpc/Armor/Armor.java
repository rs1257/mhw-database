package zinogre.pascal.mhwpc.Armor;

import android.database.Cursor;

public class Armor {
    private int uid;
    private String name;
    private String rank;

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

    private void setRank(String rank){
        this.rank = rank;
    }
    public String getRank(){
        return rank;
    }

    public static Armor fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Armor m = new Armor();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        m.setRank(cursor.getString(cursor.getColumnIndexOrThrow("rank")));
        return m;
    }
}

