package org.ssy.zk.shell.constant;

public class ZkCmdConstant {
    //查看配置信息，或许可以动态更具配置版本解析文本内容
    private String conf="echo conf | nc localhost 2181";
    //查看链接信息
    private String cons="echo cons | nc localhost 2181";
    //重置链接信息
    private String crst="echo crst | nc localhost 2181";
    //dump leader节点的所有等待队列中的会话和临时节点的信息
    private String dump="echo dump | nc localhost 2181";
    //当前server的环境信息
    private String envi="echo envi | nc localhost 2181";
    //当前服务器是否存活
    private String ruok="echo ruok | nc localhost 2181";
    //重置统计状态
    private String srst="echo srst | nc localhost 2181";
    //输出服务器的详细信息。zk版本、接收/发送包数量、连接数、模式（leader/follower）、节点总数
    private String srvr="echo srvr | nc localhost 2181";
    //：接收/发送包数量、连接数、模式（leader/follower）、节点总数、延迟。 所有客户端的列表.等于cons+srvr
    private String stat="echo stat | nc localhost 2181";
    // 如果watches数量很大的话，将会产生很大的开销，会影响性能，小心使用。
    private String wchs="echo wchs | nc localhost 2181";
    // 通过session分组，列出watch的所有节点，它的输出是一个与 watch 相关的会话的节点列表。
    private String wchc="echo wchc | nc localhost 2181";
    //通过路径分组，列出所有的 watch 的session id信息。它输出一个与 session 相关的路径
    private String wchp="echo wchp | nc localhost 2181";
    //列出集群的健康状态。包括“接受/发送”的包数量、操作延迟、当前服务模式（leader/follower）、节点总数、watch总数、临时节点总数
    private String mntr="echo mntr | nc localhost 2181";
}
