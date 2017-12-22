create table book(
	id serial primary key,
	page varchar(100),
	publicDate varchar(50),
	author varchar(50),
	title varchar(50),
	coverImage varchar(200)
);

create table publisher(
	id serial primary key,
	name varchar(50),
	gender varchar(10)
); 

create table bookpublic(
	book_id int4 references book(id) on delete cascade,
	publisher_id int4 references publisher(id) on delete cascade
);