package org.ylc.frame.cloud.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 代码全万行，注释第一行
 * 注释不规范，同事泪两行
 * <p>
 * 过滤器
 *
 * @author YuLc
 * @version 1.0.0
 * @date 2020-02-13
 */
@Component
public class MyFilter extends ZuulFilter {

    /**
     * 过滤器类别
     * pre,routing,post,error
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤顺序，值越小越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行过滤逻辑
     * true则执行run方法
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤业务逻辑
     * 只有当`shouldFilter`为true时才执行
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }
}
