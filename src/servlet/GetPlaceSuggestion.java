package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baidu.GetSuggestionJson;
import baidu.GetSuggestionJsonResponse;
import baidu.PlaceSuggestionServiceStub;

/**
 * Servlet implementation class GetPlaceSuggestion
 */
@WebServlet("/GetPlaceSuggestion")
public class GetPlaceSuggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPlaceSuggestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		String query=request.getParameter("query");
		
		try {
			PlaceSuggestionServiceStub stub=new PlaceSuggestionServiceStub();
			GetSuggestionJson para=new GetSuggestionJson();
			GetSuggestionJsonResponse resp;
			
			para.setQuery(query);
			resp=stub.getSuggestionJson(para);
			String jsonReturn=resp.get_return();
			
			OutputStream out = response.getOutputStream();
			out.write(jsonReturn.getBytes("UTF-8"));
		    System.out.println(jsonReturn);
		    out.flush();
			out.close();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
