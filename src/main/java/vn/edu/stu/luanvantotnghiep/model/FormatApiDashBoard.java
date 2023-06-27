package vn.edu.stu.luanvantotnghiep.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class FormatApiDashBoard {
    private HttpStatus status;
    private String message;
    private Object data;
    private List<HoaDon> hoaDon;
    public FormatApiDashBoard(HttpStatus status, String message, Object data, List<HoaDon> hoaDon) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.hoaDon = hoaDon;
    }
    public FormatApiDashBoard() {
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
    public List<HoaDon> getHoaDon() {
        return hoaDon;
    }
    public void setHoaDon(List<HoaDon> hoaDon) {
        this.hoaDon = hoaDon;
    }
    

}
