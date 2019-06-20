
public class Account {

	public static int deposite(int amount,int balance)
	{
		balance=balance+amount;
		System.out.println(balance);
		return balance;
	}
	public static int withdrawal(int amount,int balance) throws Exception
	{
		if(balance<amount)
			throw  new Exception("Insufficient balance");
		if(amount<=15000)
		balance=balance-amount;
		if(amount>15000)
			throw new Exception("Overlimit - cannot withdraw morethan 15000");
		System.out.println(balance);
		return balance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int balance=20000;
		System.out.println(balance);
		balance=deposite(20000,balance);
		try
		{
		balance=withdrawal(15000,balance);
		balance=withdrawal(18000,balance);
		balance=withdrawal(15000,balance);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(balance);
	}

}
