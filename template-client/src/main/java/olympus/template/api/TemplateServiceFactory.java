package olympus.template.api;

import olympus.message.processor.MessagingService;
import olympus.template.TemplateClient;
import olympus.template.api.controller.NotificationHandler;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TemplateServiceFactory {
    private final TemplateClient client;
    private final Map<String, ITemplateService> appDomainAndAPIVersionToServiceMap;

    public TemplateServiceFactory(MessagingService messagingService, NotificationHandler notificationHandler) {
        client = new TemplateClient(messagingService, notificationHandler);
        appDomainAndAPIVersionToServiceMap = new ConcurrentHashMap<>();
    }

    public Optional<ITemplateService> getService(String appDomain, String versionString) {
        if (versionString.equals("1.0")) {
            //todo: do cache management
            TemplateService value = new TemplateService();
            return Optional.of(value);
        }
        return Optional.empty();
    }
}