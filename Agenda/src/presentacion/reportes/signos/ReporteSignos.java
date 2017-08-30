package presentacion.reportes.signos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteSignos
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	
	//Recibe la lista de personas para armar el reporte
    public ReporteSignos(List<PersonaReporteSigno> personas)
    {
    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		try		{
    		
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes\\ReporteSignos.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(personas));
		}
		catch( JRException ex ) 
		{
			ex.printStackTrace();
		}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
   
}	