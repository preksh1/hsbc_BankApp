package com.wechat.dao;

import java.util.ArrayList;

import com.wechat.entity.Pojo;

public interface WeChatDaoInterface {

	public int RegistrationDao(Pojo p);

	public int LoginDao(Pojo x);

	public ArrayList<Pojo> FriendListDao(Pojo x);
}
