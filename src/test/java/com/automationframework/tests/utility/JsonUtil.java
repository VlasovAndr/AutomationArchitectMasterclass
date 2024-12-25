package com.automationframework.tests.utility;

import com.automationframework.tests.vendorportal.model.VendorPortalTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static VendorPortalTestData getTestData(String path) throws Exception {
        try (InputStream stream = ResourceLoader.getResource(path)) {
            return mapper.readValue(stream, VendorPortalTestData.class);
        } catch (Exception e) {
            log.error("Unable to read test data {}", path);
        }
        return null;
    }
}
