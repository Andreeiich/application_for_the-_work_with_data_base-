INSERT INTO client ("surname","name_of_client","patronymic","passport_serial","passport_number","telephone_number") Values
('Иванов','Сергей','Алексеевич',2204, 545852,'89378941596'),
('Иванова','Людмила','Алексеевна',2255, 545354,'89507931494'),
('Иванов','Владимир','Александрович',2203, 549852,'89578748596'),
('Пивоваров','Анатолий','Сергеевич',3375, 879354,'89416278216' ),
('Еске','Денис','Федорович',2365, 887323,'89546378228' ),
('Сидоров','Сергей','Владимирович',3785, 987243,'88746432523' );


INSERT INTO "request" ("client","status")
Values (2,'Уточняется'), (3,'Уточняется'),(4,'Проверяется'),(1,'Исполнена'),(5,'Уточняется'),(6,'Исполнена');

INSERT INTO "finishing_materials" ("materials_id","naming_of_rope")
values (1,'average'),(2,'initial'),(3,'superior'),(4,'special');

INSERT INTO "finishing_cabin" ("cabin_id","finishing_materials_fk","naming")
values (5,2,'base'),(6,3,'medium'),(7,1,'special'),(8,3,'special'),(1,3,'base'),(2,2,'base'),(3,1,'base'),(4,4,'base');

INSERT INTO "wheels"  ("wheels_id","radius","bolt_pattern","width")
Values (1,16,'5*113',185),(2,17,'5*113',200),(3,18,'5*113',225),(4,19,'5*120',225);

INSERT INTO "package_of_safe" ("safe_id","description")
values(1,'airbag_of_driver,airbag_of_passenger, side_airbags,ABS,ESC,ESP'),
(2,'airbag_of_driver,airbag_of_passenger,side_airbags,safety shutters,ABS,ESC,ESP'),
(3,'airbag_of_driver,airbag_of_passenger,ABS,ESC,ESP');
INSERT INTO "option_of_auto" ("option_id","finishing_cab","wheels","package_of_safe")
values(1,5,1,1),(2,6,2,1),(3,7,2,2),(4,8,1,3),(5,5,3,2),(6,6,2,2),(7,7,1,3);

insert into "equipment" ("equipment_id","naming")
values(1,'base'),(2,'special'),(3,'business'),(4,'Exclusive');

Insert into color ("color_id","naming") values
(1,'White Gloss'),(2,'Red Gloss'),(3,'Blue Gloss'),(4,'Black Gloss'),(5,'Red Metallic'),(6,'Blue Metallic'),(7,'Black Gloss'),(8,'Gray Metallic');
Insert into "auto"("auto_id","mark","model","equipment","option_of_auto","color","price")
values(1,1,1,1,1,1,1100000),(2,1,1,2,2,3,1200000),(3,1,1,2,3,4,1300000),(4,1,1,3,2,5,1320000),(5,1,1,4,1,6,140000),
(6,1,2,2,3,8,1800000),(7,1,1,3,2,7,1200000),(8,1,3,3,5,5,2090000),(9,1,3,1,1,6,2080000),(10,1,3,2,1,7,2120000),
(11,1,3,2,2,3,2340000),(12,1,3,4,1,4,2450000),(13,1,3,1,1,5,2700000),(14,1,3,2,2,6,2400000),(15,1,5,3,2,7,2505000),
(16,1,5,4,1,2,2700000),(17,1,5,4,2,3,2680000),(18,1,2,1,1,8,1930000);


INSERT INTO "request_auto"("request","auto","date_of_request")
Values(1,9,'25.09.2021'),(3,11,'25.09.2021'),(2,13,'13,10,2021');