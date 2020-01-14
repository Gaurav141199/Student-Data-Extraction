
public class MyHashTable<K , T> implements MyHashTable_<K, T> {
	
    private int TABLE_SIZE;
    private int hashtablesize; 
    private Object<K, T>[] table;
    
   
    
    //constructor
    public MyHashTable(int ts) 
    {
        hashtablesize = 0;
        TABLE_SIZE = ts;
        table = new Object[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;     
    }
	
    
    // insert function returning no. of times double hashing works
    public int insert(K key, T obj) {
		int i =1;
        long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        long hash2 = sdbm( ((Pair)key).fname + ((Pair)key).lname ,TABLE_SIZE );
	        while (table[(int)hash1] != null)
	        {
	            hash1 += hash2;
	            hash1 %= TABLE_SIZE;
	            i++;
	        }
	        if(table[(int)hash1]==obj) {
	        	System.out.println("E");
	        	return 0;
	        }
	        Object<K,T> hi = new Object<K,T>(key , obj);
	        table[(int)hash1]= hi ;       
	        hashtablesize++;
		return i;
        
	}
    // insert checked
	
    
    
    public int update(K key, T obj) {
    	if (contains(key)) {
        long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        long hash2 = sdbm( ((Pair)key).fname + ((Pair)key).lname ,TABLE_SIZE ); 
        int i =1;
        while(i<TABLE_SIZE) {
        	if(table[(int) hash1] == null) {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
                i++;
        	}
        	else {
                if (!table[(int) hash1].key.toString().equals(key.toString())) {
                    hash1 += hash2;
                    hash1 %= TABLE_SIZE;
                    i++;
                }
                else {
                    Object<K,T> hi = new Object<K,T>(key , obj);
                    table[(int) hash1] = hi;
                    break;
                }
        	}
        }
		return i;
    	}
    	else {
    		System.out.println("E");
    		return 0;
    	}
	}
    //update checked
	
    
    
    public int delete(K key) {
    	if(contains(key)) {
        long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        long hash2 = sdbm( ((Pair)key).fname + ((Pair)key).lname ,TABLE_SIZE ); 
        int i =1;
        while(i<TABLE_SIZE) {
        	if(table[(int) hash1] == null) {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
                i++;
        	}
        	else {
                if (!table[(int) hash1].key.toString().equals(key.toString())) {
                    hash1 += hash2;
                    hash1 %= TABLE_SIZE;
                    i++;
                }
                else {
                    table[(int) hash1] = null;
                    break;
                }
        	}
        }
		return i;
    	}
    	else {
    		System.out.println("E");
    		return 0 ;
    	}
	}

	//delete checked
    
    
    
    public boolean contains(K key) {
        long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        long hash2 = sdbm( ((Pair)key).fname + ((Pair)key).lname ,TABLE_SIZE ); 
        int i =1;
        while(i<TABLE_SIZE) {
        	if(table[(int) hash1] == null) {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
                i++;
        	}
        	else {
                if (!table[(int) hash1].key.toString().equals(key.toString())) {
                    hash1 += hash2;
                    hash1 %= TABLE_SIZE;
                    i++;
                }
                else {
                	return true;
                }
        	}
        }
		return false;
	}
    // contains checked
    
    
    
    public String address(K key) throws NotFoundException {
    	try {
    	if(contains(key)) {
        long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        long hash2 = sdbm( ((Pair)key).fname + ((Pair)key).lname ,TABLE_SIZE ); 
        int i =1;
        while(i<TABLE_SIZE) {
        	if(table[(int) hash1] == null) {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
                i++;
        	}
        	else {
                if (!table[(int) hash1].key.toString().equals(key.toString())) {
                    hash1 += hash2;
                    hash1 %= TABLE_SIZE;
                    i++;
                }
                else {
                    return String.valueOf((int)hash1);
                }
        	}
        }
    	}
    	else {
    		throw new NotFoundException();
    	}
    	}
		catch (NotFoundException e)
		{
			System.out.println("E");
			return null;
		}
		return null;
	}
	
	public T get(K key) throws NotFoundException {
		try
		{
		if(contains(key)) {
        long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        long hash2 = sdbm( ((Pair)key).fname + ((Pair)key).lname ,TABLE_SIZE );
        int i = 1;
        while(i<TABLE_SIZE) {
        	if(table[(int) hash1] == null) {
                hash1 += hash2;
                hash1 %= TABLE_SIZE;
                i++;
        	}
        	else {
                if (!table[(int) hash1].key.toString().equals(key.toString())) {
                    hash1 += hash2;
                    hash1 %= TABLE_SIZE;
                    i++;
                }
                else {
                    return table[(int)hash1].obj;
                }
        	}
        }
		}
		else {
			throw new NotFoundException();
		}
		}
		catch (NotFoundException e)
		{
			System.out.println("E");
			return null;
		}
		return null;
	}
	
	
	
	
	
	
	
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}

	public static long sdbm(String str, int hashtableSize) { 
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	

}
