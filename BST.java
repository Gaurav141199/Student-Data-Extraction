
public class BST<K,T> {
	private Node<K,T> root;
    
    
    
    
    public int insert(K key , T object)
    {	int i =1;
        if (root == null) {
        	Node node = new Node(key,object);
        	root=node;
        	return i;
        }
        else{
        Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			Pair p = (Pair) parent.key;
			if ((((Pair)key).toString()).compareTo(p.toString()) == 0) {
				System.out.println("E");
				return 0;
			}
			if((((Pair)key).toString()).compareTo(p.toString()) < 0){				
				current = current.left;
				i++;
				if(current==null){
					Node node1 = new Node(key,object);
					parent.left=node1;
					return i;
				}
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) > 0){
				current = current.right;
				i++;
				if(current==null){					
					Node node2 = new Node(key,object);
					parent.right=node2;
					return i;
				}
			}
		}
        }
}
    //insert checked
   
    public boolean contains(K key) {
    	if(root == null) {
    		return false;
    	}
    	else {
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			Pair p = (Pair) parent.key;
			if ((((Pair)key).toString()).equals(p.toString())) {
				return true;
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) <0){				
				current = current.left;
				if(current==null){
					return false;
				}
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) >0){
				current = current.right;
				if(current==null){
					return false;
				}
			}
		} 
    	}
    }
    
    // contains checked
       
    public int update(K key,T obj) {
    	if (contains(key)) {
    	int i =0;
    	if(root == null) {
    		return 0;
    	}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			Pair p = (Pair) parent.key;
			if ((((Pair)key).toString()).equals(p.toString())) {
				i++;
				parent.obj = obj;
				return i;
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) <0){				
				current = current.left;
				i++;
				if(current==null){
					return i;
				}
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) >0){
				current = current.right;
				i++;
				if(current==null){
					return i;
				}
			}
		}
    	}
    	else {
    		System.out.println("E");
    		return 0;
    	}
    	
    }
    //update checked
   
	public T get(K key) throws NotFoundException {
    	try {
	    	if (contains(key)) {
		    	if(root == null) {
		    		throw new NotFoundException();
		    	}
		    	else {
				Node current = root;
				Node parent = null;
					while(true){
						parent = current;
						Pair p = (Pair) (parent.key);
							if ((((Pair)key).toString()).equals(p.toString())) {
								return  (T) parent.obj;
							}
							else if((((Pair)key).toString()).compareTo(p.toString()) <0){				
								current = current.left;
								if(current==null){
									throw new NotFoundException();
								}
							}
							else if((((Pair)key).toString()).compareTo(p.toString()) >0){
								current = current.right;
								if(current==null){
									throw new NotFoundException();
								}
							}
					}
		    	}
    	}
    	else {
    		throw new NotFoundException();
    	}
    	}
    	catch(NotFoundException e) {
    		System.out.println("E");
    		return null;
    	}
	}
	// get checked 	
	
	public String address(K key) throws NotFoundException {
    	try {
    	if (contains(key)) {
    	String line ="";
    	if(root == null) {
    		throw new NotFoundException();
    	}
    	else {
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			Pair p = (Pair) parent.key;
			if ((((Pair)key).toString()).equals(p.toString())) {
				return line;
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) <0){				
				current = current.left;
				line = line +"L";
				if(current==null){
					throw new NotFoundException();
				}
			}
			else if((((Pair)key).toString()).compareTo(p.toString()) >0){
				current = current.right;
				line = line +"R";
				if(current==null){
					throw new NotFoundException();
				}
			}
		}
    	}
    	}
    	else {
    		throw new NotFoundException();
    	}
    	}
    	catch(NotFoundException e) {
    		System.out.println("E");
    		return "hi";
    	}
	}
	// address checked
	int h =1;
	public int delete(K key){
		try {
		if (contains(key)) {


	    Node parent = root;
	    Node current = root;
	    boolean isLeftChild = false;
	    while(!(current.key).toString().equals(key.toString())){
	    h++;
	      parent = current;
	      if(((Pair)(current.key)).toString().compareTo(((Pair)key).toString())>0){
	        isLeftChild = true;
	        current = current.left;
	      }
	      else if(((Pair)(current.key)).toString().compareTo(((Pair)key).toString())<0){
	        isLeftChild = false;
	        current = current.right;
	      }
	      if(current ==null){
	        throw new NotFoundException();
	      }
	    }
	    //if i am here that means we have found the node
	    //Case 1: if node to be deleted has no children
	    if(current.left==null && current.right==null){

	      if(current==root){
	        root = null;
	      }
	      if(isLeftChild ==true){
	        parent.left = null;
	      }else{
	        parent.right = null;
	      }
	    }
	    //Case 2 : if node to be deleted has only one child
	    else if(current.right==null){
	    	h++;
	      if(current==root){
	        root = current.left;
	      }else if(isLeftChild){
	        parent.left = current.left;
	      }else{
	        parent.right = current.left;
	      }
	    }
	    else if(current.left==null){
	    	h++;
	      if(current==root){
	        root = current.right;
	      }else if(isLeftChild){
	        parent.left = current.right;
	      }else{
	        parent.right = current.right;
	      }
	    }else if(current.left!=null && current.right!=null){
	      h++;
	      //now we have found the minimum element in the right sub tree
	      Node successor   = getSuccessor(current);
	      if(current==root){
	        root = successor;
	      }else if(isLeftChild){
	        parent.left = successor;
	      }else{
	        parent.right = successor;
	      }     
	      successor.left = current.left;
	    }   
	    return h;    }
		else {
			throw new NotFoundException();
		}
		}
		catch (NotFoundException e){
			System.out.println("E");
			return 0;
		}
	  }
	
	
	public Node getSuccessor(Node deleleNode){
		h++;
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
	
	
	
	
    
    
    
}
