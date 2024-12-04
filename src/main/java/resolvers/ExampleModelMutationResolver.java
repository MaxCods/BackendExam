package resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import models.ExampleModel;
import models.ExampleModelInput;
import storage.ExampleModelInMemoryStorage;

public class ExampleModelMutationResolver implements GraphQLMutationResolver {
    public ExampleModel create(final String Name )
    {
        final ExampleModel model = new ExampleModel( );
        model.setName( Name );
        ExampleModelInMemoryStorage.getInstance( ).create( model );

        return model;
    }

    public ExampleModel update( final ExampleModelInput exampleModelInput )
    {
        // TODO fill this method
        ExampleModelInMemoryStorage storage = ExampleModelInMemoryStorage.getInstance();
        ExampleModel toUpdate = ExampleModelInMemoryStorage.getInstance( ).readById(exampleModelInput.getId() ).orElseGet( null );
        if (toUpdate == null){
            throw new RuntimeException("Model not found");
        }
        toUpdate.setName(exampleModelInput.getName());
        storage.update(toUpdate);
        return toUpdate;
    }

    public Boolean delete( final long id )
    {
        // TODO fill this method
        ExampleModelInMemoryStorage storage = ExampleModelInMemoryStorage.getInstance();
        storage.delete(id);
        return true;
    }
}
