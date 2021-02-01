package br.com.wesley.dividas.util;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizadorInterceptorAdapter extends
        HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object controller) throws Exception {

        String uri = request.getRequestURI();
        if (uri.contains("bootstrap") || uri.contains("css") ||
                uri.contains("img") || uri.contains("js") || uri.contains("resources") || uri.endsWith("dividas/")
                || uri.endsWith("logar") || uri.endsWith("exibirInserirUsuario") || uri.endsWith("inserirUsuario")) {

            return true;
        }

        if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
        }

        response.sendRedirect("/dividas");
        return false;
    }
}
