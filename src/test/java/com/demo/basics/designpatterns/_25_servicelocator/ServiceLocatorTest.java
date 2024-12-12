package com.demo.basics.designpatterns._25_servicelocator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Service Locator
 */
public class ServiceLocatorTest {

    @Test
    public void test() {
        MessagingService service = ServiceLocator.getService("EmailService");
        String email = service.getMessageBody();
        System.out.println(email);

        MessagingService smsService = ServiceLocator.getService("SMSService");
        String sms = smsService.getMessageBody();
        System.out.println(sms);

        MessagingService emailService = ServiceLocator.getService("EmailService");
        String newEmail = emailService.getMessageBody();
        System.out.println(newEmail);
    }
}

class InitialContext {
    public Object lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            return new EmailService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            return new SmsService();
        }
        return null;
    }
}

class EmailService implements MessagingService {
    public String getMessageBody() {
        return "email message";
    }

    public String getServiceName() {
        return "EmailService";
    }

}

class SmsService implements MessagingService {
    public String getMessageBody() {
        return "sms message";
    }

    public String getServiceName() {
        return "SmsService";
    }

}

class Cache {
    private List<MessagingService> services;

    public Cache() {
        services = new ArrayList<MessagingService>();
    }

    public MessagingService getService(String serviceName) {

        for (MessagingService service : services) {
            if (service.getServiceName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached  " + serviceName + " object");
                return service;
            }
        }
        return null;
    }

    public void addService(MessagingService newService) {
        boolean exists = false;

        for (MessagingService service : services) {
            if (service.getServiceName().equalsIgnoreCase(newService.getServiceName())) {
                exists = true;
            }
        }
        if (!exists) {
            services.add(newService);
        }
    }
}

interface MessagingService {
    String getMessageBody();

    String getServiceName();

}

class ServiceLocator {

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static MessagingService getService(String serviceName) {

        MessagingService service = cache.getService(serviceName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        MessagingService service1 = (MessagingService) context.lookup(serviceName);
        cache.addService(service1);
        return service1;
    }
}

