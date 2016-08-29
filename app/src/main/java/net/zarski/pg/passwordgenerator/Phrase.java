package net.zarski.pg.passwordgenerator;

/**
 * Created by lb_lb on 27.08.16.
 */
public class Phrase {
    private final String noun;
    private final String adjective;

    public Phrase(String noun, String adjective) {
        this.noun = noun;
        this.adjective = adjective;
    }

    public String getNoun() {
        return noun;
    }

    public String getAdjective() {
        return adjective;
    }

    @Override
    public String toString(){
        return adjective+" "+noun;
    }
}
