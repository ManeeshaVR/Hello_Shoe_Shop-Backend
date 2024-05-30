package software.vimukthirajapaksha.shoe_shop_project.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
