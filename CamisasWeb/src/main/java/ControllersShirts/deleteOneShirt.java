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
 * Servlet implementation class deleteOneShirt
 */
@WebServlet("/deleteOneShirt")
public class deleteOneShirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public deleteOneShirt() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Writer writer = response.getWriter();
		try {
			int id = Integer.parseInt(idParam);
			Common.shirtsRepository.deleteById(id);
			
			writer.append("<html>");
			writer.append("<head>");
			writer.append("<link rel=\"stylesheet\" href=\"DeleteShirt.css\"/>");
			writer.append("</head>");
			writer.append("<body>");
			writer.append("C?digo identificador  del art?culo: " + id + "    eleminada  ");
			writer.append("<br>");
			writer.append("<a href='index.html'>Volver al men? principal</a>");
			writer.append("</body>");
			writer.append("</html>");
			response.setContentType("text/html;charset=UTF-8");
			response.setStatus(HttpServletResponse.SC_OK);
		}catch(Exception e) {
			writer.append("ERROR OF THE SERVER , SIDE deleteOneShirt" + e);
		}
	}

}
