package KPI;
/*检验数据的合法性
* */
public class KpiData {
    private boolean is_truedata=true;
    private String ip;//用户名
    private String time;//请求时间
    private String method;//请求方法
    private String page ;//请求页面
    private String http;//请求协议
    private String status;//返回状态
    private String bytes;//字节数
    private String  jumppage;//跳转页面
    private String user_info;//用户其他信息

    public static KpiData kpi(String line){
        String array[]=line.split(" ");
        KpiData kpiData=new KpiData();
        //标准长度是23
        if(array.length>22) {
            kpiData.setIp(array[0]);
            kpiData.setTime(array[3].substring(1));
            kpiData.setMethod(array[5].substring(1));
            kpiData.setPage(array[6]);
            if(array[7].length()<1){
                kpiData.setHttp("http");
            }else{
                kpiData.setHttp(array[7].substring(0,array[7].length()-1));
            }
            kpiData.setStatus(array[8]);
            kpiData.setBytes(array[9]);
            kpiData.setJumppage(array[10]);
            kpiData.setUser_info(array[11]);
            if(!kpiData.getStatus().equals(" ")&&Integer.parseInt(kpiData.getStatus())>400){
                kpiData.setIs_truedata(false);
            }
        }else{
            kpiData.setIs_truedata(false);
        }
         return kpiData;
    }

    @Override
    public String toString() {
       StringBuilder sb=new StringBuilder();
       sb.append("is_truedata: ").append(this.is_truedata);
       sb.append("\nip: ").append(this.ip);
       sb.append("\n time: ").append(this.time);
       sb.append("\n method: ").append(this.method);
       sb.append("\n page: ").append(this.page);
       sb.append("\n http: ").append(this.http);
       sb.append("\n status: ").append(this.status);
       sb.append("\n bytes: ").append(this.bytes);
       sb.append("\n jumppage: ").append(this.jumppage);
       sb.append("\n user_info: ").append(this.user_info);
        return sb.toString();
    }

    public static void main(String[] args) {
        String line = "66.102.12.84 - - " +
                "[04/Jan/2012:23:18:32 +0800] " +
                "\"GET /ctp080113.php?tid=1495366 HTTP/1.1\" " +
                "200 " +
                "31 " +
                "\"http://www.itpub.net/thread-1495366-1-1.html\" " +
                "\"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.51 (KHTML, like Gecko; Google Web Preview) Chrome/12.0.742 Safari/534.51\"";
       KpiData kpiData= kpi(line);
        System.out.println(kpiData.toString());
    }

    public boolean isIs_truedata() {
        return is_truedata;
    }

    public void setIs_truedata(boolean is_truedata) {
        this.is_truedata = is_truedata;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getJumppage() {
        return jumppage;
    }

    public void setJumppage(String jumppage) {
        this.jumppage = jumppage;
    }

    public String getUser_info() {
        return user_info;
    }

    public void setUser_info(String user_info) {
        this.user_info = user_info;
    }
}
