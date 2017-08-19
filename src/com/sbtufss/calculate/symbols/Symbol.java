package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.beans.Operation;
import com.sbtufss.calculate.enums.OperationType;
import com.sbtufss.calculate.enums.SymbolPriority;

/**
 * 操作符的父类
 * 
 * @author sbtufss
 * 
 */
public abstract class Symbol {
	/**
	 * @return 操作符的指定标识
	 */
	public abstract String flag();

	/**
	 * @return 操作符的优先级
	 */
	public abstract SymbolPriority priority();

	/**
	 * @return 需要多少个操作数参与运算
	 */
	public abstract int numOfSymbol();

	/**
	 * 将结果封装成Operation
	 * @param values
	 * @return
	 */
	public Operation operation(double... values) {
		double result = cal(values);
		Operation o = new Operation(OperationType.VALUE, String.valueOf(result));
		return o;
	}
	/**
	 * 计算结果
	 * @param values
	 * @return 
	 * @return
	 */
	public abstract double cal(double[] values);

}
