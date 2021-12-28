DROP TABLE IF EXISTS Color cascade;
DROP TABLE IF EXISTS request_auto;
DROP TABLE IF EXISTS auto;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS option_of_auto;
DROP TABLE IF EXISTS wheels;
DROP TABLE IF EXISTS finishing_cabin;
DROP TABLE IF EXISTS package_of_safe;
DROP TABLE IF EXISTS finishing_materials;
DROP TABLE IF EXISTS Request;
DROP TABLE IF EXISTS Client;
DROP TABLE if EXISTS Model;
Drop table if Exists Mark;

Create table Mark(
Mark_id Integer,
Naming varchar(30),
Primary key (Mark_id)
);

Create table Model(
Model_id Integer,
Naming varchar(30),
Primary key (Model_id)
);

CREATE TABLE Client (
		Client_id SERIAL,
		Surname varchar(20),
		Name_of_client varchar(20),
		Patronymic varchar(20),
		Passport_serial Integer,
		Passport_number Integer,
		Telephone_number varchar(30),
		PRIMARY KEY(Client_id)
);
Create table Request (
	Request_id Serial,
	Client integer,
	Status varchar(50),
	Primary key(Request_id),
	Foreign key (Client) references Client (Client_id) on delete restrict
);
create table Finishing_materials(
	Materials_id integer not null,
	Naming_of_rope varchar(20) not null,
	Primary key(Materials_id)
);
create table Finishing_cabin(
	Cabin_id integer,
	Finishing_materials_fk integer,
	Naming varchar(20) not null,
	Primary key(cabin_id),
	Foreign key (Finishing_materials_fk) references Finishing_materials(Materials_id)on delete restrict
);
create table Wheels (
	Wheels_id integer,
	Radius integer not null,
	Bolt_pattern varchar(8) not null,
	Width integer not null,
	Primary key(Wheels_id)
);
create table Package_of_safe(
	Safe_id integer,
	Description varchar(100),
	Primary key(safe_id)
);
create table Equipment(
	Equipment_id integer not null,
	Naming varchar(30),
	Primary key(equipment_id)
);
create table Option_of_auto(
	Option_id integer,
 	Finishing_cab integer,
	Wheels integer,
	Package_of_safe integer,
	primary key(Option_id),
	foreign key (Finishing_cab) references Finishing_cabin(Cabin_id) on delete restrict,
	foreign key (Wheels) references Wheels(Wheels_id) on delete restrict,
	foreign key (Package_of_safe) references Package_of_safe(Safe_id) on delete restrict
);
create table Color(
Color_id integer,
Naming varchar(30),
primary key(Color_id)
);
create table Auto(
	Auto_id integer,
	Mark Integer,
	Model Integer,
	Equipment integer not null,
	Option_of_auto integer not null,
	Color integer not null,
	Price numeric,
	primary key(Auto_id),
	foreign key (Equipment) references Equipment(Equipment_id) on delete restrict,
	foreign key (Option_of_auto) references Option_of_auto(Option_id)on delete restrict,
	foreign key (Color) references Color(Color_id),
	foreign key (Mark) references Mark(Mark_id),
	foreign key (Model) references Model(Model_id)
);
create table Request_auto(
	Request_auto_id serial,
	Request integer not null,
	Auto integer not null,
	Date_of_request date,
	primary key(Request_auto_id),
	foreign key (Request) references Request(Request_id) on delete restrict,
	foreign key (Auto) references Auto(Auto_id) on delete restrict
);









