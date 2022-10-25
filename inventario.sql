create database inventarioALO
use inventarioALO

create table Departamento(
idDepartamento int identity(1,1) primary key not null,
nombreDepartamento varchar(70)
)

create table Empleado(
idEmpleado int identity(1,1) primary key not null,
nombre varchar(100),
apellidoPaterno varchar(50),
apellidoMaterno varchar(50),
estatus varchar(8),
fechaAlta varchar(12),
fechaBaja varchar(12),
idDepartamento int not null,
constraint fk_departamento foreign key (idDepartamento) references Departamento(idDepartamento)
)

create table TipoArticulo(
idTipo int identity(1,1) primary key not null,
nombreTipo varchar(50)
)

create table Articulos(
idArticulo int identity(1,1) primary key not null,
descrip varchar(60),
modelo varchar(30),
marca varchar (20),
idTipo int not null,
constraint fk_tipoArticulo foreign key (idTipo) references TipoArticulo(idTipo)
)

create table Gestion(
idGestion int identity(1,1) primary key,
idEmpleado int not null,
idArticulo int not null,
fechaEntrega varchar(12),
constraint fk_empleado foreign key (idEmpleado) references Empleado(idEmpleado),
constraint fk_articulo foreign key (idArticulo) references Articulos(idArticulo)
)



insert into Departamento values('TI')
insert into Departamento values('Capital Humano')
insert into Departamento values ('Finanzas')

insert into Empleado values ('Josue','De La Iglesia','Ochoa','Activo','20/Sep/2022','20/Mar/2022',1)
insert into Empleado values ('Josue','Yepez','Ponce','Activo','20/Ene/2022','',1)
insert into Empleado values ('Angel Aaron','Figueroa','Contreras','Activo','20/Nov/2021','',1)

insert into TipoArticulo values('Monitor')
insert into TipoArticulo values ('CPU')
insert into TipoArticulo values ('Laptop')

insert into Articulos values ('Monitor','Optiplex 3060','DELL',2)
insert into Articulos values ('CPU','E2417H 24','DELL',1)
insert into Articulos values ('Laptop','INSPIRON 3480 I5','DELL',3)


insert into Gestion values (1,3,'20/09/2022')
insert into Gestion values (2,2,'20/03/2022')
insert into Gestion values (2,2,'20/03/2022')
insert into Gestion values (2,3,'20/03/2022') 

---Muestra un inner Join en la tabla Empleado
select nombre, apellidoMaterno, apellidoMaterno, estatus, nombreDepartamento from Empleado E
inner join Departamento D on D.idDepartamento = E.idDepartamento

select idGestion, nombre, apellidoMaterno, apellidoMaterno, estatus,descrip, marca, modelo from Gestion G
inner join Empleado E on E.idEmpleado = G.idEmpleado inner join Articulos A on A.idArticulo = G.idArticulo


select * from Departamento
select * from Empleado
select * from TipoArticulo
select * from Articulos
select * from Gestion






-----------------
drop table Empleado
drop table Departamento
drop table Articulos
drop table TipoArticulo
drop table Gestion