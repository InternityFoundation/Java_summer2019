
public class employee {
	
private int empid;
private String name;
private date dob;

public employee()
{ 
	empid=1;
    name="abc";
    dob=new date();
}
public employee(int id,String n,int d,int m,int y){
	empid=id;
	name=n;
	dob=new date(d,m,y);
}

public void display() {
	System.out.println(empid);
	System.out.println(name);
	dob.display();

}
}
