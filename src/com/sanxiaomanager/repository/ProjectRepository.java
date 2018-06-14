package com.sanxiaomanager.repository;

import java.util.List;
import java.util.Map;

/**
 * 152061���*��
 * ��С����ϵͳ������Ŀ���ݲ����ӿ�
 * @author zjr
 * date:2018-06-11
 * ��Ҫ����˵����
 * ��������Ҫ����Ŀ�����ķ���
 */
public interface ProjectRepository {
	//�����Ŀ
	public boolean insert(ProjectDO project);
	
	//������Ŀ
	public boolean update(ProjectDO project);
	
	//������ĿIDɾ����Ŀ��Ϣ
	public boolean delete(int id);
	
	//������ĿID������Ŀ
	public ProjectDO selectById(int id);
	
	//������ĿID������Ŀ����
	public Map<String,Object> selectProjectDetail(int id);
	
	//������ĿID���ҳ�Ա
	public List<Map<String,Object>> getMember(int id);
}
