package CityService;

import java.util.List;

import been.CityBeen;

public class CityServiceImpl implements CityService{

	@Override
	public List<CityBeen> getAllCitys() {
		// TODO Auto-generated method stub
		return CityBusiness.getAllStudents();
	}

	@Override
	public CityBeen getCityByid(String id) {
		// TODO Auto-generated method stub
		return CityBusiness.getStudentInfoById(id);
	}

	@Override
	public List<CityBeen> getCitysByPage(String pagenum, String datanum) {
		// TODO Auto-generated method stub
		return CityBusiness.getStudentsBypage(pagenum, datanum);
	}

}
