package br.com.gastosapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gastosapi.model.Gasto;

@Repository
public interface GastosRepository extends CrudRepository<Gasto, Long>{

	List<Gasto> findByCodigoUsuario(Long codigoUsuario);

	List<Gasto> findByDataGasto(Long codigoUsuario, LocalDate dataGasto);
	
	List<Gasto> findByDataGasto(Long codigoUsuario, LocalDate dataInicio, LocalDate dataFim);
	
//	List<Gasto> pesquisarGastosUltimosCincoSegundosPorIdCliente(Long idCliente, LocalDateTime data);
	
}
