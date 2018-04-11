package com.sapient.usecases;

import java.util.Scanner;


/*Design a Call Center.
Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). 
There can be multiple employees, but only one TL or PM. An incoming telephone call    must be  allocated to a fresher who is free. 
If a fresher can’t handle the call, he or she must escalate the call to technical lead. If the TL is not free or not able to handle it, 
then the call should be escalated to PM*/

abstract class CustomerService{
	String name;
	String designation;
	CustomerService higherAuthority = null;
	abstract void transferToLead();
	abstract void takeComplaint();
}

class CustomerExecutive extends CustomerService{

	CustomerExecutive(String name, String designation){
		this.name = name;
		this.designation=designation;
	}
	@SuppressWarnings("resource")
	void takeComplaint(){

		Scanner scanner= new Scanner(System.in);
		System.out.println("Name : "+name+" Designation :"+ designation);
		System.out.println("Complaint please : ");
		System.out.print("Satisfied with resolution : ");
		String response = scanner.next();
		if(response.equals("NO")){
			System.out.print("Want to speak with higher authority: ");
			response = scanner.next();
			if(response.equals("YES")){
				transferToLead();
			}
		}
	}
	void transferToLead(){
		higherAuthority.takeComplaint();
	}
}

class LeadExecutive extends CustomerService{

	LeadExecutive(String name, String designation){
		this.name = name;
		this.designation=designation;
	}
	@SuppressWarnings("resource")
	void takeComplaint(){

		System.out.println("Name : "+name+" Designation :"+ designation);
		Scanner scanner= new Scanner(System.in);
		System.out.println("Complaint please : ");
		System.out.print("Satisfied with resolution : ");
		String response = scanner.next();
		if(response.equals("no"))
		{
			System.out.print("Want to speak with higher authority: ");
			response = scanner.next();
			if(response.equals("yes"))
			{
				transferToLead();
			}
		}
	}
	void transferToLead(){
		higherAuthority.takeComplaint();
	}
}

class ManagerExecutive extends CustomerService{

	ManagerExecutive(String name, String designation){
		this.name = name;
		this.designation=designation;
	}

	@SuppressWarnings("resource")
	void takeComplaint(){

		System.out.println("Name : "+name+" Designation :"+ designation);
		Scanner scanner= new Scanner(System.in);
		System.out.print("Satisfied with resolution : ");
		String response = scanner.next();
		if(response.equals("no")){

			System.out.print("Want to speak with my higher authority: ");
			response = scanner.next();
			if(response.equals("yes")){

				transferToLead();
			}
		}
	}

	//No need to transfer again it's already highest to the heirarchy
	void transferToLead(){
	}
}

public class CallCentreChainOfResponsibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService level1 = new CustomerExecutive("Susmit", "CustomerExecutive");
		CustomerService level2 = new LeadExecutive("Babloo", "LeadExecutive");
		CustomerService level3 = new ManagerExecutive("Akash", "ManagerExecutive");
		level1.higherAuthority = level2;
		level2.higherAuthority = level3;
		level1.takeComplaint();
	}
}





