package org.ssy.zk.entries;

import com.alibaba.fastjson.JSON;

public class ZkConf {

    private String clientPort;
    private String dataDir;
    private String dataLogDir;
    private String tickTime;
    private String maxClientCnxns;
    private String minSessionTimeout;
    private String maxSessionTimeout;
    private String serverId;

    public String getClientPort() {
        return clientPort;
    }

    public void setClientPort(String clientPort) {
        this.clientPort = clientPort;
    }

    public String getDataDir() {
        return dataDir;
    }

    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }

    public String getDataLogDir() {
        return dataLogDir;
    }

    public void setDataLogDir(String dataLogDir) {
        this.dataLogDir = dataLogDir;
    }

    public String getTickTime() {
        return tickTime;
    }

    public void setTickTime(String tickTime) {
        this.tickTime = tickTime;
    }

    public String getMaxClientCnxns() {
        return maxClientCnxns;
    }

    public void setMaxClientCnxns(String maxClientCnxns) {
        this.maxClientCnxns = maxClientCnxns;
    }

    public String getMinSessionTimeout() {
        return minSessionTimeout;
    }

    public void setMinSessionTimeout(String minSessionTimeout) {
        this.minSessionTimeout = minSessionTimeout;
    }

    public String getMaxSessionTimeout() {
        return maxSessionTimeout;
    }

    public void setMaxSessionTimeout(String maxSessionTimeout) {
        this.maxSessionTimeout = maxSessionTimeout;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }


    public static ZkConf buildZkConf(String shellStr, String separator) {
        String[] shells = shellStr.split(separator);
        if (shells.length == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 1; i < shells.length - 1; i++) {
            sb.append("\"").append(shells[i].replace("=", "\":\"")).append("\"");
            if (i != shells.length - 2) {
                sb.append(",");
            }
        }
        sb.append("}");
        ZkConf zkConf = JSON.parseObject(sb.toString(),ZkConf.class);
        return zkConf;
    }


    public static void main(String args[]) {
        ZkConf zkConf = new ZkConf();
        zkConf.serverId = "1";
        System.out.println(JSON.toJSON(zkConf));
    }
}
