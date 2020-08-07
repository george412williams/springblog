package services;


import com.codeup.springblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;
    //delivery guy

    //NOTE: pulls property defined in app properties and assigns to variable its createing
        //will see this syntax much in capstone
        //pulling from: the email line inthe app.props file
    @Value("${spring.mail.from")
    private String from;


    //fxality from javamailsender
    //packing a box up with it fx's
    public void prepareAndSend(Post post, String subject, String body){
        //in curric, simplemailmessage - an object that puts it together, build in
        SimpleMailMessage msg = new SimpleMailMessage();
        //has properties, the info about the email, coming from? subj, body etc. w built in stuff
        msg.setFrom(from);
        //comign from controller that was injected into, quiz: which one?
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(subject);
        msg.setText(body);
        //the box is packed up next:

        //email sender throws exc
        try {
            //esender is an instance, send is a method of it, and sending the composed msg
            this.emailSender.send(msg);
        }catch (MailException e){
            System.out.println(e.getMessage());
        }
    }

    //now how to integrate further, like the view
}
