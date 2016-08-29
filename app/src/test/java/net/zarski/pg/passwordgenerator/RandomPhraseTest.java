package net.zarski.pg.passwordgenerator;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lb_lb on 27.08.16.
 */
public class RandomPhraseTest {

    @Test
    public void testNext() throws Exception {
        RandomWord rw = mock(RandomWord.class);
        when(rw.getWord()).thenReturn("projekt", "wspanialy");
        RandomPhrase rp = new RandomPhrase(rw, rw);
        assertEquals("wspanialy projekt", rp.next().toString());
    }


}