package com.wechat.service;

import java.util.ArrayList;

import com.wechat.entity.Pojo;

public interface WeChatServiceInterface {

	public int RegistrationService(Pojo p);

	public int LoginData(Pojo x);

	public ArrayList<Pojo> FriendList(Pojo x);
}
