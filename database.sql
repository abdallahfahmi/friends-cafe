CREATE DATABASE Cafe;
use Cafe;

CREATE TABLE Items(
	Item_ID int Auto_Increment,
	Name varchar(30) unique not null,
	Price double not null,
	Quantity int not null,
	Expire_date varchar(10) not null,
	Item_type varchar(10) not null,
	PRIMARY key(Item_ID)
);

CREATE TABLE Orders(
	Order_ID int Auto_Increment,
	Order_date varchar(30) not null,
	Order_amount double not null,
	PRIMARY key(Order_ID)
);

CREATE TABLE Items_Orders(
	Order_ID int not null REFERENCES Orders(Order_ID),
	Item_ID int not null REFERENCES Items(Item_ID),
	Num_of_Items int not null
);
/*
INSERT INTO Orders(Order_ID, Order_date, Order_amount) values ('1','2018-08-10', '230');
INSERT INTO Orders(Order_ID, Order_date, Order_amount) values ('2','2018-08-11', '240');
INSERT INTO Orders(Order_ID, Order_date, Order_amount) values ('3','2018-08-12', '250');

INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items) values ('1','1', '1');
INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items) values ('1','2', '1');
INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items) values ('2','3', '1');
INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items) values ('1','4', '1');
INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items) values ('3','26', '1');
INSERT INTO Items_Orders(Order_ID, Item_ID, Num_of_Items) values ('3','27', '1');*/

INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('1','Tea','15','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('2','Green Tea','17','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('3','Black Coffee','20','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('4','Espresso','20','25','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('5','Double Espresso','29','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('6','Latte','30','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('7','Vanilla Latte','35','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('8','Caramel Latte','35','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('9','Cappuccino','25','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('10','Mocha','27','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('11','Macchiatto','28','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('12','Hot Chocolate','26','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('13','Nescafe','24','66','20/3/2018','hot_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('14','Pepsi','20','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('15','Coke','20','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('16','Diet Coke','20','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('17','Sprite','20','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('18','Water','12','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('19','Red Bull','32','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('20','Iced Coffee','35','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('21','Orange Juice','33','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('22','Strawberry Juice','33','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('23','Mango Juice','33','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('24','Pineapple Juice','33','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('25','Peach Juice','33','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('26','Fruit Cocktail','35','66','20/3/2018','cold_drink'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('27','Strawberry Smoothie','38','66','20/3/2018','smoothie'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('28','Mango Smoothie','38','66','20/3/2018','smoothie'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('29','Blueberry Smoothie','40','66','20/3/2018','smoothie'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('30','Kiwi Smoothie','40','66','20/3/2018','smoothie'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('31','Watermelon Smoothie','35','66','20/3/2018','smoothie'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('32','Pineapple Smoothie','35','66','20/3/2018','smoothie'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('33','Chocolate Brownie','44','66','20/3/2018','dessert'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('34','Strawberry Cheesecake','46','66','20/3/2018','dessert'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('35','Chocolate Mousse Cake','46','66','20/3/2018','dessert'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('36','Red Velvet Cake','48','66','20/3/2018','dessert'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('37','Molten Cake','44','66','20/3/2018','dessert'); 
INSERT INTO Items(Item_ID, Name, Price, Quantity, Expire_date, Item_type) values ('38','blueberry Buckle','46','66','20/3/2018','dessert'); 