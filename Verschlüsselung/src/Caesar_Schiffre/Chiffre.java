package Caesar_Schiffre;

public class Chiffre {

	public String messege;
	
	
	public Chiffre(){
		
	}
	
	public void setMessege(String txt){
		this.messege = txt;
	}
	
	public char[] caesarChiffre(int gape){
		char[] temp = this.messege.toCharArray();
		char[] retTemp = new char[temp.length];
		
		gape = gape +55;
		for(int i=0; i<temp.length; i++){
			int val = Character.getNumericValue(temp[i])+gape;
			char[] t = Character.toChars(val);
			retTemp[i] = t[0];
		}
		
		return retTemp;
	}
		
}

