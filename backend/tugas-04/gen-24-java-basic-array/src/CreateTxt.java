import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTxt {
    public CreateTxt(String input) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("\n" + input);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
