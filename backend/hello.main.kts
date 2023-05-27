@file:DependsOn("org.jetbrains.kotlin:kotlin-stdlib:1.8.21")
@file:DependsOn("org.eclipse.jetty:jetty-server:9.4.31.v20200723")
@file:DependsOn("org.eclipse.jetty:jetty-servlet:9.4.31.v20200723")
@file:DependsOn("org.eclipse.jetty:jetty-servlets:9.4.31.v20200723")
@file:DependsOn("com.google.code.gson:gson:2.8.6")

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.servlets.CrossOriginFilter
import com.google.gson.Gson
import javax.servlet.DispatcherType
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.util.EnumSet

class HelloServlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.contentType = "application/json"
        resp.writer.println(Gson().toJson(mapOf("message" to "こんにちは")))
    }
}

val server = Server(8080)
val context = ServletContextHandler(ServletContextHandler.NO_SESSIONS).apply {
    contextPath = "/"
    addFilter(CrossOriginFilter::class.java, "/*", EnumSet.of(DispatcherType.REQUEST)).apply {
        setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*")
        setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,HEAD")
        setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin")
    }
    addServlet(ServletHolder(HelloServlet()), "/hello")
}
server.handler = context
server.start()
server.join()
