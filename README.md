# calculate
java字符串转算术表达式，并且计算出结果，能自定义自己要的运算符，扩展性好
调用非常方便，示例代码
public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.handleStr("(2+3.2)+Math.pow(3,2)*(40-5+(-1)*4)");
}

自定义自己的运算符，上面的Math.pow就是我们自定义的运算符
主要实现Symbol这个类,例如
package com.sbtufss.calculate.symbols;

import com.sbtufss.calculate.enums.SymbolPriority;

public class MathPowSymbol extends Symbol {

	@Override
	public String flag() {
		return "Math.pow";
	}

	@Override
	public SymbolPriority priority() {
		// TODO Auto-generated method stub
		return SymbolPriority.CUSTOM;
	}

	@Override
	public int numOfSymbol() {
		return 2;
	}

	@Override
	public double cal(double[] values) {
		double v1 = values[0];
		double v2 = values[1];
		return Math.pow(v1, v2);
	}

}
然后我们就要通知我们Calculator中的symbolManager，我们自定义了一个新的运算符，要添加进去
例如

public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.getSymbolManager().add(new MathPowSymbol());
		calculator.handleStr("(2+3.2)+Math.pow(3,2)*(40-5+(-1)*4)");
	}

 然后就可以了，扩展非常简单
 
 博客地址：http://www.cnblogs.com/pig-brother/p/7398274.html
