package kr.co.spatialt.rdatgis.cmm.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : 김언중
 * @since : 2023. 07. 10.
 * <p>
 * == 수정사항 ==
 * ---------------------------------------
 * 2023. 07. 10.  김언중 최초 생성
 */
@Slf4j
public class RdaTgisInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("===============");
        log.info("preHandle");
        log.info("===============");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("===============");
        log.info("postHandle");
        log.info("===============");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
