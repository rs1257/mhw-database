package zinogre.pascal.mhwpc.Locations;

import android.database.Cursor;

public class Location {
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

    public static Location fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Location m = new Location();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));

        return m;
    }
}

