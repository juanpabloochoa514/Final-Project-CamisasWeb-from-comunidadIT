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

/**
 * Servlet implementation class discountOpcionalShirts
 */
@WebServlet("/discountOpcionalShirts")
public class discountOpcionalShirts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public discountOpcionalShirts() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Shirt[] shirtarray = Common.shirtsRepository.getAll();
    	
		response.setContentType("text/html;charset=UTF-8");
		Writer writer  = response.getWriter();
		
		//writer.append("<h1>Cantidad de camisas "+shirtarray.length+"</h1>");
		
		//String maxQuantityParam = request.getParameter("max-quantity");
		
		//int maxQuantity = shirtarray.length;
		
		
		
		for (int index = 0; index < shirtarray.length; index++) {
			Shirt shirts = shirtarray[index];
			
			writer.append("<li><em><b>Código identificador: " + shirts.getId()  + "  , Descripción:  " + shirts.getName() + " , precio:  " + shirts.getPrice()+" , cantidad :" + shirts.getCant() + "</b></li></em>");
			writer.append("<p>_____________________________________________________________________________________________________________________________</p>");

			writer.append("<br>");
			writer.append("<br>");
		}
		
		writer.append("<!DOCTYPE html>");
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<link rel=\"stylesheet\" href=\"TotalApagar.css\"/>");
		writer.append("</head>");
		writer.append("<body style=\"\r\n"
				+ "    background-image: url('cool2.png');\r\n"
				+ "    background-size:cover;\r\n"
				+ "    font-family: 'Roboto', sans-serif;\r\n"
				+ "    text-align: center;\r\n"
				+ "\"></body>");
		
		writer.append("<br>");
		writer.append("<a href='index.html'>Volver al menú principal</a>");
		writer.append("</body>");
		writer.append("</html>");
		response.setStatus(HttpServletResponse.SC_OK);
	
    }
    
    	
   
}
