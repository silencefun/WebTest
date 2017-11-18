package CityService;

import java.util.List;

import been.CityBeen;

public interface  CityService {
	 public List<CityBeen> getAllCitys();  
	 public CityBeen getCityByid(String id);  
	 public List<CityBeen> getCitysByPage(String pagenum,String datanum); 
}
