package CityService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import been.CityBeen;
import db.DbHelper;

public class CityBusiness {
	 /** 
     * 获取所有数据 
     * @return 
     */  
    public static List<CityBeen> getAllStudents() {  
        List<CityBeen> list = new ArrayList<CityBeen>();//list对象  
        String sql = null;  
        DbHelper db1 = null;  
        sql = "select * from city";// SQL  
        db1 = new DbHelper(sql);//创建DBHelper对象  
        ResultSet ret = null;//创建结果集对象，执行sql后返回的数据集合  
        try {  
            ret = db1.pst.executeQuery();//这个方法就类似于执行了SELECT语句一样！  
            while (ret.next()) {  
                String id = ret.getString(1);//第一列是id  
                String name = ret.getString(2);//第二列是name  
                String CountryCode = ret.getString(3);//第三列是CountryCode  
                String District = ret.getString(4);//第四列是District  
                String     p= ret.getString(5);//第四列是Population 
                CityBeen city = new CityBeen();//创建city对象  
                city.setID(id);//设置id  
                city.setName(name);//设置name  
                city.setCountryCode(CountryCode);//设置CountryCode  
                city.setDistrict(District);//设置District 
                city.setPopulation(p);//设置District 
                
                list.add(city);//将city对象放置到列表中  
            } //循环从结果集中获取数据并设置到list列表对象中  
            ret.close();//关闭对象  
            db1.close();//关系数据库连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } //  
  
        return list;//返回结果  
    }  
  
    
   /**
    * 查询某一页
    * @param page
    * @param num
    * @return
    */
    public static List<CityBeen> getStudentsBypage(String pagenum,String datanum) {  
    	 List<CityBeen> list = new ArrayList<CityBeen>();//list对象  
         String sql = null;  
         DbHelper db1 = null;  
         int page=Integer.parseInt(pagenum);//第几页
         int num=Integer.parseInt(datanum);//一页数量
         int start=(page-1)*num ;
         sql = "select * from city limit "+start+","+num;// SQL  
         db1 = new DbHelper(sql);//创建DBHelper对象  
         ResultSet ret = null;//创建结果集对象，执行sql后返回的数据集合  
         try {  
             ret = db1.pst.executeQuery();//这个方法就类似于执行了SELECT语句一样！  
             while (ret.next()) {  
                 String id = ret.getString(1);//第一列是id  
                 String name = ret.getString(2);//第二列是name  
                 String CountryCode = ret.getString(3);//第三列是CountryCode  
                 String District = ret.getString(4);//第四列是District  
                 String     p= ret.getString(5);//第四列是Population 
                 CityBeen city = new CityBeen();//创建city对象  
                 city.setID(id);//设置id  
                 city.setName(name);//设置name  
                 city.setCountryCode(CountryCode);//设置CountryCode  
                 city.setDistrict(District);//设置District 
                 city.setPopulation(p);//设置District 
                 
                 list.add(city);//将city对象放置到列表中  
             } //循环从结果集中获取数据并设置到list列表对象中  
             ret.close();//关闭对象  
             db1.close();//关系数据库连接  
         } catch (SQLException e) {  
             e.printStackTrace();  
         } //  
   
         return list;//返回结果  
     }  
    
    
    /** 
     * 通过id来获取某个城市数据 
     * @param _id 
     * @return 
     */  
    public static CityBeen getStudentInfoById(String _id) {  
        String sql = null;  
        DbHelper db1 = null;  
        sql = "select * from city where id =" + _id;// sql  
        db1 = new DbHelper(sql);//创建DBHelper对象  
        ResultSet ret = null;//创建结果集对象  
        CityBeen city = new CityBeen();//创建对象  
        try {  
            ret = db1.pst.executeQuery();//正常来说，这个结果集只有一个对象  
            while (ret.next()) {  
            	   String id = ret.getString(1);//第一列是id  
                   String name = ret.getString(2);//第二列是name  
                   String CountryCode = ret.getString(3);//第三列是CountryCode  
                   String District = ret.getString(4);//第四列是District  
                   String Population= ret.getString(5);//第四列是Population 
                   
                   city.setID(id);//设置id  
                   city.setName(name);//设置name  
                   city.setCountryCode(CountryCode);//设置CountryCode  
                   city.setDistrict(District);//设置District  
                   city.setPopulation(Population);//设置District 
                   
            } //循环从结果集中获取数据并设置到对象中（正常来说，这个循环只执行一次）  
            ret.close();//关闭对象  
            db1.close();//关系数据库连接  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } //   
        return city;//返回结果  
    }  
}
