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

create table Projects(
	pid int primary key,
	uid int not null,
	pname varchar(80),
	ptype varchar(40),
	pprofile varchar(1024),
	pplan varchar(1024),
	pof varchar(20),
	pfee decimal,
	pstate int,
	ptea varchar(40),
	ptel varchar(20),
	psession int
);

alter table Projects
add constraint FK_UID
foreign key (uid) references Users(uid);

insert into PROJECTS values(1000, 123, 'chesuo', 'normal', 'no profile', 'no plan', 'concrete', 1000, 0, 'laowang', '123123', 0);