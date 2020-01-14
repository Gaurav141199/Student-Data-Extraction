
public class Node<K,T> {
T obj;
K key;
Node<K,T> left , right  ;
public Node(K key,T obj) {
	this.obj= obj;
	this.key=key;
	left = null;
	right = null;
}
}
