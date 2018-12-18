package org.ssy.zk.entries;

public class ZkWchs {

    private String connections;

    private String watchingPaths;

    private String totalWatches;

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public String getWatchingPaths() {
        return watchingPaths;
    }

    public void setWatchingPaths(String watchingPaths) {
        this.watchingPaths = watchingPaths;
    }

    public String getTotalWatches() {
        return totalWatches;
    }

    public void setTotalWatches(String totalWatches) {
        this.totalWatches = totalWatches;
    }

    public static ZkWchs buildZkWchs(String shellStr, String separator) {
        String shells[] = shellStr.split(separator);
        if (shells.length != 4) {
            return null;
        }
        String lines[] = shells[1].split(" ");
        if (lines.length != 5) {
            return null;
        }

        String lines1[] = shells[2].split(":");

        if (lines1.length != 2) {
            return null;
        }
        //设置watch 数据信息
        ZkWchs zkWchs = new ZkWchs();
        zkWchs.setConnections(lines[0]);
        zkWchs.setWatchingPaths(lines[3]);
        zkWchs.setTotalWatches(lines1[1]);
        return zkWchs;

    }
}
