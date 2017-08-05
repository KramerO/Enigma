package Enigma;

import java.util.*;


public class Enigma2
{

  public final static StringBuffer rotorI      = new StringBuffer("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
  public final static StringBuffer rotorII     = new StringBuffer("AJDKSIRUXBLHWTMCQGZNPYFVOE");
  public final static StringBuffer rotorIII    = new StringBuffer("BDFHJLCPRTXVZNYEIWGAKMUSQO");
  public final static StringBuffer rotorIV     = new StringBuffer("ESOVPZJAYQUIRHXLNFTGKDCMWB");
  public final static StringBuffer rotorV      = new StringBuffer("VZBRGITYUPSDNHLXAWMJQOFECK");
  public final static StringBuffer rotorVI     = new StringBuffer("JPGVOUMFYQBENHZRDKASXLICTW");
  public final static StringBuffer rotorVII    = new StringBuffer("NZJHGRCXMYSWBOUFAIVLPEKQDT");
  public final static StringBuffer rotorVIII   = new StringBuffer("JPGVOUMFYQBENHZRDKASXLICTW");

  public static final StringBuffer reflectorB  = new StringBuffer("YRUHQSLDPXNGOKMIEBFZCWVJAT");
  public static final StringBuffer reflectorC  = new StringBuffer("FVPJIAOYEDRZXWGCTKUQSBNMHL");
  public static final StringBuffer reflector0  = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

  public StringBuffer firstRotor;
  public StringBuffer firstRotorT = new StringBuffer(reflector0.toString());
  public StringBuffer secondRotor;
  public StringBuffer secondRotorT = new StringBuffer(reflector0.toString());
  public StringBuffer thirdRotor;
  public StringBuffer thirdRotorT = new StringBuffer(reflector0.toString());
  public StringBuffer reflector;

  public char[] plugBoard = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

  public final static StringBuffer[] notches = {new StringBuffer("Q"),new StringBuffer("E"),new StringBuffer("V"),new StringBuffer("J"),
  	new StringBuffer("Z"),new StringBuffer("Z"),new StringBuffer("Z"),new StringBuffer("Z")};
  
  //CURRENT ROTOR NOTCHES
  private StringBuffer n1;
  private StringBuffer n2;
  
   
  public Enigma2(String r1, String r2, String r3, String r)
  {
    firstRotor = getValue(r1)[0];
    n1 = getValue(r1)[1];
    secondRotor = getValue(r2)[0];
    n2 = getValue(r2)[1];
    thirdRotor = getValue(r3)[0];
    reflector = getValue(r)[0];
  }
  
  
  public void setFirstRotor(String r1){
  	firstRotor = getValue(r1)[0];
    n1 = getValue(r1)[1];
  }

 
  public void setSecondRotor(String r2){
  	secondRotor = getValue(r2)[0];
    n2 = getValue(r2)[1];
  }
  
   
  public void setThirdRotor(String r3){
  	thirdRotor = getValue(r3)[0];
  }
  
  
  public void initialSettings(String s1, String s2, String s3){
    int p;

	//First Rotor
	p = firstRotorT.toString().indexOf(s1);
	firstRotorT.append(firstRotorT.substring(0,p));
	firstRotorT.delete(0,p);
    
    //Second Rotor
	p = secondRotorT.toString().indexOf(s2);
	secondRotorT.append(secondRotorT.substring(0,p));
	secondRotorT.delete(0,p);
    
    //Third Rotor
	p = thirdRotorT.toString().indexOf(s3);
	thirdRotorT.append(thirdRotorT.substring(0,p));
	thirdRotorT.delete(0,p);
  }

  
  public void setPlugBoard(char x, char y){
    for(int i=0; i<plugBoard.length; i++){
      if(plugBoard[i] == x)
        plugBoard[i] = y;
      else if(plugBoard[i] == y)
        plugBoard[i] = x;
    }
  }

  
  public boolean setPlugBoard(String str){
    String s;
    StringTokenizer tokenCheck = new StringTokenizer(str, " ");
    while(tokenCheck.hasMoreTokens()){
      s = tokenCheck.nextToken();
      if (s.length() != 2)
        return false;
      if(s.charAt(0)>90 || s.charAt(0)<65 || s.charAt(1)>90 || s.charAt(1)<65)
        return false;
    }

    StringTokenizer token = new StringTokenizer(str, " ");
    while(token.hasMoreTokens()){
      s = token.nextToken();
      if(s.length()==2)
        setPlugBoard(s.charAt(0), s.charAt(1));
      else
        return false;
    }
    return true;
  }

  
  public StringBuffer[] getValue(String v){
  	StringBuffer[] result = new StringBuffer[2];
    if (v.equals("RotorI") || v.equals("1")){
    	result[0] = rotorI;
    	result[1] = notches[0];
    	return result;
    	} 
    if (v.equals("RotorII")|| v.equals("2")){
    	result[0] = rotorII;
    	result[1] = notches[1];
    	return result;
    	} 
    if (v.equals("RotorIII")|| v.equals("3")){
    	result[0] = rotorIII;
    	result[1] = notches[2];
    	return result;
    	} 
    if (v.equals("RotorIV")|| v.equals("4")){
    	result[0] = rotorIV;
    	result[1] = notches[3];
    	return result;
    	} 
    if (v.equals("RotorV")|| v.equals("5")){
    	result[0] = rotorV;
    	result[1] = notches[4];
    	return result;
   		 } 
    if (v.equals("RotorVI")|| v.equals("6")){
    	result[0] = rotorVI;
    	result[1] = notches[5];
    	return result;
    	} 
    if (v.equals("RotorVII")|| v.equals("7")){
    	result[0] = rotorVII;
    	result[1] = notches[6];
    	return result;
    }
    if (v.equals("RotorVIII")|| v.equals("8")){
    	result[0] = rotorVIII;
    	result[1] = notches[7];
    	return result;
    }
    if (v.equals("ReflectorB")){
    	result[0] = reflectorB;
    	result[1] = new StringBuffer("");
    	return result;
    } 
    if (v.equals("ReflectorC")){
    	result[0] = reflectorC;
    	result[1] = new StringBuffer("");
    	return result;
    } 
    if (v.equals("No Reflector")){
    	result[0] = reflector0;
    	result[1] = new StringBuffer("");
    	return result;
    } 
    return new StringBuffer[]{new StringBuffer("ERROR"), new StringBuffer("")};
  }

  
  public char rotorOne(char l){
    int position = firstRotorT.toString().indexOf(l);
    return firstRotor.charAt(position);
    
  }

  
  public char rotorTwo(char l){
    int position = secondRotorT.toString().indexOf(l);
    return secondRotor.charAt(position);
  }

  
  public char rotorThree(char l){
    int position = thirdRotorT.toString().indexOf(l);
    return thirdRotor.charAt(position);
  }

  
  public char reflector(char l){
    int position = (int)l - 65;
    l = reflector.charAt(position);
    return l;
  }

  
  public char IrotorOne(char l){
    int position = firstRotor.toString().indexOf(l);
    return firstRotorT.charAt(position);
  }

  
  public char IrotorTwo(char l){
    int position = secondRotor.toString().indexOf(l);
    return secondRotorT.charAt(position);
  }

  
  public char IrotorThree(char l){
    int position = thirdRotor.toString().indexOf(l);
    return thirdRotorT.charAt(position);
  }

  
   public void rotate(){
   	StringBuffer currentR1 = new StringBuffer(firstRotorT.charAt(0)+"");
   	StringBuffer currentR2 = new StringBuffer(secondRotorT.charAt(0)+"");
   
   	//Rotate first rotor
    firstRotorT.append(firstRotorT.charAt(0));
    firstRotorT.delete(0, 1);

    //if first rotor is at notch
    if (currentR1.toString().equals(n1.toString())){
    	//then also rotate second rotor
     	secondRotorT.append(secondRotorT.charAt(0));
     	secondRotorT.delete(0, 1);
     	
     	//if second rotor is at notch
     	if(currentR2.toString().equals(n2.toString())){
     		//then also rotate the third rotor
     		thirdRotorT.append(thirdRotorT.charAt(0));
     		thirdRotorT.delete(0, 1);
     		}
     	}
   	}

  	
   public char plugBoard(char c){
     int i = (int)(c) - 65;
     return plugBoard[i];
   }

  
   public char getFRSetting(){
     return firstRotorT.charAt(0);
   }

  
   public char getSRSetting(){
     return secondRotorT.charAt(0);
   }

  
   public char getTRSetting(){
     return thirdRotorT.charAt(0);
   }


  
  public String encrypt(String p){
     p = p.toUpperCase();
     String e = "";
     char c;
     int k;
     
     for(int i=0; i<p.length(); i++){
       c = p.charAt(i);
       
       if (c<=90 && c>=65){
           rotate();
           
           c = plugBoard(c);
           
           c = rotorOne(c);
           
           c = rotorTwo(c);
           
           c = rotorThree(c);
           
           c = reflector(c);
           
           c = IrotorThree(c);
           
           c = IrotorTwo(c);
           
           c = IrotorOne(c);
           
           c = plugBoard(c);
           
           e = e + c;
       }
       
       else if(c==32)
           e = e + c;
           
       else
         return null;
     }
     
        return e;
  }

  public boolean pbParser(String str){
    if(str.length()<=0 || str.equals(null) || str == null){
      return true;
    }
    
    for(int i=0; i<str.length()-1; i++){
      if(str.charAt(i)>90 || str.charAt(i)<65)
        i++;
      else if(str.substring(i+1).indexOf(str.charAt(i)) != -1)
        return false;
    }
    
    return true;
  }
  

  }

