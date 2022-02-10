package ControllersShirts;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ModelShirt.Shirt;
import repositories.Common;

/**
 * Servlet implementation class AddShirt
 */
@WebServlet("/AddShirt")
public class AddShirt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddShirt() {
        // TODO Auto-generated constructor stub
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceparam = request.getParameter("price");
		String idparam = request.getParameter("id");
		
		String date=request.getParameter("dateoff"); 
		Writer writer = response.getWriter();
		
		try {
			int id = Integer.parseInt(idparam);
			int price = Integer.parseInt(priceparam);
			String shirtDate="2021-12-24";
			//String descuento="HAY DESCUENTO!";
			//String discount=Objects.equals(date,shirtDate)?"HAY DESCUENTO!":" NO HAY DESCUENTO";
			Shirt shirts = new Shirt(name,price,id);//OBJETO CAMISA
			
			if(Objects.equals(date,shirtDate)) {
				
				Common.shirtsRepository.ShirtDiscount(shirts);//EN CASO DE SER TRUE QUE AGREGUE EN LA DB UN DESCUENTO.
			}
			else {
			
				Common.shirtsRepository.addNewShirt(shirts);
			}
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<a href='index.html'>Volver al menu</a>");
		}catch(Exception e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			writer.append("ERROR DEL SERVIDOR");
		}
	}

}
