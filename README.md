# Tomcat内存泄漏定位实战

1. 运行程序并打开 verbosegc，将 GC 的日志输出到 gc.log 文件中

> java -verbose:gc -Xloggc:gc.log -XX:+PrintGCDetails -jar learn-tomcat-memory-leak-0.0.1-SNAPSHOT.jar

2. 使用jstat命令观察 GC 的过程

> jstat -gc 94223 2000 1000

3. 通过 GCViewer 工具查看 GC 日志
4. 为了找到内存泄漏点，我们通过 jmap 工具生成 Heap Dump

> jmap -dump:live,format=b,file=94223.bin 94223

5. 用 Eclipse Memory Analyzer 打开 Dump 文件，通过内存泄漏分析，得到这样一个分析报告