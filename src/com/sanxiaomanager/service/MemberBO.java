package com.sanxiaomanager.service;

import com.sanxiaomanager.ACSingleton;
import com.sanxiaomanager.RepositorySingleton;
import com.sanxiaomanager.repository.MemberDO;

public class MemberBO {
	//ÃÌº”≥…‘±
	public static boolean addMember(int pid, int mid, String mname, int mage, String msex, String mps, String mac) {
		MemberDO member = (MemberDO)ACSingleton.getAC().getBean("memberDO");
		member.setPID(pid);
		member.setId(mid);
		member.setName(mname);
		member.setAge(mage);
		member.setSex(msex);
		member.setPs(mps);
		member.setAc(mac);
		
		return RepositorySingleton.getMemberRepositoryImpl().insert(member);
	}
}
