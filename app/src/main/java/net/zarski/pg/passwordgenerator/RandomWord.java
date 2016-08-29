package net.zarski.pg.passwordgenerator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by lb_lb on 27.08.16.
 */
public class RandomWord implements Iterable<String> {
    private ArrayList<String> words = new ArrayList();
    Random random = new Random(System.nanoTime());
    public RandomWord(InputStream stream) throws IOException {
        InputStreamReader r = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(r);
        String line;
        while((line = br.readLine()) != null){
            words.add(line);
        }

    }

    public String getWord(){
        return randomWord();
    }

    private String randomWord(){
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public String next() {
                return getWord();
            }

            @Override
            public void remove() {
                //do nothing
            }
        };
    }
}
