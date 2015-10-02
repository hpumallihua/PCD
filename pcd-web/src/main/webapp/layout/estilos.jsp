<style type="text/css">

body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}

.header {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 18px;
	color: #{a4jSkin.generalLinkColor};
}

.bottom {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	text-align: center;
	vertical-align: middle;
	color: #8E969D;
}
    .cabeceraSkin {
        background-color: #{a4jSkin.selectControlColor}; 

        background: #{a4jSkin.generalLinkColor}; 
		border-color: #{a4jSkin.selectControlColor}; 
	    color: #{a4jSkin.generalBackgroundColor}; 

    }
    
    .cabeceraUsuarioEtiqueta {
/* 		color: #{a4jSkin.generalLinkColor}; */
        color:#000000;
		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	}
	
    .cabeceraUsuarioValor {
    color:#{a4jSkin.generalLinkColor};
		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	}
    
    .cuerpoSkin {
        background: #{a4jSkin.headerBackgroundColor};
		color: #{a4jSkin.generalBackgroundColor};
		
    }
    .footer {   	 
        text-align: center; 
 	    font-family: #{a4jSkin.headerFamilyFont}; 
 	    font-size: #{a4jSkin.generalSizeFont};
 	    background: #000000; 
	    color:#FFFFFF;	    
	 
	     	    
	} 

	.rich-table-subheader {

		background-color:#{a4jSkin.generalLinkColor};
/* 		background-color: #{a4jSkin.generalLinkColor};  */

		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	    color: #{a4jSkin.selectControlColor}; 
	}

