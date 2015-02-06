create table Viaje (id identity,
						creador varchar not null,
						desde varchar not null,
						hasta varchar not null,
						fecha varchar not null,
						cupos integer not null,
						acompaniantes varchar not null,
						costo varchar not null,
						primary key (id));
