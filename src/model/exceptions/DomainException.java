package model.exceptions;

public class DomainException extends RuntimeException {

	/**
	 *  Serializable - Obj dessa Classe que são serializable podem ser convertidas para Byte 
	 *  E assim trafegar melhor em redes e tem possibilidade em ser gravada em arquivos
	 */
	private static final long serialVersionUID = 1L;
	
	public DomainException (String msg) {
		super(msg);
	}
	
	
	

}
