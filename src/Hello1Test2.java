import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Hello1Test {

	@Test
	public void testGenerateNewText() throws IOException {
		Hello1 Hello1= new Hello1();
		Hello1.InitMain("c:/Users/Administrator/Desktop/AHHW.txt");
		String result = Hello1.generateNewText("where ad");
		assertEquals("where ad",result);
	}
}

