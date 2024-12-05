package resolvers;

import graphql.kickstart.tools.GraphQLMutationResolver;
import models.ExampleModel;
import models.Task;
import models.TaskInput;
import storage.TaskInMemoryStorage;
import models.*;

public class TaskMutationResolver implements GraphQLMutationResolver {

    public Task create(final TaskInput Task )
    {
        Task t= new Task();
        t.setTitle(Task.getTitle());
        t.setDescription(Task.getDescription());
        t.setDate(Task.getDate());
        t.setStatus(Task.getStatus());
        TaskInMemoryStorage.getInstance().create(t);
        return t;
    }
}
