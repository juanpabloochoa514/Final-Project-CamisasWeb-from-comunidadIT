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
		String cantModr = request.getParameter("cantMod");
		//String descriptionparam=request.getParameter("description");
		Writer writer = response.getWriter();
		try {
			//String shirtDateoff="2021-12-24";
			int price = Integer.parseInt(priceParam);
			int id = Integer.parseInt(idParam);
			int cantMod =Integer.parseInt(cantModr);
			Shirt shirts = new Shirt(name,price,id,cantMod);
			
			Common.shirtsRepository.modifyExisting(shirts);
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<!DOCTYPE html>");
			writer.append("<html>");
			writer.append("<head>");
			writer.append("<link rel=\"stylesheet\" href=\"backgroundinputshirt.css\"/>");
			writer.append("</head>");
			writer.append("<body>");
			writer.append("<div>"
					+	 "Se ha Modificado la camisa con èxito "
					+ "</div>");
			writer.append("<a href='index.html'>Volver al menú principal</a>");
			writer.append("</body>");
			writer.append("</html>");
		}catch(Exception e){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
