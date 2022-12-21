-- CREATE TABLEs

create table CAMPUS ( 
    CampusID varchar2(5) not null constraint campus_pk primary key, 
    CampusName varchar2(100), 
    Street varchar2(100), 
    City varchar2(100), 
    State varchar2(100), 
    Zip varchar2(100), 
    Phone varchar2(100), 
    CampusDiscount Decimal(2,2) 
)

create table POSITION ( 
    PositionID varchar2(5) constraint position_pk primary key, 
    POSITION varchar2(100), 
    YearlyMembershipFee decimal(7,2) 
)

create table MEMBERS ( 
    MemberID varchar2(5) not null constraint members_pk primary key, 
    LastName varchar2(100), 
    FirstName varchar2(100), 
    CampusAddress varchar2(100), 
    CampusPhone varchar2(100), 
    CampusID varchar2(5), 
    PositionID varchar2(5), 
    ContractDuration integer, 
    foreign key (CampusID) references CAMPUS(CampusID), 
    foreign key (PositionID) references POSITION(PositionID) 
)

create table PRICES ( 
    FoodItemTypeID number not null constraint prices_pk primary key, 
    MealType varchar2(100), 
    MealPrice decimal(7,2)
)

create table FoodItems ( 
    FoodItemID varchar2(5) not null constraint food_item_pk primary key, 
    FoodItemName varchar2(100), 
    FoodItemTypeID number,  
    foreign key (FoodItemTypeID) references PRICES(FoodItemTypeID)
)

create table Orders ( 
    OrderID varchar2(5) constraint orders_pk primary key, 
    MemberID varchar2(5), 
    OrderDate varchar2(25), 
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID) 
)

create table OrderLine ( 
    OrderID varchar2(5), 
    FoodItemsID varchar2(5), 
    Quantity integer, 
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID), 
    FOREIGN KEY (FoodItemsID) REFERENCES FoodItems(FoodItemID), 
    CONSTRAINT orderLine_pk PRIMARY KEY (OrderID, FoodItemsID)  
)


---------------------------------------------------

-- INSERT VALUES INTO TABLES

INSERT INTO Campus VALUES 
('1','IUPUI', '425 University Blvd.', 'Indianapolis', 'IN','46202', '317-274-4591',.08);
INSERT INTO Campus VALUES 
('2','Indiana University', '107 S. Indiana Ave.', 'Bloomington', 'IN','47405', '812-855 4848',.07);
INSERT INTO Campus VALUES 
('3','Purdue University', '475 Stadium Mall Drive', 'West Lafayette', 'IN', '47907', '765 494-1776',.06);

INSERT INTO POSITION VALUES 
('1','Lecturer', 1050.50);
INSERT INTO POSITION VALUES 
('2','Associate Professor', 900.50);
INSERT INTO POSITION VALUES 
('3','Assistant Professor', 875.50);
INSERT INTO POSITION VALUES 
('4','Professor', 700.75);
INSERT INTO POSITION VALUES 
('5', 'Full Professor', 500.50);

INSERT 
    INTO MEMBERS VALUES ('1', 'Ellen', 'Monk', '009 Purnell', '812-123-1234', '2', '5', 12);
INSERT 
    INTO MEMBERS VALUES ('2', 'Joe', 'Brady', '008 Statford Hall', '765-234-2345', '3', '2', 10);
INSERT 
    INTO MEMBERS VALUES ('3','Dave', 'Davidson', '007 Purnell', '812-345-3456', '2', '3', 10);
INSERT 
    INTO MEMBERS VALUES ('4','Sebastian', 'Cole', '210 Rutherford Hall', '765-234-2345', '3', '5', 10);
INSERT 
    INTO MEMBERS VALUES ('5','Michael', 'Doo', '66C Peobody', '812-548-8956', '2', '1', 10);
INSERT 
    INTO MEMBERS VALUES ('6','Jerome', 'Clark', 'SL 220', '317-274-9766', '1', '1', 12);
INSERT 
    INTO MEMBERS VALUES ('7', 'Bob', 'House', 'ET 329', '317-278-9098', '1', '4', 10);
INSERT 
    INTO MEMBERS VALUES ('8', 'Bridget','Stanley', 'SI 234', '317-274-5678', '1', '1', 12);
INSERT 
    INTO MEMBERS VALUES ('9','Bradley', 'Wilson', '334 Statford Hall', '765-258-2567', '3', '2', 10);

INSERT 
    INTO prices VALUES (Prices_FoodItemTypeID_SEQ.Nextval,'Beer/Wine', 5.50);
INSERT 
    INTO prices VALUES (Prices_FoodItemTypeID_SEQ.Nextval, 'Dessert', 2.75);
INSERT 
    INTO prices VALUES (Prices_FoodItemTypeID_SEQ.Nextval,'Dinner', 15.50);
INSERT 
    INTO prices VALUES (Prices_FoodItemTypeID_SEQ.Nextval,'Soft Drink', 2.50);
