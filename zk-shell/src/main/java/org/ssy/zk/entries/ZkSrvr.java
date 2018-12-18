package org.ssy.zk.entries;

import com.alibaba.fastjson.JSON;

public class ZkSrvr {

    private String Latencymin_avg_max;

    private String Received;

    private String Connections;

    private String Sent;

    private String Outstanding;

    private String Zxid;

    private String Mode;

    private String Nodecount;


    public String getLatencymin_avg_max() {
        return Latencymin_avg_max;
    }

    public void setLatencymin_avg_max(String latencymin_avg_max) {
        Latencymin_avg_max = latencymin_avg_max;
    }

    public String getReceived() {
        return Received;
    }

    public void setReceived(String received) {
        Received = received;
    }

    public String getConnections() {
        return Connections;
    }

    public void setConnections(String connections) {
        Connections = connections;
    }

    public String getSent() {
        return Sent;
    }

    public void setSent(String sent) {
        Sent = sent;
    }

    public String getOutstanding() {
        return Outstanding;
    }

    public void setOutstanding(String outstanding) {
        Outstanding = outstanding;
    }

    public String getZxid() {
        return Zxid;
    }

    public void setZxid(String zxid) {
        Zxid = zxid;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    public String getNodecount() {
        return Nodecount;
    }

    public void setNodecount(String nodecount) {
        Nodecount = nodecount;
    }

    /**
     * 跳过zookepper 版本
     * @param shellStr
     * @param separator
     * @return
     */
    public static ZkSrvr buildZkSrvr(String shellStr, String separator) {

        String shells[] = shellStr.split(separator);
        if (shells.length <= 2) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 2; i < shells.length - 1; i++) {
            sb.append("\"").append(shells[i].replace(" ", "")
                    .replace("/", "_")
                    .replace(":", "\":\""))
                    .append("\"");
            if (i != shells.length - 2) {
                sb.append(",");
            }

        }
        sb.append("}");
        ZkSrvr zkSrvr = JSON.parseObject(sb.toString(), ZkSrvr.class);
        return zkSrvr;
    }
}
