--Abhilash Ari final proj
drop table if exists Customer cascade;
drop table if exists Associate cascade;
drop table if exists Purchases cascade;
drop table if exists Product cascade;
drop table if exists Providers cascade;
--creating tables and populating with same datas
CREATE TABLE Customer(
    customer_id varchar(40) ,
    name varchar(40) NOT NULL,
    PRIMARY KEY(customer_id)
);
--Customer
INSERT INTO Customer values ('19832A','John');
INSERT INTO Customer values ('3r8dcs','Becky');
INSERT INTO Customer values ('4ifehi','James');


CREATE TABLE Associate(
    associate_id varchar(40),
    name varchar(40) NOT NULL,
    PRIMARY KEY(associate_id)
);
--Associate
INSERT INTO Associate values('43hy','Mike');
INSERT INTO Associate values('827cycjg','Hawk');
INSERT INTO Associate values ('iruhc','Miles');


CREATE TABLE Providers(
    provider_id varchar(40),
    name varchar(40),
    street_address varchar(40),
    city varchar(40),
    state varchar(2),
    PRIMARY KEY(provider_id)
);
--Providers
INSERT INTO Providers values('98scjnh','Ash','1234 bondai street', 'New york', 'MN');
INSERT INTO Providers values('vtuskhf','Ashley','1234 mike street', 'New Jersey', 'MN');
INSERT INTO Providers values('ve098iew','Ketchup','1234 wescott street', 'Chicago', 'TX');



CREATE TABLE Product(
    categories varchar(40),
    barcode varchar(40),
    description varchar(40),
    weight float,
    provider_id varchar(40),
    PRIMARY KEY(barcode),
    FOREIGN KEY(provider_id) REFERENCES Providers
);
--Product
INSERT INTO Product values ('Grocery',2038389, 'Tomato vegetable', 1.6, '98scjnh');
INSERT INTO Product values ('Apparel', 3272198, 'Nike Jersey Blue',2.4, 'vtuskhf' );
INSERT INTO Product values ('Sports', 203819, 'Hockey stick Oakley 7', 7.3, 've098iew');


CREATE TABLE Purchases(
   barcode varchar(40),
   customer_id varchar(40),
   associate_id varchar(40),
   total_amount float,
   taxes_paid float,
   transaction_number integer,
   timestamp TIMESTAMP not null,
   FOREIGN KEY(associate_id) references Associate,
   foreign key(customer_id) references Customer,
   FOREIGN KEY(barcode) references Product

);
--Purchases
INSERT INTO Purchases values(2038389,'19832A','43hy',12.32,0.89,12313412,now());
INSERT INTO Purchases values(3272198,'3r8dcs','827cycjg',14.72,1.06,7876443,now()-interval '30 Days');
INSERT INTO Purchases values(203819,'4ifehi','iruhc',8.23,0.59,1927397,now());

