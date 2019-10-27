package com.jebugs.common.utis;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * 工具类
 * @author haozhaoxu
 * @date 2019年8月6日11:53:10
 */
public class FuncUtils {


    /**
     * 将Xml字符串转化为java对象
     */
    public static <T> T xmlStrToObject(Class<T> clazz,String xmlStr) throws Exception{
        Object xmlObject = null;
        // 创建Xml转化实例实例
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML转化为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        try(
                // 将字符串转换为Reader
                Reader reader = new StringReader(xmlStr)
        ){
            // 执行具体的转换逻辑
            xmlObject = unmarshaller.unmarshal(reader);
        }

        return (T)xmlObject;
    }

    /**
     * 使用shiro的SimpleHash处理密码的加密操作
     * @param username 用户名
     * @param pwd 密码
     * @return 加密结果
     */
    public static String MD5Pwd(String username, String pwd) {
        // 加密算法MD5
        // salt盐 username + salt
        // 迭代次数
        String md5Pwd = new SimpleHash("MD5", pwd,
                ByteSource.Util.bytes(username + "salt"), 2).toHex();
        return md5Pwd;
    }


}
