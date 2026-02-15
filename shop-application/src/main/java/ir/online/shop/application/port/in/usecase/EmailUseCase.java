package ir.online.shop.application.port.in.usecase;

import io.qoop.filter.bean.api.UseCaseService;

@UseCaseService
public class EmailUseCase {

//    @Autowired
//    private JavaMailSender mailSender;

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
