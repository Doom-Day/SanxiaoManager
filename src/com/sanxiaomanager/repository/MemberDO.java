package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;

/**
 * 152061���*��
 * ��С����ϵͳ������Ա���ݶ���
 * @author zjr
 * date:2018-06-11
 * ��Ҫ����˵����
 * �����ݿ���Members���Ӧ
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MemberDO {
	//��ԱID
	private int id;
	//��Ա����
	private String name;
	//��Ա����
	private int age;
	//��Ա�Ա�
	private String sex;
	//��Ա������ò
	private String ps;
	//��ԱѧԺ
	private String ac;
	//��Ա������Ŀ
	private ProjectDO project;
	
	public MemberDO() {
		super();
		this.id = 0;
		this.name = "";
		this.age = 0;
		this.sex = "��";
		this.ps = "";
		this.ac = "";
		this.project = (ProjectDO)ACSingleton.getAC().getBean("projectDO");
	}

	public MemberDO(int id, String name, int age, String sex, String ps, String ac, ProjectDO project) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.ps = ps;
		this.ac = ac;
		this.project = project;
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
	
	public ProjectDO getProject() {
		return project;
	}

	public ProjectDO getTrueProject() {
		if("null".equals(project.getName())) {
			project = RepositorySingleton.getProjectRepositoryImpl().selectById(project.getId());
		}
		return project;
	}

	public void setProject(ProjectDO project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "MemberDO [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", ps=" + ps + ", ac=" + ac
				+ ", projectID=" + project.getId() + "]";
	}
}
