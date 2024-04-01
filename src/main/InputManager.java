package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputManager {

    public ArrayList<String> getFileContents(String path) {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> input = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
            return input;
        } catch (Exception e) {
            return null;
        }
    }
}
