package services;


import org.springframework.stereotype.Service;

@Service
//can provide a name like:
//@Service("greet-service")
public class GreetingSvc {

    public String goodMorning(String name){
        return "good morning, " + name + "!";
    }

    public String goodAfternoon(String name){
        return "good afternoon, " + name + "!";
    }

    public String goodEvening(String name){
        return "good evening, " + name + "!";
    }


}
