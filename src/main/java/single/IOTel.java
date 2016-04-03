package single;

import java.io.*;
import java.util.HashSet;

/**
 * Created by Fennel on 02.02.2016.
 */
public class IOTel {
    private static void save(HashSet<TelNum> oHS) throws IOException{
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(oHS);
        oos.flush();
        oos.close();
    }
    private static HashSet<TelNum> load() throws IOException,ReflectiveOperationException{
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        HashSet<TelNum> iMT = (HashSet<TelNum>)oin.readObject();
        return iMT;
    }
    private static String getCmd() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        return stdin.readLine();
    }
    public static void setCollection(HashSet<TelNum> collection){
        try {
            save(collection);
        }
        catch (IOException e){
            System.err.println("setCollectException\n"+e);
        }
    }
    public static HashSet<TelNum> getCollection(){
        try {
            return load();
        }
        catch (Exception e){
            System.err.println(e);
            return new HashSet<TelNum>();
        }
    }
    public static String ascCom(){
        try{
            return getCmd();
        }
        catch (IOException e){
            System.err.println("getCommandException\n"+e);
            return "";
        }
    }
}