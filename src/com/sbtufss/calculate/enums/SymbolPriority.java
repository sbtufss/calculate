package com.sbtufss.calculate.enums;
/**
 * 操作符的优先级
 * @author sbtufss
 *
 */
public enum SymbolPriority {
	/**
	 * 没用，类似左右括号
	 */
	USELESS(0),
	/**
	 * 最低优先级
	 */
	MIN(1),
	/**
	 * 加
	 */
	PLUS(3),
	/**
	 * 减
	 */
	RDUCE(3),
	/**
	 * 乘
	 */
	MULT(6),
	/**
	 * 除
	 */
	DIVIDE(6),
	/**
	 * 
	 */
	CUSTOM(10),
	/**
	 * 最高
	 */
	MAX(20);

	private int value;

	private SymbolPriority(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
	
	/**
	 * @param priority 对比的枚举
	 * @return 如果返回值大于0,则比priority的优先级高，等于，则和priority的优先级相等，反正，比priority的优先级低
	 */
	public int compareWith(SymbolPriority priority) {
		return value - priority.value();
	}
}
