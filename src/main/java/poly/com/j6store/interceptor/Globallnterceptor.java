package poly.com.j6store.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import poly.com.j6store.services.CategoryServices;

@Component
public class Globallnterceptor implements HandlerInterceptor {

    @Autowired
    CategoryServices categoryServices;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    request.setAttribute("cates", categoryServices.findAll() );
    }
}
