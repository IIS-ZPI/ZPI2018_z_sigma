import org.junit.runner.JUnitCore;

public class MainTest {
	
	public static void main(String[] args) {
		
		// Main Test Class
		
		JUnitCore.runClasses(TestSuite.class);
		// Tests for class PeriodOfTime
		JUnitCore.runClasses(PeriodOfTimeTestSuite.class);
		// Tests for class TableCurrency
		JUnitCore.runClasses(TableCurrencyTestSuite.class);
		
	}

}
