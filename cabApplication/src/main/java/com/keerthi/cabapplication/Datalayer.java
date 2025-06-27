package com.keerthi.cabapplication;

import java.util.*;

import model.*;

public class Datalayer {
	
	  private static Datalayer datalayer;
	  
	  public static Datalayer getInstance() {
		  if(datalayer==null)
			  datalayer=new Datalayer();
		  
		  return datalayer;
	  }
	
	  List<Customers> customerList=new ArrayList<>();
	  
	  List<Drivers> driverList=new ArrayList<>();
	  
	  List<Location> locationList=new ArrayList<>();
	  
	  Datalayer() {
		  Customers customer1=new Customers();
		  customer1.setId(1);
		  customer1.setName("ww");
		  customer1.setPassword("55");
		  customer1.setAge(55);
		  customerList.add(customer1);
		  
		  Customers customer2=new Customers();
		  customer2.setId(2);
		  customer2.setName("xx");
		  customer2.setPassword("66");
		  customer2.setAge(36);
		  customerList.add(customer2);
		  
		  Customers customer3=new Customers();
		  customer3.setId(3);
		  customer3.setName("yy");
		  customer3.setPassword("77");
		  customer3.setAge(31);
		  customerList.add(customer3);
		  
		  Customers customer4=new Customers();
		  customer4.setId(4);
		  customer4.setName("zz");
		  customer4.setPassword("88");
		  customer4.setAge(28);
		  customerList.add(customer4);
		  
		  
		  Drivers driver1=new Drivers();
		  driver1.setId(1);
		  driver1.setName("aaa");
		  driver1.setPassword("111");
		  driver1.setAge(55);
		  driverList.add(driver1);
		  
		  Drivers driver2=new Drivers();
		  driver2.setId(2);
		  driver2.setName("bbb");
		  driver2.setPassword("222");
		  driver2.setAge(36);
		  driverList.add(driver2);
		  
		  Drivers driver3=new Drivers();
		  driver3.setId(3);
		  driver3.setName("ccc");
		  driver3.setPassword("333");
		  driver3.setAge(31);
		  driverList.add(driver3);
		  
		  Drivers driver4=new Drivers();
		  driver4.setId(4);
		  driver4.setName("ddd");
		  driver4.setPassword("444");
		  driver4.setAge(28);
		  driverList.add(driver4);
		  
		  Location location1=new Location();
		  location1.setId(1);
		  location1.setlocationName('A');
		  location1.setDistance(0);
		  location1.setCabId(4);
		  locationList.add(location1);
		  
		  Location location3=new Location();
		  location3.setId(3);
		  location3.setlocationName('C');
		  location3.setDistance(4);
		  locationList.add(location3);
		  
		  Location location2=new Location();
		  location2.setId(2);
		  location2.setlocationName('B');
		  location2.setDistance(15);
		  locationList.add(location2);
		  
		  Location location4=new Location();
		  location4.setId(4);
		  location4.setlocationName('D');
		  location4.setDistance(7);
		  location4.setCabId(1);
		  locationList.add(location4);
		  
		  
		  Location location5=new Location();
		  location5.setId(5);
		  location5.setlocationName('R');
		  location5.setDistance(23);
		  locationList.add(location5);
		  
		  Location location6=new Location();
		  location6.setId(6);
		  location6.setlocationName('F');
		  location6.setDistance(9);
		  locationList.add(location6);
		  
		  
		  Location location7=new Location();
		  location7.setId(7);
		  location7.setlocationName('G');
		  location7.setDistance(18);
		  location7.setCabId(2);
		  locationList.add(location7);
		  
		  Location location8=new Location();
		  location8.setId(8);
		  location8.setlocationName('H');
		  location8.setDistance(20);
		  location8.setCabId(3);
		  locationList.add(location8);
	  }
	  
	  
	  public List<Customers> getAllCustomers() {
		  return customerList;
	  }
	  
	  public List<Drivers> getAllDrivers() {
		  return driverList;
	  }
	  
	  
	  public void printCustomer() {
		    System.out.println("id"+" "+"name"+" "+"password"+" "+"age");
			for(Customers customer:customerList)
				System.out.println(customer.getId()+" "+customer.getName()+" "+customer.getPassword()+" "+customer.getAge());
		}
		
		public void printDriver() {
			 System.out.println("id"+" "+"name"+" "+"password"+" "+"age");
			for(Drivers driver:driverList)
				System.out.println(driver.getId()+" "+driver.getName()+" "+driver.getPassword()+" "+driver.getAge());
		}
		
		public void printLocation() {
			 System.out.println("id"+" "+"location-name"+" "+"Distance");
			for(Location location:locationList)
				System.out.println(location.getId()+" "+location.getlocationName() +" "+location.getDistance());
		}
		
		
		public void printInitialLocation() {
			 System.out.println("location-name"+" "+"cabId");
				for(Location location:locationList)
					if(location.getCabId()!=0)
					System.out.println(location.getlocationName() +" "+location.getCabId() );
		}


		public boolean checkCustomer(String username,String password) {
			for(Customers customer:customerList) {
				if(customer.getName().equals(username) && customer.getPassword().equals(password))
					return true;
			}
			
			return false;
		}


		public void bookCab(char source, char destination) {
			int distance=0,cabId=0;
			for(Location location:locationList) {
				if(source==location.getlocationName())
					distance=location.getDistance();
			}
			
			int min=Integer.MAX_VALUE;
			for(Location location:locationList) {
				if(location.getDistance()-distance<min) {
					min=location.getDistance()-distance;
					cabId=location.getCabId();
				}
			}
			
		    updateCount(cabId);
		    System.out.println("Your cab booked successfully"+"\n Your cab id is:"+cabId +"\n your cost is:"+distance*10);
			
		}


		private void updateCount(int cabId) {
			for(Drivers list:driverList) {
				if(list.getId()==cabId)
					list.setCabcount((list.getCabcount())+1);
			}
				
		}
	  
}
