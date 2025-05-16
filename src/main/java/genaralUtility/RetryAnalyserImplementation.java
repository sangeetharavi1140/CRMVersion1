package genaralUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count=0;
		int retrycout=2;
		if(count<retrycout)
		{
			count++;
			return true;
		}
		return false;
	}

}
