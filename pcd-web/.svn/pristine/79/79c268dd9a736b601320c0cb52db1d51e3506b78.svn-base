function confirmar() {
	if (!confirm('\xbb\tLos datos se eliminar\xe1n permanentemente. \n\xbb\tEst\xe1 seguro ?'))
		return false;
	return true;
}

function confirmar(obj) {
	var msg = '\xbb\tLos datos se eliminar\xe1n ';
	if (obj) {
		msg = '\xbb\t' + obj + ' se eliminar\xe1';
	}
	if (!confirm(msg + ' permanentemente. \n\xbb\tEst\xe1 seguro ?'))
		return false;
	return true;
}

function confirmarInicio(obj) {
	var msg = '\xbb\tRealmente desea iniciar la evaluaci\xf3n? ';
	if (obj) {
		msg = '\xbb\tRealmente desea ' + obj + ' la evaluaci\xf3n? ';
	}
	if (!confirm(msg))
		return false;
	return true;
}

function confirmarSalida(obj) {
	var msg = '\xbb\tRealmente desea iniciar la evaluaci\xf3n? ';
	if (obj) {
		msg = '\xbb\tRealmente desea ' + obj + ' la evaluaci\xf3n? ';
	}
	if (!confirm(msg))
		return false;
	return true;
}

function contar(entrada, salida, maximo) {
	e = entrada.value.length;
	m = maximo;
	if (e > m) {
		entrada.value = entrada.value.substring(0, m);
	} else {
		salida.innerHTML = (e) + '/' + m;
	}
}

function limpiar(obj) {
	
	if (obj) {
		obj.value = '';
	} else {
		alert('objeto no existe')
	}
}



