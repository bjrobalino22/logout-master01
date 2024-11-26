package servicio;

import Modelo.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImplement implements ProductoServices{

    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1,"laptop","computacion",574.25),
                new Producto(2,"cocina","hogar",359.45),
                new Producto(3,"mouse","tecnologia",15.52));
    }
}