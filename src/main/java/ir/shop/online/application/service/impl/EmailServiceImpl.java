package ir.shop.online.application.service.impl;

import ir.shop.online.application.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

//    @Autowired
//    private JavaMailSender mailSender;

    @Override
    public void sendOTP(String email, String code) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("کد تأیید شما");
//        message.setText("کد تأیید شما: " + code + "\nاین کد به مدت ۵ دقیقه معتبر است.");
//
//        mailSender.send(message);

        System.out.println(email + ":" + code);
    }
}
