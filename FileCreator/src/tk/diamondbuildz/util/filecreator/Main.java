package tk.diamondbuildz.util.filecreator;

import java.io.*;

import static tk.diamondbuildz.util.filecreator.Reference.*;

public class Main {
    private static File fileHome = new File("C:\\FileCreator\\");
    public static void main(String[] args) {
        try {
            System.out.println("Enter Y to start");
            java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String YS = in.readLine();
            if (YS.equals("Y")) {
                in.close();
                System.out.println("Starting");
                startup();
                run();
                System.out.println("Done");
            }
            else {
                System.out.println("Canceling");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void run() throws IOException {
        for (String letter : letters) {

            var1 = letter;

            for (String color : colors) {

                var2 = color;
                File file = new File("C:\\FileCreator\\" + letter + "_" + var10 + "_" + color + ".json");
                file.createNewFile();
                System.out.println("Created " + file.getName());
                updateStrings();
                writeFile(file);
            }
        }
    }

    private static void writeFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        System.out.println("Wrote to " + file.getName());

        bw.close();
    }

    private static void startup() {
        if (!fileHome.exists()) fileHome.mkdir();
        else {
            fileHome.delete();
            System.out.println("Deleted " + fileHome.getName());
            fileHome.mkdir();
        }
        System.out.println("Created " + fileHome.getName());
    }
    
    private static void updateStrings() {
        line1 = "{";
        line2 = "  \"variants\": {";
        line3 = "    \"facing=south\": { \"model\": \"character_mod:"+var1+"_concrete_"+var2+"\", \"y\": 0 },";
        line4 = "    \"facing=west\": { \"model\": \"character_mod:"+var1+"_concrete_"+var2+"\", \"y\": 90 },";
        line5 = "    \"facing=north\": { \"model\": \"character_mod:"+var1+"_concrete_"+var2+"\", \"y\": 180 },";
        line6 = "    \"facing=east\": { \"model\": \"character_mod:"+var1+"_concrete_"+var2+"\", \"y\": 270 },";
        line7 = "  }";
        line8 = "}";

        lines[0] = line1;
        lines[1] = line2;
        lines[2] = line3;
        lines[3] = line4;
        lines[4] = line5;
        lines[5] = line6;
        lines[6] = line7;
        lines[7] = line8;
    }
}