package com.TiendaM_1Q2023.Service;

import com.TiendaM_1Q2023.Dao.CarritoDao;
import com.TiendaM_1Q2023.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceIMPL implements CarritoService {

    @Autowired
    CarritoDao carritoDao;

    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);

    }

    @Override
    public Carrito getcarritoCliente(Long idCliente) {
        Carrito carritoCliente = carritoDao.findByIdCliente(idCliente).orElse(null);

        //Si no exisdte el carrito se crea
        if (carritoCliente == null) {
            Carrito carritoNuevo = new Carrito(idCliente); // idCarrito 0 = =, idCliente =2
            carritoDao.save(carritoNuevo); // idCarrito 1= =, idCliente =2

        }
        return carritoCliente;

    }
}
