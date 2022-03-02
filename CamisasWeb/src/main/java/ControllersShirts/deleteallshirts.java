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
			writer.append("<!DOCTYPE html>");
			writer.append("<html>");
			writer.append("<head>");
			writer.append("<link rel=\"stylesheet\" href=\"DAS.css\"/>");
			writer.append("</head>");
			writer.append("<body <body style=\"\r\n"
					+ "    background-image: url('cool2.png');\r\n"
					+ "    background-size: cover;\r\n"
					+ "    font-family: 'Roboto', sans-serif;\r\n"
					+ "    text-align: center;\r\n"
					+ "\"><h1>Todos los  artículos fueron eleminadas en su totalidad</h1><a href=\"index.html\">Volver al menú principal</a></body>>");
			writer.append("</html>");
		}catch(Exception e){
			writer.append("ERROR OF SERVER" + e);
			
		}
	}

}
