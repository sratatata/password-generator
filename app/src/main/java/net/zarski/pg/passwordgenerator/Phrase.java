package net.zarski.pg.passwordgenerator;
import net.zarski.pg.passwordgenerator.alg.*;

/**
 * Created by lb_lb on 27.08.16.
 */
public class Phrase {
    private final String noun;
    private final String adjective;
	private final PolishNounAnalysis.Kind kind;
	
    public Phrase(String noun, String adjective) {
        this.noun = noun;
		PolishNounAnalysis pna = new PolishNounAnalysis();
		this.kind = pna.calculateKind(noun);
        this.adjective = adjective;
    }

    public String getNoun() {
        return noun;
    }

    public String getAdjective() {
        return adjective;
    }
	
	public String getTransformedAdjective(){
		PolishAdjectiveTransformation pat = new PolishAdjectiveTransformation();
		String newAdj = pat.transform(adjective, kind);
		return newAdj;
	}
	
	public String getCamelCase(String s1, String s2){
		return s1 + s2.substring(0,1).toUpperCase() + s2.substring(1, s2.length());
		
	}

    @Override
    public String toString(){
		String result = String.format(
			"Adj: %s, Noun: %s = \n\n%s",
			 getAdjective(),
			 getNoun(),
			 getCamelCase(getTransformedAdjective(), getNoun())); 
        return result;
    }
}
