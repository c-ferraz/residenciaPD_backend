package br.com.conexaoporto.springbootAPI.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.conexaoporto.springbootAPI.entities.Profissional;

public interface ProfissionalRepository extends CrudRepository<Profissional, Long> {
	Profissional findById(long id);//Subscreve o tipo de findById para Profissional
}
