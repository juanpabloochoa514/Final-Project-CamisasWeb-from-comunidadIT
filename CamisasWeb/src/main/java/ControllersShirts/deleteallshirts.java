package ControllersShirts;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModelShirt.Shirt;
import repositories.Common;

@WebServlet("/deleteallshirts")
public class deleteallshirts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleteallshirts() {
        super();
        
    }

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Writer writer = response.getWriter();	
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			Common.shirtsRepository.deleteallshirts();
			writer.append("La camisas fueron eleminadas en su totalidad ");
			writer.append("<a href='index.html'>Volver al menu</a>");
		}catch(Exception e){
			writer.append("ERROR OF SERVER" + e);
			
		}
	}

}
