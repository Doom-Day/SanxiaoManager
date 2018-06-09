create table Users(
	uid int primary key,
	upwd varchar(40),
	uname varchar(20),
	uage int,
	usex varchar(20),
	uac varchar(40),
	ups varchar(40),
	uadd varchar(1024),
	utel varchar(20),
	uch int
);

insert into USERS values(123, '123', 'xiaoming', 10, 'ÄÐ', 'software', 'dangyuan', 'haiyuan', '1231223', 0);