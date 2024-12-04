package models;

public class ExampleModelInput {
    private long id;

    private String Name;

    public String getName( )
    {
        return Name;
    }

    public void setName( final String Name )
    {
        this.Name = Name;
    }

    public long getId( )
    {
        return id;
    }

    public void setId( final long id )
    {
        this.id = id;
    }
}
