# Steps to successfully run the Bank Application Project

I. SQL Commands
    1. To connect to your derby database
	  CONNECT 'jdbc:derby:your specific pathanem;create=true;user=yourusername;password=yourpassword';
	  //Now create employee table
	2. create table bankemployee(empid varchar(30) primary key,empname varchar(30) not null,eusername varchar(30) not null,epassword varchar(30) not null);
	//autopopulated employee data:
	insert into bankemployee values('987654','ram','ram1','ram12');
	insert into bankemployee values('12345678','ramesh','ramesh12','ramesh1234');
	//now create customer table
	3. create table customer1(cust_id integer primary key,cust_name varchar(30) not null,address varchar(30) not null,phone varchar(30) not null,email varchar(25) not null,pan varchar(20) not null,dob varchar(30) not null,secem varchar(30),secph varchar(30));
    insert into customer1 values(12345678,'rajesh','sec1','9876543210','raj@r.com','X240','09/09/1986','raj1@r.com','0123456789');
	
	//now create table account
	4. create table account1(accounttype varchar(30) not null,curbal integer not null,minbal integer not null,overdraft integer,open_date date not null,cust_id integer not null,acc_no varchar(30) not null);
      
	  insert into account1 values('savings',50000,10000,0,'08/21/2020',12345678,'123456789123456789');
	  //now create table trans
    5. create table trans(transid bigint not null,accountid varchar(30) not null,typeoftrans varchar(30) not null,transdatetime varchar(30) not null,remarks varchar(30) not null); 

    6. create table login(username varchar(30) not null,password varchar(30) not null,last_login timestamp not null,custid integer not null);
	

//Program running info
    The step is super easy,you just need to right click and run the CodeFuryy project folder by clicking run on server and you will be directed to Home.html page where you have varoius options like employee login,customer registration and open account.Customer can choose options as per wish and play with software on localhost and perform operations as all pages and interlinked and interface is super smooth.
