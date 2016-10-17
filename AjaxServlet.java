import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tableName = request.getParameter("tableName");
		
		if(tableName != null){
			response.setContentType("text/html");
			response.getWriter().write(generateJSONData(tableName));
		}
		
	}
	
	public String generateJSONData(String tableName) {
		StringBuffer returnData = null;
		
		if(tableName.equals("pomidorowa")){
			
			returnData = new StringBuffer("{\"topic\":{");
			returnData.append("\"name\": \"Pomidorowa\",");
			returnData.append("\"tutorial\": [");
			returnData.append("{\"name\": \"3 pomidory\"},");
			returnData.append("{\"name\": \"rosol\"},");
			returnData.append("{\"name\": \"przeciez pomidorowy\"}]");
			returnData.append("}}");
			
		} else if(tableName.equals("rosol")) {
			
			returnData = new StringBuffer("{\"topic\":{");
			returnData.append("\"name\": \"Rosol\",");
			returnData.append("\"tutorial\": [");
			returnData.append("{\"name\": \"kurczak\"},");
			returnData.append("{\"name\": \"woda\"},");
			returnData.append("{\"name\": \"marchew\"},");
			returnData.append("{\"name\": \"makaron\"}]");
			returnData.append("}}");
			
		} else {
			
			returnData = new StringBuffer("{\"topic\":{");
			returnData.append("\"name\": \"Nieznane danie\",");
			returnData.append("\"tutorial\": [");
			returnData.append("{\"name\": \"Brak skladnikow\"}]");
			returnData.append("}}");
		}
		
		return returnData.toString();
		
	}

}
