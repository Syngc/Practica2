package com.udea.practica2.modelo;

import com.udea.practica2.modelo.EstudiantePK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-09T22:20:37")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, EstudiantePK> estudiantePK;
    public static volatile SingularAttribute<Estudiante, byte[]> foto;
    public static volatile SingularAttribute<Estudiante, Date> fechaNacimiento;
    public static volatile SingularAttribute<Estudiante, String> direccion;
    public static volatile SingularAttribute<Estudiante, String> programa;
    public static volatile SingularAttribute<Estudiante, String> telefono;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile SingularAttribute<Estudiante, String> email;

}