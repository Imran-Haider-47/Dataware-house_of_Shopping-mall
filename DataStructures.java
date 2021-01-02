package Dataware;
import org.apache.commons.collections4.map.MultiValueMap;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


@SuppressWarnings("deprecation")
public class DataStructures{

	public static void main(String[] args) throws SQLException 
	{
		
		
		ReadTransactions ReadTrans=new ReadTransactions();
		ReadMasterData ReadMaster= new ReadMasterData();
		
		
		ResultSet RTD=ReadTrans.Read_Trans_Data(); // Reads the transactions table
		
		
		DoublyLinkList DLL=new DoublyLinkList();
		//HashTable
		@SuppressWarnings({ "unchecked" })
		MultiValueMap<String, String> orderedMap =  MultiValueMap.multiValueMap(
				                new LinkedHashMap<String, Collection<String>>(), 
				                (Class<LinkedHashSet<String>>)(Class<?>)LinkedHashSet.class);
		
		while (RTD.next())
	     {
	        String PRODUCT_ID = RTD.getString("PRODUCT_ID");
	        String CUSTOMER_ID =RTD.getString("CUSTOMER_ID");
	        String CUSTOMER_NAME = RTD.getString("CUSTOMER_NAME"); 
			String STORE_ID = RTD.getString("STORE_ID");
			String STORE_NAME = RTD.getString("STORE_NAME");
			Date T_DATE = RTD.getDate("T_DATE"); 
			int QUANTITY = RTD.getInt("QUANTITY");
	       
			// Add the Product id to the head of the doubly linked list
			DLL.push(PRODUCT_ID);
			
			// Also add the transactions data to the has table
			//before that convert all the values to the String
			
			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			String date = df.format(T_DATE); // date has been converted to string
			String quantity=String.valueOf(QUANTITY);
			
			orderedMap.put(PRODUCT_ID,CUSTOMER_ID);
			orderedMap.put(PRODUCT_ID,CUSTOMER_NAME);
			orderedMap.put(PRODUCT_ID,STORE_ID);
			orderedMap.put(PRODUCT_ID,STORE_NAME);
			orderedMap.put(PRODUCT_ID,date);
			orderedMap.put(PRODUCT_ID,quantity);
			
	     }
		//System.out.println("The Product ids in the Linked list are : ");
		
		//	DLL.printLinkedlist();
		
		
		
		Iterator<String> mapIterator = orderedMap.keySet().iterator();
		
		// iterate over the map
		while (mapIterator.hasNext()) 
		{
			String key = mapIterator.next();
			System.out.println("key:" + key + ", values=" + orderedMap.get(key));
			
			Collection<String> values = orderedMap.getCollection(key);
			
			
			// iterate over the entries for this key in the map
			for(Iterator<String> entryIterator = values.iterator(); entryIterator.hasNext();) {
				String value = entryIterator.next();
				
				System.out.println("    value:" + value);
			}
		
		}
		
		
		
		
		//Read the Last Product id from the Doubly Linked List
		String P_ID=DLL.Get_Last(); //P_ID is product id 
		
		StringTokenizer multiTokenizer = new StringTokenizer(P_ID ,"-");
		
		String PID = null;
		while (multiTokenizer.hasMoreTokens())
		{
		   PID=multiTokenizer.nextToken();
		}
		int intpid=Integer.parseInt(PID);
		
		int count=0;
		String p1="P-";
		
		
		System.out.println("The Data in the Disk Buffer : ");
		while(count<10)
		{
			String p2=String.valueOf(intpid);
			String Pro_id=p1.concat(p2);
			if(intpid>1099)
			{
				break;
			}
			
			ResultSet rs=ReadMaster.Get_Master_Data(Pro_id);
			while (rs.next())
			{
			  String PRODUCT_ID1 = rs.getString("PRODUCT_ID"); 
			  String PRODUCT_NAME1=rs.getString("PRODUCT_NAME");
			  String SUPPLIER_ID1=rs.getString("SUPPLIER_ID");
			  String SUPPLIER_NAME1=rs.getString("SUPPLIER_NAME");
			  float PRICE1 = rs.getFloat("PRICE");
			  
			  // print the results //
			  System.out.format("%s, %s,  %s, %s, %s \n",
			  PRODUCT_ID1,PRODUCT_NAME1,SUPPLIER_ID1,SUPPLIER_NAME1,PRICE1);
			 
			}
		
			
			intpid++;
			count++;
		}
		
		
		//Don't forget to Close the connections
		
	 }// Main ends here
	
	
}

