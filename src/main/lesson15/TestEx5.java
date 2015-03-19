package main.lesson15;

import java.io.IOException;

/**
 * Created by NaNLagger on 19.03.15.
 *
 * @author Stepan Lyashenko
 */
public class TestEx5 {

    public static void main(String args[]) {
        try {
            System.out.println(Lesson15.fileToString("lesson8_1.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
