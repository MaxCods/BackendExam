package models;

public abstract class AbstractModel {

    protected long id;

    public long getId( )
    {
        return id;
    }

    public void setId( final long id )
    {
        this.id = id;
    }

}
