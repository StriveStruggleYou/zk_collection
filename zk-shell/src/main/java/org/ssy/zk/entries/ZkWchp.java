package org.ssy.zk.entries;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class ZkWchp {

    private String path;

    private List<String> sidList;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getSidList() {
        return sidList;
    }

    public void setSidList(List<String> sidList) {
        this.sidList = sidList;
    }


    public static List<ZkWchp> buildZkWchpList(String shellStr, String separator) {
        List<ZkWchp> zkWchpList = new ArrayList<>();
        String shells[] = shellStr.split(separator);
        for (int i = 1; i < shells.length - 1; i++) {
            if (shells[i].startsWith("\t")) {
                continue;
            }
            //如果为空类型数据信息
            if (StringUtils.isBlank(shells[i])) {
                continue;
            }
            ZkWchp zkWchp = new ZkWchp();
            zkWchp.setPath(shells[i]);
            List<String> sidList = new ArrayList<>();
            for (int j = i + 1; ; j++) {
                if (shells[j].startsWith("\t")) {
                    i = j;
                    sidList.add(shells[j].replace("\t", ""));
                } else {
                    break;
                }
            }
            zkWchp.setSidList(sidList);
            zkWchpList.add(zkWchp);
        }
        return zkWchpList;
    }

}
