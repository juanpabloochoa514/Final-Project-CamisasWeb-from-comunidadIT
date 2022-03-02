package repositories;

import ModelShirt.Shirt;

public interface ShirtsRepository {

	void addNewShirt(Shirt shirts);
	
	void  ShirtDiscount(Shirt shirts);
	
	void modifyExisting(Shirt shirts);
	//void modifyExistingShirtDiscount(Shirt shirts);

	void deleteByIndex(int index);
	
	void deleteallshirts();

	void deleteById(int id);

	Shirt[] getAll();
	void obtenerTodo();

}