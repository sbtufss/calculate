package com.sbtufss.calculate.managers;

import com.sbtufss.calculate.symbols.DivideSymbol;
import com.sbtufss.calculate.symbols.MathPowSymbol;
import com.sbtufss.calculate.symbols.MultSymbol;
import com.sbtufss.calculate.symbols.PlusSymbol;
import com.sbtufss.calculate.symbols.ReduceSymbol;

/**
 * 管理操作符字符串所对应的操作符类
 * 
 * @author sbtufss
 * 
 */
public class CommonSymbolManager extends SymbolManager {

	public CommonSymbolManager() {
		super();
		list.add(new PlusSymbol());
		list.add(new ReduceSymbol());
		list.add(new MultSymbol());
		list.add(new DivideSymbol());
		list.add(new MathPowSymbol());
	}

	
}
