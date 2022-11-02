create database inventarioALO
use inventarioALO


create table Departamento(
idDepartamento int identity(1,1) primary key not null,
nombreDepartamento varchar(70) unique
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

create table Categoria(
idCategoria int identity(1,1) primary key not null,
nombreCategoria varchar(50)
)

create table Articulos(
idArticulo int identity(1,1) primary key not null,
nombre varchar(170),
descrip varchar(200),
modelo varchar(30),
marca varchar (20),
almacenamiento varchar(50),
numSerie varchar (70),
folio varchar(30),
idCategoria int not null,
constraint fk_Categoria foreign key (idCategoria) references Categoria(idCategoria)
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

insert into Empleado(nombre,apellidoPaterno,apellidoMaterno,estatus,fechaAlta,fechaBaja,idDepartamento) values ('Josue','De La Iglesia','Ochoa','Activo','20/Sep/2022','20/Mar/2022',1)
insert into Empleado values ('Josue','Yepez','Ponce','Activo','20/Ene/2022','',1)
insert into Empleado values ('Angel Aaron','Figueroa','Contreras','Activo','20/Nov/2021','',1)

insert into Articulos (nombre,descrip,modelo,marca,almacenamiento,numSerie,folio,idCategoria) 
values ('Laptop','Voltro','ICORE7','DELL','1TB','8766jnghh','ABFA283',2)

insert into Categoria values('Vehiculo')
insert into Categoria values ('TI')
insert into Categoria values ('Laptop')

insert into Gestion values (5,1,'20/09/2022')
insert into Gestion values (4,2,'20/03/2022')
insert into Gestion values (2,2,'20/03/2022')
insert into Gestion values (5,4,'20/03/2022') 




---inner join articulos
select Articulos.nombre as nombre,Articulos.descrip AS descripcion, Articulos.modelo AS modelo, Articulos.marca AS marca,
Articulos.almacenamiento as almacenamiento,
Articulos.numSerie AS numSerie, Articulos.folio AS folio,Categoria.nombreCategoria AS nombreTipo
from Articulos inner join
Categoria on Categoria.idCategoria = Articulos.idCategoria






select * from Departamento
select * from Empleado
select * from Articulos
select * from Categoria
select * from Gestion

---Muestra un inner Join en la tabla Empleado
select Empleado.nombre AS nombre, Empleado.apellidoPaterno AS apellidoPaterno, Empleado.apellidoMaterno AS apellidoMaterno, 
Empleado.estatus AS estatus,Empleado.fechaAlta as fechaAlta ,Departamento.nombreDepartamento AS nombreDepartamento from Empleado
inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento



update Empleado set estatus = 'inactivo', fechaBaja = '20/12/2022', idDepartamento ='1 ' where idEmpleado = '1' 

--delete from Departamento where idDepartamento = 6
select Empleado.idEmpleado as idEmpleado, Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno,
Empleado.apellidoMaterno as apellidoMaterno, Articulos.descrip as descrip,
Articulos.marca as marca, Articulos.modelo as modelo, Articulos.numSerie as numserie,
Gestion.fechaEntrega as fecha from Gestion inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado 
inner join Articulos on Articulos.idArticulo = Gestion.idArticulo

-----------------
drop table Gestion
drop table Empleado
drop table Articulos
drop table Departamento
drop table Categoria
