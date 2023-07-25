import java.io.*;

public class FileReader {
    public String readFile(String filePath) throws IOException{
        String rt = "";
        try{
            FileInputStream read = new FileInputStream(new File(filePath));
            int bt;
            while((bt = read.read()) != -1){
                rt = rt + (char)bt;
            }
            read.close();
        }catch (IOException e)
        {}
        return rt;
    }
}
