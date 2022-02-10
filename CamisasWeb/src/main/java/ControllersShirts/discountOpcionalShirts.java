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
		
		int total=0;
		/*
		try {
			maxQuantity = Integer.parseInt(maxQuantityParam);
			if (maxQuantity > shirtarray.length) {
				System.out.println("Se trunco la cantidad a mostrar!");
				maxQuantity = shirtarray.length;
				writer.append("<i><b>Se trunco la cantidad a mostrar!</b></i>");
			}
		} catch (Exception e) {
			System.out.println("Hubo un errocito: " + e);
		}
		*/
		for (int index = 0; index < shirtarray.length; index++) {
			Shirt shirts = shirtarray[index];
			
			writer.append("<li><em><b>Identificador de camisa:  " + shirts.getId()  + "  , nombre:  " + shirts.getName() + " , price:  " + shirts.getPrice()+"</b></li></em>");
			writer.append("<p>_____________________________________________________________________________________________________________________________</p>");
			
			total+=shirts.getPrice();
			writer.append("<br>");
			writer.append("<br>");
		}
		writer.append("<br>");
		writer.append("<br>");
		writer.append("<br>");
		writer.append("<b>TOTAL A PAGAR ==> </b>"+total);
		writer.append("<br>");
		writer.append("<br>");
		writer.append("<br>");
		writer.append("<a href='index.html'>Volver a menu principal</a>");
		
		response.setStatus(HttpServletResponse.SC_OK);
	
    }
    
    	
    /*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Shirt[] shirtarray = Common.shirtsRepository.getAll();
		response.setContentType("text/html;charset=UTF-8");
		Writer writer  = response.getWriter();
		
		writer.append("<h1>Cantidad de camisas "+shirtarray.length+"</h1>");
		
		String maxQuantityParam = request.getParameter("max-quantity");
		
		int maxQuantity = shirtarray.length;
		
		int total=0;
		
		try {
			maxQuantity = Integer.parseInt(maxQuantityParam);
		} catch (Exception e) {
			System.out.println("Error  : " + e);
		}
		
		for (int index = 0; index < maxQuantity; index++) {
			Shirt shirts = shirtarray[index];
			writer.append("En posicion  " + index + "  , shirt identificador:  " + shirts.getId()  + "  , nombre:  " + shirts.getName() + " , price:  " + shirts.getPrice()+", Detalle :"+shirts.getDescription());
			total+=shirts.getPrice();
			writer.append("<br/>");
		}
		
		writer.append("TOTAL A PAGAR == "+total);
		writer.append("<a href='list.html'>Volver</a>");
		
		response.setStatus(HttpServletResponse.SC_OK);	
		
		
	}
	*/
}
