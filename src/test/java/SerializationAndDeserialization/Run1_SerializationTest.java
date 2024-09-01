package SerializationAndDeserialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class gamerDetails implements Serializable
{
	String name;
	int level;
	long score;
	int life;
	
	public gamerDetails(String name,int level,long score,int life)
	{
		this.name=name;
		this.level=level;
		this.score=score;
		this.life=life;
	}
}

public class Run1_SerializationTest 
{
	public static void main(String[] args) throws Throwable
	{
		gamerDetails gmd = new gamerDetails("Shiny",5,43554,3);
				
		FileOutputStream fos = new FileOutputStream("./textFile.text");
		
		ObjectOutputStream OutStrm = new ObjectOutputStream(fos);
		OutStrm.writeObject(gmd);
		
		System.out.println("======END=====");
		
	}
}
