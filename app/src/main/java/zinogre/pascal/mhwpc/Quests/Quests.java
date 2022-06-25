package zinogre.pascal.mhwpc.Quests;

import android.database.Cursor;

public class Quests {
    private int uid;
    private String name;
    private String questType;

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

    private void setQuestType(String questType){
        this.questType = questType;
    }
    public String getQuestType(){
        return questType;
    }

    public static Quests fromCursor(Cursor cursor) {
        //TODO return your MyListItem from cursor.
        Quests m = new Quests();
        m.setUid(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        m.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        m.setQuestType(cursor.getString(cursor.getColumnIndexOrThrow("questType")));
        return m;
    }
}

