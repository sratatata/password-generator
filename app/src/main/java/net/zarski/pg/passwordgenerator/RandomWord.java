package net.zarski.pg.passwordgenerator;

import java.io.*;
import java.util.*;

/**
 * Created by lb_lb on 27.08.16.
 */
public class RandomWord implements Iterable<String>
{
    private final List<String> words;

	Random random = new Random(System.nanoTime());

	public RandomWord(InputStream stream) throws IOException
	{
		words  = new ArrayList<>();

		loadAllWordsToMemmory(stream, new OnWord() {
				@Override
				public void onWord(String word)
				{
					words.add(word);
				}
			});
    }

	private void loadAllWordsToMemmory(InputStream stream, OnWord onWord) throws IOException
	{
		InputStreamReader r = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(r);
        String line;
        while ((line = br.readLine()) != null)
		{
			onWord.onWord(line);
        }
	}

	private static interface OnWord
	{
		void onWord(String word);
	}

    public String getWord()
	{
        return randomWord();
    }

    private String randomWord()
	{
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    @Override
    public Iterator<String> iterator()
	{
        return new Iterator<String>() {
            @Override
            public boolean hasNext()
			{
                return true;
            }

            @Override
            public String next()
			{
                return getWord();
            }

            @Override
            public void remove()
			{
                //do nothing
            }
        };
    }
}
