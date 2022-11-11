create database inventarioALO
use inventarioALO


create table Departamento(
idDepartamento int identity(1,1) primary key not null,
nombreDepartamento varchar(70) unique
)

create table Zona(
idZona int identity(1,1) primary key not null,
nombreZona varchar(50) UNIQUE,
sigla char(3)
)

create table Puesto(
idPuesto int identity(1,1) primary key not null,
nombrePuesto varchar(50) UNIQUE,
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
idPuesto int not null,
idZona int not null,
constraint fk_departamento foreign key (idDepartamento) references Departamento(idDepartamento),
constraint fk_puestos foreign key (idPuesto) references Puesto(idPuesto),
constraint fk_zona foreign key (idZona) references Zona(idZona)
)


insert into Departamento (nombreDepartamento) values ('TI')
insert into Departamento (nombreDepartamento) values ('FINANZAS')

insert into Puesto (nombrePuesto) values ('Pasate')
insert into Puesto (nombrePuesto) values ('Jefe de Departamento')

insert into Zona (nombreZona,sigla) values ('VERACRUZ','VER')
insert into Zona (nombreZona,sigla) values ('PUEBLA','PUE')
insert into Zona (nombreZona,sigla) values ('QUERETARO','QRO')

insert into Empleado (nombre,apellidoPaterno,apellidoMaterno,estatus,fechaAlta,fechaBaja,idDepartamento,idPuesto,idZona)
			values   ('El','Ma','caco ','Activo','02/11/2022','.',2,2,3)

------/////////////////Para mostrar en JAVA
select Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno, Empleado.apellidoMaterno as apellidoMaterno,
Empleado.estatus as estatus, Empleado.fechaAlta as fechaAlta, Departamento.nombreDepartamento as nombreDepartamento,Puesto.nombrePuesto as nombrePuesto ,Zona.nombreZona as nombreZona
from Empleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento inner join Zona on Zona.idZona = Empleado.idZona inner join Puesto on Puesto.idPuesto = Empleado.idPuesto
where Empleado.idDepartamento = '2'
where Empleado.idZona = '3'

select Empleado.nombre as nombre, Empleado.apellidoPaterno as apellidoPaterno, Empleado.apellidoMaterno as apellidoMaterno, Empleado.estatus as estatus,
Empleado.fechaAlta as fechaAlta, Empleado.fechaBaja as fechaBaja, Departamento.nombreDepartamento as nombreDepartamento, Zona.nombreZona as nombreZona 
from Empleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento inner join Zona on Zona.idZona = Empleado.idZona 


Select idZona, nombreZona from Zona order by idZona
-------------------
create table Categoria(
idCategoria int identity(1,1) primary key not null,
nombreCategoria varchar(50)
)

create table Marca(
idMarca int identity (1,1) primary key not null,
nombreMarca varchar(70) unique
)

create table Articulos(
idArticulo int identity(1,1) primary key not null,
nombreA varchar(170),
descrip varchar(200),
modelo varchar(30),
capacidad varchar(50),
identificador varchar (70),
folio varchar(30),
idCategoria int not null,
idMarca int not null,
constraint fk_Categoria foreign key (idCategoria) references Categoria(idCategoria),
constraint fk_marca foreign key (idMarca) references Marca(idMarca)
)

insert into Categoria (nombreCategoria) values ('TI')
insert into Categoria (nombreCategoria) values ('Oficina')


insert into Marca (nombreMarca) values ('Microsoft')
insert into Marca (nombreMarca) values ('DELL')
insert into Marca (nombreMarca) values ('LENOVO')

insert into Articulos (nombreA,descrip,modelo,capacidad,identificador,folio,idCategoria,idMarca)

			values ('LAPTOP','ICORE7 4 NUCLEOS','LHNN943','1TB','874JKSJYA7','44ABA3',1,3)
insert into Articulos (nombreA,descrip,modelo,capacidad,identificador,folio,idCategoria,idMarca)
			values ('MONITOR','HD SIN MARCO 4K','ABC943',' ','874JKSJYA7','44ABA3',1,2)
			insert into Articulos (nombreA,descrip,modelo,capacidad,identificador,folio,idCategoria,idMarca)
			values ('MONITOR','HD SIN MARCO 4K','ABC943',' ','874JKSJYA7','44ABA3',3,2)


