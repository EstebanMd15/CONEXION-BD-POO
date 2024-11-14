
package modelo;


public class Categoria {
    private int codigo;
    private String nombre;
    private String descipcion;

    public Categoria(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descipcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descipcion;
    }

    public void setDescripcion(String descripcion) {
        this.descipcion = descripcion;
    }
    
}
