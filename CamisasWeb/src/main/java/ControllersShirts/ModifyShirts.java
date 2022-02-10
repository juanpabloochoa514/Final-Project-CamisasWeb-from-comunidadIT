package ControllersShirts;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModelShirt.Shirt;
import repositories.Common;
/**
 * Servlet implementation class ModifyShirts
 */
@WebServlet("/ModifyShirts")
public class ModifyShirts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyShirts() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceParam = request.getParameter("price");
		String idParam = request.getParameter("id");
		String dateparameter = request.getParameter("datediscount");
		//String descriptionparam=request.getParameter("description");
		Writer writer = response.getWriter();
		try {
			String shirtDateoff="2021-12-24";
			int price = Integer.parseInt(priceParam);
			int id = Integer.parseInt(idParam);
			Shirt shirts = new Shirt(name,price,id);
			if(Objects.equals(dateparameter,shirtDateoff)) {
				Common.shirtsRepository.modifyExistingShirtDiscount(shirts);
			}else {
				Common.shirtsRepository.modifyExisting(shirts);
			}
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<div>"
					+	 "Se ha Modificado la camisa con id " +shirts.getId()+ ", Con nombre =  " + shirts.getName() + " Con precio = " + shirts.getPrice()
					+ "</div>");
			writer.append("<a href='index.html'>Volver a menu principal</a>");
		}catch(Exception e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
