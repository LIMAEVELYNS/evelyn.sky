package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
	
	public static String dataHoraParaArquivo(){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
	//	Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMhhmmss").format(ts);
	}
	
	public void variaveisGerais() {
		
		
	}

}
