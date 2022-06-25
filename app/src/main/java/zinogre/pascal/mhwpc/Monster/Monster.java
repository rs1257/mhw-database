package zinogre.pascal.mhwpc.Monster;

import android.database.Cursor;

public class Monster {
    private int uid;
    private String name;
    private String species;

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

    private void setSpecies(String species){
        this.species = species;
    }

    public String getSpecies(){
        return species;
    }

    public static Monster fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Monster m = new Monster();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        m.setSpecies(cursor.getString(cursor.getColumnIndexOrThrow("species")));

        return m;
    }
}

