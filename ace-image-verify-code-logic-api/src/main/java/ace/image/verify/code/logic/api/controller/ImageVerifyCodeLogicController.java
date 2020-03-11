package ace.image.verify.code.logic.api.controller;

import ace.image.verify.code.logic.api.service.ImageVerifyCodeLogicService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 11:37
 * @description
 */

@RestController
@RequestMapping(path = "/" + ImageVerifyCodeLogicService.MODULE_RESTFUL_NAME)
@Validated
public interface ImageVerifyCodeLogicController extends ImageVerifyCodeLogicService {

}
