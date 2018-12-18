package org.ssy.zk.entries;

public class ZkRuok {

    private int areYouOk;

    public int getAreYouOk() {
        return areYouOk;
    }

    public void setAreYouOk(int areYouOk) {
        this.areYouOk = areYouOk;
    }

    public static ZkRuok buildZkRuok(String shellStr, String separator) {
        String shells[] = shellStr.split(separator);
        if (shells.length == 0) {
            return null;
        }
        ZkRuok zkRuok = new ZkRuok();
        if (shells[1].startsWith("imok")) {
            zkRuok.setAreYouOk(0);
        } else {
            zkRuok.setAreYouOk(1);
        }
        return zkRuok;
    }

}
