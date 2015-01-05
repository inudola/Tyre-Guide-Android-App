package dougs.fourwdtyres;

import android.graphics.drawable.Drawable;

public class Tyres {
	
	private int _id;
	private String _type;
	private String _size;
	private String _name;
	private String _brandname;
	private int _price;
//	private byte[] _picDataDraw;
	
	public Tyres() {
		
	}
	
	public Tyres(int id, String type, String size, String name, String brandname, int price){ // , byte[] picdata
		this._id = id;
		this._type = type;
		this._size = size;
		this._name = name;
		this._brandname = brandname;
		this._price = price;
//		this._picDataDraw = picdata;
	}
	
	public Tyres(String name, String size){
		this._name = name;
		this._size = size;
	}
	
	public void setID(int id){
		this._id = id;
	}
	
	public int getID(){
		return this._id;
	}
	
	public void setName(String name){
		this._name = name;
	}
	
	public String getName(){
		return this._name;
	}
	
	public void setSize(String string){
		this._size = string;
	}
	
	public String getSize(){
		return this._size;
	}
	
	public void setType(String type){
		this._type = type;
	}
	
	public String getType(){
		return this._type;
	}
	
	public void setBrandName(String brandname){
		this._brandname = brandname;
	}
	
	public String getBrandName(){
		return this._brandname;
	}
	
	public void setPrice(int price){
		this._price = price;
	}
	
	public int getPrice(){
		return this._price;
	}
	
//	public void setPicData(byte[] picdata){
//		this._picDataDraw = picdata;
//	}
	
//	public byte[] getPicData(){
//		return this._picDataDraw;
//	}
//
//	public void setPicData(byte[] picdata) {
//		this._picDataDraw = picdata;
//		
//	}
//	
	



	 
	

}
