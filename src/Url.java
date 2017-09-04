import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Url 
{
	{	
		try
		{
			URL goo = new URL("http://www.google.com");
			BufferedReader  reader = new BufferedReader(new InputStreamReader(goo.openStream()));
			boolean done = false;
			while (!done)
			{
				String line = reader.readLine();
				if(line == null)
				{
					break;
				}
				System.out.println(line);
				reader.close();
				done = false;
			}
		}
		catch (Exception ex)
		{
			System.out.println("Excess denied : " + ex);
		}


	}

	public static void main(String[] args)
	{
		Url  k = new Url();
	}
}

