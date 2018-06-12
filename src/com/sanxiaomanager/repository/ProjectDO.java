package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;

/**
 * 152061���*��
 * ��С����ϵͳ������Ŀ���ݶ���
 * @author zjr
 * date:2018-06-03
 * ��Ҫ����˵����
 * �����ݿ���Projects���Ӧ
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProjectDO {
	//��ĿID
	private int id;
	//��Ŀ����
	private String name;
	//��Ŀ����
	private String type;
	//��Ŀ���
	private String profile;
	//��Ŀ�ƻ�
	private String plan;
	//��Ŀ������ʽ
	private String of;
	//��ĿԤ��
	private double fee;
	//��Ŀ״̬
	private int state;
	//��Ŀָ����ʦ
	private String tea;
	//��Ŀָ����ʦ��ϵ�绰
	private String tel;
	//��Ŀ���ڵڼ�����С
	private int session;
	//��Ŀ������
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
