package prog2.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class base{

    protected Long id;
    protected boolean eliminado;
    protected LocalDateTime createdAt;

    public base(){
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    public base(Long id){
        this.id = id;
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public boolean isEliminado(){
        return eliminado;
    }

    public void setEliminado(boolean eliminado){
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof base base)) return false;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}