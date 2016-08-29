package net.zarski.pg.passwordgenerator;

import android.app.Application;
import android.test.ActivityTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by lb_lb on 27.08.16.
 */
public class RandomWordTest  extends ActivityTestCase {

    @Test
    public void testGetWord() throws Exception {
        RandomWord rw = new RandomWord(getNounsData());
        String w1 = rw.getWord();
        String w2 = rw.getWord();
        assertNotNull(w1);
        assertNotNull(w2);
        assertFalse(w1.equals(w2));

    }

    public InputStream getNounsData(){
        return getInstrumentation().getTargetContext().getResources().openRawResource(R.raw.rzeczowniki);
    }
}