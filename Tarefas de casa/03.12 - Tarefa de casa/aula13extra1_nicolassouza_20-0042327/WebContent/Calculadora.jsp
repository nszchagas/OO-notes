<HTML>
<HEAD>
<TITLE>Multiplicando</TITLE>
</HEAD>

<BODY>
	<H1>Multiplicando</H1>
	<BR>
	<%
		float num1, num2;
	try {
		num1 = Float.parseFloat(request.getParameter("num1"));
		num2 = Float.parseFloat(request.getParameter("num2"));

		out.println("Produto entre os dois números: " + new java.text.DecimalFormat("0.00").format(num1 * num2));

	} catch (NumberFormatException e) {
		out.println("Digite apenas numeros");
	}
	%>
</BODY>
</HTML>
