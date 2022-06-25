package zinogre.pascal.mhwpc.Combinations;

import android.database.Cursor;

public class Combination {
    private int uid;
    private String name;
    private String item1;
    private String item2;

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

    private void setItem1(String item1){
        this.item1=item1;
    }
    public String getItem1(){
        return item1;
    }

    private void setItem2(String item2){
        this.item2=item2;
    }
    public String getItem2(){
        return item2;
    }

    public static Combination fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Combination m = new Combination();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("result")));
        m.setItem1(cursor.getString(cursor.getColumnIndexOrThrow("item1")));
        m.setItem2(cursor.getString(cursor.getColumnIndexOrThrow("item2")));
        return m;
    }
}

