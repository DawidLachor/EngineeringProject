insert into body_type (id_body_type, name) values (1,'SUV'), (2,'Sedan'), (3,'Coupe'), (4,'Hatchback'), (5,'Kombi'), (6,'VAN'),(7,'Kabriolet');

insert into mark (id_mark, name) values (1,'BMW'),(2,'Audi'), (3,'Citroen'), (4,'Dacia'), (5,'Fiat'), (6,'Ford'),(7,'Hyundai');

insert into model (id_model, name, mark_id_mark) values (1,'x5' ,1), (2,'x3', 1), (3,'m8',1), (4,'x6',1), (5,'a4', 2), (6,'a5', 2),(7,'r8', 2);

insert into generation (id_generation, name, model_id_model) values (1,'2' ,1), (2,'1', 1), (3,'3',1), (4,'1',2), (5,'2', 2), (6,'3', 2),(7,'r8', 2);

insert into type_engine (id_type_engine, name) values (1,'Diesel'), (2,'Benzyna'), (3,'Gaz'), (4,'Elektryk'), (5,'Hybryda');

insert into transmission (id_transmission, type) values (1,'Manual'), (2,'Automatyczna');


