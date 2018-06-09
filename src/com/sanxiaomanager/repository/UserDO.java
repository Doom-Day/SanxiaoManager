package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 152061���*��
 * ��С����ϵͳ�����û����ݶ���
 * @author zjr
 * date:2018-06-03
 * ��Ҫ����˵����
 * �����ݿ���Users���Ӧ
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserDO {
	//�ͻ�ID
	private int id;
	//�ͻ�����
	private String pwd;
	//�ͻ�����
	private String name;
	//�ͻ�����
	private int age;
	//�ͻ��Ա�
	private String sex;
	//�ͻ�ѧԺ
	private String ac;
	//�ͻ�������ò
	private String ps;
	//�ͻ���ϵ��ַ
	private String add;
	//�ͻ���ϵ�绰
	private String tel;
	//�û����
	private int ch;
	
	public UserDO() {
		super();
		this.id = 0;
		this.pwd = "default";
		this.name = "default";
		this.age = 0;
		this.sex = "δ֪";
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
