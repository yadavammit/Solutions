
public class Parenthesis {
	public static void main(String[] args) {
		Parenthesis pa = new Parenthesis();
		System.out.println(pa.longestValidParentheses("(()"));
	}

	public int longestValidParentheses(String s) {
		int numberOfLeftPar = 0;
		int numberOfRightPar = 0;

		int i = 0;
		int j = 0;
		int maxValue = 0;
		while (j <= i && i < s.length()) {
			if (s.charAt(i) == '(') {
				numberOfLeftPar++;
			}
			if (s.charAt(i) == ')') {
				numberOfRightPar++;
			}

			if (numberOfLeftPar == numberOfRightPar) {
				maxValue = maxValue > i - j + 1 ? maxValue : i - j + 1;
			}

			while (numberOfLeftPar < numberOfRightPar) {
				if (s.charAt(j) == '(') {
					numberOfLeftPar--;
				}
				if (s.charAt(j) == ')') {
					numberOfRightPar--;
				}
				j++;
			}

			i++;
		}

		while (numberOfLeftPar > numberOfRightPar && j < i) {
			if (s.charAt(j) == '(') {
				numberOfLeftPar--;
			}
			if (s.charAt(j) == ')') {
				numberOfRightPar--;
			}

			if (numberOfLeftPar < numberOfRightPar) {
				maxValue = maxValue > i - j ? maxValue : i - j;
			}
			j++;
		}

		return maxValue;

	}
}
