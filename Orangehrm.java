package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.projects.generic.Baseclasses.Base1;

public class Orangehrm extends Base1
{
	@Test
	public void Login()
	{
		Reporter.log("Login Successfully in OrangeHRM",true);
	}		
}
