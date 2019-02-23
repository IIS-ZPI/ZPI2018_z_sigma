import org.junit.runner.JUnitCore;

public class MainTest {
	
	public static void main(String[] args) {
		
		// Main Test Class
		
		JUnitCore.runClasses(MenuTestSuite.class);
		JUnitCore.runClasses(TableCurrencyTestSuite.class);
		JUnitCore.runClasses(StatisticalMeasuresTestSuite.class);

		
	}

}
