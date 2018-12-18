package org.ssy.zk.entries;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class ZkCons {

    private String ip;

    private String port;

    private String queued;

    private String recved;

    private String sent;

    private String sid;

    private String lop;

    private String est;

    private String to;

    private String lcxid;

    private String lzxid;

    private String lresp;

    private String llat;

    private String minlat;

    private String avglat;

    private String maxlat;

    public String getQueued() {
        return queued;
    }

    public void setQueued(String queued) {
        this.queued = queued;
    }

    public String getRecved() {
        return recved;
    }

    public void setRecved(String recved) {
        this.recved = recved;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLcxid() {
        return lcxid;
    }

    public void setLcxid(String lcxid) {
        this.lcxid = lcxid;
    }

    public String getLzxid() {
        return lzxid;
    }

    public void setLzxid(String lzxid) {
        this.lzxid = lzxid;
    }

    public String getLresp() {
        return lresp;
    }

    public void setLresp(String lresp) {
        this.lresp = lresp;
    }

    public String getLlat() {
        return llat;
    }

    public void setLlat(String llat) {
        this.llat = llat;
    }

    public String getMinlat() {
        return minlat;
    }

    public void setMinlat(String minlat) {
        this.minlat = minlat;
    }

    public String getAvglat() {
        return avglat;
    }

    public void setAvglat(String avglat) {
        this.avglat = avglat;
    }

    public String getMaxlat() {
        return maxlat;
    }

    public void setMaxlat(String maxlat) {
        this.maxlat = maxlat;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public static ZkCons buildZkCons(String shellStr) {
//        shellStr = "queued=0,recved=1053,sent=1053,sid=0x167bc9de7380016,lop=PING,est=1545097150496,to=40000,lcxid=0x3,lzxid=0x2d,lresp=1545111139451,llat=0,minlat=0,avglat=0,maxlat=4";
        String[] shells = shellStr.split(",");
        if (shells.length == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < shells.length; i++) {
            sb.append("\"").append(shells[i].replace("=", "\":\"")).append("\"");
            if (shells.length - 1 != i) {
                sb.append(",");
            }
        }
        sb.append("}");
        ZkCons zkCons = JSON.parseObject(sb.toString(), ZkCons.class);
        return zkCons;
    }

    public static List<ZkCons> buildZkConsList(String shellStr, String separator) {
        List<ZkCons> zkConsList = new ArrayList<>();
        String[] shells = shellStr.split(separator);
        if (shells.length == 0) {
            return zkConsList;
        }
        for (int i = 1; i < shells.length - 1; i++) {
            //为空
            if (StringUtils.isBlank(shells[i])) {
                continue;
            }
            String zkConsStr[] = shells[i].split("\\(");
            //没有（ 标志
            if (zkConsStr.length != 2) {
                continue;
            }
            StringBuffer line = new StringBuffer();
            String ips[] = zkConsStr[0].split(":");
            if (ips.length != 2) {
                continue;
            }
            //去掉／127.0.0.1 得到 127.0.0.1,并且移除空格
            String ip = ips[0].replace("/", "").replace(" ", "");
            //62664[1] 移除[1]
            String port = ips[1].split("\\[")[0];
            if (StringUtils.isBlank(ip) || StringUtils.isBlank(port)) {
                System.out.println("解析失败，根据版本进行修改信息");
                continue;
            }
            line.append("ip\":\"").append(ip).append(",");
            line.append("port\":\"").append(port).append(",");
            line.append(zkConsStr[1].replace(")", ""));
            ZkCons zkCons = buildZkCons(line.toString());
            if (zkCons != null) {
                zkConsList.add(zkCons);
            }
        }
        return zkConsList;
    }


    public static void main(String args[]) {
        ZkCons zkCons = ZkCons.buildZkCons("");
    }
}
