/*
 * @(#) NormalResponse.java 2015年9月12日
 * 
 */
package com.snow.db.web.web.abst;

import com.alibaba.fastjson.JSONObject;

/**
*
* @version 2015年9月12日
*/
public class NormalResponse {
    private boolean status = true;
    private String msg = "";
    private JSONObject extra = new JSONObject();

    public boolean isStatus() {
        return status;
    }

    public NormalResponse setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public NormalResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public JSONObject getExtra() {
        return extra;
    }

    public NormalResponse setExtra(JSONObject extra) {
        this.extra = extra;
        return this;
    }

    @Override
    public String toString() {
        JSONObject toStr = new JSONObject();
        toStr.put("status", status);
        toStr.put("msg", msg);
        toStr.put("extra", extra.toString());
        return toStr.toString();
    }
}
