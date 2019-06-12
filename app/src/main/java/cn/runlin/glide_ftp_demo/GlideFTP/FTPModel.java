package cn.runlin.glide_ftp_demo.GlideFTP;

public class FTPModel {

    String ftpPath;
    private String filePath;
    private String server;
    private String port;
    private String username;
    private String password;

    //ftp文件全路径(自动解析)
    public FTPModel(String ftpPath) {
        this.ftpPath = ftpPath;
        parseFTPUrl(ftpPath);
    }

    //ftp信息
    public FTPModel(String server, String port, String userName, String password, String filePath) {
        this.server = server;
        this.port = port;
        this.username = userName;
        this.password = password;
        this.filePath = filePath;
        //todo
        this.ftpPath = filePath;
    }

    @Override
    public int hashCode() {
        return ftpPath.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ftpPath.equals(((FTPModel) obj).ftpPath);
    }

    public void parseFTPUrl(String ftpPath) {
        String s1[] = ftpPath.split("@");

        String s2[] = s1[1].split("/");
        String local = s2[0];
        String locals[] = local.split(":");
        String filePath = "";
        for (int i = 1; i < s2.length; i++) {
            filePath = filePath + "/" + s2[i];
        }

        String login = s1[0].substring(6, s1[0].length());
        String loginArr[] = login.split(":");
        String username = loginArr[0];
        String password = loginArr[1];

        this.setServer(local);
//        this.setPort("80");
        this.setUsername(username);
        this.setPassword(password);
        this.setFilePath(filePath);
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
