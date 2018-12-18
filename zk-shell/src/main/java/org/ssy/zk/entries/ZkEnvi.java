package org.ssy.zk.entries;

import com.alibaba.fastjson.JSON;

public class ZkEnvi {

    private String zookeeperversion;

    private String hostname;

    private String javaversion;

    private String javavendor;

    private String javahome;

    private String javaclasspath;

    private String javalibrarypath;

    private String javaiotmpdir;

    private String javacompiler;

    private String osname;

    private String osarch;
    private String osversion;
    private String username;
    private String userhome;
    private String userdir;

    public String getZookeeperversion() {
        return zookeeperversion;
    }

    public void setZookeeperversion(String zookeeperversion) {
        this.zookeeperversion = zookeeperversion;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getJavaversion() {
        return javaversion;
    }

    public void setJavaversion(String javaversion) {
        this.javaversion = javaversion;
    }

    public String getJavavendor() {
        return javavendor;
    }

    public void setJavavendor(String javavendor) {
        this.javavendor = javavendor;
    }

    public String getJavahome() {
        return javahome;
    }

    public void setJavahome(String javahome) {
        this.javahome = javahome;
    }

    public String getJavaclasspath() {
        return javaclasspath;
    }

    public void setJavaclasspath(String javaclasspath) {
        this.javaclasspath = javaclasspath;
    }

    public String getJavalibrarypath() {
        return javalibrarypath;
    }

    public void setJavalibrarypath(String javalibrarypath) {
        this.javalibrarypath = javalibrarypath;
    }

    public String getJavaiotmpdir() {
        return javaiotmpdir;
    }

    public void setJavaiotmpdir(String javaiotmpdir) {
        this.javaiotmpdir = javaiotmpdir;
    }

    public String getJavacompiler() {
        return javacompiler;
    }

    public void setJavacompiler(String javacompiler) {
        this.javacompiler = javacompiler;
    }

    public String getOsname() {
        return osname;
    }

    public void setOsname(String osname) {
        this.osname = osname;
    }

    public String getOsarch() {
        return osarch;
    }

    public void setOsarch(String osarch) {
        this.osarch = osarch;
    }

    public String getOsversion() {
        return osversion;
    }

    public void setOsversion(String osversion) {
        this.osversion = osversion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserhome() {
        return userhome;
    }

    public void setUserhome(String userhome) {
        this.userhome = userhome;
    }

    public String getUserdir() {
        return userdir;
    }

    public void setUserdir(String userdir) {
        this.userdir = userdir;
    }

    public static ZkEnvi buildZkEnvi(String shellStr, String separator) {
        String shells[] = shellStr.split(separator);
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 2; i < shells.length - 1; i++) {
            String lines[] = shells[i].split("=");
            if (lines.length != 2) {
                continue;
            }
            sb.append("\"").append(lines[0].replace(".","")).append("\":\"").append(lines[1]).append("\"");
            if (i != shells.length - 2) {
                sb.append(",");
            }
        }
        sb.append("}");
        ZkEnvi zkEnvi = JSON.parseObject(sb.toString(), ZkEnvi.class);
        return zkEnvi;
    }
}

