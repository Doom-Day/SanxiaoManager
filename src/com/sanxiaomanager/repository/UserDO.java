package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 152061班第*组
 * 三小管理系统——用户数据对象
 * @author zjr
 * date:2018-06-03
 * 主要功能说明：
 * 与数据库中Users表对应
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserDO {
	//客户ID
	private int id;
	//客户密码
	private String pwd;
	//客户姓名
	private String name;
	//客户年龄
	private int age;
	//客户性别
	private String sex;
	//客户学院
	private String ac;
	//客户政治面貌
	private String ps;
	//客户联系地址
	private String add;
	//客户联系电话
	private String tel;
	//用户身份
	private int ch;
	
	public UserDO() {
		super();
		this.id = 0;
		this.pwd = "default";
		this.name = "default";
		this.age = 0;
		this.sex = "未知";
		this.ac = "null";
		this.ps = "null";
		this.add = "null";
		this.tel = "null";
		this.ch = 0;
	}
	
	public UserDO(int id, String pwd, String name, int age, String sex, String ac, String ps, String add, String tel,
			int ch) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.ac = ac;
		this.ps = ps;
		this.add = add;
		this.tel = tel;
		this.ch = ch;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getPs() {
		return ps;
	}
	public void setPs(String ps) {
		this.ps = ps;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	
	@Override
	public String toString() {
		return "UserDO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", age=" + age + ", sex=" + sex + ", ac=" + ac
				+ ", ps=" + ps + ", add=" + add + ", tel=" + tel + ", ch=" + ch + "]";
	}
	
}
