create table Account (Id identity,
						Email varchar unique,
						Nombre varchar not null,
						Apellido varchar not null,
						Telefono varchar not null,
						Password varchar not null,
						primary key (id));
