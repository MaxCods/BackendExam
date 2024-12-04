package storage;

import com.github.javafaker.Faker;
import models.ExampleModel;

public class ExampleModelInMemoryStorage extends AbstractInMemoryStorage<ExampleModel>{
    private static ExampleModelInMemoryStorage INSTANCE;

    public static final ExampleModelInMemoryStorage getInstance( )
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new ExampleModelInMemoryStorage( );
        }

        return INSTANCE;
    }

    public void populateDatabase()
    {
        final Faker faker = new Faker( );
        for( int i=0; i<100; i++ )
        {
            final ExampleModel exampleModel = new ExampleModel();
            exampleModel.setName( faker.name().name());

            create( exampleModel );
        }
    }
}
