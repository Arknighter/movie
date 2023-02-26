package com.yjh.movie.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class ReturnCode {

    private static int newcode;
    public static int getNewcode() {
        return newcode;
    }
    public static void setNewcode(){
        newcode = (int)(Math.random()*999999)+10000;  //每次调用生成一位六位数的随机数
    }

    //直接本地生成 验证码不用阿里云
    public  String  sendSmsNOaliyun(String telephone) {
        setNewcode();
        String code = Integer.toString(getNewcode());
        System.out.println("手机号"+telephone+"发送的验证码为："+code);

        return code;
    }


    //利用阿里云短信发送
    public  String  sendSms(String telephone) {
        setNewcode();
        String code = Integer.toString(getNewcode());
        System.out.println("发送的验证码为："+code);
        // 填入自己的接口  2023年2月26日更：阿里云key已失效  看了History也无所谓
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "xxxxxxxxxx", "xxxxx");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telephone);
        request.putQueryParameter("SignName", "海的树");
        request.putQueryParameter("TemplateCode", "SMS_205875131");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }
}
