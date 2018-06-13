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

insert into USERS values(123, '123', 'xiaoming', 10, '男', 'software', 'dangyuan', 'haiyuan', '1231223', 0);

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
	pttel varchar(20),
	psession int
);

alter table Projects
add constraint FK_UID
foreign key (uid) references Users(uid);

insert into PROJECTS values(1000, 15206136, '三小管理系统', '一般项目', 'm没有简介', '没有计划', '软件', 1000, 0, '蔡柯', '123123', 11);
insert into PROJECTS values(1001, 15206136, '三小管理系统', '一般项目', 'm没有简介', '没有计划', '软件', 1000, 0, '蔡柯', '123123', 11);

