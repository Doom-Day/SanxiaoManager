package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 152061班第*组
 * 三小管理系统——成员数据对象
 * @author zjr
 * date:2018-06-03
 * 主要功能说明：
 * 与数据库中Members表对应
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MemberDO {
	//成员ID
	private int id;
	//成员姓名
	private String name;
	//成员年龄
	private int age;
	//成员性别
	private String sex;
	//成员政治面貌
	private String ps;
	//成员学院
	private String ac;
	
	public MemberDO() {
		super();
		this.id = 0;
		this.name = "";
		this.age = 0;
		this.sex = "男";
		this.ps = "";
		this.ac = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	@Override
	public String toString() {
		return "MemberDO [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", ps=" + ps + ", ac=" + ac
				+ "]";
	}
}
