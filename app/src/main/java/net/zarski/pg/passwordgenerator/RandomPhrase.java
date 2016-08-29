package net.zarski.pg.passwordgenerator;

/**
 * Created by lb_lb on 27.08.16.
 */
public class RandomPhrase {
    final private RandomWord noun;
    final private RandomWord adjecticve;

    public RandomPhrase(RandomWord noun, RandomWord adjecticve) {
        this.noun = noun;
        this.adjecticve = adjecticve;
    }

    public Phrase next(){
        return new Phrase(noun.getWord(), adjecticve.getWord());
    }

}
