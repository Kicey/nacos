package com.alibaba.nacos.console.controller;

import com.alibaba.nacos.common.http.HttpClientBeanHolder;
import com.alibaba.nacos.common.http.client.NacosRestTemplate;
import com.alibaba.nacos.console.utils.OidcUtil;
import com.alibaba.nacos.core.utils.Loggers;
import com.alibaba.nacos.sys.env.EnvUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth/oidc")
public class OidcAuthController {

    NacosRestTemplate restTemplate = HttpClientBeanHolder.getNacosRestTemplate(Loggers.AUTH);

    @GetMapping("/list")
    public Map<String, String> list() {
        Map<String, String> oidpMap = new HashMap<>();
        List<String> oidpList = EnvUtil.getProperty("oidps", List.class);
        oidpList.forEach(
                oidp -> {
                    oidpMap.put(oidp, OidcUtil.getAuthUrl(oidp));
                }
        );
        return oidpMap;
    }

    @GetMapping("/init")
    public void init(@RequestParam("oidpId") String oidpId, HttpServletResponse response) {

        response.setStatus(HttpServletResponse.SC_FOUND);
        response.setHeader("Location", OidcUtil.getAuthUrl(oidpId));

    }

    @PostMapping("callback")
    public void callback(@RequestParam("code") String code) {

    }
}
