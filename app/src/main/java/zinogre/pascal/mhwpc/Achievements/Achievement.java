package zinogre.pascal.mhwpc.Achievements;

import android.database.Cursor;

public class Achievement {
    private int uid;
    private String name;
    private String description;

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

    private void setDescription(String description){this.description = description;}
    public String getDescription(){return description;}

    public static Achievement fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Achievement m = new Achievement();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        m.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("description")));
        return m;
    }
}

