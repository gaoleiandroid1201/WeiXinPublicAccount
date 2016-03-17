package com.gaolei.weinxinpublicaccount;

public class CommonUrl {

//传入自己申请的微信服务号的AppID和AppSecret
	public static final String AppID="";
	public static final String AppSecret="";
	public static final String getAccessToken="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=AppID&secret=AppSecret";
	public static final String getMaterial="https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";

}
