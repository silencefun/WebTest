
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CityService.CityServiceImpl;
import been.CityBeen;
import been.ListObject;
import been.SingleObject;
import cons.StatusHouse;
import utils.JackJsonUtils;
import utils.ResponseUtils;

/**
 * Servlet implementation class CityServleet
 */
@WebServlet("/CityServleet")
public class CityServleet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CityServleet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		switch (action) {
		case "all":

			List<CityBeen> list = new CityServiceImpl().getAllCitys();
			ListObject listObject = new ListObject();
			listObject.setItems(list);
			listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
			String responseText = JackJsonUtils.toJson(listObject);
			ResponseUtils.renderJson(response, responseText);

			break;
		case "id":
			CityBeen city = new CityServiceImpl().getCityByid("1");
			SingleObject object = new SingleObject();
			object.setStatusObject(StatusHouse.COMMON_STATUS_OK);

			object.setObject(city);
			ResponseUtils.renderJson(response, JackJsonUtils.toJson(object));
			break;
		case "page":
			String page = request.getParameter("page");
			String num = request.getParameter("num");

			List<CityBeen> list2 = new CityServiceImpl().getCitysByPage(page, num);
			ListObject listObject2 = new ListObject();
			listObject2.setItems(list2);
			listObject2.setStatusObject(StatusHouse.COMMON_STATUS_OK);
			String responseText2 = JackJsonUtils.toJson(listObject2);
			ResponseUtils.renderJson(response, responseText2);

			break;
		default:
			SingleObject object2 = new SingleObject();
			object2.setStatusObject(StatusHouse.COMMON_STATUS_ERROR_PARAMETER);

			object2.setObject("");
			ResponseUtils.renderJson(response, JackJsonUtils.toJson(object2));
			
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