INSERT 
    INTO prices VALUES (Prices_FoodItemTypeID_SEQ.Nextval,'Lunch', 7.25);

INSERT 
    INTO foodItems VALUES ('10001', 'Lager', 1);
INSERT 
    INTO foodItems VALUES ('10002', 'Red Wine', 1);
INSERT 
    INTO foodItems VALUES ('10003', 'White Wine', 1);
INSERT 
    INTO foodItems VALUES ('10004', 'Coke', 4);
INSERT 
    INTO foodItems VALUES ('10005', 'Coffee', 4);
INSERT 
    INTO foodItems VALUES ('10006', 'Chicken a la King', 3);
INSERT 
    INTO foodItems VALUES ('10007', 'Rib Steak', 3);
INSERT 
    INTO foodItems VALUES ('10008', 'Fish and Chips',  3);
INSERT 
    INTO foodItems VALUES ('10009', 'Veggie Delight',  3);
INSERT 
    INTO foodItems VALUES ('10010', 'Chocolate Mousse', 2);
INSERT 
    INTO foodItems VALUES ('10011', 'Carrot Cake', 2);
INSERT 
    INTO foodItems VALUES ('10012', 'Fruit Cup', 2);
INSERT 
    INTO foodItems VALUES ('10013', 'Fish and Chips', 5);
INSERT 
    INTO foodItems VALUES ('10014', 'Angus Beef Burger', 5);
INSERT 
    INTO foodItems VALUES ('10015', 'Cobb Salad', 5);

INSERT 
    INTO Orders VALUES ('1', '9', 'March 5, 2005');
INSERT 
    INTO Orders VALUES ('2', '8', 'March 5, 2005');
INSERT 
    INTO Orders VALUES ('3', '7', 'March 5, 2005');
INSERT 
    INTO Orders VALUES ('4', '6', 'March 7, 2005');
INSERT 
    INTO Orders VALUES ('5', '5', 'March 7, 2005');
INSERT 
    INTO Orders VALUES ('6', '4', 'March 10, 2005');
INSERT 
    INTO Orders VALUES ('7', '3', 'March 11, 2005');
INSERT 
    INTO Orders VALUES ('8', '2', 'March 12, 2005');

INSERT 
    INTO Orders VALUES ('9', '1', 'March 13, 2005');

INSERT 
    INTO OrderLine VALUES ('1','10001',1);
INSERT 
    INTO OrderLine VALUES ('1','10006',1);
INSERT 
    INTO OrderLine VALUES ('1','10012',1);
INSERT 
    INTO OrderLine VALUES ('2','10004',2);
INSERT 
    INTO OrderLine VALUES ('2','10013',1);
INSERT 
    INTO OrderLine VALUES ('2','10014',1);
INSERT 
    INTO OrderLine VALUES ('3','10005',1);
INSERT 
    INTO OrderLine VALUES ('3','10011',1);
INSERT 
    INTO OrderLine VALUES ('4','10005',2);
INSERT 
    INTO OrderLine VALUES ('4','10004',2);
INSERT 
    INTO OrderLine VALUES ('4','10006',1);
INSERT 
    INTO OrderLine VALUES ('4','10007',1);
INSERT 
    INTO OrderLine VALUES ('4','10010',2);
INSERT 
    INTO OrderLine VALUES ('5','10003',1);
INSERT 
    INTO OrderLine VALUES ('6','10002',2);
INSERT 
    INTO OrderLine VALUES ('7','10005',2);
INSERT 
    INTO OrderLine VALUES ('8','10005',1);
INSERT 
    INTO OrderLine VALUES ('8','10011',1);
INSERT 
    INTO OrderLine VALUES ('9','10001',1);

---------------------------------------------------------
-- Liệt kê tất cả constrains trong database
select constraint_name, table_name FROM user_constraints;

-- Liệt kê tất cả tên bảng trong database 
select owner, table_name from all_tables;

-- Viết lệnh liệt kê tên tất cả sequence trong database 
select sequence_owner, sequence_name from all_sequences;

-- Liệt kê các thành viên với các cột FirstName, LastName, Position, CampusName, (YearlyMembershipFee / 12 ) Monthly_Dues. Sau đó sắp xếp theo tên đại học giảm dần, tiếp theo LastName tăng dần
SELECT m.FirstName, m.LastName, p.position, c.CampusName, (p.YearlyMembershipFee/12) as Monthly_Dues 
FROM position p, members m, campus c 
WHERE c.CampusID = m.CampusID and m.PositionID=p.PositionID 
Order by (c.CampusName) Desc;

SELECT m.FirstName, m.LastName, p.position, c.CampusName, (p.YearlyMembershipFee/12) as Monthly_Dues 
FROM position p, members m, campus c 
WHERE c.CampusID = m.CampusID and m.PositionID=p.PositionID 
Order by (m.LastName) ASC ;