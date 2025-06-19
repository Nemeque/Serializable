import java.io.Serializable;

public interface interfaz extends Serializable {
    
    long serialVersionUID = 1L;
    
    String getName();
    void setName(String name);
    String deberes();
    
}