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
    public Task update(final TaskInput Input){
        if(TaskInMemoryStorage.getInstance().readById(Input.getId()).isPresent()){
            Task toUpdate= (Task)TaskInMemoryStorage.getInstance().readById(Input.getId()).get();
            toUpdate.setStatus(Input.getStatus());
            toUpdate.setTitle(Input.getTitle());
            toUpdate.setDescription(Input.getDescription());

            TaskInMemoryStorage.getInstance().update(toUpdate);
            return toUpdate;
        }
        else return null;
    }
    public boolean delete(int id){

        if(TaskInMemoryStorage.getInstance().readById(id).isPresent()){
        TaskInMemoryStorage.getInstance().delete(id);
        return true;}
        else return false;
    }
}
