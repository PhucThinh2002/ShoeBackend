package vn.edu.vlu.khoaluan.service;

public interface ISendMailService {
    public void sendMail(String toEmail, String subject, String body);
}
