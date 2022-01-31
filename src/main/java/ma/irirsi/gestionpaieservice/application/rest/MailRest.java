package ma.irirsi.gestionpaieservice.application.rest;

import ma.irirsi.gestionpaieservice.application.dto.MailParameter;
import ma.irirsi.gestionpaieservice.infra.impl.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestion-paie/api/v1/mail")
public class MailRest {
    @Autowired
    MailSender mailSender;

    @PostMapping("/send")
    public void sendMail(@RequestBody MailParameter mailParameter) {
        mailSender.sendSimpleMessage(mailParameter);
    }

    @PostMapping("/sendKafka")
    public void sendMailKafka(@RequestBody MailParameter mailParameter) {
        mailSender.sendKafkaMessage(mailParameter);
    }
}
