package br.com.gastosapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gastosapi.model.Gasto;
import br.com.gastosapi.repository.GastosRepository;

@Service
public class GastosService{

	@Autowired
	private GastosRepository gastosRepository;

	public void save(Gasto gasto){
		gastosRepository.save(gasto);
	}
	
	public Iterable<Gasto> listarTodos(){
		return gastosRepository.findAll();
	}
	
	public void delete(Long idGasto){
		gastosRepository.delete(idGasto);;
	}

	public List<Gasto> findByCodigoUsuario(Long codigoUsuario){
		return gastosRepository.findByCodigoUsuario(codigoUsuario);
	}
	
	public List<Gasto> findByDataGasto(Long codigoUsuario, LocalDate dataGasto){
		return gastosRepository.findByDataGasto(codigoUsuario, dataGasto);
	}
	
	public List<Gasto> findByDataGasto(Long codigoUsuario, LocalDate dataInicio, LocalDate dataFim){
		return gastosRepository.findByDataGasto(codigoUsuario, dataInicio, dataFim);
	}

	//	public List<Gasto> pesquisarGastosUltimosCincoSegundosPorIdCliente(Long idCliente, LocalDateTime data){
//		return gastosRepository.pesquisarGastosUltimosCincoSegundosPorIdCliente(idCliente, data);
//	}
//	
	
}
