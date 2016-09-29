# olympus_template
Its a template for writing Olympus services.

* olympus.common.OlympusService should have the name of your service.

* olympus.proteus.services.TenantFactory.java in proteus will compose TemplateServiceFactory.

There will be  handler added to a map like:

tenants.put("templateService", new Function<String[], Object>() {
            @Nullable
            @Override
            public Object apply(@Nullable String[] args) {
                String ad = args[0];
                String version = args[1];
                return templateServiceFactory.getService(ad, version);
            }
        });