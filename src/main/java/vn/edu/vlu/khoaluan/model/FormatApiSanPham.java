package vn.edu.vlu.khoaluan.model;

import org.springframework.http.HttpStatus;

public class FormatApiSanPham {
    private HttpStatus status;
    private String message;
    private Object data;
    private Integer totalPage;
    private Integer currentpage;
    public FormatApiSanPham() {
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getCurrentpage() {
        return currentpage;
    }
    public void setCurrentpage(Integer currentpage) {
        this.currentpage = currentpage;
    }
    
}
