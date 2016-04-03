package single;

import java.util.HashSet;

/**
 * Created by Fennel on 02.02.2016.
 */
public class EditTel {
    public static void add(TelNum newElem){
        HashSet<TelNum> col = IOTel.getCollection();
        col.add(newElem);
        IOTel.setCollection(col);
    }
    public static void remove(HashSet<TelNum> remove){
        HashSet<TelNum> col = IOTel.getCollection();
        HashSet<TelNum> col2 = new HashSet<TelNum>();
        for (TelNum r:remove){
            for (TelNum c:col){
                if(c.equals(r)){
                    col2.add(c);
                }
            }
        }
        col.removeAll(col2);
        IOTel.setCollection(col);
    }
    public static void changeName(TelNum editElem, String newName){
        HashSet<TelNum> col = IOTel.getCollection();
        for (TelNum c:col){
            if(c.equals(editElem)){
                c.setName(newName);
            }
        }
        IOTel.setCollection(col);
    }
    public static void changeNum(TelNum editElem, int newNum){
        HashSet<TelNum> col = IOTel.getCollection();
        for (TelNum c:col){
            if(c.equals(editElem)){
                c.setNum(newNum);
            }
        }
        IOTel.setCollection(col);
    }
    public static void changeMail(TelNum editElem, String newMail){
        HashSet<TelNum> col = IOTel.getCollection();
        for (TelNum c:col){
            if(c.equals(editElem)){
                c.setMail(newMail);
            }
        }
        IOTel.setCollection(col);
    }
}
