package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva() {
	
	}


	public Reserva(Integer numeroQuarto, Date entrada, Date saida) throws DomainException {
		if (!saida.after(entrada)) {
			throw new DomainException("Erro na reserva, saida anterior a data de entrada");
			
		}
		
		
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}


	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}


	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}


	public Date getEntrada() {
		return entrada;
	}


	

	public Date getSaida() {
		return saida;
	}


	public long duracao() {
		long diferenca = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date entrada, Date saida) throws DomainException{
		
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			throw new DomainException("ERRO!!!  A reserva s� pode ser atualizada para datas futuras.");
			
		}
		
		if (!saida.after(entrada)) {
			throw new DomainException("Erro na reserva, saida anterior a data de entrada");
			
		}
		this.entrada = entrada;
		this.saida = saida;
		
	}


	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", Entrada: "
			+ sdf.format(entrada)
			+ ", saida: "
			+ sdf.format(saida)
			+ ", "
			+ duracao()
			+ " noites";
	}
	
	
	
	
}
