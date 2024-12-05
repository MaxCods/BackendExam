import models.ExampleModel;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import storage.ExampleModelInMemoryStorage;

import java.util.List;

public class ServerExam {
    public static void main(String[] args)  throws Exception{
        server();
    }

    public static void server() throws Exception{
        Server server= new Server(8082);

        ServletContextHandler context = new ServletContextHandler( ServletContextHandler.SESSIONS );
        context.setContextPath( "/" );
        server.setHandler( context );

        context.addServlet( new ServletHolder( new ExamServlet( ) ), "/task" );

        server.start( );

        // The next statement keeps the server running -- don't remove it!
        server.join( );


    }
}
