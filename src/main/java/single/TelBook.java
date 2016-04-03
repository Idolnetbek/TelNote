package single;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Created by Fennel on 17.11.2015.
 */
public class TelBook {
    private static void inst(){
        System.out.println("How to use:\n1 - Add.\n2 - Delete.\n3 - Edit.\n4 - Extended search.\n5 - Show All.\n6 - Exit.");
    }
    private static void showSingle(TelNum in){
        System.out.println("Name: " + in.getName());
        System.out.println("Email: " + in.getMail());
        System.out.println("Tel.: " + in.getNum()+"\n");
    }
    private static void err(){
        System.out.println("Error. Try again.");
    }

    private static void showAll(HashSet<TelNum> all){
        for (TelNum o:all) {
            showSingle(o);
        }
    }
    private static void add(){
        TelNum newElem = new TelNum();
        System.out.println("New contact.\nEnter name:");
        newElem.setName(IOTel.ascCom());
        System.out.println("Enter number:");
        newElem.setNum(Integer.parseInt(IOTel.ascCom()));
        System.out.println("Enter mail:");
        newElem.setMail(IOTel.ascCom());
        EditTel.add(newElem);
    }
    private static HashSet<TelNum> getEntries(){
        System.out.println("Enter name: ");
        HashSet<TelNum> founded = new HashSet<TelNum>();
        String inp = IOTel.ascCom();
        for(TelNum s:IOTel.getCollection()){
            if(Pattern.matches("(?i:.*"+inp+".*)",s.getName())){
                founded.add(s);
            }
        }
        return founded;
    }
    private static HashSet<TelNum> getEntries(HashSet<TelNum> at){
        System.out.println("Enter name: ");
        HashSet<TelNum> founded = new HashSet<TelNum>();
        String inp = IOTel.ascCom();
        for(TelNum s:at){
            if(Pattern.matches("(?i:.*"+inp+".*)",s.getName())){
                founded.add(s);
            }
        }
        return founded;
    }
    private static void search(){
        System.out.println("Search by name.");
        HashSet<TelNum> result = getEntries();
        System.out.println(result.size()+" record(s) was(were) founded");
        showAll(result);
    }
    private static void delete(){
        System.out.println("Delete records by name.");
        HashSet<TelNum> result = getEntries();
        EditTel.remove(result);
        System.out.println(result.size()+" record(s) was(were) deleted.");
    }
    private static void edit(){
        System.out.println("Edit record by name.");
        HashSet<TelNum> result = getEntries();
        while (result.size() != 1){
            System.out.println("More than one records were founded.\nSelect which one you want to edit.");
            showAll(result);
            result = getEntries(result);
            if (result.isEmpty()){
                System.out.println("There are 0 records found.");
                err();
                result = getEntries();
            }
        }
        TelNum edit = new TelNum();
        for (TelNum o:result) edit = o;
        System.out.println("What do you want to edit?");
         outer: while (true){
            System.out.println("1 - Name.\n2 - Number.\n3 - Mail.");
            switch (IOTel.ascCom().charAt(0)){
                case '1':
                    System.out.println("Enter name:");
                    EditTel.changeName(edit,IOTel.ascCom());
                    System.out.println("Name changed.");
                    break outer;
                case '2':
                    System.out.println("Enter number:");
                    EditTel.changeNum(edit,Integer.parseInt(IOTel.ascCom()));
                    System.out.println("Number changed.");
                    break outer;
                case '3':
                    System.out.println("Enter mail:");
                    EditTel.changeMail(edit,IOTel.ascCom());
                    System.out.println("Mail changed.");
                    break outer;
                default:
                    System.out.println(IOTel.ascCom().charAt(0));
                    err();
            }
        }
    }
    public static void main(String[] args){
        while(true) {
            inst();
            switch (Integer.parseInt(IOTel.ascCom())) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    showAll(IOTel.getCollection());
                    break;
                case 6:
                    return;
                default:
                    err();
            }
            System.out.println("Press any key to continue.");
            IOTel.ascCom();
        }
    }

}

