package com.example.demo.read;

import com.example.demo.utils.EnvironmentUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("read")
@Api(value = "ReadProperties")
public class ReadProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadProperties.class);

    @Autowired
    private Environment env;

    @Autowired
    private EnvironmentUtil envUtil;

    @Value("${val.name}")
    private String readValueFromProperties;
    @Value("${some.key}")
    private String[] urls;

    @ApiOperation(value = "Read Environment")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping(path = "/env")
    public Object environment(HttpServletRequest request) throws UnknownHostException {
        Map<String, Object> map = new HashMap<>();
        map.put("port", envUtil.getPort());
        map.put("host", envUtil.getHostname());
        map.put("URI",request.getRequestURI());
        return map;
    }

    @ApiOperation(value = "Read Properties")
    @ApiResponses(value = {
            @ApiResponse(code = 100, message = "100 Message"),
            @ApiResponse(code = 200, message = "200 Success Message")
    })
    @GetMapping("/prop")
    public String getAllEmployees(HttpServletRequest request) {
        LOGGER.info("getAllEmployees===");
        String path = env.getProperty("val.name");
        String[] springRocks = env.getProperty("some.key", String[].class);
        return "getAllEmployees=====" + readValueFromProperties + "====" + path + "====" + springRocks.length + "====" + request.getRequestURI();
    }
}