package repositories;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import DB.ConcreteDBMSHandler;
import DB.DbFacade;
import ModelShirt.Shirt;

public class DataBaseShirtsRepository implements ShirtsRepository  {

	private DbFacade dbFacade;
	
	public DataBaseShirtsRepository() throws SQLException {
		ConcreteDBMSHandler dbmsHandler = new ConcreteDBMSHandler();
		dbmsHandler.startup();
		this.dbFacade = new DbFacade(dbmsHandler);
	}
	
	@Override
	public void addNewShirt(Shirt shirts) {
		int id = 0;	
		try {
			String insertionQuery = "INSERT INTO shirts(id,price, name,cantidad) VALUES ("+shirts.getId()+" ,"+ shirts.getPrice()+",'"+shirts.getName()+"',"+shirts.getCant()+");";                     
			id = dbFacade.executeInsertionQuery(insertionQuery);
			shirts.setId(id);
		} catch (SQLException e) {
			System.err.println("Error al insertar: " + e.getMessage());
		}
	}
	
	public void ShirtDiscount(Shirt shirts) {
		int id = 0;
		int Discounts$=0;
		Discounts$= (shirts.getPrice())-((shirts.getPrice() * 30)/100);
		
		try {
			String insertionQuery = "INSERT INTO shirts(id,price,name) VALUES ("+shirts.getId()+" , "+ Discounts$+",'"+shirts.getName()+"');";                     
			id = dbFacade.executeInsertionQuery(insertionQuery);
			shirts.setId(id);
		} catch (SQLException e) {
			System.err.println("Error al insertar: " + e.getMessage());
		}
	}
	@Override
	public void modifyExisting(Shirt shirts) {
		try {
			String updateQuery = "UPDATE shirts SET price = "+ shirts.getPrice()+", cantidad ="+shirts.getCant()+", name='"+shirts.getName()+"' WHERE id = "+shirts.getId()+";";                   
			int value = dbFacade.executeDeleteOrUpdateQuery(updateQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al actualizar: " + e.getMessage());
		}
	}
	/*
	public void modifyExistingShirtDiscount(Shirt shirts) {
		int discount=0;
		discount=(shirts.getPrice())-((shirts.getPrice() * 30)/100);
		try {
			String updateQuery = "UPDATE shirts SET price = "+ discount+", name='"+shirts.getName()+"' WHERE id = "+shirts.getId()+";";                   
			int value = dbFacade.executeDeleteOrUpdateQuery(updateQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al actualizar: " + e.getMessage());
		}
	}
	*/
	@Override
	public void deleteByIndex(int index) {
		throw new RuntimeException("Metodo deleteByIndex no implementado para DataBase");
	}

	@Override
	public void deleteById(int id) {
		try {
			String deletionQuery = "delete from shirts WHERE id = " + id;
			int value = dbFacade.executeDeleteOrUpdateQuery(deletionQuery);
			System.out.println("Resultado: " + value);
		} catch (SQLException e) {
			System.err.println("Error al borrar: " + e.getMessage());
		}
	}
	@Override
	public void deleteallshirts () {
		try {
			String deletionQuery = "delete from shirts";
			int value = dbFacade.executeDeleteOrUpdateQuery(deletionQuery);
			System.out.println("Resultado: " + value);
		}catch(Exception e) {
			System.err.println("Error al borrar: " + e.getMessage());
		}
	}
	
	@Override
	public Shirt[] getAll() {
		try {
			List<HashMap<String,Object>> rows = this.dbFacade.executeQueryReturningSet("SELECT * FROM  shirts");
			int rowCount = rows.size();
		    Shirt[] shirtarray = new Shirt[rowCount];
			for (int i = 0; i < rows.size(); i++) {
				Shirt shirt = toShirt(rows.get(i));
				shirtarray[i] = shirt;
			}
			return shirtarray;
		} catch(Exception e) {
			System.err.println("Error al recuperar: " + e.getMessage());
			return new Shirt[0];
		}
	}
	
	public void obtenerTodo() {
		try {
			List<HashMap<String,Object>> rows = this.dbFacade.executeQueryReturningSet("SELECT (id,name,price) FROM shirts");
		}catch(Exception e) {
			System.err.println("Error al recuperar: " + e.getMessage());
		
		}
		
	}
	
	public Shirt toShirt(HashMap<String, Object> valueByColumnName) {
		int id = (Integer) valueByColumnName.get("id");
		String name = (String) valueByColumnName.get("name");
		int priceStr = (Integer) valueByColumnName.get("price");
		int cantStr=(Integer)valueByColumnName.get("cantidad");
		//String DescStr = (String) valueByColumnName.get("description");
		//int price = Integer.parseInt(priceStr);
		
		Shirt shirt = new Shirt(name,priceStr,id,cantStr);
		return shirt;
	}
	
}
