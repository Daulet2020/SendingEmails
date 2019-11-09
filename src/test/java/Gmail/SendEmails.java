package Gmail;

import org.apache.commons.mail.SimpleEmail;

public class SendEmails {
    /*
           first Step:
               go to  :
                    https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web
                       Make sure that your google account allows third part app
        */
    public static void main(String[] args) {
        String userName = "daulet2020@gmail.com";
        String passWord = "Astana1!1";
        String MSG;
        MSG = "Hello my friend!!!!!";
        String Subject ="Cybertekskills";

        String[] Recievers = new String[]{"doshayev@gmail.com", "dauren.polatbekov@gmail.com", "daulet2030@mail.ru"};

        int times = 1;
        while( times > 0) {
            for (String students : Recievers) {
                sendEmails(userName, passWord, students, MSG, Subject);
                System.out.println("Send successfully");
            }
            times--;
        }
    }

    public static void sendEmails(String username, String password, String Receiver, String MSG, String Subject){
        SimpleEmail email=new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true);
        email.setSubject(Subject);
        try {
            email.setFrom(username);
            email.setMsg(MSG);
            email.addTo(Receiver);
            email.send();
            Thread.sleep(3000);
        } catch (Exception e) {   }
    }
}

