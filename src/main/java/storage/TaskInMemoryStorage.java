package storage;

public class TaskInMemoryStorage extends AbstractInMemoryStorage{
    private static TaskInMemoryStorage INSTANCE;

    public static final TaskInMemoryStorage getInstance( )
    {
        if ( INSTANCE == null )
        {
            INSTANCE = new TaskInMemoryStorage( );
        }

        return INSTANCE;
    }
}
