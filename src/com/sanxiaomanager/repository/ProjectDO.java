package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
	//项目
	private int session;
}
