import org.junit.runner.JUnitCore;

public class MainTest {
	
	public static void main(String[] args) {
		
		// Main Test Class
		
		JUnitCore.runClasses(MenuTest.class);
		JUnitCore.runClasses(TableCurrencyTest.class);
		JUnitCore.runClasses(StatisticalMeasuresTest.class);

		
	}

}
