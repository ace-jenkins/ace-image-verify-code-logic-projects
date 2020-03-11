package ace.image.verify.code.logic.api.web.application.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.image.verify.code.logic.api.controller.ImageVerifyCodeLogicController;
import ace.image.verify.code.logic.api.web.application.biz.imageverifycode.ImageVerifyCodeCheckBiz;
import ace.image.verify.code.logic.api.web.application.biz.imageverifycode.ImageVerifyCodeGetBiz;
import ace.image.verify.code.define.base.model.request.CheckRequest;
import ace.image.verify.code.define.base.model.request.GetImageVerifyCodeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */
@RestController
@Validated
@Slf4j
public class ImageVerifyCodeLogicControllerImpl implements ImageVerifyCodeLogicController {
    @Autowired
    private ImageVerifyCodeGetBiz getBiz;
    @Autowired
    private ImageVerifyCodeCheckBiz imageVerifyCodeCheckBiz;

    @Override
    public void get(@Valid GetImageVerifyCodeRequest request) {
        getBiz.execute(request);
    }

    @Override
    public GenericResponseExt<Boolean> check(@Valid CheckRequest request) {
        return imageVerifyCodeCheckBiz.execute(request);
    }
}
