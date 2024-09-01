package SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Run2_DeserializationTest 
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./textFile.txt"); //convert the same file to object
		ObjectInputStream InStrm = new ObjectInputStream(fis);
		//InStrm.readObject(); Deserialize
		
		//Downcasting - converting back to the original obj - received using the same class
		gamerDetails gmdObj =(gamerDetails) InStrm.readObject();
		
		System.out.println(gmdObj.name);
		System.out.println(gmdObj.level);
		
		
		System.out.println(gmdObj.score);
		System.out.println(gmdObj.life);
	}
}
