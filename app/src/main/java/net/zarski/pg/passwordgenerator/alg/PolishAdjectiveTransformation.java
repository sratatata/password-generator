package net.zarski.pg.passwordgenerator.alg;

public class PolishAdjectiveTransformation
{
	public String transform(String adj, PolishNounAnalysis.Kind kind)
	{
		String newAdjForm;
		if (adj.endsWith("ski") && 
			kind.equals(PolishNounAnalysis.Kind.NONE)
			)
		{
			return adj.replace("ski", "skie");
		}
		else if (adj.endsWith("cki") && 
				 kind.equals(PolishNounAnalysis.Kind.NONE)
				 )
		{
			return adj.replace("cki", "ckie");
		} else if (adj.endsWith("dzki") && 
				   kind.equals(PolishNounAnalysis.Kind.NONE)
				   )
		{
			return adj.replace("dzki", "dzkie");
		}
		else if (adj.endsWith("ski") && 
				 kind.equals(PolishNounAnalysis.Kind.MALE))
		{
			return adj;		   

		}
		else
		{
			newAdjForm = adj.substring(0, adj.length() - 1);
			newAdjForm = newAdjForm.concat(kind.getSufix());
		}
		return newAdjForm;
	}
}
