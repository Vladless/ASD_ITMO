import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder data = new StringBuilder();
        FileReader reader = new FileReader("input.txt");
        int c;
        while((c=reader.read())!=-1){
            data.append((char) c);
        }
        StringBuilder deleted = new StringBuilder();
        String value;
        int counter = 0;
        int actionsValue = Integer.parseInt(data.toString().split("\\n")[0].split(" ")[0].trim());
        ArrayList<Integer>  stack = new ArrayList<Integer>();
        for(int i = 1; i < actionsValue+1; i++){
            if(data.toString().split("\\n")[i].split(" ")[0].trim().equals("-")){
                counter--;
                deleted.append(stack.get(counter)).append("\n");
                stack.remove(counter);
            }
            else  {
                value = data.toString().split("\\n")[i].split(" ")[1].trim();
                stack.add(counter, Integer.valueOf(value));
                counter++;
            }
        }
        FileWriter writer = new FileWriter("output.txt", false);
        writer.write(deleted.toString());
        writer.flush();
    }
}