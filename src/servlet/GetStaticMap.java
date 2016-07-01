package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

import javax.activation.DataHandler;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baidu.GetImg;
import baidu.GetImgResponse;
import baidu.StaticMapServiceStub;

/**
 * Servlet implementation class GetStaticMap
 */
@WebServlet("/GetStaticMap")
public class GetStaticMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStaticMap() {
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
		String placeId=request.getParameter("placeId");
		String latitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		//System.out.println(latitude+","+longitude);
		
		try {
			StaticMapServiceStub stub=new StaticMapServiceStub();
			GetImg para=new GetImg();
			GetImgResponse resp;
			
			para.setLatitude(latitude);
			para.setLongitude(longitude);
			resp=stub.getImg(para);
			DataHandler dataH=resp.get_return();
			if (dataH==null){
				String jsonReturn="{\"flag\":\"0\"}";
				
				OutputStream out = response.getOutputStream();
				out.write(jsonReturn.getBytes("UTF-8"));
			    System.out.println(jsonReturn);
			    out.flush();
				out.close();
				return;
			}
			byte[] data=new byte[dataH.getInputStream().available()];
			dataH.getInputStream().read(data);
			
			//servlet所在项目的路径
			ServletContext servletContext = getServletContext();
			String realPath = servletContext.getRealPath("/");
			System.out.println(realPath);
			String filePath=realPath+"\\staticMap_"+placeId+".png";
			File imageFile = new File(filePath);
		    //创建输出流
		    FileOutputStream outStream;
			try {
				outStream = new FileOutputStream(imageFile);
		        //写入数据
		        outStream.write(data);
		        //关闭输出流
		        outStream.flush();
		        outStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}  
			
			String jsonReturn="{\"flag\":\"1\"}";
			
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
