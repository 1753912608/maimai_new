package maimai_new.demo.interceptors;

import maimai_new.demo.dao.SessionInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器访问");
        HttpSession session=request.getSession();
        String phone=(String)session.getAttribute(SessionInfo.USER_ID);
        if(phone==null){
            request.getRequestDispatcher("test_login").forward(request,response);
            return false;
        }
        return true;
    }
}
