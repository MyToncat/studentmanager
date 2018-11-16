import java.util.List;
import java.util.Map;

import java.io.FileWriter;
import java.io.IOException;
public class FileOperation {
    private FileWriter out;//声明
    public  FileOperation (String filename)throws IOException{
        out=new FileWriter(filename);
    }
    public void save(List<Map<String,String>>lst)throws IOException{
        for(Map<String,String>m:lst){
            for(Map.Entry entry:m.entrySet()){
                out.write(entry.getKey()+":"+entry.getValue()+"\t");
            }
            out.write("\r\t");
        }
    }
    public void close()throws IOException{
        out.close();
    }
}
