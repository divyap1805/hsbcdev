package com.hsbc.banking.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.hsbc.banking.models.Customer;

public class App {

	public static void main(String[] args) {
		List<Customer> customer=new ArrayList<Customer>();
		for(int i=0;i<100;i++) {
			customer.add(new Customer(new Random().nextInt(10000),
					"customer"+i,
					LocalDate.of(1980+new Random().nextInt(10), 1+new Random().nextInt(10) , 1+new Random().nextInt(25) )));
		}
		for(Customer cust :customer) {
			System.out.println(cust.getCustomerId()+" "+cust.getName()+" "+cust.getDob());
		}

	}
	

}
