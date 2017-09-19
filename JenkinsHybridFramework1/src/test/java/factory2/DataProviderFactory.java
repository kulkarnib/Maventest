package factory2;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfig()
	{
		//to create object of class configdataprovider and returning its object
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		//to create object of class exceldataprovider and returning its object
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
	}

}
