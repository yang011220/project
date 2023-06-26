package com.oa.project.biz.lt;

import com.oa.project.entity.lt.User;

public class Test {
    UserBiz userBiz=new UserBiz();
	public void sss() {
		String name[]={"a","b","c","d","e","f","g","h","i","j"};
	    String secondName[]={"bb","cc","dd","jj","ik","ok","yu","it","we","rf"
	            ,"yh","dt","yu","rt","wb","th","fb","yh","ft","fw"};
	
	    for(int i=0;i<100;i++){
	       int a=(int)Math.abs(name.length*Math.random());
	       int b=(int)Math.abs(secondName.length*Math.random());
	       int c=(int)Math.abs(secondName.length*Math.random());
	        StringBuffer sb=new StringBuffer();
	        sb.append(name[a]).append(secondName[b]).append(secondName[c]);
	        User user=new User();
	        user.setUserName(sb.toString());
	        user.setUserPwd("123456");
	        userBiz.save(user);
	    }
		
		
		
	}
    
}
