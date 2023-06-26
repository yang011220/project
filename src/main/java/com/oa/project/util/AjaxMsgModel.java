package com.oa.project.util;

public class AjaxMsgModel {
	    private String statusCode;
	    private String message;
	    private String navTabId;
	    private String rel;
	    private String callbackType;
	    private String forwardUrl;
	    public String getStatusCode() {
	        return statusCode;
	    }
	    public void setStatusCode(String statusCode) {
	        this.statusCode = statusCode;
	    }
	    public String getMessage() {
	        return message;
	    }
	    public void setMessage(String message) {
	        this.message = message;
	    }
	    public String getNavTabId() {
	        return navTabId;
	    }
	    public void setNavTabId(String navTabId) {
	        this.navTabId = navTabId;
	    }
	    public String getRel() {
	        return rel;
	    }
	    public void setRel(String rel) {
	        this.rel = rel;
	    }
	    public String getCallbackType() {
	        return callbackType;
	    }
	    public void setCallbackType(String callbackType) {
	        this.callbackType = callbackType;
	    }
	    public String getForwardUrl() {
	        return forwardUrl;
	    }
	    public void setForwardUrl(String forwardUrl) {
	        this.forwardUrl = forwardUrl;
	    }
	    public AjaxMsgModel(String statusCode, String message, String navTabId, String rel, String callbackType,
	                        String forwardUrl) {
	        super();
	        this.statusCode = statusCode;
	        this.message = message;
	        this.navTabId = navTabId;
	        this.rel = rel;
	        this.callbackType = callbackType;
	        this.forwardUrl = forwardUrl;
	    }
	    public AjaxMsgModel() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    public static AjaxMsgModel createSuccessModel(boolean isCloseCurrent){
	        String closeCurrent = isCloseCurrent ? "closeCurrent" : "";
	        return new AjaxMsgModel("200","操作成功","main","",closeCurrent,"");
	    }

	    public static AjaxMsgModel createfailModel(boolean isCloseCurrent){
	        String closeCurrent = isCloseCurrent ? "closeCurrent" : "";
	        return new AjaxMsgModel("300","操作失败","main","",closeCurrent,"");
	    }

}
