package com.wechat.service;

import java.util.ArrayList;

import com.wechat.dao.WeChatDao;
import com.wechat.dao.WeChatDaoInterface;
import com.wechat.entity.Pojo;

public class WeChatService implements WeChatServiceInterface{

	private WeChatDaoInterface ws;
	public WeChatService() {
		ws=new WeChatDao();
	}
	@Override
	public int RegistrationService(Pojo p) {
		
		int i = ws.RegistrationDao(p);
		return i;
	}
	@Override
	public int LoginData(Pojo x) {
		
		int i = ws.LoginDao(x);
		return i;
	}
	@Override
	public ArrayList<Pojo> FriendList(Pojo x) {
		
		ArrayList<Pojo> a=  ws.FriendListDao(x);
		
		return a;
	}

}
