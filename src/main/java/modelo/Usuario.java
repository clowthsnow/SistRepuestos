package modelo;

public class Usuario {
        private String codigo;
	private String nombre;
	private String contraseña;
	private String DNI;
        private String cargo;
	private String EstRegistro;
	public Usuario() {
		this.codigo = "";
		this.nombre = "";
		this.contraseña = "";
                this.DNI="";
		this.cargo = "";
		EstRegistro = "";
	}
        public Usuario(String codigo, String contraseña) {
		this.codigo = codigo;
		this.nombre = null;
		this.contraseña = contraseña;
                this.DNI=null;
		this.cargo = null;
		EstRegistro = null;
	}

    public Usuario(String codigo, String nombre, String contraseña, String DNI, String cargo, String EstRegistro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.DNI = DNI;
        this.cargo = cargo;
        this.EstRegistro = EstRegistro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstRegistro() {
        return EstRegistro;
    }

    public void setEstRegistro(String EstRegistro) {
        this.EstRegistro = EstRegistro;
    }
        
}
