import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Student_Data_Extract {
	public static void main(String []args) throws IOException, NotFoundException {
		if (args[1].equals("DH")) {
			MyHashTable table = new MyHashTable(Integer.valueOf(args[0]));
			BufferedReader br = new BufferedReader(new FileReader(args[2]));
			String line ;
			while((line=br.readLine())!= null) {
				String [] arr = line.split(" ");
				Pair p = new Pair (arr[1],arr[2]);
				if (arr[0].equals("insert")) {
					Student stu = new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					int j = table.insert(p, stu);
					if (j!=0)
					System.out.println(j);
				}
				else if (arr[0].equals("delete")) {
					int j = table.delete(p);
					if (j!=0)
					System.out.println(j);
				}
				else if(arr[0].equals("update")) {
					Student stu = new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					int j = table.update(p, stu);
					if(j!=0)
					System.out.println(j);
				}
				else if(arr[0].equals("contains")) {
					boolean bool =table.contains(p);
					if (bool == false)
					System.out.println("F");
					if (bool == true)
						System.out.println("T");
				}
				else if (arr[0].equals("get")){
					if (table.get(p) != null) {
					System.out.println((table.get(p)).toString());
					}
				}
				else if (arr[0].equals("address")){
					String s = table.address(p);
					if(s!=null)
					System.out.println(s);
				}
			}
		}
		
		
		else if (args[1].equals("SCBST")) {
			BSTHash table = new BSTHash(Integer.valueOf(args[0]));
			BufferedReader br = new BufferedReader(new FileReader(args[2]));
			String line ;
			while((line=br.readLine())!= null) {
				String [] arr = line.split(" ");
				Pair p = new Pair (arr[1],arr[2]);
				if (arr[0].equals("insert")) {
					Student stu = new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					int j = table.insert(p, stu);
					if(j!=0) {
					System.out.println(j);
					}
				}
				 if (arr[0].equals("delete")) {
					
					int j = table.delete(p);
					if (j!=0)
					System.out.println(j);
				}
				 if(arr[0].equals("update")) {
					Student stu = new Student(arr[1],arr[2],arr[3],arr[4],arr[5]);
					int j = table.update(p, stu);
					if(j!=0)
					System.out.println(j);
				}
				 if(arr[0].equals("contains")) {
					boolean bool =table.contains(p);
					if (bool == false)
					System.out.println("F");
					if (bool == true)
						System.out.println("T");
				}
				 if (arr[0].equals("get")){
					if (table.get(p) != null) {
					System.out.println((table.get(p)).toString());
					}
				}
				 if (arr[0].equals("address")){
					String s = table.address(p);
					if(s!="hi")
					System.out.println(s);
				}

			
		}
		
		
		
		
	}
}
}
