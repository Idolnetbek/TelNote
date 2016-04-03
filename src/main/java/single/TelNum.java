package single;

import java.io.Serializable;

/**
 * Created by Fennel on 02.02.2016.
 */
public class TelNum implements Serializable {
    private String name, mail;
    private int number;
    public boolean setName(String n){
        if(n.isEmpty()) {
            System.out.println("Name can't be empty.");
            return false;
        }
        else {
            name = n;
            return true;
        }
    }
    public boolean setMail(String m){
        if(m.isEmpty()) {
            System.out.println("Email can't be empty.");
            return false;
        }
        else {
            mail = m;
            return true;
        }
    }
    public boolean setNum(int numb){
        number = numb;
        return true;
    }
    public int getNum(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getMail(){
        return mail;
    }

    public boolean equals(TelNum obj) {
        return this.getNum() == obj.getNum();
    }
}