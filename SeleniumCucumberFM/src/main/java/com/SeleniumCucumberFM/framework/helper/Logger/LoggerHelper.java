package com.SeleniumCucumberFM.framework.helper.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;








import com.SeleniumCucumberFM.framework.utility.ResourceHelper;




public class LoggerHelper {
	
	public static boolean root = false;
	public static Logger getLogger(String ClassName)
	{
	if (root=true){
		
	}
	 root=true;
	PropertyConfigurator.configure(ResourceHelper.getResourcePath("src/main/resources/configfile/log4j.properties"));
	//System.out.println(ResourceHelper.getResourcePath("src/main/resources/configfile/log4j.properties"));
	return Logger.getLogger(ClassName);
	//return Logger.getLogger(clas);
	
}
//	public static void main(String[] args)
//	{
//		
//		
//		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/main/resources/configfile/log4j.properties");
//	
//		System.out.println(logger.getAllAppenders());
//		
//}

}
