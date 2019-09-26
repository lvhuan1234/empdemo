package com.neuedu.VO;


import lombok.Data;

@Data
public class LoginVO {

    private Integer status;
    private  String message;

    /**
     * 利用静态方法创建对象
     * @return
     */
    public static LoginVO success() {
        LoginVO loginVO = new LoginVO();
        loginVO.setStatus(0);
        loginVO.setMessage("成功");
        return loginVO;
    }

    public static LoginVO error(Integer status,String message) {
        LoginVO loginVO = new LoginVO();
        loginVO.setStatus(status);
        loginVO.setMessage(message);
        return loginVO;
    }

}
