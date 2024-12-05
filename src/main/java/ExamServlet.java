import graphql.kickstart.servlet.GraphQLConfiguration;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import jakarta.servlet.annotation.WebServlet;
import org.apache.commons.io.IOUtils;
import resolvers.ExampleModelMutationResolver;
import resolvers.ExampleModelQueryResolver;
import resolvers.TaskMutationResolver;
import resolvers.TaskQueryResolver;

import java.io.IOException;

@WebServlet(name="ExamServlet",urlPatterns={"/task/*"},loadOnStartup=1)
public class ExamServlet extends GraphQLHttpServlet {

    public ExamServlet(){
        System.out.println("ExamServlet starts");
    }

   @Override
   protected GraphQLConfiguration getConfiguration(){
        return  GraphQLConfiguration.with( createSchema( ) ).build( );
   }

    private GraphQLSchema createSchema( )
    {
        try
        {
            final String schemaString = IOUtils.toString( this.getClass( )
                    .getResourceAsStream( "/schemaTask.graphqls" ) );

            return SchemaParser.newParser( )
                    .schemaString( schemaString )
                    .resolvers( new TaskQueryResolver(),new TaskMutationResolver()  )
                    .build( )
                    .makeExecutableSchema( );
        }
        catch ( final IOException e )
        {
            e.printStackTrace( );
            return null;
        }
    }
}
