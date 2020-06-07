package app.util;

import java.io.*;
import java.util.List;

public class CSVWriter {

    private static CSVWriter instance;

    private CSVWriter() {
    }

    public static CSVWriter getInstance() {
        if (instance == null) {
            instance = new CSVWriter();
        }
        return instance;
    }

    public static void writeToFile(List<String> values) {
        try {
            FileWriter outPut = new FileWriter("output.csv");
            for (String str : values) {
                outPut.append(str + "\n");
            }
            /*When using a FileWriter always make sure you flush and close the stream. This improves the performance
            of the IO operation and indicates that there is no more data to be written to the output stream.*/
            outPut.flush();
            outPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
