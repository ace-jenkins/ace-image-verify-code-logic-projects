package ace.image.verify.code.logic.api.web.application.biz.imageverifycode;

import ace.image.verify.code.base.api.service.ImageVerifyCodeBaseService;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 17:32
 * @description
 */
@Component
@Slf4j
public class ImageVerifyCodeGetBiz {
    @Autowired
    private ImageVerifyCodeBaseService imageVerifyCodeBaseService;

    public void execute(GetImageVerifyCodeRequest request) {
        Response feignResponse = imageVerifyCodeBaseService.get(request);

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        response.setStatus(feignResponse.status());
        feignResponse.headers().entrySet().stream()
                .forEach(p -> {
                    response.setHeader(p.getKey(), StringUtils.join(p.getValue(), ';'));
                });

//        //设置响应头通知浏览器以图片的形式打开
//        response.setContentType("image/jpeg");
//        //设置响应头控制浏览器不要缓存
//        response.setDateHeader("expries", -1);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Pragma", "no-cache");
        try {
            //将图片写给浏览器
            IOUtils.copy(feignResponse.body().asInputStream(), response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception ex) {
            log.error("生成图形验证码失败", ex);
            throw new RuntimeException(ex);
        }
    }


}
