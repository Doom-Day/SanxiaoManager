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

insert into PROJECTS values(1000, 15206136, '三小管理系统', '一般项目', '没有简介', '没有计划', '软件', 1000, 0, '蔡柯', '123123', 11);
insert into PROJECTS values(1001, 15206136, '三小管理系统', '一般项目', '没有简介', '没有计划', '软件', 1000, 0, '蔡柯', '123123', 11);

create table Members(
	mid int primary key,
	pid int,
	mname varchar(20),
	mage int,
	msex varchar(20),
	mps varchar(40),
	mac varchar(40),
);

alter table Members
add constraint FK_PID
foreign key (pid) references Projects(pid);

insert into MEMBERS values(15206139, 1000, '冯超', 22, '男', '群众', '软件');
insert into MEMBERS values(15206137, 1000, '赵宇嘉', 22, '男', '群众', '软件');

create sequence seq_pid
 　 minvalue 1000
  　maxvalue 9999
  　start with 1000
  　increment by 1;