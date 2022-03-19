package studentCRUDOperation;
import java.io.*;
import java.sql.Connection;
public class StudentCRUD {

	public static void main(String args[]) throws Exception {
		int choice=-1;
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 DBConnection con =  new DBConnection();
		do {
			System.out.println("1. INSERT");
			System.out.println("2. DISPLAY ALL");
			System.out.println("3. SEARCH");
			System.out.println("4. UPDATE");
			System.out.println("5. DELETE");
			System.out.println("0. EXIT");
			System.out.println("Enter Your Choice : ");
			choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
				System.out.println("Enter how many student you want : ");
				  int n = Integer.parseInt(br.readLine());
				  
				  for(int i=0;i<n;i++) {
					  System.out.println("Enter Student Number : ");
					  int sno = Integer.parseInt(br.readLine());
					  
					  System.out.println("Enter Student Name : ");
					  String sname = br.readLine();
					  
					  System.out.println("Enter Student Date of Birth : ");
					  int dob = Integer.parseInt(br.readLine());
					  
					  System.out.println("Enter Student Date of Joining : ");
					  int doj = Integer.parseInt(br.readLine());
					  
					  con.insert(sno, sname, dob, doj);
				  }
				  
			break;
			case 2: 
				con.display();
			break;
			case 3:
				System.out.println("Enter Student Number to Search : ");
				  int sno = Integer.parseInt(br.readLine());
				  con.search(sno);
			break;
			case 4:
				System.out.println("Enter Student Number to Update : ");
				   sno = Integer.parseInt(br.readLine());
				  
				  System.out.println("Enter New Name : ");
				  String sname = br.readLine();
				  
				  System.out.println("Enter New Date of Birth : ");
				  int dob = Integer.parseInt(br.readLine());
				  
				  System.out.println("Enter New Date of Joining");
				  int doj = Integer.parseInt(br.readLine());
				con.update(sno,sname,dob,doj);
			break;
			case 5:
				System.out.println("Enter Student Number to Delete : ");
				 sno = Integer.parseInt(br.readLine());
				 con.delete(sno);
			break;
				  
			case 0:
				 con.close();
				 System.out.println("Thanks....!");
			break;		
			}
			
		}while(choice!=0);

		
		 		
				
	}
}
