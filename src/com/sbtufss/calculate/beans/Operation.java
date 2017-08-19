package com.sbtufss.calculate.beans;

import com.sbtufss.calculate.enums.OperationType;
import com.sbtufss.calculate.enums.SymbolPriority;

/**
 * 操作符和操作数的基本描述
 * 
 * @author sbtufss
 * 
 */
public class Operation {
	private OperationType type;
	private String value;

	public Operation(OperationType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}

	public OperationType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}

}
