package resolvers;

import graphql.kickstart.tools.GraphQLQueryResolver;
import models.ExampleModel;
import models.TaskInput;
import storage.ExampleModelInMemoryStorage;
import models.*;
import storage.TaskInMemoryStorage;

import java.util.List;

public class TaskQueryResolver implements GraphQLQueryResolver {

    public List<Task> getAll( )
    {
        return TaskInMemoryStorage.getInstance( ).readByPredicate(p -> true );
    }

    public List<Task> getAllWithFilter(String contains){
    return TaskInMemoryStorage.getInstance().readByPredicate(p->((Task)p).getDescription().contains(contains));
    }
}
