package co.edu.sena.ejemplojpa02.model.jpa.entites.llavesforaneas;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente implements java.io.Serializable{
    private final static long serialVersionUID = 34L;

    @EmbeddedId
    private ClientePk clientePk;

    @Column(name = "primer_nombre", length = 50)
    @NotNull
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 50)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 50)
    @NotNull
    private String primerApellido;

    @Column(name = "segundo_Apellido", length = 50)
    private String segundoApellido;

    @JoinColumn(name ="tipo_documento", referencedColumnName = "documento", insertable = false, updatable = false)
    @ManyToOne
    private TipoDocumento tipoDocumento;







}
