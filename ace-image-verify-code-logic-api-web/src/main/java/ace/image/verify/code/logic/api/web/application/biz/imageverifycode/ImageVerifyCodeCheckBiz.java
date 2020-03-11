package ace.image.verify.code.logic.api.web.application.biz.imageverifycode;

import ace.fw.exception.BusinessException;
import ace.fw.model.response.GenericResponseExt;
import ace.image.verify.code.base.api.service.ImageVerifyCodeBaseService;
import ace.image.verify.code.logic.api.web.application.biz.imageverifycode.util.ImageVerifyCodeUtils;
import ace.image.verify.code.define.base.model.request.CheckRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/3/2 17:32
 * @description
 */
@Component
@Slf4j
public class ImageVerifyCodeCheckBiz {

    @Autowired
    private ImageVerifyCodeBaseService imageVerifyCodeBaseService;


    public GenericResponseExt<Boolean> execute(CheckRequest request) {
        return imageVerifyCodeBaseService.check(request);
    }
}
