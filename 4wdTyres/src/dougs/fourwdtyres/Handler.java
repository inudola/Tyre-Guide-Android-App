package dougs.fourwdtyres;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Handler extends SQLiteOpenHelper {
	
	private static final String DEBUG_TAG= "DOUGIOS";

	@SuppressWarnings("unused")
	private static final int DATABASE_VERSION = 4;
	@SuppressWarnings("unused")
	private static final String DATABASE_NAME = "dougstyres.db";
	private static final String TABLE_PRODUCTS = "products";
	private static final String TABLE_USERS = "users";

	@SuppressWarnings("unused")
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_TYPE = "type";
	private static final String COLUMN_SIZE = "size";
	@SuppressWarnings("unused")
	private static final String COLUMN_NAME = "name";
	@SuppressWarnings("unused")
	private static final String COLUMN_BRAND = "brandname";
	@SuppressWarnings("unused")
	private static final String COLUMN_PRICE = "price";
	

	private static final String COLUMN_USER = "usernames";
	private static final String COLUMN_USEREMAIL = "email";
	
	
	public Handler(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		this.onCreate(db);
	}
	


	public void onCreate(SQLiteDatabase db) {
	//	db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
	//	db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		
		String CREATE_PRODUCTS_TABLE = "CREATE TABLE products ( " +
				"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"type TEXT," +
				"size TEXT," +
				"name TEXT," +    // "name TEXT )";		
				"brandname TEXT, " +
				"price INTEGER )";
		
		
		String CREATE_USERS_TABLE = "CREATE TABLE users ( " +
				"usernames TEXT," +
				"email TEXT )";
		
		db.execSQL(CREATE_PRODUCTS_TABLE);
		db.execSQL(CREATE_USERS_TABLE);
		
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('1', 'Mud Terrain', '31', 'Maxxis', 'BuckShot', '375');"); // , 'mmaxxis.png'
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('2', 'Highway Terrain', '31', 'Cooper', 'Discoverer', '134');"); 
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('3', 'All Terrain', '31', 'BF Goodrich', 'AO', '269');"); 
		
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('4', 'Mud Terrain', '33', 'Treppidor', 'Slinger', '455');"); 
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('5', 'Highway Terrain', '33', 'Maxxis', 'Bravo', '189');"); 
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('6', 'All Terrain', '33', 'Mickey Thompson', 'ATZ', '299');"); 
		
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('7', 'Mud Terrain', '35', 'Symex', 'Silverstone', '410');"); 
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('8', 'Highway Terrain', '35', 'BF Goodrich', 'KO', '209');"); 
		db.execSQL("INSERT INTO " + TABLE_PRODUCTS + " VALUES ('9', 'All Terrain', '35', 'Maxxis', 'At 980', '300');"); 
	}
	
	public Tyres findProduct(String type, String size) {
			String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_TYPE + " = \"" + type + "\" AND " + COLUMN_SIZE + " = \"" + size + "\""; // + "\""
			 
			
			SQLiteDatabase db = this.getWritableDatabase();
			
			Cursor cursor = db.rawQuery(query, null);
		
			Tyres product = new Tyres();

			if (cursor.moveToFirst()){
				try {
				//	cursor.moveToFirst();
					product.setID(Integer.parseInt(cursor.getString(0)));
					product.setName(cursor.getString(1));
					product.setSize(cursor.getString(2));
					product.setType(cursor.getString(3));
					product.setBrandName(cursor.getString(4));
					product.setPrice(Integer.parseInt(cursor.getString(5)));
					
					cursor.close();
				} catch (Exception e) {
					Log.e(DEBUG_TAG, "A FUCK UP", e);
					e.printStackTrace();
				}
			} else {
				product = null;
			}
			db.close();
			return product;
		
			
	
		}
	
	
	public void addUser(Users user){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_USER, user.getName());
		values.put(COLUMN_USEREMAIL, user.getEmail());
		
		
		
		db.insert(TABLE_USERS, null, values);
		db.close();
	}




	






}
