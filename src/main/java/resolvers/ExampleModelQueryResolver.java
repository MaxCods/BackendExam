package resolvers;

import graphql.kickstart.tools.GraphQLQueryResolver;
import models.ExampleModel;
import storage.ExampleModelInMemoryStorage;

import java.util.List;

public class ExampleModelQueryResolver implements GraphQLQueryResolver {
    public ExampleModel model(int id )
    {
        return ExampleModelInMemoryStorage.getInstance( ).readById( id ).orElseGet( null );
    }

    public List<ExampleModel> models( )
    {
        return ExampleModelInMemoryStorage.getInstance( ).readByPredicate( p -> true );
    }

    public List<ExampleModel> modelByName( final String lastName )
    {
        return ExampleModelInMemoryStorage.getInstance( ).readByPredicate( p -> p.getName( ).equals( lastName ) );
    }

}
