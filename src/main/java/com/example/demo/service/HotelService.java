package com.example.demo.service;

import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	
	public void crear(Hotel hotel);
	public void modificar(Hotel hotel);
	public Hotel buscar(Integer id);
	public void eliminar(Integer id);

}
