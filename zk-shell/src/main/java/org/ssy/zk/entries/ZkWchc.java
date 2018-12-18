package org.ssy.zk.entries;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class ZkWchc {

    private String sid;

    private List<String> paths;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public static List<ZkWchc> buildZkWchcList(String shellStr, String separator) {
        List<ZkWchc> zkWchcList = new ArrayList<>();
        String shells[] = shellStr.split(separator);
        for (int i = 1; i < shells.length - 1; i++) {
            if (shells[i].startsWith("\t")) {
                continue;
            }
            //如果为空类型数据信息
            if (StringUtils.isBlank(shells[i])) {
                continue;
            }
            ZkWchc zkWchc = new ZkWchc();
            zkWchc.setSid(shells[i]);
            List<String> pathList = new ArrayList<>();
            for (int j = i + 1; ; j++) {
                if (shells[j].startsWith("\t")) {
                    pathList.add(shells[j].replace("\t",""));
                } else {
                    break;
                }
            }
            zkWchc.setPaths(pathList);
            zkWchcList.add(zkWchc);
        }
        return zkWchcList;
    }
}
