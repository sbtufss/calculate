package com.sbtufss.calculate;

import java.util.Arrays;
import java.util.Stack;

import com.sbtufss.calculate.beans.Operation;
import com.sbtufss.calculate.enums.OperationType;
import com.sbtufss.calculate.managers.CommonSymbolManager;
import com.sbtufss.calculate.managers.SymbolManager;
import com.sbtufss.calculate.symbols.Symbol;

public class Calculator {

	private SymbolManager symbolManager;
	private Operation operationsBo[];// 存储关于逆波兰的字符串数组
	private int index = 0;// strsBo的下一个存储下标，从0开始
	private Stack<Operation> stack = new Stack<>();// 存储操作符的栈

	public Calculator() {
		symbolManager = new CommonSymbolManager();
	}

	public void setSymbolManager(SymbolManager symbolManager) {
		this.symbolManager = symbolManager;
	}

	public void handleStr(String strOp) {
		String str = spaceStr(strOp.trim());
		String[] split = str.trim().split(" +");// 根据多个空格或者一个空格来进行分隔
		// 将字符串数组转换成Operation
		Operation[] operations = new Operation[split.length];
		// 处理新的表达式，要将operationsBo数组初始化,index赋值0，stack清空
		operationsBo = new Operation[split.length];
		index = 0;
		stack.clear();

		turnToOperations(split, operations);

		for (Operation operation : operations) {
			if (operation.getType() == OperationType.VALUE) {// 判断是否是数值
				operationsBo[index++] = operation;
			} else {
				handleStack(operation);
			}
		}
		// 当遍历结束后，将栈里面剩余的操作符依次弹出并且添加到数组strs里面
		while (stack != null && !stack.empty()) {
			operationsBo[index++] = stack.pop();
		}
		System.out.println(Arrays.toString(operationsBo));
		// 计算结果
		Operation operation;
		for (int i = 0; operationsBo[i] != null; i++) {
			operation = operationsBo[i];
			if (operation.getType() == OperationType.VALUE) {
				stack.push(operation);
			} else {
				Symbol symbol = symbolManager.get(operation.getValue());
				if (symbol != null) {
					int numOfSymbol = symbol.numOfSymbol();
					double values[] = new double[numOfSymbol];
					for (int j = 0; j < numOfSymbol; j++) {
						values[numOfSymbol - j - 1] = Double.valueOf(stack
								.pop().getValue());
					}
					Operation result = symbol.operation(values);// 计算出结果再压入栈里面
					stack.push(result);
				}
			}
		}
		System.out.println("计算结果：" + stack.pop().getValue());
	}

	/**
	 * 将字符串数组转变为Operation数组
	 * 
	 * @param split
	 * @param operations
	 */
	private void turnToOperations(String[] split, Operation[] operations) {
		Operation operation;
		OperationType type;
		for (int i = 0; i < split.length; i++) {
			if (split[i].matches("-?[0-9]+")
					|| split[i].matches("-?[0-9]+.?[0-9]+")) {// 判断是否是数值
				type = OperationType.VALUE;
			} else {
				type = OperationType.SYMBOL;
			}
			operation = new Operation(type, split[i]);
			operations[i] = operation;
		}
	}

	/**
	 * 将初始字符串表达式变成带空格的字符串表达式，方便分隔开来
	 * 
	 * @param str
	 * @return
	 */
	private String spaceStr(String str) {
		StringBuilder sb = new StringBuilder();
		char lastC = 0;
		char c = 0;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c > 57 || c < 48) {// 非数字
				if (c == 46 && lastC <= 57 && lastC >= 48) {// 小数点
															// 如果c为小数点，并且lastC为数字，那就直接append到sb里面
					sb.append(c);
				} else if (lastC == 40 && c == 45) {// 负数
													// 如果lastC为左括号，c为减号或者负号(减号)，那就直接append到sb里面
					sb.append(c);
				} else if (c == 40 || c == 41 || c == 42 || c == 43 || c == 45
						|| c == 47) {// 如果是左括号 右括号 乘号 加号 减号 除号
										// 则空格隔开，在append到sb里面
					sb.append(" ").append(c).append(" ");
				} else if (c == 44) {//如果是","那就不append到里卖弄，有空格隔开，是这种情况Math.pow(2,3)
					sb.append(" ");
				} else {// 其他字符直接append到sb里面
					sb.append(c);
				}
			} else {// 数字 是数字就直接append到sb里面
				sb.append(c);
			}// 记录上一个字符
			lastC = c;
		}
		return sb.toString();
	}

	private void handleStack(Operation operation) {
		if (operation.getValue().equals("(")) {// 当遇到左括号"("时，将它压入栈里面
			stack.push(operation);
		} else if (operation.getValue().equals(")")) {// 遇到了右括号,依次弹出操作符并且添加到strsBo里面，直到遇到左括号“(”，此时左右括号都作废
			Operation pop = stack.pop();
			while (!pop.getValue().equals("(")) {
				operationsBo[index++] = pop;
				pop = stack.pop();
			}
		} else if (stack.isEmpty()
				|| stack.lastElement().getValue().equals("(")) {// 栈stack为空，或栈顶运算符为左括号“(”，则直接将此操作符入栈
			stack.push(operation);
		} else {// 操作符不为右括号，才比较优先级
			if (symbolManager.get(operation.getValue()).priority().value() > symbolManager
					.get(stack.lastElement().getValue()).priority().value()) {// 若优先级比栈顶运算符的高，也将操作符压入stack
				stack.push(operation);
			} else {// 否则，将stack栈顶的运算符弹出并存储到strs数组中，再次与stack中新的栈顶运算符相比较
				operationsBo[index++] = stack.pop();
				handleStack(operation);
			}
		}
	}

}
