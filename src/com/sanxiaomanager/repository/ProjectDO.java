package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;

/**
 * 152061班第*组
 * 三小管理系统——项目数据对象
 * @author zjr
 * date:2018-06-03
 * 主要功能说明：
 * 与数据库中Projects表对应
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectDO {
	//项目ID
	private int id;
	//项目名称
	private String name;
	//项目类型
	private String type;
	//项目简介
	private String profile;
	//项目计划
	private String plan;
	//项目结题形式
	private String of;
	//项目预算
	private double fee;
	//项目状态
	private int state;
	//项目指导老师
	private String tea;
	//项目指导老师联系电话
	private String tel;
	//项目属于第几届三小
	private int session;
	//项目负责人
	private UserDO user;
	
	public ProjectDO() {
		super();
		this.id = 0;
		this.name = "null";
		this.type = "null";
		this.profile = "null";
		this.plan = "null";
		this.of = "null";
		this.fee = 0;
		this.state = 0;
		this.tea = "null";
		this.tel = "null";
		this.session = 0;
		this.user = (UserDO)ACSingleton.getAC().getBean("userDO");
	}
	
	public ProjectDO(int id, String name, String type, String profile, String plan, String of, double fee, int state,
			String tea, String tel, int session, UserDO user) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.profile = profile;
		this.plan = plan;
		this.of = of;
		this.fee = fee;
		this.state = state;
		this.tea = tea;
		this.tel = tel;
		this.session = session;
		this.user = user;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getOf() {
		return of;
	}

	public void setOf(String of) {
		this.of = of;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTea() {
		return tea;
	}

	public void setTea(String tea) {
		this.tea = tea;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getUID() {
		return user.getId();
	}
	
	public void setUID(int uid) {
		user.setId(uid);
	}

	public UserDO getUser() {
		//Realization lazy load
		if("null".equals(user.getName())) {
			user = RepositorySingleton.getUserRepositoryImpl().selectById(user.getId());
		}
		return user;
	}

	public void setUser(UserDO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ProjectDO [id=" + id + ", name=" + name + ", type=" + type + ", profile=" + profile + ", plan=" + plan
				+ ", of=" + of + ", fee=" + fee + ", state=" + state + ", tea=" + tea + ", tel=" + tel + ", session="
				+ session + ", userID=" + user.getId() + "]";
	}
}
