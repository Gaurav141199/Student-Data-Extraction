
public class BSTHash<K,T> implements MyHashTable_<K,T>{
	

	private BST<K,T>[] table;
    private int TABLE_SIZE;
    private int hashtablesize; 
    
    
    public BSTHash(int ts) 
    {
        hashtablesize = 0;
        TABLE_SIZE = ts;
        table = new BST[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = new BST();     
    }
	
    
    
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	
	
	public int insert(K key, T obj) {
		long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
//		System.out.println("hash value is "+ hash1);
		int h =table[(int)hash1].insert(key, obj);
		return h;
	}

	
	public int update(K key, T obj)  {
		long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        int i =(table[(int)hash1]).update(key, obj) ; 
		return i;
	}

	
	public int delete(K key) {
		long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        return table[(int)hash1].delete(key);
	}

	
	public boolean contains(K key) {
		long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        return table[(int)hash1].contains(key) ; 
		
	}

	
	public T get(K key) throws NotFoundException {
		long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
        return table[(int)hash1].get(key);
		
	}

	
	public String address(K key) throws NotFoundException {
		long hash1 = djb2( ((Pair)key).fname + ((Pair)key).lname , TABLE_SIZE );
		String line = table[(int)hash1].address(key);
		if (line != "hi")
		return hash1 + "-" + table[(int)hash1].address(key);
		else
			return "hi";	}
	
	
	
	

}
