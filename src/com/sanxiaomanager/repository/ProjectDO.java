package com.sanxiaomanager.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
	//��Ŀ
	private int session;
}