.rich-table-headercell {
		color: #000000;
	background-color:#{a4jSkin.generalBackgroundColor};
}

	.rich-table-header {
		background-color: #900000;
		background-image:url(/)	;
	}

	.rich-table-subheadercell {
		color: #{a4jSkin.tableBackgroundColor}; 

		
	}
	
	.rich-pmenu-top-group {

		background-color: #666;
		background-image:url(/);
	}
	
	.dr-pmenu-selected-item {
		font-style: normal;
		font-weight: normal;
/* 		background-color: #{a4jSkin.selectControlColor}; */
        background-color:#{a4jSkin.generalLinkColor};

	}
	
	.datosPostulante {
		font-size: 24pt;
         color: #{a4jSkin.generalLinkColor};
  
		font-family: #{a4jSkin.headerFamilyFont};
	    
	}
	
	.filaExamenPar {
		background-color: #{a4jSkin.selectControlColor};
	}
	.filaExamenImpar {
		background-color: #{a4jSkin.generalLinkColor};
	}
	
	.timerPanel {
		position: fixed;
		top: 0;
		left: 0;
		border: 0;
		margin: 0;
		padding: 0;
		width:100%;
		border-style: none;
		text-align: center;
		filter: alpha(opacity = 90);
		opacity: 0.9;
	}
	.timerPanelGrid {
		border: 0;
		margin: 0;
		padding: 0;
		width:100%;
		text-align: right;
	}
	.timerPanelText {
		font-size: large;
		color: white;
		text-align: right;
		width:150px;
		background-color: #{a4jSkin.generalLinkColor};
	}
	
	.respuestaCorrecta {
		font-weight: bold;
		color: #{a4jSkin.generalLinkColor};
	}
	
	.dr-pnl-h {

        /*background-color: #{a4jSkin.generalLinkColor};*/
		border-color: #666;
		font-size: 11px;
		color: #FFF;
		font-weight: bold;
		font-family: Arial, Verdana, sans-serif;
		background-image:none;
		

	}
	
	.elementoSeleccionado {
	
		background-color: #{a4jSkin.selectControlColor};

		border-color: #{a4jSkin.selectControlColor};

		font-size: 11px;
		color: #FFF;
		font-weight: bold;
		font-family: Arial, Verdana, sans-serif;
		background-image:url(/);
	}
	
	.cabeceraPanel {
		position: fixed;
		top: 0;
		left: 0;
		border: 0;
		margin: 0;
		padding: 0;
		width:100%;
		border-style: none;
		text-align: center;
		filter: alpha(opacity = 90);
		opacity: 0.9;
		background-color: #{a4jSkin.generalLinkColor}; 

/* background-color:#36AC10; */
		color: white;
		font-family: #{a4jSkin.headerFamilyFont};
	}
	
	.cabeceraText {
		font-size: large;
		text-align: center;
		font-family: #{a4jSkin.headerFamilyFont};
	}
	
	.cabeceraControl {
		text-align: right;
		width:250px;
		text-decoration: none;
	}
	
	.cabeceraControl img {
		text-decoration: none;
		border: 0;
	}
	
	.mensajesError {
		background: url('#{UtilBean.urlApp}/images/error.png') no-repeat;
		text-indent: 20px;
		color: red;
		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	}
	.mensajesInfo {
	
		background: url('#{UtilBean.urlApp}/images/info.png') no-repeat;
		text-indent: 20px;
		height: image height;
		
		color: #1C4882;
		
		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	}
	.mensajesAdvertencia {
		background: url('#{UtilBean.urlApp}/images/error.png') no-repeat;
		text-indent: 20px;
	    color: red;
	    width: 100%;
	    font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	}
	.mensajeNoVisible {
		display: none;
	}
	.contadorCaracteres {
		text-align: right;
		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: 10px;
	    color: #{a4jSkin.generalLinkColor};
	    padding-bottom: 10px;
	}
	.campoRequerido {
		border-color: #{a4jSkin.selectControlColor};
		border-width: 1px;
		border-style: solid;
	}
	
	.filaInactiva {
	    font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	    color: #{a4jSkin.headerBackgroundColor};
	}
	
	.fondoAviso {
		background-color: #ffffdd;
		font-family: #{a4jSkin.headerFamilyFont};
	    font-size: #{a4jSkin.generalSizeFont};
	}
	
	.rich-separator {
		background-image:url(/);
		background-color: #{a4jSkin.generalLinkColor};
	}
	.rich-progress-bar-completed {
		background-image:url(/);
	}
	.examenTotal {
		background-color: #ffffdd;
	}
	.examenMinimo {
		background-color: #{a4jSkin.generalLinkColor};
	}
	.examenAprobado {
		background-color: #{a4jSkin.selectControlColor};
	}
	.examenDesaprobado {
		background-color: #ff0000;
	}
	
	.filaMouseOver {
		background-color: #F3F3F3;
		color: white;
	}
	.filaMouseOut {
		background-color: #{a4jSkin.tableBackgroundColor};
		color: #{a4jSkin.generalTextColor};
	}
	
	.tabBusqueda {
/* 		background-color:#{a4jSkin.generalLinkColor}; */
        background-color:#666;
		color: #FFFFFF;
		background-image:url(/);
	}
	
	.tabBusquedaSeleccionada {
/* 		background-color:#{a4jSkin.selectControlColor}; */
		background-color:#{a4jSkin.generalLinkColor};
		color: #FFFFFF;
		background-image:url(/);
	}
	
	.tituloFila {
		font-size: 14px;
		font-weight:bold;
		text-align: left;
		text-decoration: none;
		/*color: #{a4jSkin.selectControlColor};*/
		height:127px;
		margin-bottom:0px;
	}
	
	.tituloFila a {
		border: 0;
		color: #{a4jSkin.generalLinkColor};
	}
	
	.tooltip {
            background-color:#{richSkin.generalBackgroundColor};
            border-width:3px;
            padding:10px;
    }
    .tooltip-text {
        width:350px;
        height:80px;
        cursor:arrow;
        border-width:2px;
        text-align:center;
        display: table-cell;
        vertical-align: middle; 
    }
    .tooltipData {
        font-weight: bold;
    }
    
    .datoNoValidado {
		background-color: #F3F3F3;
	}
/*	
	.rich-list-picklist-button {
		background-image: url(/);
		background-color: #{a4jSkin.generalLinkColor};
		color: #FFFFFF;
		font-family: Arial, Verdana, sans-serif;
		font-size: 11px;
	}
	*/
.filaTabla {
	background-color: white;
}

.filaTabla:hover {
	color:white;
	background-color: #{a4jSkin.generalLinkColor};
}

.botonBuscar {
	padding: 3px 0;
	width: 143px;
	font-size: 1.2em;
	cursor: pointer;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 7px;
	border: 1px solid #999;
}

.botonBuscar:hover {
	border: 1px solid #CCC;
	cursor: pointer;
	background-color: #{a4jSkin.generalLinkColor};
}
</style>