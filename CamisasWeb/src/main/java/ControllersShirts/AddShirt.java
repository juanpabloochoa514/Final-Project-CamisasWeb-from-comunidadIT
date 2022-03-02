package ControllersShirts;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	//style="margin: auto; width: 100px;"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceparam = request.getParameter("price");
		String idparam = request.getParameter("id");
		String cantParm =request.getParameter("cant");
		//String date=request.getParameter("dateoff"); 
		Writer writer = response.getWriter();
		
		try {
			int id = Integer.parseInt(idparam);
			int price = Integer.parseInt(priceparam);
			int cant = Integer.parseInt(cantParm);
			//String shirtDate="2022-12-24";
			/*
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate;
			startDate = df.parse(date);
		    String newDateString = df.format(startDate);
		    System.out.println(newDateString);
		    */
			Shirt shirts = new Shirt(name,price,id,cant);//OBJETO CAMISA
			/*
			if(Objects.equals(date,shirtDate)) {
				
				Common.shirtsRepository.ShirtDiscount(shirts);//EN CASO DE SER TRUE QUE AGREGUE EN LA DB UN DESCUENTO.
			}
			else {
			
				Common.shirtsRepository.addNewShirt(shirts);
			}
			*/
			Common.shirtsRepository.addNewShirt(shirts);
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<!DOCTYPE html>");
			writer.append("<html>");
			writer.append("<head>");
			writer.append("<link rel=\"stylesheet\" href=\"backgroundinputshirt.css\"/>");
			writer.append("</head>");
			writer.append("<body>");
			writer.append("<p>artículo ingresado con Èxito</p>");
			writer.append("<a href='index.html'>Volver al menú principal</a>");
			writer.append("</body>");
			writer.append("</html>");
			
		}catch(Exception e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			writer.append("ERROR DEL SERVIDOR");
			e.printStackTrace();
		}
	}

}
