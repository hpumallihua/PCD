package pe.gob.trabajo.pcd.vista.faces.convertidor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

// TODO: Auto-generated Javadoc
/**
 * The Class StringConverter.
 */
public class BooleanConverter implements Converter {

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// TODO Auto-generated method stub
		if(value != null && value.equals("1")) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
//		return (Object) value;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String convertido = "0";
		if(value != null) {
			Boolean b = new Boolean(value.toString());
			if (b != null && b) {
				convertido = "1";
			}
			
		}
		return convertido;
	}

}
