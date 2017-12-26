package net.zarski.pg.passwordgenerator.alg;

public class PolishNounAnalysis
{
	public Kind calculateKind(String noun)
	{
		if (
			noun.endsWith("a")
			|| noun.endsWith("ni")
			|| noun.endsWith("dz")
			|| noun.endsWith("sc"))
		{
			return Kind.FEMALE;
		}
		else if (noun.endsWith("e"))
		{
			return Kind.NONE;
		} else if (
			noun.endsWith("ik")
			|| noun.endsWith("ta")
			)
		{ 
			return Kind.MALE;
		}
		return Kind.MALE;
	}

	public static enum Kind
	{
		MALE("y"),
		MALE2("i"),
		FEMALE("a"),
		NONE("e");
		private String sufix;

		public Kind(String sufix){
			this.sufix = sufix;
		}

		public String getSufix(){
			return this.sufix;
		} 
	}
}