-----------////Mostrar en JAVA
select Articulos.idArticulo as id,Articulos.nombreA as nombreA,Articulos.descrip AS descripcion, Articulos.modelo AS modelo,
Articulos.capacidad as capacidad,
Articulos.identificador AS identificador, Articulos.folio AS folio,Categoria.nombreCategoria AS nombreCategoria, Marca.nombreMarca as marca
from Articulos inner join
Categoria on Categoria.idCategoria = Articulos.idCategoria inner join Marca on Marca.idMarca = Articulos.idMarca
where Articulos.idCategoria = '1'

----TablaEntrada
create table Entrada(
idEntrada int identity(1,1) primary key,
cantidad int,
fecha varchar(12),
idArticulo int not null,
constraint fk_articulo foreign key (idArticulo) references Articulos(idArticulo)
)

insert into Entrada (cantidad,fecha,idArticulo) values (3,'20/03/2022',1)

select Articulos.nombreA as Articulo,Articulos.modelo as modelo, Entrada.cantidad, Entrada.fecha from Entrada inner join Articulos on Articulos.idArticulo = Entrada.idArticulo

------

create table Gestion(
idGestion int identity(1,1) primary key,
idEmpleado int not null,
idArticulo int not null,
motivo varchar(200),
cantidad varchar(11),
fechaEntrega varchar(12),
constraint fk_empleadoG foreign key (idEmpleado) references Empleado(idEmpleado),
constraint fk_articuloG foreign key (idArticulo) references Articulos(idArticulo)
)



insert into Gestion (idEmpleado,idArticulo,motivo,cantidad,fechaEntrega) 
				values (1,1,'nuevo equipo',1,'20/09/2022')
----JAVA----
select Empleado.nombre as nombre,Empleado.apellidoPaterno as aplleidoPaterno,Empleado.apellidoMaterno as apellidoM, Articulos.nombreA as nombreA,Articulos.descrip as descrip,
Articulos.identificador as identificador, Gestion.motivo as motivo, Gestion.fechaEntrega as fechaEntrega 
from Gestion 
inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado inner join Articulos on Articulos.idArticulo = Gestion.idArticulo where Empleado.idEmpleado = '2'

select Empleado.nombre as Nombre, Empleado.apellidoPaterno as ApellidoPaterno, Departamento.nombreDepartamento as Departamento, Articulos.nombreA as Articulo,Articulos.descrip as Descripcion,Articulos.identificador as Identificador,
Gestion.cantidad as Cantidad, Gestion.fechaEntrega as Fecha from Gestion inner join Empleado on Empleado.idEmpleado = Gestion.idEmpleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento
inner join Articulos on Articulos.idArticulo = Gestion.idArticulo where Empleado.idEmpleado = '6' 
 


--delete from Departamento where idDepartamento = 6

select Empleado.nombre AS nombre, Departamento.nombreDepartamento AS departamento, Puesto.nombrePuesto AS puesto,Articulos.nombreA AS articulo, Articulos.identificador AS identificador,
Gestion.cantidad AS cantidad, Gestion.fechaEntrega AS fecha from Gestion inner join Empleado ON Empleado.idEmpleado = Gestion.idEmpleado inner join Departamento on Departamento.idDepartamento = Empleado.idDepartamento
inner join Puesto on Puesto.idPuesto = Empleado.idPuesto inner join Articulos on Articulos.idArticulo = Gestion.idArticulo 


----------------
select * from Departamento ORDER BY idDepartamento
select * from Zona
select * from Empleado
select * from Articulos
select * from Categoria
select * from Marca ORDER BY idMarca
select * from Gestion
select * from Entrada
select * from Puesto

-----------------
drop table Gestion
drop table Empleado
drop table Articulos
drop table Departamento
drop table Zona
drop table Puesto
drop table Categoria
drop table Marca 
drop table Entrada


