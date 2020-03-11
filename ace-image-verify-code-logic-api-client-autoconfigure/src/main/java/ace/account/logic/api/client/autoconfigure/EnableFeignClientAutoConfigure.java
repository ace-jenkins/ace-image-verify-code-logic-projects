package ace.account.logic.api.client.autoconfigure;

import ace.image.verify.code.define.base.constant.ImageVerifyCodeConstants;
import ace.image.verify.code.logic.api.controller.ImageVerifyCodeLogicController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/5 1:20
 * @description
 */
@ConditionalOnProperty(
        name = ImageVerifyCodeConstants.LOGIC_CONFIG_KEY_API_CLIENT_ENABLE,
        havingValue = "true",
        matchIfMissing = true
)
@ConditionalOnMissingBean({ImageVerifyCodeLogicController.class})
@ConditionalOnBean(annotation = {EnableFeignClients.class})
@EnableFeignClients(basePackages = {ImageVerifyCodeConstants.LOGIC_FEIGN_CLIENT_SERVICE_PACKAGE})
@Configuration
public class EnableFeignClientAutoConfigure {

}
