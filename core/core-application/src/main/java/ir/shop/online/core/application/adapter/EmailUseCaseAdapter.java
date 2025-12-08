package ir.shop.online.core.application.adapter;

import ir.shop.online.commons.domain.annotation.UseCaseService;
import ir.shop.online.core.domain.usecase.EmailUseCase;

@UseCaseService
public class EmailUseCaseAdapter implements EmailUseCase {

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
